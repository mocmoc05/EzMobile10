package com.trang.ez_mobile.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;

import com.trang.ez_mobile.App;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Locale;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.trang.ez_mobile.App.getInstance;
import static com.trang.ez_mobile.util.Api.API_GRATEWAY;
import static com.trang.ez_mobile.util.Define.LANGUAGE_EN;
import static com.trang.ez_mobile.util.Define.LANGUAGE_VI;
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_LANGUAGE;

/**
 * Created by TraPTH on 2/24/2018.
 */

public class Utils {
    private static Retrofit retrofit = null;

    private static Api api;

    public static Retrofit getRetrofit(String url) {
        Gson gson = new GsonBuilder()
                .setLenient().create();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
//                    .addConverterFactory(SimpleXmlConverterFactory.create())
//                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static boolean isNetworkAvailable() {
        ConnectivityManager connectivity = (ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED
                            || info[i].getState() == NetworkInfo.State.CONNECTING) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void setLanguage(int language) {
        String lan = "";
        switch (language) {
            case LANGUAGE_EN:
                lan = "en";
                break;
            case LANGUAGE_VI:
                lan = "vi";
                break;
            default:
                lan = "en";
                break;
        }
        SharedPreferences.Editor editor = getInstance()
                .getSharedPreferences(SHARED_PREFRENCES_LANGUAGE, Context.MODE_PRIVATE).edit();

        editor.putInt(SHARED_PREFRENCES_LANGUAGE, language);
        editor.apply();
        editor.commit();

        try {
            Locale myLocale = new Locale(lan);
            Resources res = App.getInstance().getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean check = false;

    public static boolean checkInTime() {
        String url = "http://gateway.fpts.com.vn/g5g/fpts/?s=CheckDateTime";
        if (!Utils.isNetworkAvailable()) {
            return check;
        }
        if (api == null) {
            api = Utils.getRetrofit(API_GRATEWAY).create(Api.class);
            return checkInTime();
        }

        api.getString("CheckDateTime")
                .subscribeOn(Schedulers.io())
                .map(s -> s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    try {
                        String str = s.split("\\|")[1];
                        if (Double.parseDouble(str) == 1) {
                            check = true;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }, throwable -> throwable.printStackTrace(), () -> {
                });
        return check;
    }
}

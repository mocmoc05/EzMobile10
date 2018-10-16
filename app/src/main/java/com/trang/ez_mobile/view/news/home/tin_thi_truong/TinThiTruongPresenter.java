package com.trang.ez_mobile.view.news.home.tin_thi_truong;

import android.content.Context;
import android.content.SharedPreferences;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.util.Utils;
import com.trang.ez_mobile.view.news.home.TinTuc;
import com.trang.ez_mobile.view.news.home.TinTucInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by TraPTH on 2/22/2018.
 */

public class TinThiTruongPresenter implements TinTucInterface.Presenter {
    private Context context;
    private TinTucInterface.View view;
    private List<TinTuc> tinTucList;
    private String baseUrl;

    //Luu trang thai
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String keyShered = "Tin_Thi_Truong";

    public TinThiTruongPresenter(Context context, TinTucInterface.View view, List<TinTuc> tinTucList) {
        this.context = context;
        this.view = view;
        this.tinTucList = tinTucList;
        baseUrl = "http://gateway.fpts.com.vn/G5G/";
        sharedPreferences = App.getInstance().getSharedPreferences(Define.SHARED_PREFERENCES_SECURITIES_PUBLIC, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    @Override
    public void getData() {
        if (Utils.isNetworkAvailable() == true) {
            Utils apiClient = new Utils();
            Retrofit retrofit = apiClient.getRetrofit(baseUrl);

            Api myService = retrofit.create(Api.class);
            Call<String> stringCall = myService.getStringTinTuc("news2", "1", "82", "abt", "1", "20");
            stringCall.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        String responseString = response.body();
                        if (responseString.equals("")) {
                            view.getDataFail();
                        } else {
                            splitTinTuc(responseString);
                            view.getDataDone(tinTucList, "82");
                            setList(keyShered, tinTucList);
                        }
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    view.connectServerFail();
                    tinTucList = getList(keyShered);
                    view.getDataDone(tinTucList, "82");
                }
            });

            view.onLoad();
        } else {
            view.connectFail();
            tinTucList = getList(keyShered);
            view.getDataDone(tinTucList, "82");
        }
    }

    private void splitTinTuc(String body) {
        String item[] = body.split("@");
        String img = "";
        String date = "";
        for (int i = 0; i < item.length - 2; i++) {
            String obj[] = item[i].split("#");
            if (obj.length > 5) {
                img = "http://www.fpts.com.vn" + obj[5];
            }
            date = "[" + obj[2].split("\\s+")[0] + "]";

            tinTucList.add(new TinTuc(img, obj[1], date, obj[0]));
        }
    }

//    private boolean isNetworkConnected() {
//        ConnectivityManager cm = (ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
//        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
//    }

    public List<TinTuc> getList(String key) {
        Gson gson = new Gson();
        List<TinTuc> list = new ArrayList<>();

        String json = get(key);
        Type type = new TypeToken<List<TinTuc>>() {
        }.getType();
        list = gson.fromJson(json, type);

        return list;
    }

    public String get(String key) {
        return sharedPreferences.getString(key, "");
    }

    public <T> void setList(String key, List<T> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);

        set(key, json);
    }

    public void set(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }
}

package com.trang.ez_mobile.view.marketOverview.market.hnx;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.util.ErrorApp;
import com.trang.ez_mobile.util.json.Api;
import com.trang.ez_mobile.util.json.Utils;
import com.trang.ez_mobile.view.marketOverview.market.IMarket_View;
import com.trang.ez_mobile.view.marketOverview.market.model.Market;
import com.trang.ez_mobile.view.marketOverview.market.model.MarketData;
import com.trang.ez_mobile.view.marketOverview.market.model.MarketDatabase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.arch.persistence.room.Room.databaseBuilder;
import static com.trang.ez_mobile.App.getInstance;
import static com.trang.ez_mobile.util.Define.API_URL;
import static com.trang.ez_mobile.util.Define.CATEGORY_DB;
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_MARKETOVERVIEW;
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_MARKETOVERVIEW_LISTMARKET_HNX;
import static com.trang.ez_mobile.util.Utils.checkInTime;
import static com.trang.ez_mobile.util.Utils.isNetworkAvailable;
import static com.trang.ez_mobile.view.marketOverview.market.model.MarketDatabase.MIGRATION_2_3;
import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;
import static io.reactivex.schedulers.Schedulers.io;

/**
 * Created by TraPTH on 2/21/2018.
 */

public class HNXPresenter {
    private final int TIME_DELAY = 2000;
    private IMarket_View view;
    private Api api;
    private boolean isRequesting = false;
    private List<Market> marketList = new ArrayList<>();
    final Handler handler = new Handler();

    MarketDatabase marketDatabase;

    public HNXPresenter(IMarket_View view) {
        this.view = view;
        handler.post(runnable);
        marketDatabase = databaseBuilder(App.getInstance(), MarketDatabase.class, CATEGORY_DB)
                .addMigrations(MIGRATION_2_3)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries().build();
    }

    int count = 0;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            getData();
            boolean check = checkInTime();
            if (count < 1) {
                handler.postDelayed(runnable, TIME_DELAY);
                count++;
            }
            if (check) {
                handler.postDelayed(runnable, TIME_DELAY);
            } else {
                getDataFromSharedPreferences();
            }
        }
    };

    public void destroy() {
        handler.removeCallbacks(runnable);
    }

    private void getData() {
        if (com.trang.ez_mobile.util.Utils.isNetworkAvailable() == true) {
            com.trang.ez_mobile.util.Utils apiClient = new com.trang.ez_mobile.util.Utils();
            Retrofit retrofit = apiClient.getRetrofit(API_URL);

            com.trang.ez_mobile.util.Api myService = retrofit.create(com.trang.ez_mobile.util.Api.class);
            Call<String> stringCall = myService.getDataMarket("others_index", 2, 0);
            stringCall.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        String responseString = response.body();
                        if (responseString.equals("")) {
                            view.onDisplayError(ErrorApp.NULL);
                        } else {
                            marketList= convertStringToListMarket(responseString);
                            view.onDisplay(marketList);
                        }
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    view.onDisplayError(ErrorApp.ERROR_CONNECT_SERVER);
                }
            });

//            view.onLoad();
        } else {
            view.onDisplayError(ErrorApp.ERROR_NETWORK);
        }
    }

    private List<Market> convertStringToListMarket(String body) {
        List<Market> list= new ArrayList<>();
        String s[]= body.split("@");
        for (int i=0; i< s.length; i++) {
            String obj[]= s[i].split("\\|");

            list.add(new Market(obj[0], obj[1], obj[3], obj[2], obj[4], obj[5]));
        }

        return list;
    }

    private void getDataFromSharedPreferences() {
        SharedPreferences preferences = getInstance()
                .getSharedPreferences(SHARED_PREFRENCES_MARKETOVERVIEW, Context.MODE_PRIVATE);
        String str = preferences.getString(SHARED_PREFRENCES_MARKETOVERVIEW_LISTMARKET_HNX, "");
//        marketList = convertStringToListMarket(str);
        getCheck();
    }

    public void OnClickItem(String marketName) {
        view.onDisplayReplaceFragment(marketName);
//        switch (marketName.trim().toLowerCase()) {
//            case "vniindex":
//            case "vni":
//                view.onDisplayReplaceFragment("realtime_index_ho", marketName);
//                break;
//            case "hnxindex":
//            case "hnx":
//                view.onDisplayReplaceFragment("realtime_index_ha", marketName);
//                break;
//            case "upcom":
//                view.onDisplayReplaceFragment("realtime_index_up", marketName);
//                break;
//            case "vn30":
//                view.onDisplayReplaceFragment("realtime_index_vni30", marketName);
//                break;
//            case "hnx30":
//                view.onDisplayReplaceFragment("realtime_index_hnx30", marketName);
//                break;
//            default:
//                view.onDisplayError(ErrorApp.NULL);
//                break;
//        }
    }

    private void getCheck() {
//        for (int i = 0; i < marketList.size(); i++) {
//            marketList.get(i).setMarketIsChecked(marketDatabase.dao().getMarketCheck(marketList.get(i).getMarketName()) == 1 ? true : false);
//        }
    }

    public void OnClickItem(String marketName, Boolean isChecked) {
        Log.w("HNXPresenter", "OnClickItem: " + marketName);
        marketDatabase.dao().update(marketName, isChecked);
    }

    private void saveData(List<Market> marketList) {
        for (Market market : marketList) {
            if (marketDatabase.dao().getMarket(market.getMarketName()) == null) {
                marketDatabase.dao().insert(new MarketData(market.getMarketName(), true));
            }
        }
    }
}

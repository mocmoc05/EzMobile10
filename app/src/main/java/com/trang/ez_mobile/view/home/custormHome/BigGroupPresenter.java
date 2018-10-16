package com.trang.ez_mobile.view.home.custormHome;

import android.content.Context;
import android.content.SharedPreferences;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.model.entity.StockMarket;
import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.Utils;
import com.trang.ez_mobile.view.home.IHomeView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.trang.ez_mobile.util.Api.API_GRATEWAY;
import static com.trang.ez_mobile.util.Define.HOME_SHARED_PREFERENCES;
import static com.trang.ez_mobile.util.Define.HOME_TYPE_INDEXES;
import static com.trang.ez_mobile.util.Define.HOME_TYPE_WORLD_INDEXES;
import static com.trang.ez_mobile.util.Utils.checkInTime;

public class BigGroupPresenter {
    private final int TIME_DELAY = 2000;
    IHomeView.IBigGroupView iBigGroupView;
    private boolean isRequesting_indexes = false;
    private Api api;
    List<StockMarket> indexesList = new ArrayList<>();

    public BigGroupPresenter(IHomeView.IBigGroupView iBigGroupView) {
        this.iBigGroupView = iBigGroupView;
//        LoadDataIndexes();
        LoadIndexes();
    }

    final android.os.Handler handler = new android.os.Handler();
    //indexes
    int count = 0;

    public void LoadDataIndexes() {
        if (count == 0) {
            handler.post(runnable_indexes);
            count++;
        }
        if (checkInTime()) {
            handler.post(runnable_indexes);
        }
    }

    int count1 = 0;
    Runnable runnable_indexes = new Runnable() {
        @Override
        public void run() {
            LoadIndexes();
            if (count1 < 1) {
                handler.postDelayed(runnable_indexes, TIME_DELAY);
                count1++;
            }
            boolean check = checkInTime();
            if (check) {
                handler.postDelayed(runnable_indexes, TIME_DELAY);
            }
        }
    };

    private void LoadIndexes() {
        if (isRequesting_indexes) {
            return;
        }
        if (!Utils.isNetworkAvailable()) {
            //
            getDataFromSharedPreferences(HOME_TYPE_INDEXES);
            return;
        }
        if (api == null) {
            api = Utils.getRetrofit(API_GRATEWAY).create(Api.class);
            LoadIndexes();
            return;
        }
        isRequesting_indexes = true;
        indexesList = new ArrayList<>();
        api.getString("vn_indices").subscribeOn(Schedulers.io())
                .map(s -> s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    try {
                        String[] lines = s.split("@");
                        for (int i = 0; i < lines.length - 1; i++) {
                            StockMarket stockMarket = new StockMarket();
                            String[] parts = lines[i + 1].split("#");
                            if (parts.length > 6) {
                                stockMarket.setMarketName(parts[0]);
                                stockMarket.setMarketPrice(parts[1]);
                                stockMarket.setMarketColorCode(parts[2]);
                                stockMarket.setMarketValueChange(parts[3] + " ");
                                stockMarket.setMarketValueChangeRatio(" " + parts[4]);
                                stockMarket.setMarketToTalVolumn(parts[5]);
                                stockMarket.setMarketToTalValue(parts[6].trim().replace(" bil", ""));
                                stockMarket.setIsMarketData(true);
                            }
                            indexesList.add(stockMarket);
                        }
                        saveDataToSharedPreferences(HOME_TYPE_WORLD_INDEXES);
                        iBigGroupView.onDisplay(indexesList);
                    } catch (Exception e) {
                    }
                }, throwable -> {
                    throwable.printStackTrace();
                }, () -> isRequesting_indexes = false);
    }

    private void getDataFromSharedPreferences(int type) {
        SharedPreferences preferences = App.getInstance().getSharedPreferences(HOME_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        switch (type) {

            case HOME_TYPE_INDEXES:
                //SAVE OR NOT
                break;
        }
    }

    private void saveDataToSharedPreferences(int type) {
        SharedPreferences preferences = App.getInstance().getSharedPreferences(HOME_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        switch (type) {
            case HOME_TYPE_INDEXES:
                //SAVE OR NOT
                break;
            default:
                break;
        }
        editor.commit();
        editor.apply();
    }

}

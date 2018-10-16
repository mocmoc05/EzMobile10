package com.trang.ez_mobile.view.marketOverview.detail.top_losers;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.model.entity.Market;
import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.ErrorApp;
import com.trang.ez_mobile.util.Utils;
import com.trang.ez_mobile.view.marketOverview.ConvertToObject;
import com.trang.ez_mobile.view.marketOverview.detail.IDetail_View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.trang.ez_mobile.util.Api.API_GRATEWAY;
import static com.trang.ez_mobile.util.Define.SHARED_PREFERENCES_MARKETOVERVIEW_DATAMARKET_DETAIL_TOP_LOSERS;
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_MARKETOVERVIEW;

/**
 * Created by TraPTH on 2/25/2018.
 */

public class TopLosers_Presenter {
    private IDetail_View.IDetailPrice_View view;
    private String marketName = "";
    private int type = 0;

    private boolean isRequesting = false;
    List<Market> marketList = new ArrayList<>();

    private Api api;
    private final Map<String, Object> _parameter = new HashMap<>();

    public TopLosers_Presenter(IDetail_View.IDetailPrice_View view, String marketName, int type) {
        Log.w("DetailPrice_Presenter", "DetailPrice_Presenter: " + marketName + " " + type);
        this.view = view;
        this.marketName = marketName;
        this.type = type;
        LoadData();
    }

    private void LoadData() {
        if (isRequesting) {
            return;
        }

        int category = getCategoryFromMarketName(marketName);
        if (!Utils.isNetworkAvailable()) {
            view.onError(ErrorApp.ERROR_NETWORK);

            isRequesting = false;
            getDataFromSharedPreferences(category);
            view.onDisplay(marketList);

            return;
        }

        if (api == null) {
            api = Utils.getRetrofit(API_GRATEWAY).create(Api.class);
            LoadData();
            return;
        }


        isRequesting = true;
        api.getDataMarketDetailInfo("top_realtime", category, type)
                .subscribeOn(Schedulers.io())
                .map(s -> s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {

                    marketList = ConvertToObject.convertStringToListMarket(s, category);

                    SharedPreferences.Editor editor = App.getInstance()
                            .getSharedPreferences(SHARED_PREFRENCES_MARKETOVERVIEW, Context.MODE_PRIVATE).edit();
//type: 1,2,3,4,5,6; trong đó 1: Price up; 2: price down; 3: quantity up; 4: quantity down; 5: value up; 6: value down
                    editor.putString(SHARED_PREFERENCES_MARKETOVERVIEW_DATAMARKET_DETAIL_TOP_LOSERS, s);

                    editor.apply();
                    editor.commit();
                    isRequesting = false;
                    view.onDisplay(marketList);

                }, throwable -> {

                    isRequesting = false;
                    throwable.printStackTrace();
                    getDataFromSharedPreferences(category);

                }, () -> isRequesting = false);


    }

    private int getCategoryFromMarketName(String marketName) {
        switch (marketName.trim().toLowerCase()) {
            case "hnxindex":
            case "hnx":
                return 1;

            case "vniindex":
            case "vni":
                return 2;

            case "upcom":
                return 3;

            case "vn30":
                return 4;

            case "hnx30":
                return 5;

            default:
                return 0;
        }
    }

    private void getDataFromSharedPreferences(int category) {
        SharedPreferences preferences = App.getInstance()
                .getSharedPreferences(SHARED_PREFRENCES_MARKETOVERVIEW, Context.MODE_PRIVATE);
        String str = preferences.getString(SHARED_PREFERENCES_MARKETOVERVIEW_DATAMARKET_DETAIL_TOP_LOSERS, "");
        marketList = ConvertToObject.convertStringToListMarket(str, category);
    }
}

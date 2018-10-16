package com.trang.ez_mobile.view.marketOverview.detail;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.model.entity.DetailMarket;
import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.ErrorApp;
import com.trang.ez_mobile.util.Utils;
import com.trang.ez_mobile.view.marketOverview.ConvertToObject;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.trang.ez_mobile.util.Api.API_GRATEWAY;
import static com.trang.ez_mobile.util.Define.COLOR_FLOOR;
import static com.trang.ez_mobile.util.Define.COLOR_REF;
import static com.trang.ez_mobile.util.Define.COLOR_UP;
import static com.trang.ez_mobile.util.Define.SHARED_PREFERENCES_MARKETOVERVIEW_DATAMARKET_DETAIL;
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_MARKETOVERVIEW;

/**
 * Created by TraPTH on 2/23/2018.
 */

public class Detail_Presenter {
    Context context;
    IDetail_View view;
    String marketName;
    String marketCode;
    private Api api;
    private boolean _requesting = false;
    private final Map<String, Object> _parameter = new HashMap<>();
    DetailMarket detailMarket = new DetailMarket();

    Detail_Presenter(Context context, IDetail_View view, String marketCode) {
        this.context = context;
        this.view = view;
        this.marketName = getMarketName(marketCode);
        this.marketCode = marketCode;
        LoadData();
        view.onUpdateTitle(getTitle(marketCode));
    }

    private String getMarketName(String marketCode) {
        switch (marketCode.trim().toLowerCase()) {
            case "vniindex":
            case "hose":
            case "vni":
                return "realtime_index_ho";
            case "hnxindex":
            case "hnx":
                return "realtime_index_ha";
            case "upcom":
                return "realtime_index_up";
            case "vn30":
                return "realtime_index_vni30";
            case "hnx30":
                return "realtime_index_hnx30";
            default:
                return "";
        }
    }

    private void LoadData() {
        if (_requesting) {
            return;
        }

        if (!Utils.isNetworkAvailable()) {
            if (view != null) {
                view.onDisplayError(ErrorApp.ERROR_NETWORK);
            }
            getDataFromSharedPreferences();
            show();
            return;
        }
        if (api == null) {
            api = Utils.getRetrofit(API_GRATEWAY).create(Api.class);
            LoadData();
            return;
        }
        view.onLoading();
        _requesting = true;

        _parameter.clear();
        Log.w("Detail_Presenter", "LoadData: " + marketName);
        api.getDataMarketDetail(marketName)
                .subscribeOn(Schedulers.io())
                .map(s -> s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    _requesting = false;
                    detailMarket = ConvertToObject.convertStringToDetailMarket(s, marketCode);
                    SharedPreferences.Editor editor = App.getInstance()
                            .getSharedPreferences(SHARED_PREFRENCES_MARKETOVERVIEW, Context.MODE_PRIVATE).edit();

                    editor.putString(SHARED_PREFERENCES_MARKETOVERVIEW_DATAMARKET_DETAIL, s);
                    editor.apply();
                    editor.commit();
                    show();

                }, throwable -> {
                    throwable.printStackTrace();
                    _requesting = false;
                    view.onDisplayError(ErrorApp.EXCEPTION);

                    getDataFromSharedPreferences();
                    show();
                }, () -> _requesting = false);
    }

    private void getDataFromSharedPreferences() {
        SharedPreferences preferences = App.getInstance()
                .getSharedPreferences(SHARED_PREFRENCES_MARKETOVERVIEW, Context.MODE_PRIVATE);
        String str = preferences.getString(SHARED_PREFERENCES_MARKETOVERVIEW_DATAMARKET_DETAIL, "");
        detailMarket = ConvertToObject.convertStringToDetailMarket(str, marketCode);
    }

    private void show() {
        Log.w("Detail_Presenter", "show: getDetailMarketChangeValueRatio() = " + detailMarket.getDetailMarketChangeValueRatio());
        if (view != null) {
            double color = 0;
            try {
                color = Double.parseDouble(detailMarket.getDetailMarketChangeValueRatio());
                if (color > 0) {
                    view.onDisplay(detailMarket, COLOR_UP);
                } else if (color == 0) {
                    view.onDisplay(detailMarket, COLOR_REF);
                } else {
                    view.onDisplay(detailMarket, COLOR_FLOOR);
                }
            } catch (Exception e) {
                view.onDisplay(detailMarket, COLOR_UP);
            }
        }
    }

    private String getTitle(String marketName) {
        switch (marketName.trim().toLowerCase()) {
            case "hnxindex":
            case "hnx":
                return "HNXindex Detail";

            case "vniindex":
            case "vni":
                return "VNIndex Detail";

            case "upcom":
                return "UPCOMindex Detail";

            case "vn30":
                return "VN30index Detail";

            case "hnx30":
                return "HNX30index Detail";

            default:
                return marketName + "index Detail";
        }
    }
}

package com.trang.ez_mobile.view.marketOverview.detail.chart;

import android.content.Context;
import android.content.SharedPreferences;

import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.ErrorApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.trang.ez_mobile.App.getInstance;
import static com.trang.ez_mobile.util.Api.API_GRATEWAY;
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_MARKETOVERVIEW;
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_MARKETOVERVIEW_DATAMARKET_CHART_ALL;
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_MARKETOVERVIEW_DATAMARKET_CHART_ONEDAY;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_ALL;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_ONE_DAY;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_ONE_MONTH;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_ONE_WEEK;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_ONE_YEAR;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_SIX_MONTH;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_THREE_MONTH;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_TWO_YEAR;
import static com.trang.ez_mobile.util.Utils.getRetrofit;
import static com.trang.ez_mobile.util.Utils.isNetworkAvailable;
import static com.trang.ez_mobile.view.marketOverview.ConvertToObject.convertStringToListChartIndex;
import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;
import static io.reactivex.schedulers.Schedulers.io;

/**
 * Created by TraPTH on 2/25/2018.
 */

class Chart_Presenter {
    private IChart_View view;
    private String marketName = "";
    List<ChartIndex> chartIndexRealtime = new ArrayList<>();
    List<ChartIndex> chartIndexDataList = new ArrayList<>();
    List<List<ChartIndex>> chartIndexSuperList = new ArrayList<>();

    private Api api;
    private boolean isRequesting = false;
    private boolean isRequesting1 = false;

    Chart_Presenter(IChart_View view, String marketName) {
        this.view = view;
        this.marketName = marketName;
        LoadData_OneDay();
        LoadData_All();
    }

    /**
     * Load Data phần 1 ngày
     */
    private void LoadData_OneDay() {
        if (isRequesting) {
            return;
        }
        if (!isNetworkAvailable()) {
            view.onError(ErrorApp.ERROR_NETWORK);
            getDataFromSharedPreferences_OneDay();
            return;
        }

        if (api == null) {
            api = getRetrofit(API_GRATEWAY).create(Api.class);
            LoadData_OneDay();
            return;
        }
        isRequesting = true;

        chartIndexRealtime = new ArrayList<>();
        api.getDataMarketChart_OneDay(getSFromMarketNameForAll(marketName))
                .subscribeOn(io())
                .map(s -> s)
                .observeOn(mainThread())
                .subscribe(r -> {
                    chartIndexRealtime = convertStringToListChartIndex(r, true);// convertStringToChartIndexRealtime(r);
                    SharedPreferences.Editor editor = getInstance()
                            .getSharedPreferences(SHARED_PREFRENCES_MARKETOVERVIEW, Context.MODE_PRIVATE).edit();
                    editor.putString(SHARED_PREFRENCES_MARKETOVERVIEW_DATAMARKET_CHART_ONEDAY, r);
                    editor.apply();
                    editor.commit();
                    if (chartIndexRealtime != null) {
                        selectTab(TYPE_CHART_ONE_DAY);
                    }
                }, throwable -> {
                    isRequesting = false;
                    throwable.printStackTrace();
                    view.onError(ErrorApp.ERROR_CONNECT_SERVER);
                    getDataFromSharedPreferences_OneDay();
                }, () -> isRequesting = false);
    }

    /**
     * Load data tất cả
     */
    private void LoadData_All() {
        if (isRequesting1) {
            return;
        }
        if (!isNetworkAvailable()) {
            view.onError(ErrorApp.ERROR_NETWORK);
            getDataFromSharedPreferences();
            return;
        }
        if (api == null) {
            api = getRetrofit(API_GRATEWAY).create(Api.class);
            LoadData_All();
            return;
        }
        isRequesting1 = true;
        chartIndexDataList = new ArrayList<>();
        api.getDataMarketChart(getSFromMarketNameForAll(marketName))
                .subscribeOn(io())
                .map(s -> s)
                .observeOn(mainThread())
                .subscribe(s -> {
                    chartIndexSuperList = convert(convertStringToListChartIndex(s, false));
                    isRequesting1 = false;
                    SharedPreferences.Editor editor = getInstance()
                            .getSharedPreferences(SHARED_PREFRENCES_MARKETOVERVIEW, Context.MODE_PRIVATE).edit();
                    editor.putString(SHARED_PREFRENCES_MARKETOVERVIEW_DATAMARKET_CHART_ALL, s);
                    editor.apply();
                    editor.commit();
                }, throwable -> {
                    view.onError(ErrorApp.ERROR_CONNECT_SERVER);
                    getDataFromSharedPreferences();
                    isRequesting1 = false;
                }, () -> isRequesting1 = false);
    }

    private void getDataFromSharedPreferences() {
        try {
            //get data from sharepreferences
            SharedPreferences preferences = getInstance()
                    .getSharedPreferences(SHARED_PREFRENCES_MARKETOVERVIEW, Context.MODE_PRIVATE);

            String str = preferences.getString(SHARED_PREFRENCES_MARKETOVERVIEW_DATAMARKET_CHART_ONEDAY, "");
            chartIndexSuperList = convert(convertStringToListChartIndex(str, false));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getDataFromSharedPreferences_OneDay() {
        try {
            //get data from sharepreferences
            SharedPreferences preferences = getInstance()
                    .getSharedPreferences(SHARED_PREFRENCES_MARKETOVERVIEW, Context.MODE_PRIVATE);
            String str = preferences.getString(SHARED_PREFRENCES_MARKETOVERVIEW_DATAMARKET_CHART_ALL, "");

            chartIndexRealtime = convertStringToListChartIndex(str, true);
            if (chartIndexRealtime != null) {
                selectTab(TYPE_CHART_ONE_DAY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param type: 1D, 1W, 1M, 3M, 6M, 1Y, 2Y, ALL
     */
    void selectTab(int type) {
        if (type == TYPE_CHART_ONE_DAY) {
            if (chartIndexRealtime == null || chartIndexRealtime.size() == 0) {
                view.onError(ErrorApp.NULL);
                return;
            } else {
                view.onDisplayOneDay(chartIndexRealtime);

                return;
            }
        } else {
            if (chartIndexSuperList == null || chartIndexSuperList.size() == 0) {

                view.onError(ErrorApp.NULL);
                return;
            }
            switch (type) {
                case TYPE_CHART_ONE_WEEK:
                    if (chartIndexSuperList.size() > 0 && chartIndexSuperList.get(0) != null && chartIndexSuperList.get(0).size() > 0) {
                        view.onDisplay(chartIndexSuperList.get(0));
                    } else view.onError(ErrorApp.NULL);

                    break;
                case TYPE_CHART_ONE_MONTH:
                    if (chartIndexSuperList.size() > 1 && chartIndexSuperList.get(1) != null && chartIndexSuperList.get(1).size() > 0) {
                        view.onDisplay(chartIndexSuperList.get(1));
                    } else view.onError(ErrorApp.NULL);

                    break;
                case TYPE_CHART_THREE_MONTH:
                    if (chartIndexSuperList.size() > 2 && chartIndexSuperList.get(2) != null && chartIndexSuperList.get(2).size() > 0) {
                        view.onDisplay(chartIndexSuperList.get(2));
                    } else view.onError(ErrorApp.NULL);
                    break;
                case TYPE_CHART_SIX_MONTH:
                    if (chartIndexSuperList.size() > 3 && chartIndexSuperList.get(3) != null && chartIndexSuperList.get(3).size() > 0) {
                        view.onDisplay(chartIndexSuperList.get(3));
                    } else view.onError(ErrorApp.NULL);
                    break;
                case TYPE_CHART_ONE_YEAR:
                    if (chartIndexSuperList.size() > 4 && chartIndexSuperList.get(4) != null && chartIndexSuperList.get(4).size() > 0) {
                        view.onDisplay(chartIndexSuperList.get(4));
                    } else view.onError(ErrorApp.NULL);
                    break;
                case TYPE_CHART_TWO_YEAR:
                    if (chartIndexSuperList.size() > 5 && chartIndexSuperList.get(5) != null && chartIndexSuperList.get(5).size() > 0) {
                        view.onDisplay(chartIndexSuperList.get(5));
                    } else view.onError(ErrorApp.NULL);
                    break;
                case TYPE_CHART_ALL:
                    if (chartIndexSuperList.size() > 6 && chartIndexSuperList.get(6) != null && chartIndexSuperList.get(6).size() > 0) {
                        view.onDisplay(chartIndexSuperList.get(6));
                    } else view.onError(ErrorApp.NULL);
                    break;
                default:
                    if (chartIndexSuperList.size() > 0 && chartIndexSuperList.get(0) != null && chartIndexSuperList.get(0).size() > 0) {
                        view.onDisplay(chartIndexSuperList.get(0));
                    } else view.onError(ErrorApp.NULL);
                    break;
            }
        }
    }

    private String getSFromMarketNameForAll(String marketName) {

        switch (marketName.trim().toUpperCase()) {
            case "HOSE":
            case "VNINDEX":
            case "VNI":
                return "vnindex";
            case "HNX":
            case "HNXINDEX":
                return "hnxindex";
            case "UPCOM":
                return "upcomindex";
            case "VN30":
                return "vn30index";
            case "HNX30":
                return "hnx30index";
            default:
                return "";
        }
    }


    private List<List<ChartIndex>> convert(List<ChartIndex> chartIndices) {
        List<List<ChartIndex>> superList = new ArrayList<>();
        List<ChartIndex>[] tem = new List[7];

        for (int i = chartIndices.size() - 1; i > 0; i--) {
            if (i == chartIndices.size() - 1)
                for (int j = 0; j < tem.length; j++)
                    tem[j] = new ArrayList<>();

            if (i >= chartIndices.size() - 5) tem[0].add(chartIndices.get(i));
            if (i >= chartIndices.size() - 5 * 4) tem[1].add(chartIndices.get(i));
            if (i >= chartIndices.size() - 21 * 3) tem[2].add(chartIndices.get(i));
            if (i >= chartIndices.size() - 21 * 6) tem[3].add(chartIndices.get(i));
            if (i >= chartIndices.size() - 21 * 6 * 2) tem[4].add(chartIndices.get(i));
            if (i >= chartIndices.size() - 21 * 6 * 2 * 2) tem[5].add(chartIndices.get(i));
            if (i >= 0) tem[6].add(chartIndices.get(i));
        }
        for (int i = 0; i < tem.length; i++) {
            superList.add(tem[i]);
        }
        return superList;
    }
}

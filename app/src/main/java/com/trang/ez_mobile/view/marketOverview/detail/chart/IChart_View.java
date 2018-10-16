package com.trang.ez_mobile.view.marketOverview.detail.chart;

import com.trang.ez_mobile.util.ErrorApp;

import java.util.List;

/**
 * Created by TraPTH on 2/25/2018.
 */

public interface IChart_View {

    void onError(ErrorApp error);

    void onDisplay(List<ChartIndex> dataList);

    void onDisplayOneDay(List<ChartIndex> chartIndexData);

}

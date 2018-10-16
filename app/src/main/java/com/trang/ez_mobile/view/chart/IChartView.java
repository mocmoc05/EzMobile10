package com.trang.ez_mobile.view.chart;


import com.trang.ez_mobile.model.entity.chart.HistoryChartOtherIndex;
import com.trang.ez_mobile.model.entity.chart.MacdData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FIT-thuctap22 on 2/7/2018.
 */

public interface IChartView {
    void showChart(ArrayList<HistoryChartOtherIndex> yVals1);

    void showChart(ArrayList<HistoryChartOtherIndex> yVals1, List<MacdData> getMacd);

    void showChart(ArrayList<HistoryChartOtherIndex> yVals1, ArrayList<Double> sma, ArrayList<Double> sma1, double[] listRsi, String key, int p1, int p3);

    void showChart(ArrayList<Double> top, ArrayList<Double> mid, ArrayList<Double> bot, ArrayList<Float> ema, ArrayList<HistoryChartOtherIndex> yVals1, String key);

    void onload();

    void loadok();

    void loadNamecpn(List<String> lg);

    interface title {
        void setT(String tit);
    }
//    void showChart(ArrayList<Double> top, ArrayList<Double> mid, ArrayList<Double> bot, ArrayList<Float> ema, ArrayList<Double> sma, ArrayList<Double> sma1, double[] listRsi, ArrayList<HistoryChartOtherIndex> yVals1, List<MacdData> getMacd, String key, int p1, int p2, int p3);

}

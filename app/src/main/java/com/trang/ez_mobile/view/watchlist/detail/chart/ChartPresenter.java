package com.trang.ez_mobile.view.watchlist.detail.chart;

import com.trang.ez_mobile.model.entity.chart.HistoryChartOtherIndex;
import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.Utils;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.trang.ez_mobile.util.Api.API_GRATEWAY;

/**
 * Created by FIT-thuctap22 on 2/7/2018.
 */

public class ChartPresenter {

    IChartView view;
    String symbol;
    ArrayList<HistoryChartOtherIndex> yVals1;

    public ChartPresenter(IChartView view, String symbol, ArrayList<HistoryChartOtherIndex> yVals1) {

        this.view = view;
        this.symbol = symbol;
        this.yVals1 = yVals1;
        if (yVals1.isEmpty()) {
            LoadDataTotal();
        }
    }

    public void LoadDataDay() {
        Api api = Utils.getRetrofit(API_GRATEWAY).create(Api.class);

        final ArrayList<HistoryChartOtherIndex> dataD = new ArrayList<>();
        api.getRealtime(symbol).subscribeOn(Schedulers.io()     )
                .map(s -> s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    try {
                        String[] line = s.split("\\]\\,\\[");

                        for (int i = 0; i < line.length; i++) {

                            String[] part = line[i].split("\\,");
                            HistoryChartOtherIndex chartOtherIndex = new HistoryChartOtherIndex();

                            String timec;
                            if (i == 0 || i == line.length - 1) {
                                timec = part[0].substring(3, part[0].length() - 1).replace("\"", "");
                            } else {
                                timec = part[0].replace("\"", "");
                            }


                            chartOtherIndex.setCharTime(timec.substring(timec.length() - 5, timec.length()));

                            chartOtherIndex.setChartO(part[1]);
                            chartOtherIndex.setChartH(part[2]);
                            chartOtherIndex.setChartL(part[3]);
                            chartOtherIndex.setChartC(part[4]);
                            if (i == line.length - 1) {
                                chartOtherIndex.setCharV(part[5].substring(0, part[5].length() - 2));
                            } else {
                                chartOtherIndex.setCharV(part[5]);
                            }
                            dataD.add(chartOtherIndex);

                        }

                    } catch (IndexOutOfBoundsException e) {

                    }
                    view.showChart(dataD);
                }, throwable -> {
                }, () -> {
                });
    }

    private void LoadDataTotal() {

        Api api = Utils.getRetrofit(API_GRATEWAY).create(Api.class);

        api.getStringHistory(symbol).subscribeOn(Schedulers.io())
                .map(s -> s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    try {

                        String[] line = s.split("\\]\\,\\[");

                        for (int i = 0; i < line.length; i++) {

                            String[] part = line[i].split("\\,");
                            HistoryChartOtherIndex chartOtherIndex = new HistoryChartOtherIndex();

                            if (i == 0 || i == line.length - 1) {
                                chartOtherIndex.setCharTime(part[0].substring(3, part[0].length() - 1).replace("\"", ""));
                            } else {
                                chartOtherIndex.setCharTime(part[0].replace("\"", ""));
                            }


                            chartOtherIndex.setChartO(part[1]);
                            chartOtherIndex.setChartH(part[2]);
                            chartOtherIndex.setChartL(part[3]);
                            chartOtherIndex.setChartC(part[4]);
                            if (i == line.length - 1) {
                                chartOtherIndex.setCharV(part[5].substring(0, part[5].length() - 2));
                            } else {
                                chartOtherIndex.setCharV(part[5]);
                            }
                            yVals1.add(chartOtherIndex);

                        }

                    } catch (IndexOutOfBoundsException e) {

                    }
                }, throwable -> {
                }, () -> {
                });
    }


    public void loadFilter(int sizedate) {
        if (!yVals1.isEmpty()) {
            ArrayList<HistoryChartOtherIndex> yVals11 = new ArrayList<>();
            int numsize = 0;
            if (sizedate > 0 && sizedate < yVals1.size()) {

                numsize = yVals1.size() - sizedate;
            }

            for (int i = numsize; i < yVals1.size(); i++) {
                HistoryChartOtherIndex chartix = new HistoryChartOtherIndex();
                chartix.setChartC(yVals1.get(i).getChartC());
                chartix.setChartH(yVals1.get(i).getChartH());
                chartix.setCharTime(yVals1.get(i).getCharTime());
                chartix.setChartL(yVals1.get(i).getChartL());
                chartix.setChartO(yVals1.get(i).getChartO());
                chartix.setCharV(yVals1.get(i).getCharV());
                yVals11.add(chartix);

            }

            view.showChart(yVals11);
        }

    }
}

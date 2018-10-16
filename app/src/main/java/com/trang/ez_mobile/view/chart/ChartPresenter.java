package com.trang.ez_mobile.view.chart;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import com.trang.ez_mobile.model.entity.chart.HistoryChartOtherIndex;
import com.trang.ez_mobile.model.entity.chart.MacdData;
import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.Utils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.trang.ez_mobile.util.Api.API_GRATEWAY;
import static com.trang.ez_mobile.util.getData._ema;
import static com.trang.ez_mobile.util.getData._sma;
import static com.trang.ez_mobile.util.getData.bbands;
import static com.trang.ez_mobile.util.getData.computerD;

/**
 * Created by FIT-thuctap22 on 2/7/2018.
 */

public class ChartPresenter {
    private static Double UNDEF_VALUE = new Double(Double.MIN_VALUE);

    IChartView view;
    Context context;
    ArrayList<HistoryChartOtherIndex> yVals1;
    double[] listRsi = null;
    ArrayList<Double> sma = new ArrayList<>();
    ArrayList<Double> pks_ = new ArrayList<>();
    ArrayList<Double> pds_ = new ArrayList<>();
    ArrayList<Double> top = new ArrayList<>();
    ArrayList<Double> mid = new ArrayList<>();
    ArrayList<Double> bot = new ArrayList<>();

    ArrayList<Float> ema = new ArrayList<>();

    private Api api;
    private boolean isRequesting = false;

    public ChartPresenter(IChartView view, Context context, ArrayList<HistoryChartOtherIndex> yVals1) {

        this.context = context;
        this.view = view;
        this.yVals1 = yVals1;
        if (yVals1.isEmpty()) {
            loadDt("VNINDEX", 5, "Volume", 12, 6, 9);
            getNamecp();
        }

    }


    private void getNamecp() {
        if (isRequesting) {
            return;
        }
        if (!Utils.isNetworkAvailable()) {
            return;
        }
        if (api == null) {
            api = Utils.getRetrofit(API_GRATEWAY).create(Api.class);

            getNamecp();
            return;
        }

        isRequesting = true;
        final List<String> lg = new ArrayList<>();
        api.getNameCompany("codename2", "0", "1")
                .subscribeOn(Schedulers.io())
                .map(s -> s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                            view.loadNamecpn(getNamecompany(s));
                            isRequesting = false;
                        },
                        throwable -> {
                            isRequesting = false;
                        },
                        () -> {
                            isRequesting = false;
                        });
    }

    @SuppressLint("NewApi")
    public void loadDt(String code, final int sizedate, final String key, final int p1, final int p2, final int p3) {
        if (!yVals1.isEmpty()) {
            yVals1.clear();
            if (listRsi != null && listRsi.length > 0) listRsi = null;
            if (!sma.isEmpty()) sma.clear();
            if (!pks_.isEmpty()) pks_.clear();
            if (!pds_.isEmpty()) pds_.clear();
            if (!top.isEmpty()) top.clear();
            if (!mid.isEmpty()) mid.clear();
            if (!bot.isEmpty()) bot.clear();
            if (!ema.isEmpty()) ema.clear();

        }
        if (api == null) {
            api = Utils.getRetrofit(API_GRATEWAY).create(Api.class);
            loadDt(code, sizedate, key, p1, p2, p3);
            return;
        }
        view.onload();
        api.getStringHistory(code)
                .subscribeOn(Schedulers.io())
                .map(s -> s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                            yVals1 = getDt(s);
                            view.loadok();
                            if (!yVals1.isEmpty()) {
                                computerData cp = new computerData(key, p1, p2, p3, sizedate);
                                cp.execute();
                            }
                        },
                        throwable -> {
                            view.loadok();
                        }, () -> {
                            view.loadok();

                        });

    }

    @SuppressLint("NewApi")
    private class computerData extends AsyncTask<String, Void, String> {

        String key;
        int p1;
        int p2;
        int p3;
        int count;

        private computerData(String key, int p1, int p2, int p3, int count) {
            this.key = key;
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
            this.count = count;
        }

        @Override
        protected void onPreExecute() {
            //load
            view.onload();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {


            addData(key, p1, p2, p3);


            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            ///ok
            loadFilter(count, key, p1, p2, p3);
            view.loadok();
            super.onPostExecute(result);
        }

    }


    @SuppressLint("NewApi")
    public void computing(String key, int p1, int p2, int p3, int count) {
        computerData cp = new computerData(key, p1, p2, p3, count);
        cp.execute();

    }

    private void addData(String key, int p1, int p2, int p3) {
        if (!yVals1.isEmpty()) {

            if (listRsi != null && listRsi.length > 0) listRsi = null;
            if (!sma.isEmpty()) sma.clear();
            if (!pks_.isEmpty()) pks_.clear();
            if (!pds_.isEmpty()) pds_.clear();
            if (!top.isEmpty()) top.clear();
            if (!mid.isEmpty()) mid.clear();
            if (!bot.isEmpty()) bot.clear();
            if (!ema.isEmpty()) ema.clear();


            switch (key) {


                case "RSI":
                    listRsi = RSIc(yVals1, p1);
                    sma = computerD(yVals1, p1);
                    pks_ = (ArrayList<Double>) _sma(sma, p3).clone();
                    pds_ = (ArrayList<Double>) _sma(pks_, p3).clone();

                    break;
                case "Stochastics":
                    listRsi = RSIc(yVals1, p1);
                    sma = computerD(yVals1, p1);
                    pks_ = (ArrayList<Double>) _sma(sma, p3).clone();
                    pds_ = (ArrayList<Double>) _sma(pks_, p3).clone();


                    break;
                case "Bolinger Band":
                    top = (ArrayList<Double>) bbands(yVals1, p1, p2, 1).clone();
                    mid = (ArrayList<Double>) bbands(yVals1, p1, p2, 2).clone();
                    bot = (ArrayList<Double>) bbands(yVals1, p1, p2, 3).clone();
                    ema = (ArrayList<Float>) _ema(yVals1, p1).clone();
                    break;
                case "EMA":
                    top = (ArrayList<Double>) bbands(yVals1, p1, p2, 1).clone();
                    mid = (ArrayList<Double>) bbands(yVals1, p1, p2, 2).clone();
                    bot = (ArrayList<Double>) bbands(yVals1, p1, p2, 3).clone();
                    ema = (ArrayList<Float>) _ema(yVals1, p1).clone();
                    break;
            }
        }
    }

    public void loadFilter(int sizedate, String key, int p1, int p2, int p3) {
        if (!yVals1.isEmpty()) {
            ArrayList<Double> top1 = new ArrayList<>();
            ArrayList<Double> mid1 = new ArrayList<>();
            ArrayList<Double> bot1 = new ArrayList<>();
            ArrayList<Float> ema1 = new ArrayList<>();
            ArrayList<Double> sma1 = new ArrayList<>();
            ArrayList<Double> sma12 = new ArrayList<>();
            ArrayList<HistoryChartOtherIndex> yVals11 = new ArrayList<>();
            double[] listRsi1 = null;

            int numsize = 0;
            if (sizedate > 0 && sizedate < yVals1.size()) {

                numsize = yVals1.size() - sizedate;
                listRsi1 = new double[sizedate];
            } else {
                listRsi1 = new double[yVals1.size()];
            }
//            view.showChart(top1, mid1, bot1, ema1, sma1, sma12, listRsi1, yVals11, getMacd(yVals11, p1, p2, p3), key, p1, p2, p3);
            switch (key) {
                case "Volume":
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
                    break;
                case "MACD":
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
                    view.showChart(yVals11, getMacd(yVals11, p1, p2, p3));


                    break;
                case "RSI":


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
                    int j = 0;
                    for (int i = numsize; i < listRsi.length; i++) {

                        if (j < sizedate) {
                            listRsi1[j] = listRsi[i];


                            j++;
                        }
                    }

                    for (int i = numsize; i < pks_.size(); i++) sma1.add(pks_.get(i));
                    for (int i = numsize; i < pds_.size(); i++) sma12.add(pds_.get(i));

                    view.showChart(yVals11, sma1, sma12, listRsi1, key, p1, p3);


                    break;
                case "Bolinger Band":


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

                    for (int i = numsize; i < ema.size(); i++) ema1.add(ema.get(i));


                    for (int i = numsize; i < top.size(); i++) top1.add(top.get(i));
                    for (int i = numsize; i < mid.size(); i++) mid1.add(mid.get(i));
                    for (int i = numsize; i < bot.size(); i++) bot1.add(bot.get(i));


                    view.showChart(top1, mid1, bot1, ema1, yVals11, key);


                    break;
                case "EMA":

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

                    for (int i = numsize; i < ema.size(); i++) ema1.add(ema.get(i));


                    for (int i = numsize; i < top.size(); i++) top1.add(top.get(i));
                    for (int i = numsize; i < mid.size(); i++) mid1.add(mid.get(i));
                    for (int i = numsize; i < bot.size(); i++) bot1.add(bot.get(i));


                    view.showChart(top1, mid1, bot1, ema1, yVals11, key);


                    break;
                case "Stochastics":


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

                    int j1 = 0;
                    for (int i = numsize; i < listRsi.length; i++) {

                        if (j1 < sizedate) {
                            listRsi1[j1] = listRsi[i];


                            j1++;
                        }


                    }

                    for (int i = numsize; i < pks_.size(); i++) sma1.add(pks_.get(i));
                    for (int i = numsize; i < pds_.size(); i++) sma12.add(pds_.get(i));

                    view.showChart(yVals11, sma1, sma12, listRsi1, key, p1, p3);
                    break;
            }
        }
    }

    public static List<MacdData> getMacd(ArrayList<HistoryChartOtherIndex> data, int p1, int p2, int signal) {
        float[] d = new float[data.size()];
        for (int i = 0; i < data.size(); i++) {
            d[i] = Float.parseFloat(data.get(i).getChartC());
        }
        List<MacdData> macdData = new ArrayList<>();
        MacdData macdDataObject = new MacdData();
        macdDataObject.setEma1(Float.parseFloat(data.get(0).getChartC()));
        macdDataObject.setEma2(Float.parseFloat(data.get(0).getChartC()));
        macdDataObject.setMacd(0);
        macdDataObject.setSignalMACD(0);
        macdData.add(macdDataObject);
        for (int i = 1; i < d.length; i++) {
            MacdData macdDataObject1 = new MacdData();

            float emaN1 = macdData.get(i - 1).getEma1();
            float a1 = ((float) 2 / (p1 + 1)) * d[i];
            float a2 = 1 - ((float) 2 / (p1 + 1));

            float ema1 = a1 + a2 * emaN1;

            float emaN2 = macdData.get(i - 1).getEma2();
            float b1 = ((float) 2 / (p2 + 1)) * d[i];
            float b2 = 1 - ((float) 2 / (p2 + 1));
            float ema2 = b1 + b2 * emaN2;

            macdDataObject1.setEma1(ema1);
            macdDataObject1.setEma2(ema2);

            macdDataObject1.setMacd(ema1 - ema2);


            macdDataObject1.setSignalMACD(((float) 2 / (signal + 1)) * (ema1 - ema2) + (1 - ((float) 2 / (signal + 1))) * macdData.get(i - 1).getSignalMACD());

            macdDataObject1.setBardataMACD(macdDataObject1.getMacd() - macdDataObject1.getSignalMACD());
            macdData.add(macdDataObject1);

        }

        return macdData;
    }

    public static List<String> getNamecompany(String res) {
        final List<String> lg = new ArrayList<>();
        String[] lines = res.split("@");
        for (int i = 0; i < lines.length - 1; i++) {

            String[] parts = lines[i].split("#");

            try {
                lg.add(parts[1] + " - " + parts[2]);
            } catch (NullPointerException e) {
                lg.add("");
            }
        }
        return lg;
    }


    public static ArrayList<HistoryChartOtherIndex> getDt(String res) {
        ArrayList<HistoryChartOtherIndex> yVals1 = new ArrayList<>();
        try {

            String[] line = res.split("\\]\\,\\[");

            for (int i = 0; i < line.length; i++) {

                String[] part = line[i].split("\\,");
                HistoryChartOtherIndex chartOtherIndex = new HistoryChartOtherIndex();

                String datet;
                if (i == 0 || i == line.length - 1) {
                    chartOtherIndex.setCharTime(part[0].substring(3, part[0].length() - 1).replace("\"", ""));
                } else {
                    chartOtherIndex.setCharTime(part[0].replace("\"", ""));
                }
//                            if (datet.contains(":")) datet = datet.substring(0, datet.length()-5);

//                            chartOtherIndex.setCharTime(datet);

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

        return yVals1;
    }

    public static double[] RSIc(ArrayList<HistoryChartOtherIndex> data, int lookback) {
        double up = 0, down = 0;
        double rs;

        double[] rsi = new double[data.size()];
        for (int k = 0; k < data.size(); k++) {
            rsi[k] = UNDEF_VALUE.doubleValue();
        }

        // empty array plus initialization for 0.

        double prev = Double.parseDouble(data.get(0).getChartC());  // close
        if (lookback > data.size()) lookback = data.size();
        for (int i = 1; i < lookback; i++) {//huynq modified 10-10-2014
            double diff = Double.parseDouble(data.get(i).getChartC()) - prev;  // change
            if (diff > 0) {
                up = up + diff; // Sumgain
            } else {
                down = down - diff;  // Sumloss
            }
            // rsi.push(undefined);
            prev = Double.parseDouble(data.get(i).getChartC());
        }
        up /= lookback; // avg Gain
        down /= lookback; // avg Loss
        rs = (down == 0) ? 0 : (up / down); // RS		// modified huynq 14-10-2014
        for (int i = lookback; i < data.size(); i++) {
            double diff = Double.parseDouble(data.get(i).getChartC()) - prev;
            if (i != lookback) {
                if (diff > 0) {
                    up = (up * (lookback - 1) + diff) / lookback;
                    down = down * (lookback - 1) / lookback;
                } else {
                    down = (down * (lookback - 1) - diff) / lookback;
                    up = up * (lookback - 1) / lookback;
                }
            }
            rs = (down == 0) ? 0 : (up / down); // RS		// modified huynq 14-10-2014

            rsi[i] = 100 - 100 / (1 + rs);

            prev = Double.parseDouble(data.get(i).getChartC());
        }


        return rsi;
    }

}

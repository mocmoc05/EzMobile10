package com.trang.ez_mobile.view.watchlist.detail.chart;


import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.FragmentWatchlistChartBinding;
import com.trang.ez_mobile.model.entity.chart.HistoryChartOtherIndex;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.trang.ez_mobile.App.getInstance;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChartFrag extends Fragment implements OnChartValueSelectedListener, IChartView, OnChartGestureListener {
    private String symbol;
    FragmentWatchlistChartBinding binding;
    ChartPresenter presenter;
    private Typeface typeface;

    private ArrayList<HistoryChartOtherIndex> yVals1 = new ArrayList<>();

    public ChartFrag() {
    }

    public static ChartFrag newInstance(String symbol) {
        ChartFrag fragment = new ChartFrag();
        Bundle args = new Bundle();
        args.putString("symbol", symbol);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            symbol = getArguments().getString("symbol");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWatchlistChartBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        typeface = Typeface.createFromAsset(getInstance().getAssets(), "font/FreeSans.ttf");

        binding.barchart.setOnChartValueSelectedListener(this);
        binding.barchart.setBackgroundColor(getResources().getColor(R.color.colorBackground));
        binding.barchart.setDrawBarShadow(false);
        binding.barchart.setDrawValueAboveBar(true);
        binding.barchart.getDescription().setEnabled(false);
        binding.barchart.setMaxVisibleValueCount(10000);
        binding.barchart.setPinchZoom(false);
        binding.barchart.animateXY(1500, 1500);
        binding.barchart.setDrawGridBackground(false);
        binding.barchart.setNoDataTextColor(getResources().getColor(R.color.colorFont));
        binding.barchart.setBorderColor(getResources().getColor(R.color.colorFont));
        binding.barchart.getXAxis().setTypeface(typeface);
        binding.barchart.getAxisLeft().setTypeface(typeface);
        binding.barchart.getAxisRight().setTypeface(typeface);
        //////////////candle
        binding.candleStick.setBackgroundColor(getResources().getColor(R.color.colorBackground));
        binding.candleStick.getDescription().setEnabled(false);
        binding.candleStick.setPinchZoom(false);
        binding.candleStick.setAutoScaleMinMaxEnabled(false);
        binding.candleStick.setDoubleTapToZoomEnabled(false);
        binding.candleStick.animateY(500);
        binding.candleStick.setDrawGridBackground(false);
        binding.candleStick.getXAxis().setTypeface(typeface);
        binding.candleStick.getAxisLeft().setTypeface(typeface);
        binding.candleStick.getAxisRight().setTypeface(typeface);
        ///line
        binding.lineChart.setOnChartGestureListener(this);
        binding.lineChart.setOnChartValueSelectedListener(this);
        binding.lineChart.setDrawGridBackground(false);
        binding.lineChart.setBackgroundColor(getResources().getColor(R.color.colorBackground));
        binding.lineChart.getDescription().setEnabled(false);
        binding.lineChart.animateY(500);
        binding.lineChart.setPinchZoom(false);
        binding.lineChart.getXAxis().setTypeface(typeface);
        binding.lineChart.getAxisLeft().setTypeface(typeface);
        binding.lineChart.getAxisRight().setTypeface(typeface);

        presenter = new ChartPresenter(this, symbol, yVals1);
        binding.lineChart.setVisibility(View.VISIBLE);
        binding.candleStick.setVisibility(View.GONE);
        presenter.LoadDataDay();

        selectT();


    }


    private void selectT() {
        binding.oday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.lineChart.setVisibility(View.VISIBLE);
                binding.candleStick.setVisibility(View.GONE);

                binding.oday.setTextColor(getResources().getColor(R.color.colorFont));
                binding.tabOneWeek.setTextColor(getResources().getColor(R.color.gray));
                binding.tabOneMonth.setTextColor(getResources().getColor(R.color.gray));
                binding.tabThreeMonth.setTextColor(getResources().getColor(R.color.gray));
                binding.tabSixMonth.setTextColor(getResources().getColor(R.color.gray));
                binding.tabOneYear.setTextColor(getResources().getColor(R.color.gray));
                binding.tabAll.setTextColor(getResources().getColor(R.color.gray));
                presenter.LoadDataDay();
            }
        });

        binding.tabOneWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.lineChart.setVisibility(View.GONE);
                binding.candleStick.setVisibility(View.VISIBLE);

                binding.oday.setTextColor(getResources().getColor(R.color.gray));
                binding.tabOneWeek.setTextColor(getResources().getColor(R.color.colorFont));
                binding.tabOneMonth.setTextColor(getResources().getColor(R.color.gray));
                binding.tabThreeMonth.setTextColor(getResources().getColor(R.color.gray));
                binding.tabSixMonth.setTextColor(getResources().getColor(R.color.gray));
                binding.tabOneYear.setTextColor(getResources().getColor(R.color.gray));
                binding.tabAll.setTextColor(getResources().getColor(R.color.gray));
                presenter.loadFilter(5);
            }
        });
        binding.tabOneMonth.setOnClickListener(view -> {
            binding.lineChart.setVisibility(View.GONE);
            binding.candleStick.setVisibility(View.VISIBLE);

            binding.oday.setTextColor(getResources().getColor(R.color.gray));
            binding.tabOneWeek.setTextColor(getResources().getColor(R.color.gray));
            binding.tabOneMonth.setTextColor(getResources().getColor(R.color.colorFont));
            binding.tabThreeMonth.setTextColor(getResources().getColor(R.color.gray));
            binding.tabSixMonth.setTextColor(getResources().getColor(R.color.gray));
            binding.tabOneYear.setTextColor(getResources().getColor(R.color.gray));
            binding.tabAll.setTextColor(getResources().getColor(R.color.gray));
            presenter.loadFilter(21);
        });

        binding.tabThreeMonth.setOnClickListener(view -> {
            binding.lineChart.setVisibility(View.GONE);
            binding.candleStick.setVisibility(View.VISIBLE);

            binding.oday.setTextColor(getResources().getColor(R.color.gray));
            binding.tabOneWeek.setTextColor(getResources().getColor(R.color.gray));
            binding.tabOneMonth.setTextColor(getResources().getColor(R.color.gray));
            binding.tabThreeMonth.setTextColor(getResources().getColor(R.color.colorFont));
            binding.tabSixMonth.setTextColor(getResources().getColor(R.color.gray));
            binding.tabOneYear.setTextColor(getResources().getColor(R.color.gray));
            binding.tabAll.setTextColor(getResources().getColor(R.color.gray));
            presenter.loadFilter(63);
        });


        binding.tabSixMonth.setOnClickListener(view -> {

            binding.lineChart.setVisibility(View.GONE);
            binding.candleStick.setVisibility(View.VISIBLE);

            binding.oday.setTextColor(getResources().getColor(R.color.gray));
            binding.tabOneWeek.setTextColor(getResources().getColor(R.color.gray));
            binding.tabOneMonth.setTextColor(getResources().getColor(R.color.gray));
            binding.tabThreeMonth.setTextColor(getResources().getColor(R.color.gray));
            binding.tabSixMonth.setTextColor(getResources().getColor(R.color.colorFont));
            binding.tabOneYear.setTextColor(getResources().getColor(R.color.gray));
            binding.tabAll.setTextColor(getResources().getColor(R.color.gray));
            presenter.loadFilter(126);
        });

        binding.tabOneYear.setOnClickListener(view -> {

            binding.lineChart.setVisibility(View.GONE);
            binding.candleStick.setVisibility(View.VISIBLE);

            binding.oday.setTextColor(getResources().getColor(R.color.gray));
            binding.tabOneWeek.setTextColor(getResources().getColor(R.color.gray));
            binding.tabOneMonth.setTextColor(getResources().getColor(R.color.gray));
            binding.tabThreeMonth.setTextColor(getResources().getColor(R.color.gray));
            binding.tabSixMonth.setTextColor(getResources().getColor(R.color.gray));
            binding.tabOneYear.setTextColor(getResources().getColor(R.color.colorFont));
            binding.tabAll.setTextColor(getResources().getColor(R.color.gray));
            presenter.loadFilter(252);
        });

        binding.tabAll.setOnClickListener(view -> {

            binding.lineChart.setVisibility(View.GONE);
            binding.candleStick.setVisibility(View.VISIBLE);

            binding.oday.setTextColor(getResources().getColor(R.color.gray));
            binding.tabOneWeek.setTextColor(getResources().getColor(R.color.gray));
            binding.tabOneMonth.setTextColor(getResources().getColor(R.color.gray));
            binding.tabThreeMonth.setTextColor(getResources().getColor(R.color.gray));
            binding.tabSixMonth.setTextColor(getResources().getColor(R.color.gray));
            binding.tabOneYear.setTextColor(getResources().getColor(R.color.gray));
            binding.tabAll.setTextColor(getResources().getColor(R.color.colorFont));
            presenter.loadFilter(408);
        });

    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    @Override
    public void showChart(ArrayList<HistoryChartOtherIndex> yVals1) {
        final ArrayList<BarEntry> datachart = new ArrayList<>();
        final ArrayList<String> Date = new ArrayList<>();
        final ArrayList<CandleEntry> chartcandle = new ArrayList<>();
        final ArrayList<Entry> dataline = new ArrayList<>();

        binding.lineChart.clear();
        binding.barchart.clear();
        binding.candleStick.clear();
        for (int i = 0; i < yVals1.size(); i++) {

            datachart.add(new BarEntry(i, Float.parseFloat(yVals1.get(i).getCharV())));

            Date.add(yVals1.get(i).getCharTime());
        }


        for (int i = 0; i < yVals1.size(); i++) {

            dataline.add(new Entry(i, Float.parseFloat(yVals1.get(i).getChartH()), null));
        }

        for (int i = 0; i < yVals1.size(); i++) {

            chartcandle.add(new CandleEntry(
                    i,
                    Float.parseFloat(yVals1.get(i).getChartH()),
                    Float.parseFloat(yVals1.get(i).getChartL()),
                    Float.parseFloat(yVals1.get(i).getChartO()),
                    Float.parseFloat(yVals1.get(i).getChartC()),
                    null));
        }


        IAxisValueFormatter xAxisFormatter = new DayAxisValueFormatter(Date);

        XAxis xAxis = binding.barchart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //xAxis.setTypeface(mTfLight);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(xAxisFormatter);
        xAxis.setLabelCount(4);
        xAxis.setTextColor(getResources().getColor(R.color.colorFont));
        IAxisValueFormatter custom = new MyAxisValueFormatter();

        YAxis rightAxis = binding.barchart.getAxisRight();
        rightAxis.setValueFormatter(custom);
        rightAxis.setLabelCount(6, false);
        rightAxis.setDrawGridLines(false);
        rightAxis.setTextColor(getResources().getColor(R.color.colorFont));
        rightAxis.setDrawAxisLine(true);
        rightAxis.setEnabled(false);
        rightAxis.setAxisMinimum(2f); // start at zero
//        rightAxis.setAxisMaximum(100f); // the axis maximum is 100


        YAxis leftAxis = binding.barchart.getAxisLeft();
        leftAxis.setLabelCount(6, false);
        leftAxis.setDrawGridLines(false);
        leftAxis.setDrawAxisLine(true);
        leftAxis.setTextColor(getResources().getColor(R.color.colorFont));
        leftAxis.setEnabled(true);
        leftAxis.setValueFormatter(custom);
        leftAxis.setAxisMinimum(2f); // start at zero

        Legend legend = binding.barchart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        legend.setForm(Legend.LegendForm.SQUARE);
        legend.setFormSize(9f);
        legend.setTextSize(11f);
        legend.setXEntrySpace(4f);
        BarDataSet set1;

        if (binding.barchart.getData() != null &&
                binding.barchart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) binding.barchart.getData().getDataSetByIndex(0);
            set1.setValues(datachart);
            binding.barchart.getData().notifyDataChanged();
            binding.barchart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(datachart, "");

            set1.setDrawIcons(false);

            set1.setValueTextColor(getResources().getColor(R.color.colorFont));

            set1.setColors(getResources().getColor(R.color.green));


            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);
//
            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            //data.setValueTypeface(mTfLight);
            data.setBarWidth(0.9f);

            binding.barchart.setData(data);


            for (IDataSet set : binding.barchart.getData().getDataSets())
                set.setDrawValues(!set.isDrawValuesEnabled());

            binding.barchart.invalidate();

        }


        ////

        binding.candleStick.getXAxis().setValueFormatter(xAxisFormatter);

        XAxis xAxis1 = binding.candleStick.getXAxis();
        xAxis1.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis1.setDrawGridLines(false);
        xAxis1.setTextColor(getResources().getColor(R.color.colorFont));
        xAxis1.setGranularity(1f);
        xAxis1.setLabelCount(4);

        YAxis leftAxis1 = binding.candleStick.getAxisLeft();
//        leftAxis.setEnabled(false);
        leftAxis1.setLabelCount(7, false);
        leftAxis1.setDrawGridLines(false);
        leftAxis1.setTextColor(getResources().getColor(R.color.colorFont));
        leftAxis1.setDrawAxisLine(false);
        leftAxis1.setAxisLineColor(Color.BLACK);

        YAxis rightAxis1 = binding.candleStick.getAxisRight();
        rightAxis1.setEnabled(false);
        rightAxis1.setAxisLineColor(Color.BLACK);

        if (datachart != null && datachart.size() > 0) {
            CandleDataSet set12 = new CandleDataSet(chartcandle, "Data Set");

            set12.setDrawIcons(false);
            set12.setAxisDependency(YAxis.AxisDependency.LEFT);
            set12.setShadowColor(Color.DKGRAY);
            set12.setShadowWidth(0.7f);
            set12.setDecreasingColor(Color.RED);
            set12.setDecreasingPaintStyle(Paint.Style.FILL);
            set12.setIncreasingColor(Color.rgb(122, 242, 84));
            set12.setNeutralColor(Color.BLUE);
            set12.setIncreasingPaintStyle(Paint.Style.FILL);

            set12.setValueTextColor(getResources().getColor(R.color.colorFont));

            binding.candleStick.setData(new CandleData(set12));
            binding.candleStick.invalidate();
            binding.candleStick.getLegend().setEnabled(false);
            //
            for (IDataSet set : binding.candleStick.getData().getDataSets())
                set.setDrawValues(false);

            binding.candleStick.invalidate();

        }


        /////line

        XAxis xAxis2 = binding.lineChart.getXAxis();
        xAxis2.enableGridDashedLine(10f, 10f, 0f);
        xAxis2.setLabelCount(6);
        xAxis2.setTextColor(getResources().getColor(R.color.colorFont));
        xAxis2.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis2.setValueFormatter(xAxisFormatter);
        //Set Cột bên trái
        YAxis leftAxis2 = binding.lineChart.getAxisLeft();
        leftAxis2.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines


        //leftAxis.setYOffset(20f);
        leftAxis2.enableGridDashedLine(10f, 10f, 0f);
        leftAxis2.setDrawZeroLine(false);
        leftAxis2.setTextColor(getResources().getColor(R.color.colorFont));

        // limit lines are drawn behind data (and not on top)
        leftAxis2.setDrawLimitLinesBehindData(true);

        binding.lineChart.getAxisRight().setEnabled(false);

        LineDataSet set3;
        if (binding.lineChart.getData() != null && binding.lineChart.getData().getDataSetCount() > 0) {
            set3 = (LineDataSet) binding.lineChart.getData().getDataSetByIndex(0);
            set3.setValues(dataline);
            binding.lineChart.getData().notifyDataChanged();
            binding.lineChart.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set3 = new LineDataSet(dataline, "");

            set3.setValueTextColor(getResources().getColor(R.color.colorFont));
            set3.setDrawIcons(false);
            set3.setDrawCircles(false);
            // set the line to be drawn like this "- - - - - -"
            set3.enableDashedLine(10f, 5f, 0f);
            set3.enableDashedHighlightLine(10f, 5f, 0f);
            set3.setColor(getResources().getColor(R.color.colorFont));
            set3.setCircleColor(getResources().getColor(R.color.colorFont));
            set3.setLineWidth(0f);
            set3.setCircleRadius(0f);
            set3.setDrawCircleHole(false);
            set3.setValueTextSize(0f);
            set3.setDrawFilled(true);
            set3.setFormLineWidth(0f);
            set3.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set3.setFormSize(10f);

            set3.setFillColor(getResources().getColor(R.color.colorFont));

            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set3); // add the datasets

            // create a data object with the datasets
            LineData data = new LineData(dataSets);
            binding.lineChart.setData(data);


        }
        Legend l = binding.lineChart.getLegend();
        l.setForm(Legend.LegendForm.LINE);

        //dont forget to refresh the drawing
        binding.lineChart.invalidate();
        //show values
        if (binding.lineChart.getData() != null && binding.lineChart.getData().getDataSets() != null) {
            List<ILineDataSet> sets = binding.lineChart.getData().getDataSets();
            for (ILineDataSet iSet : sets) {
                LineDataSet set = (LineDataSet) iSet;
                set.setDrawValues(true);
            }
            binding.lineChart.invalidate();
        }

        if (binding.lineChart.getVisibleXRange() > 50) {
            for (IDataSet set : binding.lineChart.getData().getDataSets())
                set.setDrawValues(false);
        }


    }

    @Override
    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    @Override
    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    @Override
    public void onChartLongPressed(MotionEvent me) {

    }

    @Override
    public void onChartDoubleTapped(MotionEvent me) {

    }

    @Override
    public void onChartSingleTapped(MotionEvent me) {

    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {

    }

    private class DayAxisValueFormatter implements IAxisValueFormatter {

        private ArrayList<String> Date = new ArrayList<>();

        public DayAxisValueFormatter(ArrayList<String> Date) {
            this.Date = Date;
        }


        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            if (value >= Date.size()) return null;
            else
                return Date.get((int) value);
        }
    }

    private class MyAxisValueFormatter implements IAxisValueFormatter {

        private DecimalFormat mFormat;

        public MyAxisValueFormatter() {
            mFormat = new DecimalFormat("0.0M");
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mFormat.format(value / 1000000);
        }
    }
}

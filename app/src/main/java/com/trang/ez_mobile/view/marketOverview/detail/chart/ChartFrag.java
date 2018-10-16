package com.trang.ez_mobile.view.marketOverview.detail.chart;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.FragmentMarketOverviewChartBinding;
import com.trang.ez_mobile.util.ColorTr;
import com.trang.ez_mobile.util.ErrorApp;
import com.trang.ez_mobile.util.custormView.TextViewFontBold;
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
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.makeText;
import static com.trang.ez_mobile.App.getInstance;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_ALL;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_ONE_DAY;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_ONE_MONTH;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_ONE_WEEK;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_ONE_YEAR;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_SIX_MONTH;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_THREE_MONTH;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_TWO_YEAR;
import static java.lang.Float.parseFloat;

public class ChartFrag extends Fragment implements View.OnClickListener, IChart_View {

    FragmentMarketOverviewChartBinding binding;

    private static final String ARG_PARAM_MARKET_NAME = "ARG_PARAM_MARKET_NAME";

    private Typeface typeface;

    private String marketName;
    Chart_Presenter presenter;

    public ChartFrag() {
    }

    public static ChartFrag newInstance(String marketName) {
        ChartFrag fragment = new ChartFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_MARKET_NAME, marketName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            marketName = getArguments().getString(ARG_PARAM_MARKET_NAME);
        }
        typeface = Typeface.createFromAsset(getInstance().getAssets(), "font/FreeSans.ttf");

        presenter = new Chart_Presenter(this, marketName);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMarketOverviewChartBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.lineChart.getDescription().setEnabled(false);
        binding.lineChart.setPinchZoom(false);
        binding.lineChart.setDrawGridBackground(false);
        binding.lineChart.setScaleEnabled(false);

        binding.barChart.setPinchZoom(false);
        binding.barChart.getDescription().setEnabled(false);
        binding.barChart.setDrawGridBackground(false);
        binding.barChart.setScaleEnabled(false);

        binding.candleStickChart.getDescription().setEnabled(false);
        binding.candleStickChart.setPinchZoom(false);
        binding.candleStickChart.setDrawGridBackground(false);
        binding.candleStickChart.setScaleEnabled(false);

        binding.tabOneDay.setOnClickListener(this);
        binding.tabOneWeek.setOnClickListener(this);
        binding.tabOneMonth.setOnClickListener(this);
        binding.tabThreeMonth.setOnClickListener(this);
        binding.tabSixMonth.setOnClickListener(this);
        binding.tabOneYear.setOnClickListener(this);
        binding.tabTwoYear.setOnClickListener(this);
        binding.tabAll.setOnClickListener(this);

        selectTap(TYPE_CHART_ONE_DAY);
    }

    private void selectTap(int position) {
        for (int i = 0; i < binding.menuTab.getChildCount(); i++) {
            TextViewFontBold textview = (TextViewFontBold) binding.menuTab.getChildAt(i);
            textview.setBackgroundResource(R.drawable.bg_home_tab_selector);
            textview.setTextColor(App.getInstance().getResources().getColor(R.color.black));
        }
        if (binding.barChart != null) {
            binding.barChart.clear();
        }
        if (binding.candleStickChart != null) {
            binding.candleStickChart.clear();
        }
        if (binding.lineChart != null) {
            binding.lineChart.clear();
        }
        switch (position) {
            case TYPE_CHART_ONE_DAY:
                binding.tabOneDay.setBackgroundResource(R.drawable.bg_home_tab_selector_selected);
                binding.tabOneDay.setTextColor(App.getInstance().getResources().getColor(R.color.white));
                presenter.selectTab(TYPE_CHART_ONE_DAY);
                break;
            case TYPE_CHART_ONE_WEEK:
                presenter.selectTab(TYPE_CHART_ONE_WEEK);
                binding.tabOneWeek.setBackgroundResource(R.drawable.bg_home_tab_selector_selected);
                binding.tabOneWeek.setTextColor(App.getInstance().getResources().getColor(R.color.white));
                break;
            case TYPE_CHART_ONE_MONTH:
                presenter.selectTab(TYPE_CHART_ONE_MONTH);
                binding.tabOneMonth.setBackgroundResource(R.drawable.bg_home_tab_selector_selected);
                binding.tabOneMonth.setTextColor(App.getInstance().getResources().getColor(R.color.white));
                break;
            case TYPE_CHART_THREE_MONTH:
                presenter.selectTab(TYPE_CHART_THREE_MONTH);
                binding.tabThreeMonth.setBackgroundResource(R.drawable.bg_home_tab_selector_selected);
                binding.tabThreeMonth.setTextColor(App.getInstance().getResources().getColor(R.color.white));
                break;
            case TYPE_CHART_SIX_MONTH:
                presenter.selectTab(TYPE_CHART_SIX_MONTH);
                binding.tabSixMonth.setBackgroundResource(R.drawable.bg_home_tab_selector_selected);
                binding.tabSixMonth.setTextColor(App.getInstance().getResources().getColor(R.color.white));
                break;
            case TYPE_CHART_ONE_YEAR:
                presenter.selectTab(TYPE_CHART_ONE_YEAR);
                binding.tabOneYear.setBackgroundResource(R.drawable.bg_home_tab_selector_selected);
                binding.tabOneYear.setTextColor(App.getInstance().getResources().getColor(R.color.white));
                break;
            case TYPE_CHART_TWO_YEAR:
                presenter.selectTab(TYPE_CHART_TWO_YEAR);
                binding.tabTwoYear.setBackgroundResource(R.drawable.bg_home_tab_selector_selected);
                binding.tabTwoYear.setTextColor(App.getInstance().getResources().getColor(R.color.white));
                break;
            case TYPE_CHART_ALL:
                presenter.selectTab(TYPE_CHART_ALL);
                binding.tabAll.setBackgroundResource(R.drawable.bg_home_tab_selector_selected);
                binding.tabAll.setTextColor(App.getInstance().getResources().getColor(R.color.white));
                break;
            default:
                binding.tabOneDay.setBackgroundResource(R.drawable.bg_home_tab_selector_selected);
                binding.tabOneDay.setTextColor(App.getInstance().getResources().getColor(R.color.white));
                presenter.selectTab(TYPE_CHART_ONE_DAY);
                break;
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == binding.tabOneDay.getId()) {
            selectTap(TYPE_CHART_ONE_DAY);
        } else if (v.getId() == binding.tabOneWeek.getId()) {
            selectTap(TYPE_CHART_ONE_WEEK);
        } else if (v.getId() == binding.tabOneMonth.getId()) {
            selectTap(TYPE_CHART_ONE_MONTH);
        } else if (v.getId() == binding.tabThreeMonth.getId()) {
            selectTap(TYPE_CHART_THREE_MONTH);
        } else if (v.getId() == binding.tabSixMonth.getId()) {
            selectTap(TYPE_CHART_SIX_MONTH);
        } else if (v.getId() == binding.tabOneYear.getId()) {
            selectTap(TYPE_CHART_ONE_YEAR);
        } else if (v.getId() == binding.tabTwoYear.getId()) {
            selectTap(TYPE_CHART_TWO_YEAR);
        } else if (v.getId() == binding.tabAll.getId()) {
            selectTap(TYPE_CHART_ALL);
        }
    }

    @Override
    public void onError(ErrorApp error) {
        switch (error) {
            case ERROR_CONNECT_SERVER:
                break;
            case ERROR_NETWORK:
                makeText(getInstance(), R.string.network_error, Toast.LENGTH_SHORT).show();
                break;
            case NULL:
                break;
            case EXCEPTION:
                break;
            default:
                break;
        }
    }

    @Override
    public void onDisplay(List<ChartIndex> dataList) {
        showCandleStickChart(dataList);
        showBarchart(dataList);
        binding.lineChart.setVisibility(View.GONE);
        binding.candleStickChart.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDisplayOneDay(List<ChartIndex> chartIndexData) {
        showLineChart(chartIndexData);
        showBarchart(chartIndexData);
        binding.lineChart.setVisibility(View.VISIBLE);
        binding.candleStickChart.setVisibility(View.GONE);
    }

    private void showLineChart(List<ChartIndex> dataList) {
        binding.lineChart.getLegend().setEnabled(false);
        final ArrayList<Entry> datachart = new ArrayList<>();
        final ArrayList<String> Date = new ArrayList<>();
        binding.lineChart.clear();
        for (int i = 0; i < dataList.size(); i++) {
            try {
                datachart.add(new Entry(i, parseFloat(dataList.get(i).getChartIndexHigh()), null));
                Date.add(dataList.get(i).getChartIndexTime());
            } catch (Exception e) {
                Log.w("ChartFrag", "showLineChart: i = " + i);
                e.printStackTrace();
            }
        }

        IAxisValueFormatter xAxisFormatter = new DayAxisValueFormatter(Date);
        XAxis xAxis = binding.lineChart.getXAxis();
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        xAxis.setTypeface(typeface);
        xAxis.setLabelCount(4);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(xAxisFormatter);
        //Set Cột bên trái
        YAxis leftAxis = binding.lineChart.getAxisLeft();
        leftAxis.setTypeface(typeface);
        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
        leftAxis.setDrawGridLines(false);
        YAxis rightAxis = binding.lineChart.getAxisRight();
        rightAxis.setTypeface(typeface);
        rightAxis.setDrawGridLines(false);
        leftAxis.enableGridDashedLine(10f, 10f, 10f);
        leftAxis.setDrawZeroLine(false);
        // limit lines are drawn behind data (and not on top)
        leftAxis.setDrawLimitLinesBehindData(true);

        LineDataSet set1;
        if (binding.lineChart.getData() != null && binding.lineChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) binding.lineChart.getData().getDataSetByIndex(0);
            set1.setValues(datachart);
            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            binding.lineChart.getData().notifyDataChanged();
            binding.lineChart.notifyDataSetChanged();

        } else {
            // create a dataset and give it a type
            set1 = new LineDataSet(datachart, "");
            set1.setDrawIcons(false);
            set1.setDrawCircles(false);
            // set the line to be drawn like this "- - - - - -"
            set1.enableDashedLine(10f, 5f, 0f);
            set1.enableDashedHighlightLine(10f, 5f, 0f);
            set1.setColor(getInstance().getResources().getColor(R.color.black));
            set1.setCircleColor(getInstance().getResources().getColor(R.color.black));
            set1.setLineWidth(1f);
            set1.setDrawCircleHole(false);
            set1.setValueTextSize(0f);
            set1.setDrawFilled(true);
            set1.setFormLineWidth(1f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(10f);
            set1.setFillColor(getInstance().getResources().getColor(R.color.white));

            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1); // add the datasets
            LineData data = new LineData(dataSets);
            binding.lineChart.setData(data);

        }
        binding.lineChart.getLegend().setForm(Legend.LegendForm.LINE);
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

    private void showBarchart(List<ChartIndex> chartIndexData) {
        binding.barChart.setDrawBarShadow(false);
        binding.barChart.setDrawValueAboveBar(true);
        binding.barChart.getXAxis().setTypeface(typeface);

        final ArrayList<BarEntry> datachart = new ArrayList<>();
        final ArrayList<String> datetime = new ArrayList<>();
        binding.barChart.clear();
        for (int i = 0; i < chartIndexData.size(); i++) {
            try {
                datachart.add(new BarEntry(i, parseFloat(chartIndexData.get(i).getChartIndexVolumn())));
                datetime.add(chartIndexData.get(i).getChartIndexTime());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        IAxisValueFormatter xAxisFormatter = new DayAxisValueFormatter(datetime);

        XAxis xAxis = binding.barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(xAxisFormatter);
        xAxis.setLabelCount(4);

        //phần chú thích
        binding.barChart.getLegend().setEnabled(false);

        IAxisValueFormatter custom = new MyAxisValueFormatter();
        YAxis rightAxis = binding.barChart.getAxisRight();
        rightAxis.setTypeface(typeface);
        rightAxis.setValueFormatter(custom);
        rightAxis.setLabelCount(4, false);
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinimum(2f); // start at zero

        YAxis leftAxis = binding.barChart.getAxisLeft();
        leftAxis.setTypeface(typeface);
        leftAxis.setLabelCount(4, false);
        leftAxis.setDrawGridLines(false);
        leftAxis.setValueFormatter(custom);
        leftAxis.setAxisMinimum(2f); // start at zero

        BarDataSet set1;
        if (binding.barChart.getData() != null &&
                binding.barChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) binding.barChart.getData().getDataSetByIndex(0);
            set1.setValues(datachart);
            binding.barChart.getData().notifyDataChanged();
            binding.barChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(datachart, "");
            set1.setDrawIcons(false);
            set1.setColors(App.getInstance().getResources().getColor(R.color.green));
            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);
            BarData data = new BarData(dataSets);
            data.setValueTypeface(typeface);
            data.setValueTextSize(10f);
            data.setBarWidth(0.9f);

            binding.barChart.setData(data);
            for (IDataSet set : binding.barChart.getData().getDataSets())
                set.setDrawValues(!set.isDrawValuesEnabled());
            binding.barChart.invalidate();
        }
    }

    private void showCandleStickChart(List<ChartIndex> dataListt) {
        final ArrayList<CandleEntry> datachart = new ArrayList<>();
        final ArrayList<String> Date = new ArrayList<>();
        binding.candleStickChart.clear();
        for (int i = 0; i < dataListt.size(); i++) {
            datachart.add(new CandleEntry(
                    i,
                    parseFloat(dataListt.get(i).getChartIndexHigh()),
                    parseFloat(dataListt.get(i).getChartIndexLow()),
                    parseFloat(dataListt.get(i).getChartIndexOpen()),
                    parseFloat(dataListt.get(i).getChartIndexClose()),
                    null));

            Date.add(dataListt.get(i).getChartIndexTime());
        }
        IAxisValueFormatter xAxisFormatter = new DayAxisValueFormatter(Date);
        binding.candleStickChart.getXAxis().setValueFormatter(xAxisFormatter);

        XAxis xAxis = binding.candleStickChart.getXAxis();
        xAxis.setTypeface(typeface);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(4);

        YAxis leftAxis = binding.candleStickChart.getAxisLeft();
        leftAxis.setTypeface(typeface);
        leftAxis.setLabelCount(7, false);
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisLineColor(Color.BLACK);
        YAxis rightAxis = binding.candleStickChart.getAxisRight();

        rightAxis.setTypeface(typeface);
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisLineColor(Color.BLACK);

        if (datachart != null && datachart.size() > 0) {
            CandleDataSet set1 = new CandleDataSet(datachart, " ");
            set1.setDrawIcons(false);
            set1.setAxisDependency(YAxis.AxisDependency.LEFT);
            set1.setShadowColor(Color.DKGRAY);
            set1.setShadowWidth(0.7f);
            set1.setDecreasingColor(App.getInstance().getResources().getColor(R.color.red));
            set1.setDecreasingPaintStyle(Paint.Style.FILL);
            set1.setIncreasingColor(Color.rgb(122, 242, 84));
            set1.setNeutralColor(App.getInstance().getResources().getColor(R.color.green));
            set1.setIncreasingPaintStyle(Paint.Style.FILL);
            binding.candleStickChart.setData(new CandleData(set1));
            binding.candleStickChart.invalidate();
            binding.candleStickChart.getLegend().setEnabled(false);
            //
            for (IDataSet set : binding.candleStickChart.getData().getDataSets())
                set.setDrawValues(false);
            binding.candleStickChart.invalidate();
        }
    }

    private class DayAxisValueFormatter implements IAxisValueFormatter {

        private ArrayList<String> data = new ArrayList<>();

        public DayAxisValueFormatter(ArrayList<String> Date) {
            this.data = Date;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            if (value >= data.size() || value < 0) return null;
            else {
                try {
                    String[] lines = data.get((int) value).split("-");
                    if (lines.length >= 2) {
                        return lines[2] + "-" + lines[1] + "-" + lines[0];
                    }
                    return data.get((int) value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    private class MyAxisValueFormatter implements IAxisValueFormatter {
        private DecimalFormat formatM;
        private DecimalFormat formatK;

        public MyAxisValueFormatter() {
            formatM = new DecimalFormat("0.0M");
            formatK = new DecimalFormat("0.0K");
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            if (value / 1000000 > 1) {
                return formatM.format(value / 1000000);
            }
            return value / 1000 > 1 ? formatK.format(value / 1000) : value + "";// + " $";
        }
    }
}

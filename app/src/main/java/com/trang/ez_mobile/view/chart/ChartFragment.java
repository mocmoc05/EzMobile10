package com.trang.ez_mobile.view.chart;


import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.DialogChartCustomBinding;
import com.trang.ez_mobile.databinding.FragmentChartBinding;
import com.trang.ez_mobile.model.entity.chart.HistoryChartOtherIndex;
import com.trang.ez_mobile.model.entity.chart.MacdData;
import com.trang.ez_mobile.util.custormView.TextViewFontBold;
import com.trang.ez_mobile.util.getData;
import com.github.mikephil.charting.charts.CombinedChart;

import java.util.ArrayList;
import java.util.List;

import static com.trang.ez_mobile.App.getInstance;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_ALL;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_ONE_MONTH;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_ONE_WEEK;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_ONE_YEAR;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_SIX_MONTH;
import static com.trang.ez_mobile.util.Define.TYPE_CHART_THREE_MONTH;

public class ChartFragment extends Fragment implements IChartView, View.OnClickListener {
    private Typeface typeface;

    FragmentChartBinding binding;
    int a = 12, b = 26, c = 9;
    String[] listchart = {"Volume", "MACD", "RSI", "Bolinger Band", "EMA", "Stochastics"};

    List<String> lg = new ArrayList<>();
    private String key = "Volume";
    private int count = 5;
    List<String> list = new ArrayList<>();
    private ChartPresenter pr;
    private ArrayList<HistoryChartOtherIndex> yVals1 = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        typeface = Typeface.createFromAsset(getInstance().getAssets(), "font/FreeSans.ttf");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chart, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.chart1);
        setAdapter();
        chartconfig();
        binding.type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (listchart[i]) {
                    case "Volume":
                        key = "Volume";
                        pr.loadFilter(count, key, a, b, c);
                        binding.barchart.setVisibility(View.VISIBLE);
                        binding.char1.setVisibility(View.GONE);
                        binding.char2.setVisibility(View.GONE);
                        binding.candleStick.setVisibility(View.VISIBLE);
                        break;
                    case "MACD":
                        key = "MACD";
                        showDialog(key);
                        break;
                    case "RSI":
                        key = "RSI";
                        showDialog(key);
                        break;
                    case "Bolinger Band":
                        key = "Bolinger Band";
                        showDialog(key);
                        break;
                    case "EMA":
                        key = "EMA";
                        showDialog(key);
                        break;
                    case "Stochastics":
                        key = "Stochastics";
                        showDialog(key);

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        pr = new ChartPresenter(this, App.getInstance(), yVals1);

        binding.code.setOnItemClickListener((parent, view1, position, id) -> {
            String code = binding.code.getText().toString();
            code = code.substring(0, code.indexOf("-")).trim();

            pr.loadDt(code, count, key, a, b, c);
            binding.code.setText("");
            getActivity().setTitle("Biểu đồ " + code);
            ((AppCompatActivity) getActivity()).getSupportActionBar()
                    .setTitle(App.getInstance().getResources().getString(R.string.chart1) + " " + code);
            hidekeyBoard();
        });
//        getActivity().setTitle("Biểu đồ VNINDEX");
        selectTap(TYPE_CHART_ONE_WEEK);

        binding.tabOneWeek.setOnClickListener(this);
        binding.tabOneMonth.setOnClickListener(this);
        binding.tabThreeMonth.setOnClickListener(this);
        binding.tabSixMonth.setOnClickListener(this);
        binding.tabOneYear.setOnClickListener(this);
        binding.tabAll.setOnClickListener(this);
    }

    private void hidekeyBoard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void setAdapter() {
        for (int i = 0; i < listchart.length; i++) {
            list.add(listchart[i]);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter(App.getInstance(), R.layout.item_chart_spinner_layout, list);
        adapter.setDropDownViewResource(R.layout.item_chart_spinner_layout);
        binding.type.setAdapter(adapter);
    }

    private void showDialog(final String key1) {
        final Dialog dialog = new Dialog(getContext());
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        final DialogChartCustomBinding bd =
                DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.dialog_chart_custom, null, false);
        dialog.setContentView(bd.getRoot());
        bd.tieude.setText(key1);
        switch (key1) {
            case "MACD":
                bd.name.setHint("Fast avg (12)");
                bd.name1.setHint("Slow avg (26)");
                bd.name2.setHint("Singal avg (9)");
                setEditTextMaxLength(bd.name2, 1);
                break;
            case "RSI":
                bd.name.setHint("Period (14)");
                bd.name1.setVisibility(View.GONE);
                bd.name2.setVisibility(View.GONE);
                break;
            case "Stochastics":
                bd.name.setHint("Period (14)");
                bd.name1.setHint("%K avg (3)");
                bd.name2.setHint("%D avg (3)");
                bd.name1.setVisibility(View.VISIBLE);
                bd.name2.setVisibility(View.VISIBLE);
                setEditTextMaxLength(bd.name1, 1);
                setEditTextMaxLength(bd.name2, 1);
                break;
            case "Bolinger Band":
                bd.name.setHint("Period (20)");
                bd.name1.setHint("Deviations (2.0)");
                bd.name1.setVisibility(View.VISIBLE);
                bd.name2.setVisibility(View.GONE);
                setEditTextMaxLength(bd.name1, 1);
                break;
            case "EMA":
                bd.name.setHint("First period (5)");
                setEditTextMaxLength(bd.name, 1);
                bd.name1.setVisibility(View.GONE);
                bd.name2.setVisibility(View.GONE);
                break;
        }
        bd.save.setOnClickListener(v -> {
            switch (key1) {
                case "MACD":
                    if (bd.name.getText().toString().equals("")) a = 12;
                    else a = Integer.parseInt(bd.name.getText().toString());
                    if (bd.name1.getText().toString().equals("")) b = 26;
                    else b = Integer.parseInt(bd.name1.getText().toString());
                    if (bd.name2.getText().toString().equals("")) c = 9;
                    else c = Integer.parseInt(bd.name2.getText().toString());

                    if (a > 12 || b > 26 || c > 9) showMess();
                    else {
                        pr.loadFilter(count, key1, a, b, c);
                        binding.barchart.setVisibility(View.GONE);
                        binding.char1.setVisibility(View.VISIBLE);
                        binding.char2.setVisibility(View.GONE);
                        binding.candleStick.setVisibility(View.VISIBLE);
                        dialog.dismiss();
                    }
                    break;
                case "RSI":
                    if (bd.name.getText().toString().equals("")) a = 14;
                    else a = Integer.parseInt(bd.name.getText().toString());


                    if (a > 14) showMess();
                    else {
                        pr.computing(key1, a, b, c, count);
//                            pr.loadFilter(count, key1, a, b, c);
                        binding.barchart.setVisibility(View.GONE);
                        binding.char1.setVisibility(View.GONE);
                        binding.lineChart.setVisibility(View.VISIBLE);
                        binding.char2.setVisibility(View.GONE);
                        binding.candleStick.setVisibility(View.VISIBLE);
                        dialog.dismiss();
                    }
                    break;
                case "Stochastics":
                    if (bd.name.getText().toString().equals("")) a = 14;
                    else a = Integer.parseInt(bd.name.getText().toString());
                    if (bd.name1.getText().toString().equals("")) b = 3;
                    else b = Integer.parseInt(bd.name1.getText().toString());
                    if (bd.name2.getText().toString().equals("")) c = 3;
                    else b = Integer.parseInt(bd.name2.getText().toString());
                    if (a > 14 || b > 3 || c > 3) showMess();
                    else {
                        pr.computing(key1, a, b, c, count);
                        binding.barchart.setVisibility(View.GONE);
                        binding.char1.setVisibility(View.GONE);
                        binding.lineChart.setVisibility(View.VISIBLE);
                        binding.char2.setVisibility(View.GONE);
                        binding.candleStick.setVisibility(View.VISIBLE);

                        dialog.dismiss();
                    }
                    break;
                case "Bolinger Band":

                    if (bd.name.getText().toString().equals("")) a = 20;
                    else a = Integer.parseInt(bd.name.getText().toString());
                    if (bd.name1.getText().toString().equals("")) b = 2;
                    else b = Integer.parseInt(bd.name1.getText().toString());
                    if (a > 20 || b > 2) showMess();
                    else {
                        pr.computing(key1, a, b, c, count);
                        binding.barchart.setVisibility(View.VISIBLE);
                        binding.char2.setVisibility(View.VISIBLE);
                        binding.char1.setVisibility(View.GONE);
                        binding.lineChart.setVisibility(View.GONE);
                        binding.candleStick.setVisibility(View.GONE);
                        dialog.dismiss();
                    }
                    break;

                case "EMA":
                    if (bd.name.getText().toString().equals("")) a = 5;
                    else a = Integer.parseInt(bd.name.getText().toString());

                    if (a > 5) showMess();
                    else {
                        pr.computing(key1, a, b, c, count);
                        binding.barchart.setVisibility(View.VISIBLE);
                        binding.char2.setVisibility(View.VISIBLE);
                        binding.char1.setVisibility(View.GONE);
                        binding.lineChart.setVisibility(View.GONE);
                        binding.candleStick.setVisibility(View.GONE);

                        dialog.dismiss();
                    }
                    break;
            }
        });
        bd.exit.setOnClickListener(v -> {
            key = "Volume";
            binding.type.setSelection(0);
            dialog.dismiss();
        });
        dialog.setCancelable(false);
        dialog.show();
    }

    private void setEditTextMaxLength(final EditText editText, int length) {
        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(length);
        editText.setFilters(FilterArray);
    }

    private void showMess() {
        Toast.makeText(App.getInstance(), "Giá trị không được lớn hơn giá trị mặc định!", Toast.LENGTH_SHORT).show();
    }

    private void selectTap(int position) {
        for (int i = 0; i < binding.menuTab.getChildCount(); i++) {
            TextViewFontBold textview = (TextViewFontBold) binding.menuTab.getChildAt(i);
            textview.setBackgroundResource(R.drawable.bg_home_tab_selector);
            textview.setTextColor(App.getInstance().getResources().getColor(R.color.gray));
        }
        switch (position) {

            case TYPE_CHART_ONE_WEEK:
                pr.loadFilter(5, key, a, b, c);
                count = 5;
                binding.tabOneWeek.setBackgroundResource(R.drawable.bg_home_tab_selector_selected);
                binding.tabOneWeek.setTextColor(App.getInstance().getResources().getColor(R.color.colorFont));
                break;
            case TYPE_CHART_ONE_MONTH:
                pr.loadFilter(21, key, a, b, c);
                count = 21;
                binding.tabOneMonth.setBackgroundResource(R.drawable.bg_home_tab_selector_selected);
                binding.tabOneMonth.setTextColor(App.getInstance().getResources().getColor(R.color.colorFont));
                break;
            case TYPE_CHART_THREE_MONTH:
                pr.loadFilter(63, key, a, b, c);
                count = 63;
                binding.tabThreeMonth.setBackgroundResource(R.drawable.bg_home_tab_selector_selected);
                binding.tabThreeMonth.setTextColor(App.getInstance().getResources().getColor(R.color.colorFont));
                break;
            case TYPE_CHART_SIX_MONTH:
                pr.loadFilter(126, key, a, b, c);
                count = 126;
                binding.tabSixMonth.setBackgroundResource(R.drawable.bg_home_tab_selector_selected);
                binding.tabSixMonth.setTextColor(App.getInstance().getResources().getColor(R.color.colorFont));
                break;
            case TYPE_CHART_ONE_YEAR:
                pr.loadFilter(252, key, a, b, c);
                count = 252;
                binding.tabOneYear.setBackgroundResource(R.drawable.bg_home_tab_selector_selected);
                binding.tabOneYear.setTextColor(App.getInstance().getResources().getColor(R.color.colorFont));
                break;
            case TYPE_CHART_ALL:
                pr.loadFilter(408, key, a, b, c);
                count = 408;
                binding.tabAll.setBackgroundResource(R.drawable.bg_home_tab_selector_selected);
                binding.tabAll.setTextColor(App.getInstance().getResources().getColor(R.color.colorFont));
                break;
            default:
                binding.tabOneWeek.setBackgroundResource(R.drawable.bg_home_tab_selector_selected);
                binding.tabOneWeek.setTextColor(App.getInstance().getResources().getColor(R.color.colorFont));
                break;
        }
    }

    private void chartconfig() {
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
        binding.barchart.getLegend().setEnabled(false);
        binding.barchart.getXAxis().setTypeface(typeface);
        binding.barchart.getAxisLeft().setTypeface(typeface);
        binding.barchart.getAxisRight().setTypeface(typeface);

        binding.char1.getDescription().setEnabled(false);
        binding.char1.setBackgroundColor(Color.WHITE);
        binding.char1.setDrawGridBackground(false);

        binding.char1.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.LINE
        });
        binding.char2.getDescription().setEnabled(false);
        binding.char2.setBackgroundColor(Color.WHITE);
        binding.char2.setDrawGridBackground(false);
        binding.char2.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.CANDLE, CombinedChart.DrawOrder.LINE
        });
        binding.char2.getXAxis().setTypeface(typeface);
        binding.char2.getAxisLeft().setTypeface(typeface);
        binding.char2.getAxisRight().setTypeface(typeface);
        ///line
//        binding.lineChart.setOnChartValueSelectedListener(this);
        binding.lineChart.setDrawGridBackground(false);
        binding.lineChart.setBackgroundColor(Color.WHITE);
        binding.lineChart.getLegend().setEnabled(false);
        // no description text
        binding.lineChart.getDescription().setEnabled(false);
        // if disabled, scaling can be done on x- and y-axis separately
        binding.lineChart.setPinchZoom(false);
        binding.lineChart.animateY(500);
        binding.lineChart.getXAxis().setTypeface(typeface);
        binding.lineChart.getAxisLeft().setTypeface(typeface);
        binding.lineChart.getAxisRight().setTypeface(typeface);
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
    }

    private ArrayList<String> getDate(ArrayList<HistoryChartOtherIndex> yVals1) {
        final ArrayList<String> Date = new ArrayList<>();
        for (int i = 0; i < yVals1.size(); i++) {
            Date.add(yVals1.get(i).getCharTime());
        }
        return Date;
    }

    @Override
    public void showChart(ArrayList<HistoryChartOtherIndex> yVals1) {
        binding.candleStick.clear();
        binding.barchart.clear();
        binding.char1.clear();
        binding.char2.clear();
        binding.lineChart.clear();
        getData.getCendel(App.getInstance(), binding, yVals1, getDate(yVals1));
        getData.getBarValue(App.getInstance(), binding, yVals1, getDate(yVals1));
    }

    @Override
    public void showChart(ArrayList<HistoryChartOtherIndex> yVals1, List<MacdData> getMacd) {
        binding.candleStick.clear();
        binding.barchart.clear();
        binding.char1.clear();
        binding.char2.clear();
        binding.lineChart.clear();
        getData.getCendel(App.getInstance(), binding, yVals1, getDate(yVals1));
        getData.getcombind(App.getInstance(), binding, getMacd, getDate(yVals1));
    }

    @Override
    public void showChart(ArrayList<HistoryChartOtherIndex> yVals1, ArrayList<Double> sma, ArrayList<Double> sma1, double[] listRsi, String key, int p1, int p3) {
        binding.candleStick.clear();
        binding.barchart.clear();
        binding.char1.clear();
        binding.char2.clear();
        binding.lineChart.clear();
        getData.getCendel(App.getInstance(), binding, yVals1, getDate(yVals1));
        getData.showlineC(App.getInstance(), binding, listRsi, sma, sma1, getDate(yVals1), p1, p3, key);
    }

    @Override
    public void showChart(ArrayList<Double> top, ArrayList<Double> mid, ArrayList<Double> bot, ArrayList<Float> ema, ArrayList<HistoryChartOtherIndex> yVals1, String key) {
        binding.candleStick.clear();
        binding.barchart.clear();
        binding.char1.clear();
        binding.char2.clear();
        binding.lineChart.clear();
        getData.getcombind1(App.getInstance(), binding, yVals1, ema, top, mid, bot, getDate(yVals1), key);
        getData.getBarValue(App.getInstance(), binding, yVals1, getDate(yVals1));
    }

    @Override
    public void onload() {
        binding.load.setVisibility(View.VISIBLE);
    }

    @Override
    public void loadok() {
        binding.load.setVisibility(View.GONE);
    }

    @Override
    public void loadNamecpn(List<String> lg) {
        this.lg = lg;
//        ArrayAdapter adapter = new
//                ArrayAdapter(this, android.R.layout.simple_list_item_1, lg);
        Adapter_filter adapter_filter = new Adapter_filter(App.getInstance(), R.layout.spin_chart_layout, lg);
        binding.code.setAdapter(adapter_filter);
        binding.code.setThreshold(1);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == binding.tabOneWeek.getId()) {
            selectTap(TYPE_CHART_ONE_WEEK);
        } else if (v.getId() == binding.tabOneMonth.getId()) {
            selectTap(TYPE_CHART_ONE_MONTH);
        } else if (v.getId() == binding.tabThreeMonth.getId()) {
            selectTap(TYPE_CHART_THREE_MONTH);
        } else if (v.getId() == binding.tabSixMonth.getId()) {
            selectTap(TYPE_CHART_SIX_MONTH);
        } else if (v.getId() == binding.tabOneYear.getId()) {
            selectTap(TYPE_CHART_ONE_YEAR);
        } else if (v.getId() == binding.tabAll.getId()) {
            selectTap(TYPE_CHART_ALL);
        }
    }
}


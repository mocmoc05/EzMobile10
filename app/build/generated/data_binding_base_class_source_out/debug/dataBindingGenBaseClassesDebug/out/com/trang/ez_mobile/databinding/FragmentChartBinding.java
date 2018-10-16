package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.LineChart;
import com.trang.ez_mobile.util.custormView.AutoCompleteTextViewFont;
import com.trang.ez_mobile.util.custormView.SpinnerFont;
import com.trang.ez_mobile.util.custormView.TextViewFontBold;

public abstract class FragmentChartBinding extends ViewDataBinding {
  @NonNull
  public final BarChart barchart;

  @NonNull
  public final CandleStickChart candleStick;

  @NonNull
  public final CombinedChart char1;

  @NonNull
  public final CombinedChart char2;

  @NonNull
  public final AutoCompleteTextViewFont code;

  @NonNull
  public final LineChart lineChart;

  @NonNull
  public final LinearLayout ln1;

  @NonNull
  public final ProgressBar load;

  @NonNull
  public final LinearLayout menuTab;

  @NonNull
  public final TextViewFontBold tabAll;

  @NonNull
  public final TextViewFontBold tabOneMonth;

  @NonNull
  public final TextViewFontBold tabOneWeek;

  @NonNull
  public final TextViewFontBold tabOneYear;

  @NonNull
  public final TextViewFontBold tabSixMonth;

  @NonNull
  public final TextViewFontBold tabThreeMonth;

  @NonNull
  public final SpinnerFont type;

  protected FragmentChartBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, BarChart barchart, CandleStickChart candleStick, CombinedChart char1,
      CombinedChart char2, AutoCompleteTextViewFont code, LineChart lineChart, LinearLayout ln1,
      ProgressBar load, LinearLayout menuTab, TextViewFontBold tabAll, TextViewFontBold tabOneMonth,
      TextViewFontBold tabOneWeek, TextViewFontBold tabOneYear, TextViewFontBold tabSixMonth,
      TextViewFontBold tabThreeMonth, SpinnerFont type) {
    super(_bindingComponent, _root, _localFieldCount);
    this.barchart = barchart;
    this.candleStick = candleStick;
    this.char1 = char1;
    this.char2 = char2;
    this.code = code;
    this.lineChart = lineChart;
    this.ln1 = ln1;
    this.load = load;
    this.menuTab = menuTab;
    this.tabAll = tabAll;
    this.tabOneMonth = tabOneMonth;
    this.tabOneWeek = tabOneWeek;
    this.tabOneYear = tabOneYear;
    this.tabSixMonth = tabSixMonth;
    this.tabThreeMonth = tabThreeMonth;
    this.type = type;
  }

  @NonNull
  public static FragmentChartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentChartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentChartBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_chart, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentChartBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentChartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentChartBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_chart, null, false, component);
  }

  public static FragmentChartBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentChartBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentChartBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_chart);
  }
}

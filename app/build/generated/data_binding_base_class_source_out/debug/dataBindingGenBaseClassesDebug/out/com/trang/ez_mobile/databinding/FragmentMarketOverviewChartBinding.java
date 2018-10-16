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
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.charts.LineChart;
import com.trang.ez_mobile.util.custormView.TextViewFontBold;

public abstract class FragmentMarketOverviewChartBinding extends ViewDataBinding {
  @NonNull
  public final BarChart barChart;

  @NonNull
  public final CandleStickChart candleStickChart;

  @NonNull
  public final LineChart lineChart;

  @NonNull
  public final LinearLayout menuTab;

  @NonNull
  public final TextViewFontBold tabAll;

  @NonNull
  public final TextViewFontBold tabOneDay;

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
  public final TextViewFontBold tabTwoYear;

  protected FragmentMarketOverviewChartBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, BarChart barChart, CandleStickChart candleStickChart,
      LineChart lineChart, LinearLayout menuTab, TextViewFontBold tabAll,
      TextViewFontBold tabOneDay, TextViewFontBold tabOneMonth, TextViewFontBold tabOneWeek,
      TextViewFontBold tabOneYear, TextViewFontBold tabSixMonth, TextViewFontBold tabThreeMonth,
      TextViewFontBold tabTwoYear) {
    super(_bindingComponent, _root, _localFieldCount);
    this.barChart = barChart;
    this.candleStickChart = candleStickChart;
    this.lineChart = lineChart;
    this.menuTab = menuTab;
    this.tabAll = tabAll;
    this.tabOneDay = tabOneDay;
    this.tabOneMonth = tabOneMonth;
    this.tabOneWeek = tabOneWeek;
    this.tabOneYear = tabOneYear;
    this.tabSixMonth = tabSixMonth;
    this.tabThreeMonth = tabThreeMonth;
    this.tabTwoYear = tabTwoYear;
  }

  @NonNull
  public static FragmentMarketOverviewChartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMarketOverviewChartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMarketOverviewChartBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_market_overview_chart, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMarketOverviewChartBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMarketOverviewChartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMarketOverviewChartBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_market_overview_chart, null, false, component);
  }

  public static FragmentMarketOverviewChartBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentMarketOverviewChartBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentMarketOverviewChartBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_market_overview_chart);
  }
}

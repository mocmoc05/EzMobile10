package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.charts.LineChart;
import com.trang.ez_mobile.util.custormView.TextViewFontBold;

public abstract class FragmentWatchlistChartBinding extends ViewDataBinding {
  @NonNull
  public final BarChart barchart;

  @NonNull
  public final CandleStickChart candleStick;

  @NonNull
  public final FrameLayout contentview;

  @NonNull
  public final LineChart lineChart;

  @NonNull
  public final LinearLayout menuTab;

  @NonNull
  public final TextViewFontBold oday;

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

  protected FragmentWatchlistChartBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, BarChart barchart, CandleStickChart candleStick,
      FrameLayout contentview, LineChart lineChart, LinearLayout menuTab, TextViewFontBold oday,
      TextViewFontBold tabAll, TextViewFontBold tabOneMonth, TextViewFontBold tabOneWeek,
      TextViewFontBold tabOneYear, TextViewFontBold tabSixMonth, TextViewFontBold tabThreeMonth) {
    super(_bindingComponent, _root, _localFieldCount);
    this.barchart = barchart;
    this.candleStick = candleStick;
    this.contentview = contentview;
    this.lineChart = lineChart;
    this.menuTab = menuTab;
    this.oday = oday;
    this.tabAll = tabAll;
    this.tabOneMonth = tabOneMonth;
    this.tabOneWeek = tabOneWeek;
    this.tabOneYear = tabOneYear;
    this.tabSixMonth = tabSixMonth;
    this.tabThreeMonth = tabThreeMonth;
  }

  @NonNull
  public static FragmentWatchlistChartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWatchlistChartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWatchlistChartBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_watchlist_chart, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentWatchlistChartBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWatchlistChartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWatchlistChartBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_watchlist_chart, null, false, component);
  }

  public static FragmentWatchlistChartBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentWatchlistChartBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentWatchlistChartBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_watchlist_chart);
  }
}

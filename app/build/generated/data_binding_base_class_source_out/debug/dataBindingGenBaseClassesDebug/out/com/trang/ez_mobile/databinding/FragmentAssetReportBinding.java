package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.trang.ez_mobile.util.custormView.TabLayoutFont;

public abstract class FragmentAssetReportBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout llProgressAssetReport;

  @NonNull
  public final TabLayoutFont tabsAssetReport;

  @NonNull
  public final ViewPager viewPagerAssetReport;

  protected FragmentAssetReportBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout llProgressAssetReport, TabLayoutFont tabsAssetReport,
      ViewPager viewPagerAssetReport) {
    super(_bindingComponent, _root, _localFieldCount);
    this.llProgressAssetReport = llProgressAssetReport;
    this.tabsAssetReport = tabsAssetReport;
    this.viewPagerAssetReport = viewPagerAssetReport;
  }

  @NonNull
  public static FragmentAssetReportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentAssetReportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentAssetReportBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_asset_report, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentAssetReportBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentAssetReportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentAssetReportBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_asset_report, null, false, component);
  }

  public static FragmentAssetReportBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentAssetReportBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentAssetReportBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_asset_report);
  }
}

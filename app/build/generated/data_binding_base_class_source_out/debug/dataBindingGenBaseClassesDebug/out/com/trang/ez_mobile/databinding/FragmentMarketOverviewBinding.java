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
import com.trang.ez_mobile.util.custormView.TabLayoutFont;

public abstract class FragmentMarketOverviewBinding extends ViewDataBinding {
  @NonNull
  public final TabLayoutFont tabLayout;

  @NonNull
  public final ViewPager viewpager;

  protected FragmentMarketOverviewBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TabLayoutFont tabLayout, ViewPager viewpager) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tabLayout = tabLayout;
    this.viewpager = viewpager;
  }

  @NonNull
  public static FragmentMarketOverviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMarketOverviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMarketOverviewBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_market_overview, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMarketOverviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMarketOverviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMarketOverviewBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_market_overview, null, false, component);
  }

  public static FragmentMarketOverviewBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentMarketOverviewBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentMarketOverviewBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_market_overview);
  }
}

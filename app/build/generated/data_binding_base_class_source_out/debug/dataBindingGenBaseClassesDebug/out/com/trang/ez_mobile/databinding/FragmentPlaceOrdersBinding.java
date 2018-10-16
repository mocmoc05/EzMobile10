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

public abstract class FragmentPlaceOrdersBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout llTintuc;

  @NonNull
  public final TabLayoutFont tabsPlaceOrders;

  @NonNull
  public final ViewPager viewPagerPlaceOrders;

  protected FragmentPlaceOrdersBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout llTintuc, TabLayoutFont tabsPlaceOrders,
      ViewPager viewPagerPlaceOrders) {
    super(_bindingComponent, _root, _localFieldCount);
    this.llTintuc = llTintuc;
    this.tabsPlaceOrders = tabsPlaceOrders;
    this.viewPagerPlaceOrders = viewPagerPlaceOrders;
  }

  @NonNull
  public static FragmentPlaceOrdersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentPlaceOrdersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentPlaceOrdersBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_place_orders, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentPlaceOrdersBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentPlaceOrdersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentPlaceOrdersBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_place_orders, null, false, component);
  }

  public static FragmentPlaceOrdersBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentPlaceOrdersBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentPlaceOrdersBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_place_orders);
  }
}

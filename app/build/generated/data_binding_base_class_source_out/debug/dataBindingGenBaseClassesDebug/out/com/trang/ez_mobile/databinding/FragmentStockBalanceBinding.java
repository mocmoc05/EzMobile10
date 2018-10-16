package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public abstract class FragmentStockBalanceBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout llProgressFragmentStockBalance;

  @NonNull
  public final RecyclerView rcvBaocaotaisanCk;

  protected FragmentStockBalanceBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout llProgressFragmentStockBalance,
      RecyclerView rcvBaocaotaisanCk) {
    super(_bindingComponent, _root, _localFieldCount);
    this.llProgressFragmentStockBalance = llProgressFragmentStockBalance;
    this.rcvBaocaotaisanCk = rcvBaocaotaisanCk;
  }

  @NonNull
  public static FragmentStockBalanceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentStockBalanceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentStockBalanceBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_stock_balance, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentStockBalanceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentStockBalanceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentStockBalanceBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_stock_balance, null, false, component);
  }

  public static FragmentStockBalanceBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentStockBalanceBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentStockBalanceBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_stock_balance);
  }
}

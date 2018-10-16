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

public abstract class FragmentBuyBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout llProgressFragmentBuy;

  @NonNull
  public final RecyclerView rcvDatLenhBan;

  protected FragmentBuyBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout llProgressFragmentBuy, RecyclerView rcvDatLenhBan) {
    super(_bindingComponent, _root, _localFieldCount);
    this.llProgressFragmentBuy = llProgressFragmentBuy;
    this.rcvDatLenhBan = rcvDatLenhBan;
  }

  @NonNull
  public static FragmentBuyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentBuyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentBuyBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_buy, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentBuyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentBuyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentBuyBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_buy, null, false, component);
  }

  public static FragmentBuyBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentBuyBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentBuyBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_buy);
  }
}

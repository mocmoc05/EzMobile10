package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.trang.ez_mobile.util.custormView.TextViewFont;

public abstract class ItemFragmentBuyBinding extends ViewDataBinding {
  @NonNull
  public final TextViewFont tvMaCkItemFragBuy;

  @NonNull
  public final TextViewFont tvSoLuongItemFragBuy;

  protected ItemFragmentBuyBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextViewFont tvMaCkItemFragBuy, TextViewFont tvSoLuongItemFragBuy) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tvMaCkItemFragBuy = tvMaCkItemFragBuy;
    this.tvSoLuongItemFragBuy = tvSoLuongItemFragBuy;
  }

  @NonNull
  public static ItemFragmentBuyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemFragmentBuyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemFragmentBuyBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_fragment_buy, root, attachToRoot, component);
  }

  @NonNull
  public static ItemFragmentBuyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemFragmentBuyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemFragmentBuyBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_fragment_buy, null, false, component);
  }

  public static ItemFragmentBuyBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemFragmentBuyBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemFragmentBuyBinding)bind(component, view, com.trang.ez_mobile.R.layout.item_fragment_buy);
  }
}

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
import com.trang.ez_mobile.util.custormView.TextViewFontBold;

public abstract class ItemStockBalanceBinding extends ViewDataBinding {
  @NonNull
  public final TextViewFont tvDangChoVe;

  @NonNull
  public final TextViewFontBold tvMaCkStockBalance;

  @NonNull
  public final TextViewFont tvSlHienTai;

  @NonNull
  public final TextViewFont tvTongSl;

  protected ItemStockBalanceBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextViewFont tvDangChoVe, TextViewFontBold tvMaCkStockBalance,
      TextViewFont tvSlHienTai, TextViewFont tvTongSl) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tvDangChoVe = tvDangChoVe;
    this.tvMaCkStockBalance = tvMaCkStockBalance;
    this.tvSlHienTai = tvSlHienTai;
    this.tvTongSl = tvTongSl;
  }

  @NonNull
  public static ItemStockBalanceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemStockBalanceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemStockBalanceBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_stock_balance, root, attachToRoot, component);
  }

  @NonNull
  public static ItemStockBalanceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemStockBalanceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemStockBalanceBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_stock_balance, null, false, component);
  }

  public static ItemStockBalanceBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemStockBalanceBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemStockBalanceBinding)bind(component, view, com.trang.ez_mobile.R.layout.item_stock_balance);
  }
}

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

public abstract class FragmentCashBalanceBinding extends ViewDataBinding {
  @NonNull
  public final TextViewFont tvValueDangTreo;

  @NonNull
  public final TextViewFont tvValueSoDuHienTai;

  @NonNull
  public final TextViewFont tvValueSoDuTien;

  @NonNull
  public final TextViewFont tvValueUngTruoc;

  protected FragmentCashBalanceBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextViewFont tvValueDangTreo, TextViewFont tvValueSoDuHienTai,
      TextViewFont tvValueSoDuTien, TextViewFont tvValueUngTruoc) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tvValueDangTreo = tvValueDangTreo;
    this.tvValueSoDuHienTai = tvValueSoDuHienTai;
    this.tvValueSoDuTien = tvValueSoDuTien;
    this.tvValueUngTruoc = tvValueUngTruoc;
  }

  @NonNull
  public static FragmentCashBalanceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentCashBalanceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentCashBalanceBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_cash_balance, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentCashBalanceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentCashBalanceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentCashBalanceBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_cash_balance, null, false, component);
  }

  public static FragmentCashBalanceBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentCashBalanceBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentCashBalanceBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_cash_balance);
  }
}

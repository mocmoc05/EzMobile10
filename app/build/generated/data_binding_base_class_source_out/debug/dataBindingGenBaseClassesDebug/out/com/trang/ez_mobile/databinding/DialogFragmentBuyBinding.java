package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.trang.ez_mobile.util.custormView.ButtonFont;
import com.trang.ez_mobile.util.custormView.EditTextFont;
import com.trang.ez_mobile.util.custormView.SpinnerFont;
import com.trang.ez_mobile.util.custormView.TextViewFont;
import com.trang.ez_mobile.util.custormView.TextViewFontBold;

public abstract class DialogFragmentBuyBinding extends ViewDataBinding {
  @NonNull
  public final ButtonFont btnXacNhanMua;

  @NonNull
  public final SpinnerFont spnValueLoaiLenh;

  @NonNull
  public final TextViewFontBold tvGiaBanTotNhat;

  @NonNull
  public final TextViewFontBold tvGiaMuaTotNhat;

  @NonNull
  public final TextViewFont tvGiaSan;

  @NonNull
  public final TextViewFontBold tvGiaThamChieu;

  @NonNull
  public final TextViewFont tvGiaTran;

  @NonNull
  public final TextViewFontBold tvKhoiLuongBan;

  @NonNull
  public final TextViewFontBold tvKhoiLuongMua;

  @NonNull
  public final TextViewFontBold tvMaCk;

  @NonNull
  public final EditTextFont tvValueGiaMua;

  @NonNull
  public final TextViewFont tvValueMaCk;

  @NonNull
  public final EditTextFont tvValueMatKhau;

  @NonNull
  public final TextViewFont tvValueSanGd;

  @NonNull
  public final EditTextFont tvValueSoLuong;

  @NonNull
  public final TextViewFont tvValueStockBalance;

  protected DialogFragmentBuyBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ButtonFont btnXacNhanMua, SpinnerFont spnValueLoaiLenh,
      TextViewFontBold tvGiaBanTotNhat, TextViewFontBold tvGiaMuaTotNhat, TextViewFont tvGiaSan,
      TextViewFontBold tvGiaThamChieu, TextViewFont tvGiaTran, TextViewFontBold tvKhoiLuongBan,
      TextViewFontBold tvKhoiLuongMua, TextViewFontBold tvMaCk, EditTextFont tvValueGiaMua,
      TextViewFont tvValueMaCk, EditTextFont tvValueMatKhau, TextViewFont tvValueSanGd,
      EditTextFont tvValueSoLuong, TextViewFont tvValueStockBalance) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnXacNhanMua = btnXacNhanMua;
    this.spnValueLoaiLenh = spnValueLoaiLenh;
    this.tvGiaBanTotNhat = tvGiaBanTotNhat;
    this.tvGiaMuaTotNhat = tvGiaMuaTotNhat;
    this.tvGiaSan = tvGiaSan;
    this.tvGiaThamChieu = tvGiaThamChieu;
    this.tvGiaTran = tvGiaTran;
    this.tvKhoiLuongBan = tvKhoiLuongBan;
    this.tvKhoiLuongMua = tvKhoiLuongMua;
    this.tvMaCk = tvMaCk;
    this.tvValueGiaMua = tvValueGiaMua;
    this.tvValueMaCk = tvValueMaCk;
    this.tvValueMatKhau = tvValueMatKhau;
    this.tvValueSanGd = tvValueSanGd;
    this.tvValueSoLuong = tvValueSoLuong;
    this.tvValueStockBalance = tvValueStockBalance;
  }

  @NonNull
  public static DialogFragmentBuyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogFragmentBuyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogFragmentBuyBinding>inflate(inflater, com.trang.ez_mobile.R.layout.dialog_fragment_buy, root, attachToRoot, component);
  }

  @NonNull
  public static DialogFragmentBuyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogFragmentBuyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogFragmentBuyBinding>inflate(inflater, com.trang.ez_mobile.R.layout.dialog_fragment_buy, null, false, component);
  }

  public static DialogFragmentBuyBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DialogFragmentBuyBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DialogFragmentBuyBinding)bind(component, view, com.trang.ez_mobile.R.layout.dialog_fragment_buy);
  }
}

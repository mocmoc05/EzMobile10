package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.trang.ez_mobile.util.custormView.ButtonFont;
import com.trang.ez_mobile.util.custormView.EditTextFont;
import com.trang.ez_mobile.util.custormView.SpinnerFont;
import com.trang.ez_mobile.util.custormView.TextViewFont;
import com.trang.ez_mobile.util.custormView.TextViewFontBold;

public abstract class FragmentSellBinding extends ViewDataBinding {
  @NonNull
  public final ButtonFont btnXacNhanMua;

  @NonNull
  public final EditTextFont edtValueGiaMua;

  @NonNull
  public final EditTextFont edtValueMaCk;

  @NonNull
  public final EditTextFont edtValueMatKhau;

  @NonNull
  public final EditTextFont edtValueSoLuong;

  @NonNull
  public final TextViewFontBold giaMuaMax;

  @NonNull
  public final ImageView imgMaCk;

  @NonNull
  public final LinearLayout llProgressFragmentSell;

  @NonNull
  public final LinearLayout llTtCk;

  @NonNull
  public final SpinnerFont spnValueLoaiLenh;

  @NonNull
  public final TextViewFont tvAvailableCash;

  @NonNull
  public final TextViewFontBold tvGiaBanMin;

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
  public final TextViewFont tvValueSanGd;

  protected FragmentSellBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ButtonFont btnXacNhanMua, EditTextFont edtValueGiaMua,
      EditTextFont edtValueMaCk, EditTextFont edtValueMatKhau, EditTextFont edtValueSoLuong,
      TextViewFontBold giaMuaMax, ImageView imgMaCk, LinearLayout llProgressFragmentSell,
      LinearLayout llTtCk, SpinnerFont spnValueLoaiLenh, TextViewFont tvAvailableCash,
      TextViewFontBold tvGiaBanMin, TextViewFont tvGiaSan, TextViewFontBold tvGiaThamChieu,
      TextViewFont tvGiaTran, TextViewFontBold tvKhoiLuongBan, TextViewFontBold tvKhoiLuongMua,
      TextViewFontBold tvMaCk, TextViewFont tvValueSanGd) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnXacNhanMua = btnXacNhanMua;
    this.edtValueGiaMua = edtValueGiaMua;
    this.edtValueMaCk = edtValueMaCk;
    this.edtValueMatKhau = edtValueMatKhau;
    this.edtValueSoLuong = edtValueSoLuong;
    this.giaMuaMax = giaMuaMax;
    this.imgMaCk = imgMaCk;
    this.llProgressFragmentSell = llProgressFragmentSell;
    this.llTtCk = llTtCk;
    this.spnValueLoaiLenh = spnValueLoaiLenh;
    this.tvAvailableCash = tvAvailableCash;
    this.tvGiaBanMin = tvGiaBanMin;
    this.tvGiaSan = tvGiaSan;
    this.tvGiaThamChieu = tvGiaThamChieu;
    this.tvGiaTran = tvGiaTran;
    this.tvKhoiLuongBan = tvKhoiLuongBan;
    this.tvKhoiLuongMua = tvKhoiLuongMua;
    this.tvMaCk = tvMaCk;
    this.tvValueSanGd = tvValueSanGd;
  }

  @NonNull
  public static FragmentSellBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentSellBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentSellBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_sell, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSellBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentSellBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentSellBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_sell, null, false, component);
  }

  public static FragmentSellBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentSellBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentSellBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_sell);
  }
}

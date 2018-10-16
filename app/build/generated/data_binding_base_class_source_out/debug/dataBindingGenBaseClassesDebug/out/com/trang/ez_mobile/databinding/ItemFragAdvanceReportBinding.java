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

public abstract class ItemFragAdvanceReportBinding extends ViewDataBinding {
  @NonNull
  public final TextViewFont tvNgayung;

  @NonNull
  public final TextViewFont tvSotien;

  @NonNull
  public final TextViewFont tvTinhtrang;

  protected ItemFragAdvanceReportBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextViewFont tvNgayung, TextViewFont tvSotien,
      TextViewFont tvTinhtrang) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tvNgayung = tvNgayung;
    this.tvSotien = tvSotien;
    this.tvTinhtrang = tvTinhtrang;
  }

  @NonNull
  public static ItemFragAdvanceReportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemFragAdvanceReportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemFragAdvanceReportBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_frag_advance_report, root, attachToRoot, component);
  }

  @NonNull
  public static ItemFragAdvanceReportBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemFragAdvanceReportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemFragAdvanceReportBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_frag_advance_report, null, false, component);
  }

  public static ItemFragAdvanceReportBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemFragAdvanceReportBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemFragAdvanceReportBinding)bind(component, view, com.trang.ez_mobile.R.layout.item_frag_advance_report);
  }
}

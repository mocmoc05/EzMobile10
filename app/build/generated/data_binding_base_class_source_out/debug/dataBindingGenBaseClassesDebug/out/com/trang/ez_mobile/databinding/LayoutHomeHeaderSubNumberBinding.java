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

public abstract class LayoutHomeHeaderSubNumberBinding extends ViewDataBinding {
  @NonNull
  public final TextViewFont txtChange;

  @NonNull
  public final TextViewFont txtIndices;

  @NonNull
  public final TextViewFont txtLast;

  @NonNull
  public final TextViewFont txtQty;

  protected LayoutHomeHeaderSubNumberBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextViewFont txtChange, TextViewFont txtIndices, TextViewFont txtLast,
      TextViewFont txtQty) {
    super(_bindingComponent, _root, _localFieldCount);
    this.txtChange = txtChange;
    this.txtIndices = txtIndices;
    this.txtLast = txtLast;
    this.txtQty = txtQty;
  }

  @NonNull
  public static LayoutHomeHeaderSubNumberBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static LayoutHomeHeaderSubNumberBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<LayoutHomeHeaderSubNumberBinding>inflate(inflater, com.trang.ez_mobile.R.layout.layout_home_header_sub_number, root, attachToRoot, component);
  }

  @NonNull
  public static LayoutHomeHeaderSubNumberBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static LayoutHomeHeaderSubNumberBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<LayoutHomeHeaderSubNumberBinding>inflate(inflater, com.trang.ez_mobile.R.layout.layout_home_header_sub_number, null, false, component);
  }

  public static LayoutHomeHeaderSubNumberBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static LayoutHomeHeaderSubNumberBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (LayoutHomeHeaderSubNumberBinding)bind(component, view, com.trang.ez_mobile.R.layout.layout_home_header_sub_number);
  }
}

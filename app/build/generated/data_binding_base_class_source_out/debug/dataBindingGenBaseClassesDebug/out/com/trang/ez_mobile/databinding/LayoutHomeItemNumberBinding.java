package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.trang.ez_mobile.util.custormView.TextViewFontBold;

public abstract class LayoutHomeItemNumberBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout lnLayoutMainHeader;

  @NonNull
  public final TextViewFontBold txtChange;

  @NonNull
  public final TextViewFontBold txtIndices;

  @NonNull
  public final TextViewFontBold txtLast;

  @NonNull
  public final TextViewFontBold txtQty;

  protected LayoutHomeItemNumberBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout lnLayoutMainHeader, TextViewFontBold txtChange,
      TextViewFontBold txtIndices, TextViewFontBold txtLast, TextViewFontBold txtQty) {
    super(_bindingComponent, _root, _localFieldCount);
    this.lnLayoutMainHeader = lnLayoutMainHeader;
    this.txtChange = txtChange;
    this.txtIndices = txtIndices;
    this.txtLast = txtLast;
    this.txtQty = txtQty;
  }

  @NonNull
  public static LayoutHomeItemNumberBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static LayoutHomeItemNumberBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<LayoutHomeItemNumberBinding>inflate(inflater, com.trang.ez_mobile.R.layout.layout_home_item_number, root, attachToRoot, component);
  }

  @NonNull
  public static LayoutHomeItemNumberBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static LayoutHomeItemNumberBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<LayoutHomeItemNumberBinding>inflate(inflater, com.trang.ez_mobile.R.layout.layout_home_item_number, null, false, component);
  }

  public static LayoutHomeItemNumberBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static LayoutHomeItemNumberBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (LayoutHomeItemNumberBinding)bind(component, view, com.trang.ez_mobile.R.layout.layout_home_item_number);
  }
}

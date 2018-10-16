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
import com.trang.ez_mobile.util.custormView.SquareImageView;
import com.trang.ez_mobile.util.custormView.TextViewFont;

public abstract class LayoutHomeHeaderSubTextBinding extends ViewDataBinding {
  @NonNull
  public final SquareImageView icon;

  @NonNull
  public final LinearLayout l1;

  @NonNull
  public final LinearLayout lnItemHeaderText;

  @NonNull
  public final TextViewFont txtDate;

  @NonNull
  public final TextViewFont txtTextContent;

  protected LayoutHomeHeaderSubTextBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, SquareImageView icon, LinearLayout l1, LinearLayout lnItemHeaderText,
      TextViewFont txtDate, TextViewFont txtTextContent) {
    super(_bindingComponent, _root, _localFieldCount);
    this.icon = icon;
    this.l1 = l1;
    this.lnItemHeaderText = lnItemHeaderText;
    this.txtDate = txtDate;
    this.txtTextContent = txtTextContent;
  }

  @NonNull
  public static LayoutHomeHeaderSubTextBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static LayoutHomeHeaderSubTextBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<LayoutHomeHeaderSubTextBinding>inflate(inflater, com.trang.ez_mobile.R.layout.layout_home_header_sub_text, root, attachToRoot, component);
  }

  @NonNull
  public static LayoutHomeHeaderSubTextBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static LayoutHomeHeaderSubTextBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<LayoutHomeHeaderSubTextBinding>inflate(inflater, com.trang.ez_mobile.R.layout.layout_home_header_sub_text, null, false, component);
  }

  public static LayoutHomeHeaderSubTextBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static LayoutHomeHeaderSubTextBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (LayoutHomeHeaderSubTextBinding)bind(component, view, com.trang.ez_mobile.R.layout.layout_home_header_sub_text);
  }
}

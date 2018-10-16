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
import com.trang.ez_mobile.util.custormView.TextViewFont;

public abstract class LayoutHomeItemheaderBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imageviewAdd;

  @NonNull
  public final ImageView imageviewDetail;

  @NonNull
  public final ImageView imageviewEdit;

  @NonNull
  public final LinearLayout lnItemHeader;

  @NonNull
  public final TextViewFont txtTitleHeader;

  protected LayoutHomeItemheaderBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView imageviewAdd, ImageView imageviewDetail,
      ImageView imageviewEdit, LinearLayout lnItemHeader, TextViewFont txtTitleHeader) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageviewAdd = imageviewAdd;
    this.imageviewDetail = imageviewDetail;
    this.imageviewEdit = imageviewEdit;
    this.lnItemHeader = lnItemHeader;
    this.txtTitleHeader = txtTitleHeader;
  }

  @NonNull
  public static LayoutHomeItemheaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static LayoutHomeItemheaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<LayoutHomeItemheaderBinding>inflate(inflater, com.trang.ez_mobile.R.layout.layout_home_itemheader, root, attachToRoot, component);
  }

  @NonNull
  public static LayoutHomeItemheaderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static LayoutHomeItemheaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<LayoutHomeItemheaderBinding>inflate(inflater, com.trang.ez_mobile.R.layout.layout_home_itemheader, null, false, component);
  }

  public static LayoutHomeItemheaderBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static LayoutHomeItemheaderBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (LayoutHomeItemheaderBinding)bind(component, view, com.trang.ez_mobile.R.layout.layout_home_itemheader);
  }
}

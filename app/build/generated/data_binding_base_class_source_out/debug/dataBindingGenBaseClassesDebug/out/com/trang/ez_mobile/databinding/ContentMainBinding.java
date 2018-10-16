package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.trang.ez_mobile.util.custormView.TextViewFont;

public abstract class ContentMainBinding extends ViewDataBinding {
  @NonNull
  public final FrameLayout contentview;

  @NonNull
  public final TextViewFont tvStatusMarket;

  protected ContentMainBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, FrameLayout contentview, TextViewFont tvStatusMarket) {
    super(_bindingComponent, _root, _localFieldCount);
    this.contentview = contentview;
    this.tvStatusMarket = tvStatusMarket;
  }

  @NonNull
  public static ContentMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentMainBinding>inflate(inflater, com.trang.ez_mobile.R.layout.content_main, root, attachToRoot, component);
  }

  @NonNull
  public static ContentMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentMainBinding>inflate(inflater, com.trang.ez_mobile.R.layout.content_main, null, false, component);
  }

  public static ContentMainBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ContentMainBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ContentMainBinding)bind(component, view, com.trang.ez_mobile.R.layout.content_main);
  }
}

package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class AppBarMainBinding extends ViewDataBinding {
  @NonNull
  public final ContentMainBinding contentMain;

  @NonNull
  public final Toolbar toolbar;

  protected AppBarMainBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ContentMainBinding contentMain, Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.contentMain = contentMain;
    setContainedBinding(this.contentMain);;
    this.toolbar = toolbar;
  }

  @NonNull
  public static AppBarMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static AppBarMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<AppBarMainBinding>inflate(inflater, com.trang.ez_mobile.R.layout.app_bar_main, root, attachToRoot, component);
  }

  @NonNull
  public static AppBarMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static AppBarMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<AppBarMainBinding>inflate(inflater, com.trang.ez_mobile.R.layout.app_bar_main, null, false, component);
  }

  public static AppBarMainBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static AppBarMainBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (AppBarMainBinding)bind(component, view, com.trang.ez_mobile.R.layout.app_bar_main);
  }
}

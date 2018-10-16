package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public abstract class ActivityMainBinding extends ViewDataBinding {
  @NonNull
  public final AppBarMainBinding appBarMain;

  @NonNull
  public final LinearLayout drawerContainer;

  @NonNull
  public final DrawerLayout drawerLayout;

  @NonNull
  public final NavUserLayoutBinding navUserLayout;

  protected ActivityMainBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, AppBarMainBinding appBarMain, LinearLayout drawerContainer,
      DrawerLayout drawerLayout, NavUserLayoutBinding navUserLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appBarMain = appBarMain;
    setContainedBinding(this.appBarMain);;
    this.drawerContainer = drawerContainer;
    this.drawerLayout = drawerLayout;
    this.navUserLayout = navUserLayout;
    setContainedBinding(this.navUserLayout);;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMainBinding>inflate(inflater, com.trang.ez_mobile.R.layout.activity_main, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMainBinding>inflate(inflater, com.trang.ez_mobile.R.layout.activity_main, null, false, component);
  }

  public static ActivityMainBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityMainBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityMainBinding)bind(component, view, com.trang.ez_mobile.R.layout.activity_main);
  }
}

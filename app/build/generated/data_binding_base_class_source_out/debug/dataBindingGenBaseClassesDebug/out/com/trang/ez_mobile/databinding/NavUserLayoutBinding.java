package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public abstract class NavUserLayoutBinding extends ViewDataBinding {
  @NonNull
  public final ImageView actionSave;

  @NonNull
  public final ExpandableListView expandedListview;

  @NonNull
  public final LinearLayout linearlayoutContent;

  @NonNull
  public final LinearLayout linearlayoutSetting;

  @NonNull
  public final ListView listviewSetting;

  protected NavUserLayoutBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView actionSave, ExpandableListView expandedListview,
      LinearLayout linearlayoutContent, LinearLayout linearlayoutSetting,
      ListView listviewSetting) {
    super(_bindingComponent, _root, _localFieldCount);
    this.actionSave = actionSave;
    this.expandedListview = expandedListview;
    this.linearlayoutContent = linearlayoutContent;
    this.linearlayoutSetting = linearlayoutSetting;
    this.listviewSetting = listviewSetting;
  }

  @NonNull
  public static NavUserLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static NavUserLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<NavUserLayoutBinding>inflate(inflater, com.trang.ez_mobile.R.layout.nav_user_layout, root, attachToRoot, component);
  }

  @NonNull
  public static NavUserLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static NavUserLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<NavUserLayoutBinding>inflate(inflater, com.trang.ez_mobile.R.layout.nav_user_layout, null, false, component);
  }

  public static NavUserLayoutBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static NavUserLayoutBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (NavUserLayoutBinding)bind(component, view, com.trang.ez_mobile.R.layout.nav_user_layout);
  }
}

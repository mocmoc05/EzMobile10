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

public abstract class ItemMainMenuGroupContentBinding extends ViewDataBinding {
  @NonNull
  public final ImageView actionFavorite;

  @NonNull
  public final TextViewFont category;

  @NonNull
  public final LinearLayout content;

  @NonNull
  public final ImageView icon;

  protected ItemMainMenuGroupContentBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView actionFavorite, TextViewFont category, LinearLayout content,
      ImageView icon) {
    super(_bindingComponent, _root, _localFieldCount);
    this.actionFavorite = actionFavorite;
    this.category = category;
    this.content = content;
    this.icon = icon;
  }

  @NonNull
  public static ItemMainMenuGroupContentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMainMenuGroupContentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMainMenuGroupContentBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_main_menu_group_content, root, attachToRoot, component);
  }

  @NonNull
  public static ItemMainMenuGroupContentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMainMenuGroupContentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMainMenuGroupContentBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_main_menu_group_content, null, false, component);
  }

  public static ItemMainMenuGroupContentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemMainMenuGroupContentBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemMainMenuGroupContentBinding)bind(component, view, com.trang.ez_mobile.R.layout.item_main_menu_group_content);
  }
}

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

public abstract class ItemMainMenuRecyclerviewContentBinding extends ViewDataBinding {
  @NonNull
  public final TextViewFont category;

  @NonNull
  public final ImageView imageViewIsFavorite;

  @NonNull
  public final LinearLayout linearlayoutContent;

  protected ItemMainMenuRecyclerviewContentBinding(DataBindingComponent _bindingComponent,
      View _root, int _localFieldCount, TextViewFont category, ImageView imageViewIsFavorite,
      LinearLayout linearlayoutContent) {
    super(_bindingComponent, _root, _localFieldCount);
    this.category = category;
    this.imageViewIsFavorite = imageViewIsFavorite;
    this.linearlayoutContent = linearlayoutContent;
  }

  @NonNull
  public static ItemMainMenuRecyclerviewContentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMainMenuRecyclerviewContentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMainMenuRecyclerviewContentBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_main_menu_recyclerview_content, root, attachToRoot, component);
  }

  @NonNull
  public static ItemMainMenuRecyclerviewContentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMainMenuRecyclerviewContentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMainMenuRecyclerviewContentBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_main_menu_recyclerview_content, null, false, component);
  }

  public static ItemMainMenuRecyclerviewContentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemMainMenuRecyclerviewContentBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemMainMenuRecyclerviewContentBinding)bind(component, view, com.trang.ez_mobile.R.layout.item_main_menu_recyclerview_content);
  }
}

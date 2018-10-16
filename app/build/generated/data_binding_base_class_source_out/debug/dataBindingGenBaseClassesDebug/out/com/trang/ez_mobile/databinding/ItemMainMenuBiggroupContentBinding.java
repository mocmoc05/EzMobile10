package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.trang.ez_mobile.util.custormView.TextViewFont;

public abstract class ItemMainMenuBiggroupContentBinding extends ViewDataBinding {
  @NonNull
  public final TextViewFont header;

  @NonNull
  public final ImageView imageviewArrow;

  @NonNull
  public final LinearLayout linearlayoutHeader;

  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final View viewDivider;

  protected ItemMainMenuBiggroupContentBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextViewFont header, ImageView imageviewArrow,
      LinearLayout linearlayoutHeader, RecyclerView recyclerView, View viewDivider) {
    super(_bindingComponent, _root, _localFieldCount);
    this.header = header;
    this.imageviewArrow = imageviewArrow;
    this.linearlayoutHeader = linearlayoutHeader;
    this.recyclerView = recyclerView;
    this.viewDivider = viewDivider;
  }

  @NonNull
  public static ItemMainMenuBiggroupContentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMainMenuBiggroupContentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMainMenuBiggroupContentBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_main_menu_biggroup_content, root, attachToRoot, component);
  }

  @NonNull
  public static ItemMainMenuBiggroupContentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMainMenuBiggroupContentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMainMenuBiggroupContentBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_main_menu_biggroup_content, null, false, component);
  }

  public static ItemMainMenuBiggroupContentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemMainMenuBiggroupContentBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemMainMenuBiggroupContentBinding)bind(component, view, com.trang.ez_mobile.R.layout.item_main_menu_biggroup_content);
  }
}

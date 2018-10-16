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

public abstract class ItemMainMenuBiggroupHeaderBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout category;

  @NonNull
  public final TextViewFontBold header;

  protected ItemMainMenuBiggroupHeaderBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout category, TextViewFontBold header) {
    super(_bindingComponent, _root, _localFieldCount);
    this.category = category;
    this.header = header;
  }

  @NonNull
  public static ItemMainMenuBiggroupHeaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMainMenuBiggroupHeaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMainMenuBiggroupHeaderBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_main_menu_biggroup_header, root, attachToRoot, component);
  }

  @NonNull
  public static ItemMainMenuBiggroupHeaderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMainMenuBiggroupHeaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMainMenuBiggroupHeaderBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_main_menu_biggroup_header, null, false, component);
  }

  public static ItemMainMenuBiggroupHeaderBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemMainMenuBiggroupHeaderBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemMainMenuBiggroupHeaderBinding)bind(component, view, com.trang.ez_mobile.R.layout.item_main_menu_biggroup_header);
  }
}

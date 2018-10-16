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
import com.trang.ez_mobile.util.custormView.CircularImageView;
import com.trang.ez_mobile.util.custormView.TextViewFontBold;

public abstract class ItemMainMenuBiggroupHeaderAccountBinding extends ViewDataBinding {
  @NonNull
  public final CircularImageView avatar;

  @NonNull
  public final ImageView imgLogout;

  @NonNull
  public final ImageView imgSetting;

  @NonNull
  public final TextViewFontBold textviewUserLogout;

  @NonNull
  public final TextViewFontBold textviewUsername;

  protected ItemMainMenuBiggroupHeaderAccountBinding(DataBindingComponent _bindingComponent,
      View _root, int _localFieldCount, CircularImageView avatar, ImageView imgLogout,
      ImageView imgSetting, TextViewFontBold textviewUserLogout,
      TextViewFontBold textviewUsername) {
    super(_bindingComponent, _root, _localFieldCount);
    this.avatar = avatar;
    this.imgLogout = imgLogout;
    this.imgSetting = imgSetting;
    this.textviewUserLogout = textviewUserLogout;
    this.textviewUsername = textviewUsername;
  }

  @NonNull
  public static ItemMainMenuBiggroupHeaderAccountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMainMenuBiggroupHeaderAccountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMainMenuBiggroupHeaderAccountBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_main_menu_biggroup_header_account, root, attachToRoot, component);
  }

  @NonNull
  public static ItemMainMenuBiggroupHeaderAccountBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMainMenuBiggroupHeaderAccountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMainMenuBiggroupHeaderAccountBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_main_menu_biggroup_header_account, null, false, component);
  }

  public static ItemMainMenuBiggroupHeaderAccountBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemMainMenuBiggroupHeaderAccountBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemMainMenuBiggroupHeaderAccountBinding)bind(component, view, com.trang.ez_mobile.R.layout.item_main_menu_biggroup_header_account);
  }
}

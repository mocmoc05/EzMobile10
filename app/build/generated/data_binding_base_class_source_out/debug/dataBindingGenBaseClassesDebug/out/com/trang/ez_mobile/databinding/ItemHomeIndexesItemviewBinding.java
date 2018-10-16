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
import com.trang.ez_mobile.util.custormView.TextViewFont;
import com.trang.ez_mobile.util.custormView.TextViewFontBold;

public abstract class ItemHomeIndexesItemviewBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final TextViewFont textviewChange;

  @NonNull
  public final TextViewFont textviewName;

  @NonNull
  public final TextViewFontBold textviewPrice;

  @NonNull
  public final TextViewFont textviewValue;

  protected ItemHomeIndexesItemviewBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout linearLayout, TextViewFont textviewChange,
      TextViewFont textviewName, TextViewFontBold textviewPrice, TextViewFont textviewValue) {
    super(_bindingComponent, _root, _localFieldCount);
    this.linearLayout = linearLayout;
    this.textviewChange = textviewChange;
    this.textviewName = textviewName;
    this.textviewPrice = textviewPrice;
    this.textviewValue = textviewValue;
  }

  @NonNull
  public static ItemHomeIndexesItemviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemHomeIndexesItemviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemHomeIndexesItemviewBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_home_indexes_itemview, root, attachToRoot, component);
  }

  @NonNull
  public static ItemHomeIndexesItemviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemHomeIndexesItemviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemHomeIndexesItemviewBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_home_indexes_itemview, null, false, component);
  }

  public static ItemHomeIndexesItemviewBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemHomeIndexesItemviewBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemHomeIndexesItemviewBinding)bind(component, view, com.trang.ez_mobile.R.layout.item_home_indexes_itemview);
  }
}

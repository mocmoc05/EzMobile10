package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.trang.ez_mobile.util.custormView.TextViewFont;

public abstract class ItemWatchlistFinancialBinding extends ViewDataBinding {
  @NonNull
  public final TextViewFont label;

  @NonNull
  public final TextViewFont value;

  protected ItemWatchlistFinancialBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextViewFont label, TextViewFont value) {
    super(_bindingComponent, _root, _localFieldCount);
    this.label = label;
    this.value = value;
  }

  @NonNull
  public static ItemWatchlistFinancialBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemWatchlistFinancialBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemWatchlistFinancialBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_watchlist_financial, root, attachToRoot, component);
  }

  @NonNull
  public static ItemWatchlistFinancialBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemWatchlistFinancialBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemWatchlistFinancialBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_watchlist_financial, null, false, component);
  }

  public static ItemWatchlistFinancialBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemWatchlistFinancialBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemWatchlistFinancialBinding)bind(component, view, com.trang.ez_mobile.R.layout.item_watchlist_financial);
  }
}

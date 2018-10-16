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

public abstract class ItemHomeIndexesLayoutBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView recyclerView;

  protected ItemHomeIndexesLayoutBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView recyclerView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.recyclerView = recyclerView;
  }

  @NonNull
  public static ItemHomeIndexesLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemHomeIndexesLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemHomeIndexesLayoutBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_home_indexes_layout, root, attachToRoot, component);
  }

  @NonNull
  public static ItemHomeIndexesLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemHomeIndexesLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemHomeIndexesLayoutBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_home_indexes_layout, null, false, component);
  }

  public static ItemHomeIndexesLayoutBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemHomeIndexesLayoutBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemHomeIndexesLayoutBinding)bind(component, view, com.trang.ez_mobile.R.layout.item_home_indexes_layout);
  }
}

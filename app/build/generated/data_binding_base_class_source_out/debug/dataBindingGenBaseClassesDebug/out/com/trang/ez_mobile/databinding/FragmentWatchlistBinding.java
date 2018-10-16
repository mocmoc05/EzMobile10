package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.bin.david.form.core.SmartTable;

public abstract class FragmentWatchlistBinding extends ViewDataBinding {
  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final SmartTable smarttable;

  protected FragmentWatchlistBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ProgressBar progressBar, SmartTable smarttable) {
    super(_bindingComponent, _root, _localFieldCount);
    this.progressBar = progressBar;
    this.smarttable = smarttable;
  }

  @NonNull
  public static FragmentWatchlistBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWatchlistBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWatchlistBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_watchlist, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentWatchlistBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWatchlistBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWatchlistBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_watchlist, null, false, component);
  }

  public static FragmentWatchlistBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentWatchlistBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentWatchlistBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_watchlist);
  }
}

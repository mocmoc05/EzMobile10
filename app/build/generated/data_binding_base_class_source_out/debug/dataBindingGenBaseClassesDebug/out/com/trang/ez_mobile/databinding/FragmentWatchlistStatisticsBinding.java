package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public abstract class FragmentWatchlistStatisticsBinding extends ViewDataBinding {
  @NonNull
  public final FrameLayout contentview;

  protected FragmentWatchlistStatisticsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, FrameLayout contentview) {
    super(_bindingComponent, _root, _localFieldCount);
    this.contentview = contentview;
  }

  @NonNull
  public static FragmentWatchlistStatisticsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWatchlistStatisticsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWatchlistStatisticsBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_watchlist_statistics, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentWatchlistStatisticsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWatchlistStatisticsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWatchlistStatisticsBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_watchlist_statistics, null, false, component);
  }

  public static FragmentWatchlistStatisticsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentWatchlistStatisticsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentWatchlistStatisticsBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_watchlist_statistics);
  }
}

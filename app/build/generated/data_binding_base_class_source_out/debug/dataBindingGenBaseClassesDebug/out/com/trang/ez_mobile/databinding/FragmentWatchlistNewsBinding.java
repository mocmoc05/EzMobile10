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

public abstract class FragmentWatchlistNewsBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView recyclerview;

  protected FragmentWatchlistNewsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView recyclerview) {
    super(_bindingComponent, _root, _localFieldCount);
    this.recyclerview = recyclerview;
  }

  @NonNull
  public static FragmentWatchlistNewsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWatchlistNewsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWatchlistNewsBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_watchlist_news, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentWatchlistNewsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWatchlistNewsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWatchlistNewsBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_watchlist_news, null, false, component);
  }

  public static FragmentWatchlistNewsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentWatchlistNewsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentWatchlistNewsBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_watchlist_news);
  }
}

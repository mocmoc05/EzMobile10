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
import android.widget.FrameLayout;

public abstract class FragmentWatchlistFinanceOverviewBinding extends ViewDataBinding {
  @NonNull
  public final FrameLayout contentview;

  @NonNull
  public final RecyclerView list;

  protected FragmentWatchlistFinanceOverviewBinding(DataBindingComponent _bindingComponent,
      View _root, int _localFieldCount, FrameLayout contentview, RecyclerView list) {
    super(_bindingComponent, _root, _localFieldCount);
    this.contentview = contentview;
    this.list = list;
  }

  @NonNull
  public static FragmentWatchlistFinanceOverviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWatchlistFinanceOverviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWatchlistFinanceOverviewBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_watchlist_finance_overview, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentWatchlistFinanceOverviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWatchlistFinanceOverviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWatchlistFinanceOverviewBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_watchlist_finance_overview, null, false, component);
  }

  public static FragmentWatchlistFinanceOverviewBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentWatchlistFinanceOverviewBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentWatchlistFinanceOverviewBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_watchlist_finance_overview);
  }
}

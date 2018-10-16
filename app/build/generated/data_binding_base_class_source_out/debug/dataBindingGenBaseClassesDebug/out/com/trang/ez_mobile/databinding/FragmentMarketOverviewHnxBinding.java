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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.trang.ez_mobile.util.custormView.TextViewFont;

public abstract class FragmentMarketOverviewHnxBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout contentview;

  @NonNull
  public final LinearLayout linearLayoutChange;

  @NonNull
  public final LinearLayout linearLayoutValue;

  @NonNull
  public final LinearLayout linearlayoutProgressbar;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final TextViewFont textviewChange;

  @NonNull
  public final TextViewFont textviewValue;

  protected FragmentMarketOverviewHnxBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout contentview, LinearLayout linearLayoutChange,
      LinearLayout linearLayoutValue, LinearLayout linearlayoutProgressbar, ProgressBar progressBar,
      RecyclerView recyclerView, TextViewFont textviewChange, TextViewFont textviewValue) {
    super(_bindingComponent, _root, _localFieldCount);
    this.contentview = contentview;
    this.linearLayoutChange = linearLayoutChange;
    this.linearLayoutValue = linearLayoutValue;
    this.linearlayoutProgressbar = linearlayoutProgressbar;
    this.progressBar = progressBar;
    this.recyclerView = recyclerView;
    this.textviewChange = textviewChange;
    this.textviewValue = textviewValue;
  }

  @NonNull
  public static FragmentMarketOverviewHnxBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMarketOverviewHnxBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMarketOverviewHnxBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_market_overview_hnx, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMarketOverviewHnxBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMarketOverviewHnxBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMarketOverviewHnxBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_market_overview_hnx, null, false, component);
  }

  public static FragmentMarketOverviewHnxBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentMarketOverviewHnxBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentMarketOverviewHnxBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_market_overview_hnx);
  }
}

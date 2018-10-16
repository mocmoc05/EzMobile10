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
import com.trang.ez_mobile.util.custormView.ButtonFont;

public abstract class FragmentWatchlistFinancialFiguresBinding extends ViewDataBinding {
  @NonNull
  public final ButtonFont chiso;

  @NonNull
  public final ButtonFont chitieu;

  @NonNull
  public final RecyclerView list;

  @NonNull
  public final LinearLayout nut;

  protected FragmentWatchlistFinancialFiguresBinding(DataBindingComponent _bindingComponent,
      View _root, int _localFieldCount, ButtonFont chiso, ButtonFont chitieu, RecyclerView list,
      LinearLayout nut) {
    super(_bindingComponent, _root, _localFieldCount);
    this.chiso = chiso;
    this.chitieu = chitieu;
    this.list = list;
    this.nut = nut;
  }

  @NonNull
  public static FragmentWatchlistFinancialFiguresBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWatchlistFinancialFiguresBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWatchlistFinancialFiguresBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_watchlist_financial_figures, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentWatchlistFinancialFiguresBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWatchlistFinancialFiguresBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWatchlistFinancialFiguresBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_watchlist_financial_figures, null, false, component);
  }

  public static FragmentWatchlistFinancialFiguresBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentWatchlistFinancialFiguresBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentWatchlistFinancialFiguresBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_watchlist_financial_figures);
  }
}

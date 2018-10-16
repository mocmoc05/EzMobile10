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

public abstract class ItemMarketOverviewRecyclerviewMarketDetailBinding extends ViewDataBinding {
  @NonNull
  public final TextViewFont textViewPriceOpen;

  @NonNull
  public final TextViewFont textviewChange;

  @NonNull
  public final TextViewFont textviewName;

  @NonNull
  public final TextViewFont textviewPriceClose;

  @NonNull
  public final TextViewFont textviewPriceHigh;

  @NonNull
  public final TextViewFont textviewPriceLow;

  @NonNull
  public final TextViewFont textviewVolumn;

  protected ItemMarketOverviewRecyclerviewMarketDetailBinding(DataBindingComponent _bindingComponent,
      View _root, int _localFieldCount, TextViewFont textViewPriceOpen, TextViewFont textviewChange,
      TextViewFont textviewName, TextViewFont textviewPriceClose, TextViewFont textviewPriceHigh,
      TextViewFont textviewPriceLow, TextViewFont textviewVolumn) {
    super(_bindingComponent, _root, _localFieldCount);
    this.textViewPriceOpen = textViewPriceOpen;
    this.textviewChange = textviewChange;
    this.textviewName = textviewName;
    this.textviewPriceClose = textviewPriceClose;
    this.textviewPriceHigh = textviewPriceHigh;
    this.textviewPriceLow = textviewPriceLow;
    this.textviewVolumn = textviewVolumn;
  }

  @NonNull
  public static ItemMarketOverviewRecyclerviewMarketDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMarketOverviewRecyclerviewMarketDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMarketOverviewRecyclerviewMarketDetailBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_market_overview_recyclerview_market_detail, root, attachToRoot, component);
  }

  @NonNull
  public static ItemMarketOverviewRecyclerviewMarketDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMarketOverviewRecyclerviewMarketDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMarketOverviewRecyclerviewMarketDetailBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_market_overview_recyclerview_market_detail, null, false, component);
  }

  public static ItemMarketOverviewRecyclerviewMarketDetailBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemMarketOverviewRecyclerviewMarketDetailBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemMarketOverviewRecyclerviewMarketDetailBinding)bind(component, view, com.trang.ez_mobile.R.layout.item_market_overview_recyclerview_market_detail);
  }
}

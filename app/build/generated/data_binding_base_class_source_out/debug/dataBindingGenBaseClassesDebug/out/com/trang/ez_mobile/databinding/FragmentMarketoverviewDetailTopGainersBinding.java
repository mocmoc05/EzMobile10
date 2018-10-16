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
import com.trang.ez_mobile.util.custormView.TextViewFontBold;

public abstract class FragmentMarketoverviewDetailTopGainersBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final TextViewFontBold textViewPriceOpen;

  @NonNull
  public final TextViewFontBold textviewChange;

  @NonNull
  public final TextViewFontBold textviewName;

  @NonNull
  public final TextViewFontBold textviewPriceClose;

  @NonNull
  public final TextViewFontBold textviewPriceHigh;

  @NonNull
  public final TextViewFontBold textviewPriceLow;

  @NonNull
  public final TextViewFontBold textviewVolumn;

  protected FragmentMarketoverviewDetailTopGainersBinding(DataBindingComponent _bindingComponent,
      View _root, int _localFieldCount, RecyclerView recyclerView,
      TextViewFontBold textViewPriceOpen, TextViewFontBold textviewChange,
      TextViewFontBold textviewName, TextViewFontBold textviewPriceClose,
      TextViewFontBold textviewPriceHigh, TextViewFontBold textviewPriceLow,
      TextViewFontBold textviewVolumn) {
    super(_bindingComponent, _root, _localFieldCount);
    this.recyclerView = recyclerView;
    this.textViewPriceOpen = textViewPriceOpen;
    this.textviewChange = textviewChange;
    this.textviewName = textviewName;
    this.textviewPriceClose = textviewPriceClose;
    this.textviewPriceHigh = textviewPriceHigh;
    this.textviewPriceLow = textviewPriceLow;
    this.textviewVolumn = textviewVolumn;
  }

  @NonNull
  public static FragmentMarketoverviewDetailTopGainersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMarketoverviewDetailTopGainersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMarketoverviewDetailTopGainersBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_marketoverview_detail_top_gainers, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMarketoverviewDetailTopGainersBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMarketoverviewDetailTopGainersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMarketoverviewDetailTopGainersBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_marketoverview_detail_top_gainers, null, false, component);
  }

  public static FragmentMarketoverviewDetailTopGainersBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentMarketoverviewDetailTopGainersBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentMarketoverviewDetailTopGainersBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_marketoverview_detail_top_gainers);
  }
}

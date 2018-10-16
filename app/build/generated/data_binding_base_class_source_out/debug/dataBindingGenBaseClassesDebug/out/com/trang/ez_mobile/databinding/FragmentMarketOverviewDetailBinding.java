package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.trang.ez_mobile.util.custormView.TabLayoutFont;
import com.trang.ez_mobile.util.custormView.TextViewFont;
import com.trang.ez_mobile.util.custormView.TextViewFontBold;

public abstract class FragmentMarketOverviewDetailBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final LinearLayout linearLayout1;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final RelativeLayout relativeLayoutContentView;

  @NonNull
  public final TabLayoutFont tablayout;

  @NonNull
  public final TextViewFontBold textviewChange;

  @NonNull
  public final TextViewFont textviewForeignQty;

  @NonNull
  public final TextViewFont textviewForeignVal;

  @NonNull
  public final TextViewFontBold textviewMatchPrice;

  @NonNull
  public final TextViewFont textviewPriceAverage;

  @NonNull
  public final TextViewFont textviewPriceDown;

  @NonNull
  public final TextViewFontBold textviewPriceQuantity;

  @NonNull
  public final TextViewFont textviewPriceUp;

  @NonNull
  public final TextViewFontBold textviewPriceValue;

  @NonNull
  public final View view1;

  @NonNull
  public final ViewPager viewpager;

  protected FragmentMarketOverviewDetailBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout linearLayout, LinearLayout linearLayout1,
      ProgressBar progressBar, RelativeLayout relativeLayout,
      RelativeLayout relativeLayoutContentView, TabLayoutFont tablayout,
      TextViewFontBold textviewChange, TextViewFont textviewForeignQty,
      TextViewFont textviewForeignVal, TextViewFontBold textviewMatchPrice,
      TextViewFont textviewPriceAverage, TextViewFont textviewPriceDown,
      TextViewFontBold textviewPriceQuantity, TextViewFont textviewPriceUp,
      TextViewFontBold textviewPriceValue, View view1, ViewPager viewpager) {
    super(_bindingComponent, _root, _localFieldCount);
    this.linearLayout = linearLayout;
    this.linearLayout1 = linearLayout1;
    this.progressBar = progressBar;
    this.relativeLayout = relativeLayout;
    this.relativeLayoutContentView = relativeLayoutContentView;
    this.tablayout = tablayout;
    this.textviewChange = textviewChange;
    this.textviewForeignQty = textviewForeignQty;
    this.textviewForeignVal = textviewForeignVal;
    this.textviewMatchPrice = textviewMatchPrice;
    this.textviewPriceAverage = textviewPriceAverage;
    this.textviewPriceDown = textviewPriceDown;
    this.textviewPriceQuantity = textviewPriceQuantity;
    this.textviewPriceUp = textviewPriceUp;
    this.textviewPriceValue = textviewPriceValue;
    this.view1 = view1;
    this.viewpager = viewpager;
  }

  @NonNull
  public static FragmentMarketOverviewDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMarketOverviewDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMarketOverviewDetailBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_market_overview_detail, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMarketOverviewDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMarketOverviewDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMarketOverviewDetailBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_market_overview_detail, null, false, component);
  }

  public static FragmentMarketOverviewDetailBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentMarketOverviewDetailBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentMarketOverviewDetailBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_market_overview_detail);
  }
}

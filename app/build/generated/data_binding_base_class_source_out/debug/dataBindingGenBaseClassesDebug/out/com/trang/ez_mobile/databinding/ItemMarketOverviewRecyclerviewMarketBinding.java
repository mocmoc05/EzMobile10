package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.trang.ez_mobile.util.custormView.TextViewFontBold;

public abstract class ItemMarketOverviewRecyclerviewMarketBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout contentview;

  @NonNull
  public final ImageView imageChecked;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final TextViewFontBold textviewMarketChange;

  @NonNull
  public final TextViewFontBold textviewMarketLastPrice;

  @NonNull
  public final TextViewFontBold textviewMarketName;

  @NonNull
  public final TextViewFontBold textviewMarketValue;

  protected ItemMarketOverviewRecyclerviewMarketBinding(DataBindingComponent _bindingComponent,
      View _root, int _localFieldCount, LinearLayout contentview, ImageView imageChecked,
      LinearLayout linearLayout, TextViewFontBold textviewMarketChange,
      TextViewFontBold textviewMarketLastPrice, TextViewFontBold textviewMarketName,
      TextViewFontBold textviewMarketValue) {
    super(_bindingComponent, _root, _localFieldCount);
    this.contentview = contentview;
    this.imageChecked = imageChecked;
    this.linearLayout = linearLayout;
    this.textviewMarketChange = textviewMarketChange;
    this.textviewMarketLastPrice = textviewMarketLastPrice;
    this.textviewMarketName = textviewMarketName;
    this.textviewMarketValue = textviewMarketValue;
  }

  @NonNull
  public static ItemMarketOverviewRecyclerviewMarketBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMarketOverviewRecyclerviewMarketBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMarketOverviewRecyclerviewMarketBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_market_overview_recyclerview_market, root, attachToRoot, component);
  }

  @NonNull
  public static ItemMarketOverviewRecyclerviewMarketBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemMarketOverviewRecyclerviewMarketBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemMarketOverviewRecyclerviewMarketBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_market_overview_recyclerview_market, null, false, component);
  }

  public static ItemMarketOverviewRecyclerviewMarketBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemMarketOverviewRecyclerviewMarketBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemMarketOverviewRecyclerviewMarketBinding)bind(component, view, com.trang.ez_mobile.R.layout.item_market_overview_recyclerview_market);
  }
}

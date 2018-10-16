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
import com.trang.ez_mobile.util.custormView.TextViewFont;
import com.trang.ez_mobile.util.custormView.TextViewFontBold;

public abstract class FragmentWatchlistTradingBinding extends ViewDataBinding {
  @NonNull
  public final FrameLayout contentview;

  @NonNull
  public final TextViewFontBold txtB1MrkValue;

  @NonNull
  public final TextViewFont txtB1Title;

  @NonNull
  public final TextViewFontBold txtB1VolValue;

  @NonNull
  public final TextViewFontBold txtB2MrkValue;

  @NonNull
  public final TextViewFont txtB2Title;

  @NonNull
  public final TextViewFontBold txtB2VolValue;

  @NonNull
  public final TextViewFontBold txtB3MrkValue;

  @NonNull
  public final TextViewFont txtB3Title;

  @NonNull
  public final TextViewFontBold txtB3VolValue;

  @NonNull
  public final TextViewFont txtBMrkTitle;

  @NonNull
  public final TextViewFont txtBVolTitle;

  @NonNull
  public final TextViewFontBold txtS1MrkValue;

  @NonNull
  public final TextViewFont txtS1Title;

  @NonNull
  public final TextViewFontBold txtS1VolValue;

  @NonNull
  public final TextViewFontBold txtS2MrkValue;

  @NonNull
  public final TextViewFont txtS2Title;

  @NonNull
  public final TextViewFontBold txtS2VolValue;

  @NonNull
  public final TextViewFontBold txtS3MrkValue;

  @NonNull
  public final TextViewFont txtS3Title;

  @NonNull
  public final TextViewFontBold txtS3VolValue;

  @NonNull
  public final TextViewFont txtSMrkTitle;

  @NonNull
  public final TextViewFont txtSVolTitle;

  protected FragmentWatchlistTradingBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, FrameLayout contentview, TextViewFontBold txtB1MrkValue,
      TextViewFont txtB1Title, TextViewFontBold txtB1VolValue, TextViewFontBold txtB2MrkValue,
      TextViewFont txtB2Title, TextViewFontBold txtB2VolValue, TextViewFontBold txtB3MrkValue,
      TextViewFont txtB3Title, TextViewFontBold txtB3VolValue, TextViewFont txtBMrkTitle,
      TextViewFont txtBVolTitle, TextViewFontBold txtS1MrkValue, TextViewFont txtS1Title,
      TextViewFontBold txtS1VolValue, TextViewFontBold txtS2MrkValue, TextViewFont txtS2Title,
      TextViewFontBold txtS2VolValue, TextViewFontBold txtS3MrkValue, TextViewFont txtS3Title,
      TextViewFontBold txtS3VolValue, TextViewFont txtSMrkTitle, TextViewFont txtSVolTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.contentview = contentview;
    this.txtB1MrkValue = txtB1MrkValue;
    this.txtB1Title = txtB1Title;
    this.txtB1VolValue = txtB1VolValue;
    this.txtB2MrkValue = txtB2MrkValue;
    this.txtB2Title = txtB2Title;
    this.txtB2VolValue = txtB2VolValue;
    this.txtB3MrkValue = txtB3MrkValue;
    this.txtB3Title = txtB3Title;
    this.txtB3VolValue = txtB3VolValue;
    this.txtBMrkTitle = txtBMrkTitle;
    this.txtBVolTitle = txtBVolTitle;
    this.txtS1MrkValue = txtS1MrkValue;
    this.txtS1Title = txtS1Title;
    this.txtS1VolValue = txtS1VolValue;
    this.txtS2MrkValue = txtS2MrkValue;
    this.txtS2Title = txtS2Title;
    this.txtS2VolValue = txtS2VolValue;
    this.txtS3MrkValue = txtS3MrkValue;
    this.txtS3Title = txtS3Title;
    this.txtS3VolValue = txtS3VolValue;
    this.txtSMrkTitle = txtSMrkTitle;
    this.txtSVolTitle = txtSVolTitle;
  }

  @NonNull
  public static FragmentWatchlistTradingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWatchlistTradingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWatchlistTradingBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_watchlist_trading, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentWatchlistTradingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWatchlistTradingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWatchlistTradingBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_watchlist_trading, null, false, component);
  }

  public static FragmentWatchlistTradingBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentWatchlistTradingBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentWatchlistTradingBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_watchlist_trading);
  }
}

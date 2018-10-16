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
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.trang.ez_mobile.util.custormView.TabLayoutFont;
import com.trang.ez_mobile.util.custormView.TextViewFont;
import com.trang.ez_mobile.util.custormView.TextViewFontBold;

public abstract class FragmentWatchlistDetailBinding extends ViewDataBinding {
  @NonNull
  public final ImageView icon;

  @NonNull
  public final LinearLayout la1;

  @NonNull
  public final LinearLayout la2;

  @NonNull
  public final TextViewFont nnban;

  @NonNull
  public final TextViewFont nnmua;

  @NonNull
  public final TextViewFontBold op;

  @NonNull
  public final TabLayoutFont tablayout;

  @NonNull
  public final TextViewFontBold textviewCn;

  @NonNull
  public final TextViewFont textviewGia;

  @NonNull
  public final TextViewFont textviewKhoiluong;

  @NonNull
  public final TextViewFont textviewMax;

  @NonNull
  public final TextViewFont textviewMin;

  @NonNull
  public final TextViewFontBold textviewNban;

  @NonNull
  public final TextViewFontBold textviewNmua;

  @NonNull
  public final TextViewFont textviewOpen;

  @NonNull
  public final TextViewFont textviewSan;

  @NonNull
  public final TextViewFont textviewTc;

  @NonNull
  public final TextViewFont textviewThaydoi;

  @NonNull
  public final TextViewFontBold textviewTn;

  @NonNull
  public final TextViewFont textviewTran;

  @NonNull
  public final ViewPager viewpager;

  protected FragmentWatchlistDetailBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView icon, LinearLayout la1, LinearLayout la2, TextViewFont nnban,
      TextViewFont nnmua, TextViewFontBold op, TabLayoutFont tablayout, TextViewFontBold textviewCn,
      TextViewFont textviewGia, TextViewFont textviewKhoiluong, TextViewFont textviewMax,
      TextViewFont textviewMin, TextViewFontBold textviewNban, TextViewFontBold textviewNmua,
      TextViewFont textviewOpen, TextViewFont textviewSan, TextViewFont textviewTc,
      TextViewFont textviewThaydoi, TextViewFontBold textviewTn, TextViewFont textviewTran,
      ViewPager viewpager) {
    super(_bindingComponent, _root, _localFieldCount);
    this.icon = icon;
    this.la1 = la1;
    this.la2 = la2;
    this.nnban = nnban;
    this.nnmua = nnmua;
    this.op = op;
    this.tablayout = tablayout;
    this.textviewCn = textviewCn;
    this.textviewGia = textviewGia;
    this.textviewKhoiluong = textviewKhoiluong;
    this.textviewMax = textviewMax;
    this.textviewMin = textviewMin;
    this.textviewNban = textviewNban;
    this.textviewNmua = textviewNmua;
    this.textviewOpen = textviewOpen;
    this.textviewSan = textviewSan;
    this.textviewTc = textviewTc;
    this.textviewThaydoi = textviewThaydoi;
    this.textviewTn = textviewTn;
    this.textviewTran = textviewTran;
    this.viewpager = viewpager;
  }

  @NonNull
  public static FragmentWatchlistDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWatchlistDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWatchlistDetailBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_watchlist_detail, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentWatchlistDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWatchlistDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWatchlistDetailBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_watchlist_detail, null, false, component);
  }

  public static FragmentWatchlistDetailBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentWatchlistDetailBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentWatchlistDetailBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_watchlist_detail);
  }
}

package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.trang.ez_mobile.util.custormView.SquareImageView;
import com.trang.ez_mobile.util.custormView.TextViewFont;

public abstract class ItemWatchlistNewsBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout l1;

  @NonNull
  public final SquareImageView squareImageviewIcon;

  @NonNull
  public final TextViewFont textviewDate;

  @NonNull
  public final TextViewFont textviewTitle;

  protected ItemWatchlistNewsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout l1, SquareImageView squareImageviewIcon,
      TextViewFont textviewDate, TextViewFont textviewTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.l1 = l1;
    this.squareImageviewIcon = squareImageviewIcon;
    this.textviewDate = textviewDate;
    this.textviewTitle = textviewTitle;
  }

  @NonNull
  public static ItemWatchlistNewsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemWatchlistNewsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemWatchlistNewsBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_watchlist_news, root, attachToRoot, component);
  }

  @NonNull
  public static ItemWatchlistNewsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemWatchlistNewsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemWatchlistNewsBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_watchlist_news, null, false, component);
  }

  public static ItemWatchlistNewsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemWatchlistNewsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemWatchlistNewsBinding)bind(component, view, com.trang.ez_mobile.R.layout.item_watchlist_news);
  }
}

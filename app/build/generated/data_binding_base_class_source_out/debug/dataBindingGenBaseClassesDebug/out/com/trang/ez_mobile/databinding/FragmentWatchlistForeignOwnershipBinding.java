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

public abstract class FragmentWatchlistForeignOwnershipBinding extends ViewDataBinding {
  @NonNull
  public final FrameLayout contentview;

  @NonNull
  public final TextViewFont khht;

  @NonNull
  public final TextViewFont klcl;

  @NonNull
  public final TextViewFont klm;

  @NonNull
  public final TextViewFont tyle;

  @NonNull
  public final TextViewFont update;

  protected FragmentWatchlistForeignOwnershipBinding(DataBindingComponent _bindingComponent,
      View _root, int _localFieldCount, FrameLayout contentview, TextViewFont khht,
      TextViewFont klcl, TextViewFont klm, TextViewFont tyle, TextViewFont update) {
    super(_bindingComponent, _root, _localFieldCount);
    this.contentview = contentview;
    this.khht = khht;
    this.klcl = klcl;
    this.klm = klm;
    this.tyle = tyle;
    this.update = update;
  }

  @NonNull
  public static FragmentWatchlistForeignOwnershipBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWatchlistForeignOwnershipBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWatchlistForeignOwnershipBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_watchlist_foreign_ownership, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentWatchlistForeignOwnershipBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentWatchlistForeignOwnershipBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentWatchlistForeignOwnershipBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_watchlist_foreign_ownership, null, false, component);
  }

  public static FragmentWatchlistForeignOwnershipBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentWatchlistForeignOwnershipBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentWatchlistForeignOwnershipBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_watchlist_foreign_ownership);
  }
}

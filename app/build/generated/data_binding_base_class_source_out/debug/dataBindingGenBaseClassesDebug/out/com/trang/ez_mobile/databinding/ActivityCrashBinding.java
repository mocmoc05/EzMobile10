package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.trang.ez_mobile.util.custormView.TextViewFont;

public abstract class ActivityCrashBinding extends ViewDataBinding {
  @NonNull
  public final Button btnErrorDetails;

  @NonNull
  public final Button btnRestartApp;

  @NonNull
  public final ImageView ivBug;

  @NonNull
  public final TextViewFont tvMessage;

  @NonNull
  public final TextViewFont tvMessage2;

  protected ActivityCrashBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnErrorDetails, Button btnRestartApp, ImageView ivBug,
      TextViewFont tvMessage, TextViewFont tvMessage2) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnErrorDetails = btnErrorDetails;
    this.btnRestartApp = btnRestartApp;
    this.ivBug = ivBug;
    this.tvMessage = tvMessage;
    this.tvMessage2 = tvMessage2;
  }

  @NonNull
  public static ActivityCrashBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityCrashBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityCrashBinding>inflate(inflater, com.trang.ez_mobile.R.layout.activity_crash, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityCrashBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityCrashBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityCrashBinding>inflate(inflater, com.trang.ez_mobile.R.layout.activity_crash, null, false, component);
  }

  public static ActivityCrashBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityCrashBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityCrashBinding)bind(component, view, com.trang.ez_mobile.R.layout.activity_crash);
  }
}

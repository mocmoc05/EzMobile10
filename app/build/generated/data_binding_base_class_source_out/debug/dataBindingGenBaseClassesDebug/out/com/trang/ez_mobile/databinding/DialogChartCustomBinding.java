package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.trang.ez_mobile.util.custormView.ButtonFont;
import com.trang.ez_mobile.util.custormView.EditTextFont;
import com.trang.ez_mobile.util.custormView.TextViewFont;

public abstract class DialogChartCustomBinding extends ViewDataBinding {
  @NonNull
  public final ButtonFont exit;

  @NonNull
  public final EditTextFont name;

  @NonNull
  public final EditTextFont name1;

  @NonNull
  public final EditTextFont name2;

  @NonNull
  public final ButtonFont save;

  @NonNull
  public final TextViewFont tieude;

  protected DialogChartCustomBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ButtonFont exit, EditTextFont name, EditTextFont name1,
      EditTextFont name2, ButtonFont save, TextViewFont tieude) {
    super(_bindingComponent, _root, _localFieldCount);
    this.exit = exit;
    this.name = name;
    this.name1 = name1;
    this.name2 = name2;
    this.save = save;
    this.tieude = tieude;
  }

  @NonNull
  public static DialogChartCustomBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogChartCustomBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogChartCustomBinding>inflate(inflater, com.trang.ez_mobile.R.layout.dialog_chart_custom, root, attachToRoot, component);
  }

  @NonNull
  public static DialogChartCustomBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogChartCustomBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogChartCustomBinding>inflate(inflater, com.trang.ez_mobile.R.layout.dialog_chart_custom, null, false, component);
  }

  public static DialogChartCustomBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DialogChartCustomBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DialogChartCustomBinding)bind(component, view, com.trang.ez_mobile.R.layout.dialog_chart_custom);
  }
}

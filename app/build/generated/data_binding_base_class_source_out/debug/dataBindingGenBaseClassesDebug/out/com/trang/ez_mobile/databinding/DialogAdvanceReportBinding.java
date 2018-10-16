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

public abstract class DialogAdvanceReportBinding extends ViewDataBinding {
  @NonNull
  public final ButtonFont btnXacnhan;

  @NonNull
  public final EditTextFont edtNhaptienung;

  @NonNull
  public final TextViewFont tvMaxTienung;

  @NonNull
  public final TextViewFont tvValueSotiendangco;

  protected DialogAdvanceReportBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ButtonFont btnXacnhan, EditTextFont edtNhaptienung,
      TextViewFont tvMaxTienung, TextViewFont tvValueSotiendangco) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnXacnhan = btnXacnhan;
    this.edtNhaptienung = edtNhaptienung;
    this.tvMaxTienung = tvMaxTienung;
    this.tvValueSotiendangco = tvValueSotiendangco;
  }

  @NonNull
  public static DialogAdvanceReportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogAdvanceReportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogAdvanceReportBinding>inflate(inflater, com.trang.ez_mobile.R.layout.dialog_advance_report, root, attachToRoot, component);
  }

  @NonNull
  public static DialogAdvanceReportBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogAdvanceReportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogAdvanceReportBinding>inflate(inflater, com.trang.ez_mobile.R.layout.dialog_advance_report, null, false, component);
  }

  public static DialogAdvanceReportBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DialogAdvanceReportBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DialogAdvanceReportBinding)bind(component, view, com.trang.ez_mobile.R.layout.dialog_advance_report);
  }
}

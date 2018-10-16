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
import android.widget.Button;
import android.widget.LinearLayout;

public abstract class FragmentAdvanceReportBinding extends ViewDataBinding {
  @NonNull
  public final Button btnUngtien;

  @NonNull
  public final LinearLayout llProgressFragmentAdvanceReport;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final RecyclerView rcvListUngtruoc;

  protected FragmentAdvanceReportBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnUngtien, LinearLayout llProgressFragmentAdvanceReport,
      LinearLayout llTitle, RecyclerView rcvListUngtruoc) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnUngtien = btnUngtien;
    this.llProgressFragmentAdvanceReport = llProgressFragmentAdvanceReport;
    this.llTitle = llTitle;
    this.rcvListUngtruoc = rcvListUngtruoc;
  }

  @NonNull
  public static FragmentAdvanceReportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentAdvanceReportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentAdvanceReportBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_advance_report, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentAdvanceReportBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentAdvanceReportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentAdvanceReportBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_advance_report, null, false, component);
  }

  public static FragmentAdvanceReportBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentAdvanceReportBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentAdvanceReportBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_advance_report);
  }
}

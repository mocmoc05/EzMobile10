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
import com.trang.ez_mobile.util.custormView.ButtonFont;
import com.trang.ez_mobile.util.custormView.EditTextFont;

public abstract class FragmentSignUpBinding extends ViewDataBinding {
  @NonNull
  public final ButtonFont btnCancel;

  @NonNull
  public final ButtonFont btnSignUp;

  @NonNull
  public final EditTextFont edtAccountSign;

  @NonNull
  public final EditTextFont edtPasswordSign;

  @NonNull
  public final LinearLayout llProgressFragmentSignUp;

  protected FragmentSignUpBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ButtonFont btnCancel, ButtonFont btnSignUp, EditTextFont edtAccountSign,
      EditTextFont edtPasswordSign, LinearLayout llProgressFragmentSignUp) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnCancel = btnCancel;
    this.btnSignUp = btnSignUp;
    this.edtAccountSign = edtAccountSign;
    this.edtPasswordSign = edtPasswordSign;
    this.llProgressFragmentSignUp = llProgressFragmentSignUp;
  }

  @NonNull
  public static FragmentSignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentSignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentSignUpBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_sign_up, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSignUpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentSignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentSignUpBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_sign_up, null, false, component);
  }

  public static FragmentSignUpBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentSignUpBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentSignUpBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_sign_up);
  }
}

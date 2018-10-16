package com.trang.ez_mobile.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.trang.ez_mobile.util.custormView.ButtonFont;
import com.trang.ez_mobile.util.custormView.EditTextFont;
import com.trang.ez_mobile.util.custormView.TextViewFontBold;

public abstract class FragmentLoginBinding extends ViewDataBinding {
  @NonNull
  public final ButtonFont btnLogin;

  @NonNull
  public final CheckBox cbLuuMk;

  @NonNull
  public final EditTextFont edtAccount;

  @NonNull
  public final EditTextFont edtPassword;

  @NonNull
  public final LinearLayout llProgressFragmentLogin;

  @NonNull
  public final TextViewFontBold tvSignUp;

  protected FragmentLoginBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ButtonFont btnLogin, CheckBox cbLuuMk, EditTextFont edtAccount,
      EditTextFont edtPassword, LinearLayout llProgressFragmentLogin, TextViewFontBold tvSignUp) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnLogin = btnLogin;
    this.cbLuuMk = cbLuuMk;
    this.edtAccount = edtAccount;
    this.edtPassword = edtPassword;
    this.llProgressFragmentLogin = llProgressFragmentLogin;
    this.tvSignUp = tvSignUp;
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentLoginBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_login, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentLoginBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_login, null, false, component);
  }

  public static FragmentLoginBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentLoginBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentLoginBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_login);
  }
}

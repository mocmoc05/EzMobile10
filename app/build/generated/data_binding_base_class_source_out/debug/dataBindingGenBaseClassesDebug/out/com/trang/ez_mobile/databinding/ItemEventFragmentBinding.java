package com.trang.ez_mobile.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.trang.ez_mobile.view.events.Event;

public abstract class ItemEventFragmentBinding extends ViewDataBinding {
  @Bindable
  protected Event mEvent;

  protected ItemEventFragmentBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount) {
    super(_bindingComponent, _root, _localFieldCount);
  }

  public abstract void setEvent(@Nullable Event event);

  @Nullable
  public Event getEvent() {
    return mEvent;
  }

  @NonNull
  public static ItemEventFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemEventFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemEventFragmentBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_event_fragment, root, attachToRoot, component);
  }

  @NonNull
  public static ItemEventFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemEventFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemEventFragmentBinding>inflate(inflater, com.trang.ez_mobile.R.layout.item_event_fragment, null, false, component);
  }

  public static ItemEventFragmentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemEventFragmentBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemEventFragmentBinding)bind(component, view, com.trang.ez_mobile.R.layout.item_event_fragment);
  }
}

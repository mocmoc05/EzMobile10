package com.trang.ez_mobile.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import com.trang.ez_mobile.util.custormView.TextViewFont;
import com.trang.ez_mobile.view.events.EventsInterface;

public abstract class FragmentEventBinding extends ViewDataBinding {
  @NonNull
  public final CalendarView calendarView;

  @NonNull
  public final LinearLayout llFragmentEvent;

  @NonNull
  public final LinearLayout llProgressFragmentEvent;

  @NonNull
  public final RecyclerView rcvEvent;

  @NonNull
  public final TextViewFont tvTitleDate;

  @Bindable
  protected EventsInterface.Presenter mEventPresenter;

  protected FragmentEventBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, CalendarView calendarView, LinearLayout llFragmentEvent,
      LinearLayout llProgressFragmentEvent, RecyclerView rcvEvent, TextViewFont tvTitleDate) {
    super(_bindingComponent, _root, _localFieldCount);
    this.calendarView = calendarView;
    this.llFragmentEvent = llFragmentEvent;
    this.llProgressFragmentEvent = llProgressFragmentEvent;
    this.rcvEvent = rcvEvent;
    this.tvTitleDate = tvTitleDate;
  }

  public abstract void setEventPresenter(@Nullable EventsInterface.Presenter event_presenter);

  @Nullable
  public EventsInterface.Presenter getEventPresenter() {
    return mEventPresenter;
  }

  @NonNull
  public static FragmentEventBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentEventBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentEventBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_event, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentEventBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentEventBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentEventBinding>inflate(inflater, com.trang.ez_mobile.R.layout.fragment_event, null, false, component);
  }

  public static FragmentEventBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentEventBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentEventBinding)bind(component, view, com.trang.ez_mobile.R.layout.fragment_event);
  }
}

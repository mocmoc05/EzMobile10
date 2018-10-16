package com.trang.ez_mobile.view.events;

import android.databinding.ObservableField;

/**
 * Created by TraPTH on 3/16/2018.
 */

public class Event {
    public final ObservableField<String> idEvent = new ObservableField<>();
    public final ObservableField<String> nameStock = new ObservableField<>();
    public final ObservableField<String> groupName = new ObservableField<>();
    public final ObservableField<String> url = new ObservableField<>();
    public final ObservableField<String> contentEvent = new ObservableField<>();
    public final ObservableField<String> dateEvent = new ObservableField<>();

    public Event(String idEvent, String nameStock, String groupName, String url, String contentEvent, String dateEvent) {
        this.idEvent.set(idEvent);
        this.nameStock.set(nameStock);
        this.groupName.set(groupName);
        this.url.set(url);
        this.contentEvent.set(contentEvent);
        this.dateEvent.set(dateEvent);
    }
}

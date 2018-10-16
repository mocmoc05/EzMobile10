package com.trang.ez_mobile.view.events;

import java.util.List;

/**
 * Created by TraPTH on 3/16/2018.
 */

public interface EventsInterface {
    interface View {
        void dataDone(List<Event> list);

        void dataFail();

        void onLoad();

        void connectFail();

        void connectServerFail();
    }

    interface Presenter {
        void callData(String date);

        void onClickCalendarView(String date);
    }
}

package com.trang.ez_mobile.view.events;

import android.content.Context;
import android.net.ConnectivityManager;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by TraPTH on 3/16/2018.
 */

public class EventsPresenter implements EventsInterface.Presenter {
    private List<Event> listAll;
    private List<Event> eventList;
    private Context context;
    private EventsInterface.View view;
    private String baseUrl = "";

    public EventsPresenter(List<Event> eventList, Context context, EventsInterface.View view) {
        this.eventList = eventList;
        this.context = context;
        this.view = view;
        this.baseUrl = "http://gateway.fpts.com.vn/g5g/";
        listAll = new ArrayList<>();
    }

    @Override
    public void callData(String date) {
        if (isNetworkConnected() == true) {
            Utils apiClient = new Utils();
            Retrofit retrofit = apiClient.getRetrofit(baseUrl);

            Api myService = retrofit.create(Api.class);
            Call<String> stringCall = myService.getStringEvent("eventbydate", 1 + "");
            stringCall.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        String responseString = response.body();
                        if (responseString.equals("")) {
                            view.dataFail();
                        } else {
                            splitEvent(responseString, date);
//                            view.dataDone(eventList);
                        }
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    view.connectServerFail();
                }
            });

            view.onLoad();
        } else {
            view.connectFail();
        }
    }

    @Override
    public void onClickCalendarView(String date) {
        getByDate(date);
    }

    private void splitEvent(String body, String date) {
        String item[] = body.split("@");
        for (int i = 0; i < item.length; i++) {
            String obj[] = item[i].split("#");
            String time = obj[5].split("\\s+")[0];

            listAll.add(new Event(obj[0], obj[1], obj[2], obj[3], obj[4], time));
        }

        getByDate(date);
    }

    private void getByDate(String date) {
        eventList.clear();
        for (int i = 0; i < listAll.size(); i++) {
            if (date.equals(listAll.get(i).dateEvent.get())) {
                eventList.add(listAll.get(i));
            }
        }
        view.dataDone(eventList);
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}

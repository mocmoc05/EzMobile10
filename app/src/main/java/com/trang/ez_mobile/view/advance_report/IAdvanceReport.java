package com.trang.ez_mobile.view.advance_report;

import com.trang.ez_mobile.view.place_orders.object.UngTien;

import java.util.List;

/**
 * Created by TraPTH on 5/18/2018.
 */
public interface IAdvanceReport {
    void getDataDone(List<UngTien> ungTienList);

    void getDataFail();

    void connectServerFail();

    void connectNetworkFail();

    void onLoad();
}

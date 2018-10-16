package com.trang.ez_mobile.view.place_orders.buy.detail_buy;

import com.trang.ez_mobile.view.place_orders.object.ChungKhoan;

/**
 * Created by TraPTH on 5/23/2018.
 */
public interface IDetailBuy {
    void getCKFail();

    void getCKDone(ChungKhoan chungKhoan);

    void connectNetworkFail();

    void connectServerFail();

    void transactionFail();

    void transactionDone();

    void findStockFail();

    void onLoad();

    void getTTCKDone(String ban, String klBan, String mua, String klMua);
}

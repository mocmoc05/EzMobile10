package com.trang.ez_mobile.view.place_orders.sell;

import com.trang.ez_mobile.view.place_orders.object.ChungKhoan;
import com.trang.ez_mobile.view.user.object.TaiKhoanObject;

/**
 * Created by TraPTH on 5/15/2018.
 */
public interface ISell {
    void getCKFail();

    void getCKDone(ChungKhoan chungKhoan);

    void getTTCKDone(String ban, String klBan, String mua, String klMua);

    void connectNetworkFail();

    void connectServerFail();

    void transactionFail();

    void transactionDone();

    void findStockFail();

    void onLoad();

    void failTransByMoney();
}

package com.trang.ez_mobile.view.place_orders.buy;

import com.trang.ez_mobile.view.place_orders.object.BaoCaoTaiSanCk;
import com.trang.ez_mobile.view.place_orders.object.GiaoDich;

import java.util.List;

/**
 * Created by TraPTH on 5/15/2018.
 */
public interface IBuy {
    void getDataDone(List<BaoCaoTaiSanCk> taiSanCkList);

    void getDataFail();

    void connectNetworkFail();

    void connectServerFail();

    void moveFragmentBuy(String maCK, String khoiLuong);

    void onLoad();

}

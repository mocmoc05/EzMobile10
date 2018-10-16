package com.trang.ez_mobile.view.asset_report.stock_balance;

import com.trang.ez_mobile.view.place_orders.object.BaoCaoTaiSanCk;

import java.util.List;

/**
 * Created by TraPTH on 5/18/2018.
 */
public interface IStockBalance {
    void getDataDone(List<BaoCaoTaiSanCk> baoCaoTaiSanCkList);

    void connectNetworkFail();

    void connectServerFail();

    void onLoad();

    void getDataFail();
}

package com.trang.ez_mobile.view.asset_report.stock_balance;

import com.trang.ez_mobile.util.Utils;
import com.trang.ez_mobile.util.api_json.ApiClientImp;
import com.trang.ez_mobile.view.place_orders.object.RestObject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by TraPTH on 5/18/2018.
 */
public class StockBalancePresenter {
    private IStockBalance view;

    public StockBalancePresenter(IStockBalance view) {
        this.view = view;
    }

    public void getData(String maTk) {
        CompositeSubscription subscription = new CompositeSubscription();
        if (Utils.isNetworkAvailable()) {
            subscription.add(ApiClientImp.getInstance().getTaiSanListCk("get_baocao_list_ck", maTk)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<RestObject>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                            view.connectServerFail();
                        }

                        @Override
                        public void onNext(RestObject listGiaoDichObject) {
                            if (listGiaoDichObject.getListTaiSanCk() == null) {
                                view.getDataFail();
                            } else {
                                view.getDataDone(listGiaoDichObject.getListTaiSanCk());
                            }

                        }
                    }));

            view.onLoad();

        } else {
            view.connectNetworkFail();
        }
    }
}

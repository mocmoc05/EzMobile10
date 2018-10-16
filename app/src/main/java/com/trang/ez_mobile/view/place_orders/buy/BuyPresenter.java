package com.trang.ez_mobile.view.place_orders.buy;

import com.trang.ez_mobile.util.Utils;
import com.trang.ez_mobile.util.api_json.ApiClientImp;
import com.trang.ez_mobile.view.place_orders.object.BaoCaoTaiSanCk;
import com.trang.ez_mobile.view.place_orders.object.GiaoDich;
import com.trang.ez_mobile.view.place_orders.object.RestObject;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by TraPTH on 5/15/2018.
 */
public class BuyPresenter {
    private IBuy view;
    private RestObject listGiaoDich;
    private List<BaoCaoTaiSanCk> taiSanCkList;

    public BuyPresenter(IBuy view) {
        this.view = view;
    }

    public void getData(String ma_tk) {
        CompositeSubscription subscription = new CompositeSubscription();
        if (Utils.isNetworkAvailable()) {
            subscription.add(ApiClientImp.getInstance().getTaiSanListCk("get_baocao_list_ck", ma_tk)
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
                                taiSanCkList = listGiaoDichObject.getListTaiSanCk();
                                view.getDataDone(taiSanCkList);
                            }

                        }
                    }));

            view.onLoad();

        } else {
            view.connectNetworkFail();
        }
    }
}

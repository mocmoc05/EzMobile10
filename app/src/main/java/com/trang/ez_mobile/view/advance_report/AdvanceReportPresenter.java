package com.trang.ez_mobile.view.advance_report;

import com.trang.ez_mobile.util.Utils;
import com.trang.ez_mobile.util.api_json.ApiClientImp;
import com.trang.ez_mobile.view.place_orders.object.RestObject;
import com.trang.ez_mobile.view.place_orders.object.UngTien;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by TraPTH on 5/18/2018.
 */
public class AdvanceReportPresenter {
    private IAdvanceReport view;
    private List<UngTien> tienList;

    public AdvanceReportPresenter(IAdvanceReport view) {
        this.view = view;
    }

    public void getData(String maTk) {
        CompositeSubscription subscription = new CompositeSubscription();
        if (Utils.isNetworkAvailable()) {
            subscription.add(ApiClientImp.getInstance().getListUngTienByTk("get_list_ungtien", maTk)
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
                        public void onNext(RestObject restObject) {
                            if (restObject.getListUngTien() == null) {
                                view.getDataFail();
                            } else {
                                tienList = restObject.getListUngTien();
                                view.getDataDone(tienList);
                            }

                        }
                    }));

            view.onLoad();

        } else {
            view.connectNetworkFail();
        }
    }
}

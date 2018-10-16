package com.trang.ez_mobile.view.user.login;

import com.trang.ez_mobile.util.Utils;
import com.trang.ez_mobile.util.api_json.ApiClientImp;
import com.trang.ez_mobile.view.user.object.TaiKhoanObject;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by TraPTH on 4/14/2018.
 */
public class LoginPresenter {
    private ILogin view;
    private List<TaiKhoan> list;
    private TaiKhoan tk;

    public LoginPresenter(ILogin view) {
        this.view = view;
        list = new ArrayList<>();
        tk = new TaiKhoan();
    }

    public void checkConnect(String strAccount, String strPassword) {
        CompositeSubscription subscription = new CompositeSubscription();
        if (Utils.isNetworkAvailable()) {
            subscription.add(ApiClientImp.getInstance().getTaiKhoanById("get_taikhoan", strAccount)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<TaiKhoanObject>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                            view.errorConnectServer();
                        }

                        @Override
                        public void onNext(TaiKhoanObject taiKhoan) {
                            if (taiKhoan.getTaikhoan().getMatKhau().equals(strPassword)) {
                                tk = taiKhoan.getTaikhoan();
                                view.loginSuccess(tk);
                            } else {
                                view.loginFail();
                            }
                        }
                    }));

            view.onLoad();

        } else {
            view.errorConnect();
        }
    }
}

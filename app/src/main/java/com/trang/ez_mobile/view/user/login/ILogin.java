package com.trang.ez_mobile.view.user.login;

/**
 * Created by TraPTH on 4/14/2018.
 */
public interface ILogin {
    void loginSuccess(TaiKhoan taiKhoan);

    void loginFail();

    void onLoad();

    void errorConnect();

    void errorConnectServer();
}

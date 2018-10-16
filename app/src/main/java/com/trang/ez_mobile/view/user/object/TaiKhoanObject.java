package com.trang.ez_mobile.view.user.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.trang.ez_mobile.view.user.login.TaiKhoan;

/**
 * Created by TraPTH on 5/20/2018.
 */
public class TaiKhoanObject {
    @SerializedName("taikhoan")
    @Expose
    private TaiKhoan taikhoan;
    @SerializedName("checkConnect")
    @Expose
    private Boolean checkConnect;

    public TaiKhoan getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(TaiKhoan taikhoan) {
        this.taikhoan = taikhoan;
    }

    public Boolean getCheckConnect() {
        return checkConnect;
    }

    public void setCheckConnect(Boolean checkConnect) {
        this.checkConnect = checkConnect;
    }
}

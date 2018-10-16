package com.trang.ez_mobile.view.user.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.trang.ez_mobile.view.user.login.TaiKhoan;

import java.util.List;

/**
 * Created by TraPTH on 5/20/2018.
 */
public class ListTaiKhoanObject {
    @SerializedName("taikhoans")
    @Expose
    private List<TaiKhoan> taikhoans = null;
    @SerializedName("checkConnect")
    @Expose
    private Boolean checkConnect;

    public List<TaiKhoan> getTaikhoans() {
        return taikhoans;
    }

    public void setTaikhoans(List<TaiKhoan> taikhoans) {
        this.taikhoans = taikhoans;
    }

    public Boolean getCheckConnect() {
        return checkConnect;
    }

    public void setCheckConnect(Boolean checkConnect) {
        this.checkConnect = checkConnect;
    }

}

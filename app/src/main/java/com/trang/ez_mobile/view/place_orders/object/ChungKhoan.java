package com.trang.ez_mobile.view.place_orders.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by TraPTH on 5/22/2018.
 */
public class ChungKhoan {
    @SerializedName("maCk")
    @Expose
    private String maCk;
    @SerializedName("tenCk")
    @Expose
    private String tenCk;
    @SerializedName("sanGd")
    @Expose
    private String sanGd;
    @SerializedName("giaTran")
    @Expose
    private String giaTran;
    @SerializedName("giaSan")
    @Expose
    private String giaSan;
    @SerializedName("giaTC")
    @Expose
    private String giaTC;

    public String getMaCk() {
        return maCk;
    }

    public void setMaCk(String maCk) {
        this.maCk = maCk;
    }

    public String getTenCk() {
        return tenCk;
    }

    public void setTenCk(String tenCk) {
        this.tenCk = tenCk;
    }

    public String getSanGd() {
        return sanGd;
    }

    public void setSanGd(String sanGd) {
        this.sanGd = sanGd;
    }

    public String getGiaTran() {
        return giaTran;
    }

    public void setGiaTran(String giaTran) {
        this.giaTran = giaTran;
    }

    public String getGiaSan() {
        return giaSan;
    }

    public void setGiaSan(String giaSan) {
        this.giaSan = giaSan;
    }

    public String getGiaTC() {
        return giaTC;
    }

    public void setGiaTC(String giaTC) {
        this.giaTC = giaTC;
    }

}

package com.trang.ez_mobile.view.place_orders.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by TraPTH on 5/27/2018.
 */
public class BaoCaoTaiSanCk {
    @SerializedName("maTk")
    @Expose
    private String maTk;
    @SerializedName("maCk")
    @Expose
    private String maCk;
    @SerializedName("khoiLuong")
    @Expose
    private String khoiLuong;
    @SerializedName("khoiLuongCho")
    @Expose
    private String khoiLuongCho;

    public String getMaTk() {
        return maTk;
    }

    public void setMaTk(String maTk) {
        this.maTk = maTk;
    }

    public String getMaCk() {
        return maCk;
    }

    public void setMaCk(String maCk) {
        this.maCk = maCk;
    }

    public String getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(String khoiLuong) {
        this.khoiLuong = khoiLuong;
    }

    public String getKhoiLuongCho() {
        return khoiLuongCho;
    }

    public void setKhoiLuongCho(String khoiLuongCho) {
        this.khoiLuongCho = khoiLuongCho;
    }

}

package com.trang.ez_mobile.view.place_orders.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by TraPTH on 5/23/2018.
 */
public class GiaoDich {
    @SerializedName("maCk")
    @Expose
    private String maCk;
    @SerializedName("maTK")
    @Expose
    private String maTK;
    @SerializedName("gia")
    @Expose
    private String gia;
    @SerializedName("khoiLuong")
    @Expose
    private String khoiLuong;
    @SerializedName("maLenh")
    @Expose
    private String maLenh;
    @SerializedName("loaiGd")
    @Expose
    private String loaiGd;
    @SerializedName("ngayGd")
    @Expose
    private String ngayGd;
    @SerializedName("tinhTrang")
    @Expose
    private String tinhTrang;

    public String getMaCk() {
        return maCk;
    }

    public void setMaCk(String maCk) {
        this.maCk = maCk;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(String khoiLuong) {
        this.khoiLuong = khoiLuong;
    }

    public String getMaLenh() {
        return maLenh;
    }

    public void setMaLenh(String maLenh) {
        this.maLenh = maLenh;
    }

    public String getLoaiGd() {
        return loaiGd;
    }

    public void setLoaiGd(String loaiGd) {
        this.loaiGd = loaiGd;
    }

    public String getNgayGd() {
        return ngayGd;
    }

    public void setNgayGd(String ngayGd) {
        this.ngayGd = ngayGd;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}

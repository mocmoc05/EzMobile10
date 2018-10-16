package com.trang.ez_mobile.view.place_orders.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by TraPTH on 5/27/2018.
 */
public class UngTien {
    @SerializedName("maHopDong")
    @Expose
    private Integer maHopDong;
    @SerializedName("maTK")
    @Expose
    private String maTK;
    @SerializedName("ngayUng")
    @Expose
    private String ngayUng;
    @SerializedName("soTien")
    @Expose
    private String soTien;
    @SerializedName("tinhTrang")
    @Expose
    private String tinhTrang;

    public Integer getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(Integer maHopDong) {
        this.maHopDong = maHopDong;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getNgayUng() {
        return ngayUng;
    }

    public void setNgayUng(String ngayUng) {
        this.ngayUng = ngayUng;
    }

    public String getSoTien() {
        return soTien;
    }

    public void setSoTien(String soTien) {
        this.soTien = soTien;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}

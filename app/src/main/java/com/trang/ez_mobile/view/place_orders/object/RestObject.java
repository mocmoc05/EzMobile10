package com.trang.ez_mobile.view.place_orders.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by TraPTH on 5/23/2018.
 */
public class RestObject {
    @SerializedName("checkConnect")
    @Expose
    private Boolean checkConnect;

    @SerializedName("chungkhoan")
    @Expose
    private ChungKhoan chungkhoan;

    @SerializedName("chungkhoans")
    @Expose
    private List<ChungKhoan> chungkhoans = null;

    @SerializedName("listGdByMaTk")
    @Expose
    private List<GiaoDich> listGdByMaTk = null;

    @SerializedName("baoCaoTaiSanCk")
    @Expose
    private BaoCaoTaiSanCk baoCaoTaiSanCk;

    @SerializedName("listTaiSanCk")
    @Expose
    private List<BaoCaoTaiSanCk> listTaiSanCk = null;

    @SerializedName("listUngTien")
    @Expose
    private List<UngTien> listUngTien = null;

    public List<UngTien> getListUngTien() {
        return listUngTien;
    }

    public void setListUngTien(List<UngTien> listUngTien) {
        this.listUngTien = listUngTien;
    }

    public List<BaoCaoTaiSanCk> getListTaiSanCk() {
        return listTaiSanCk;
    }

    public void setListTaiSanCk(List<BaoCaoTaiSanCk> listTaiSanCk) {
        this.listTaiSanCk = listTaiSanCk;
    }

    public BaoCaoTaiSanCk getBaoCaoTaiSanCk() {
        return baoCaoTaiSanCk;
    }

    public void setBaoCaoTaiSanCk(BaoCaoTaiSanCk baoCaoTaiSanCk) {
        this.baoCaoTaiSanCk = baoCaoTaiSanCk;
    }

    public List<ChungKhoan> getChungkhoans() {
        return chungkhoans;
    }

    public void setChungkhoans(List<ChungKhoan> chungkhoans) {
        this.chungkhoans = chungkhoans;
    }

    public List<GiaoDich> getListGdByMaTk() {
        return listGdByMaTk;
    }

    public void setListGdByMaTk(List<GiaoDich> listGdByMaTk) {
        this.listGdByMaTk = listGdByMaTk;
    }

    public Boolean getCheckConnect() {
        return checkConnect;
    }

    public void setCheckConnect(Boolean checkConnect) {
        this.checkConnect = checkConnect;
    }

    public ChungKhoan getChungkhoan() {
        return chungkhoan;
    }

    public void setChungkhoan(ChungKhoan chungkhoan) {
        this.chungkhoan = chungkhoan;
    }
}

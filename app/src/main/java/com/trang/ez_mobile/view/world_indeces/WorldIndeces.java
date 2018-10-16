package com.trang.ez_mobile.view.world_indeces;

/**
 * Created by TraPTH on 3/16/2018.
 */

public class WorldIndeces {
    private String chiSo, gia, thayDoi, thayDoiPhanTram;

    public WorldIndeces(String chiSo, String gia, String thayDoi, String thayDoiPhanTram) {
        this.chiSo = chiSo;
        this.gia = gia;
        this.thayDoi = thayDoi;
        this.thayDoiPhanTram = thayDoiPhanTram;
    }

    public String getChiSo() {
        return chiSo;
    }

    public void setChiSo(String chiSo) {
        this.chiSo = chiSo;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getThayDoi() {
        return thayDoi;
    }

    public void setThayDoi(String thayDoi) {
        this.thayDoi = thayDoi;
    }

    public String getThayDoiPhanTram() {
        return thayDoiPhanTram;
    }

    public void setThayDoiPhanTram(String thayDoiPhanTram) {
        this.thayDoiPhanTram = thayDoiPhanTram;
    }
}

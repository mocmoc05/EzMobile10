package com.trang.ez_mobile.view.user.login;

/**
 * Created by TraPTH on 5/19/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TaiKhoan implements Serializable {

    @SerializedName("maTK")
    @Expose
    private String maTK;
    @SerializedName("tenTk")
    @Expose
    private String tenTk;
    @SerializedName("matKhau")
    @Expose
    private String matKhau;
    @SerializedName("diaChi")
    @Expose
    private String diaChi;
    @SerializedName("gioiTinh")
    @Expose
    private String gioiTinh;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("ngayTao")
    @Expose
    private String ngayTao;
    @SerializedName("sdt")
    @Expose
    private String sdt;
    @SerializedName("nhomTaiKhoan")
    @Expose
    private String nhomTaiKhoan;
    @SerializedName("soDuTien")
    @Expose
    private String soDuTien;
    @SerializedName("soTienUng")
    @Expose
    private String soTienUng;
    @SerializedName("tienDangVe")
    @Expose
    private String tienDangVe;

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getTenTk() {
        return tenTk;
    }

    public void setTenTk(String tenTk) {
        this.tenTk = tenTk;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNhomTaiKhoan() {
        return nhomTaiKhoan;
    }

    public void setNhomTaiKhoan(String nhomTaiKhoan) {
        this.nhomTaiKhoan = nhomTaiKhoan;
    }

    public String getSoDuTien() {
        return soDuTien;
    }

    public void setSoDuTien(String soDuTien) {
        this.soDuTien = soDuTien;
    }

    public String getSoTienUng() {
        return soTienUng;
    }

    public void setSoTienUng(String soTienUng) {
        this.soTienUng = soTienUng;
    }

    public String getTienDangVe() {
        return tienDangVe;
    }

    public void setTienDangVe(String tienDangVe) {
        this.tienDangVe = tienDangVe;
    }

}

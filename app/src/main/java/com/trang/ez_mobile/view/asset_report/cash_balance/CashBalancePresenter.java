package com.trang.ez_mobile.view.asset_report.cash_balance;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.trang.ez_mobile.App;
import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.view.user.login.TaiKhoan;

/**
 * Created by TraPTH on 5/18/2018.
 */
public class CashBalancePresenter {
    private TaiKhoan taiKhoan;
    private ICashBalance view;
    //Luu trang thai
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String keyShered = "account";

    public CashBalancePresenter(ICashBalance view) {
        this.view = view;
        sharedPreferences = App.getInstance().getSharedPreferences(Define.SHARED_PREFERENCES_ACCOUNT, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void getData() {
        view.getDataDone(getTaiKhoan());
    }

    public TaiKhoan getTaiKhoan() {
        Gson gson = new Gson();
        String json = sharedPreferences.getString(keyShered, "");
        TaiKhoan obj = gson.fromJson(json, TaiKhoan.class);
        return obj;
    }
}

package com.trang.ez_mobile.view.advance_report.ungtien;

import android.util.Log;

import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.util.api_json.ApiClient;
import com.trang.ez_mobile.view.place_orders.object.RestObject;
import com.trang.ez_mobile.view.place_orders.object.UngTien;
import com.trang.ez_mobile.view.user.login.TaiKhoan;
import com.trang.ez_mobile.view.user.object.ListTaiKhoanObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TraPTH on 5/27/2018.
 */
public class UngTienPresenter {
    private IUngTien view;
    private TaiKhoan taiKhoan;
    private UngTien ungTien;

    public UngTienPresenter(IUngTien view, TaiKhoan taiKhoan) {
        this.view = view;
        this.taiKhoan = taiKhoan;
    }

    public void checkUngTien(String tienUng) {
        if (Double.parseDouble(taiKhoan.getTienDangVe()) >= (Double.parseDouble(tienUng) + Double.parseDouble(taiKhoan.getSoTienUng()))) {
            Double tongTienUng = Double.parseDouble(tienUng) + Double.parseDouble(taiKhoan.getSoTienUng());
            Double tongSoDuTien= Double.parseDouble(tienUng) + Double.parseDouble(taiKhoan.getSoDuTien());

            taiKhoan.setSoTienUng(String.valueOf(tongTienUng));
            taiKhoan.setSoDuTien(String.valueOf(tongSoDuTien));

            updateUser(taiKhoan);

            ungTien= new UngTien();
            ungTien.setMaTK(taiKhoan.getMaTK());
            ungTien.setSoTien(tienUng);
//            ungTien.setTinhTrang("Chưa thanh toán");
            insertUngTien(ungTien);
            view.UngTienDone();

        } else {
            view.UngTienFail();
        }
    }

    private void updateUser(TaiKhoan taiKhoan) {
        try {
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(Define.API_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.build();

            ApiClient apiClient = retrofit.create(ApiClient.class);
            Call<ListTaiKhoanObject> call = apiClient.updateAccount(taiKhoan);

            call.enqueue(new Callback<ListTaiKhoanObject>() {
                @Override
                public void onResponse(Call<ListTaiKhoanObject> call, Response<ListTaiKhoanObject> bodyResponse) {
                    if (bodyResponse.body().getCheckConnect()) {
                        Log.d("Insert", "Done");
                    } else {
                        Log.d("Insert", "Fail");
                    }
                }

                @Override
                public void onFailure(Call<ListTaiKhoanObject> call, Throwable t) {
                    Log.d("Insert", "Fail");
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            view.connectServerFail();
        }
    }

    private void insertUngTien(UngTien ungTien){
        try {
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(Define.API_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.build();

            ApiClient apiClient = retrofit.create(ApiClient.class);
            Call<RestObject> call = apiClient.insertUngTien(ungTien, "insert_ungtien");

            call.enqueue(new Callback<RestObject>() {
                @Override
                public void onResponse(Call<RestObject> call, Response<RestObject> bodyResponse) {
                    if (bodyResponse.body().getCheckConnect()) {
                        Log.d("Insert", "Done");
                    } else {
                        Log.d("Insert", "Fail");
                    }
                }

                @Override
                public void onFailure(Call<RestObject> call, Throwable t) {
                    Log.d("Insert", "Fail");
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            view.connectServerFail();
        }
    }
}

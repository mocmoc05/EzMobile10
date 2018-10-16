package com.trang.ez_mobile.view.user.sign_up;

import android.util.Log;

import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.util.Utils;
import com.trang.ez_mobile.util.api_json.ApiClient;
import com.trang.ez_mobile.view.user.login.TaiKhoan;
import com.trang.ez_mobile.view.user.object.ListTaiKhoanObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TraPTH on 5/14/2018.
 */
public class SignUpPresenter {
    private ISignUp view;
    private TaiKhoan object;

    public SignUpPresenter(ISignUp view) {
        this.view = view;
        object= new TaiKhoan();
    }

    void insertAccount(String strAccount, String strPassword) {
        if (Utils.isNetworkAvailable()) {
            object.setMaTK(strAccount);
            object.setMatKhau(strPassword);

            try {
                Retrofit.Builder builder = new Retrofit.Builder()
                        .baseUrl(Define.API_URL)
                        .addConverterFactory(GsonConverterFactory.create());

                Retrofit retrofit = builder.build();

                ApiClient apiClient = retrofit.create(ApiClient.class);
                Call<ListTaiKhoanObject> call = apiClient.insertAccount(object);

                call.enqueue(new Callback<ListTaiKhoanObject>() {
                    @Override
                    public void onResponse(Call<ListTaiKhoanObject> call, Response<ListTaiKhoanObject> bodyResponse) {
                        if (bodyResponse.body().getCheckConnect()) {
                            view.insertDone();
                        } else {
                            view.insertFail();
                        }
                    }

                    @Override
                    public void onFailure(Call<ListTaiKhoanObject> call, Throwable t) {
                        view.insertFail();
                    }
                });

            }catch (Exception e) {
                e.printStackTrace();
                view.connectServerFail();
            }

        } else {
            view.connectNetworkFail();
        }
    }
}

package com.trang.ez_mobile.view.news.detail;

import android.content.Context;

import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by TraPTH on 2/22/2018.
 */

public class NewDetailPresenter implements NewsDetailInterface.Presenter {
    private NewsDetailInterface.View view;
    private Context context;
    private String baseUrl;

    public NewDetailPresenter(NewsDetailInterface.View view, Context context) {
        this.view = view;
        this.context = context;
        this.baseUrl = "http://gateway.fpts.com.vn/G5G/";
    }

    @Override
    public void callData(final String id, String folder) {
        if (Utils.isNetworkAvailable() == true) {
            Utils apiClient = new Utils();
            Retrofit retrofit = apiClient.getRetrofit(baseUrl);

            Api myService = retrofit.create(Api.class);
            Call<String> stringCall = myService.getStringDetailTinTuc("news_detail", id);
            stringCall.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        String responseString = response.body();
                        if (responseString.equals("")) {
                            view.dataFail();
                        } else {
                            splitChiTietTin(responseString);
                        }
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    view.connectServerFail();
                }
            });

            view.onLoad();
        } else {
            view.connectFail();
        }
    }

    private void splitChiTietTin(String body) {
        String item[] = body.split("</b></font></P>");
        String title = (item[0] + "</b></font></P>");
        String lead = (item[1] + "</b></font></P>");
        if (item.length > 2) {
            String body2 = (item[2].toString());
            view.dataDetailDone(title, lead, body2);
        } else {
            view.dataDetailDone(title, lead, "");

        }
    }

//    private boolean isNetworkConnected() {
//        ConnectivityManager cm = (ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
//        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
//    }

}

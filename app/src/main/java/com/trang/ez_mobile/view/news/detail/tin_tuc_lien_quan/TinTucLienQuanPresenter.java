package com.trang.ez_mobile.view.news.detail.tin_tuc_lien_quan;

import android.content.Context;

import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by TraPTH on 2/22/2018.
 */

public class TinTucLienQuanPresenter implements TinTucLienQuanInterface.Presenter {
    private TinTucLienQuanInterface.View view;
    private Context context;
    private String baseUrl;

    private List<TinTucLienQuan> tinTucList;

    public TinTucLienQuanPresenter(TinTucLienQuanInterface.View view, Context context, List<TinTucLienQuan> tinTucList) {
        this.view = view;
        this.context = context;
        this.tinTucList = tinTucList;
        this.baseUrl = "http://gateway.fpts.com.vn/G5G/";
    }

    @Override
    public void getData(String folder, String id) {
        if (Utils.isNetworkAvailable() == true) {
            view.onLoad();

            Utils apiClient = new Utils();
            Retrofit retrofit = apiClient.getRetrofit(baseUrl);

            Api myService = retrofit.create(Api.class);
            Call<String> stringCall2 = myService.getStringTinTuc("news2", "1", folder, "abt", "1", "20");
            stringCall2.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        String responseString = response.body();
                        if (responseString.equals("")) {
                            view.dataFail();
                        } else {
                            splitTinTuc(responseString, id);
                            view.dataTinLienQuanDone(tinTucList);
                        }
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    view.connectServerFail();
                }
            });


        } else {
            view.connectFail();
        }
    }

    private void splitTinTuc(String responseString, String id) {
        String item[] = responseString.split("@");
        String img = "";
        String date = "";
        for (int i = 0; i < item.length - 2; i++) {
            String obj[] = item[i].split("#");
            if (obj[0].equals(id)) {
                continue;
            } else {
                if (obj.length > 5) {
                    img = "http://www.fpts.com.vn" + obj[5];
                }

                date = "[" + obj[2].split("\\s+")[0] + "]";

                tinTucList.add(new TinTucLienQuan(img, obj[1], date, obj[0]));
            }
        }
    }

//    private boolean isNetworkConnected() {
//        ConnectivityManager cm = (ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
//        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
//    }

}

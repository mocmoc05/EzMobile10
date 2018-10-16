package com.trang.ez_mobile.view.world_indeces;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.util.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by TraPTH on 3/16/2018.
 */

public class WorldIndecesPresenter implements WorldIndecesInterface.Presenter {
    private Context context;
    private WorldIndecesInterface.View view;
    private List<WorldIndeces> worldIndecesList;
    private String baseUrl;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String keyShered = "WORLD_INDECES";

    public WorldIndecesPresenter(Context context, WorldIndecesInterface.View view, List<WorldIndeces> worldIndecesList) {
        this.context = context;
        this.view = view;
        this.worldIndecesList = worldIndecesList;
        baseUrl = "http://gateway.fpts.com.vn/G5G/";
    }

    @Override
    public void callData() {
        if (isNetworkConnected() == true) {
            Utils apiClient = new Utils();
            Retrofit retrofit = apiClient.getRetrofit(baseUrl);

            Api myService = retrofit.create(Api.class);
            Call<String> stringCall = myService.getStringWorldIndeces("world_indices");
            stringCall.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        String responseString = response.body();
                        if (responseString.equals("")) {
                            view.dataFail();
                        } else {
                            splitTinTuc(responseString);
                            view.dataDone(worldIndecesList);
                            luuListShared(worldIndecesList);
                        }
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    view.connectServerFail();
                    //Lay du lieu tu Shared
                    getListShared();
                    view.dataDone(worldIndecesList);
                }
            });

            view.onLoad();

        } else {
            view.connectFail();
            //Lay du lieu tu Shared
            getListShared();
            view.dataDone(worldIndecesList);
        }
    }

    private void splitTinTuc(String body) {
        worldIndecesList.clear();
        String ob[] = body.split("@");

        for (int i = 0; i < ob.length; i++) {
            String item[] = ob[i].split("#");

            worldIndecesList.add(new WorldIndeces(item[0], item[2], item[3], item[4]));
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    private void getListShared() {
        sharedPreferences = App.getInstance().getSharedPreferences(Define.SHARED_PREFERENCES_SECURITIES_PUBLIC, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        worldIndecesList = getList(keyShered);
    }

    private void luuListShared(List<WorldIndeces> list) {
        sharedPreferences = App.getInstance().getSharedPreferences(Define.SHARED_PREFERENCES_SECURITIES_PUBLIC, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        setList(keyShered, list);
    }

    public List<WorldIndeces> getList(String key) {
        Gson gson = new Gson();
        List<WorldIndeces> list = new ArrayList<>();

        String json = get(key);
        Type type = new TypeToken<List<WorldIndeces>>() {
        }.getType();
        list = gson.fromJson(json, type);

        return list;
    }

    public String get(String key) {
        return sharedPreferences.getString(key, "");
    }

    public <T> void setList(String key, List<T> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);

        set(key, json);
    }

    public void set(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }
}

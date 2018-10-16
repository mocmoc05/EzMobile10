package com.trang.ez_mobile.view.place_orders.sell;

import android.util.Log;

import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.util.Utils;
import com.trang.ez_mobile.util.api_json.ApiClient;
import com.trang.ez_mobile.util.api_json.ApiClientImp;
import com.trang.ez_mobile.view.place_orders.object.BaoCaoTaiSanCk;
import com.trang.ez_mobile.view.place_orders.object.ChungKhoan;
import com.trang.ez_mobile.view.place_orders.object.RestObject;
import com.trang.ez_mobile.view.place_orders.object.GiaoDich;
import com.trang.ez_mobile.view.user.login.TaiKhoan;
import com.trang.ez_mobile.view.user.object.ListTaiKhoanObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by TraPTH on 5/15/2018.
 */
public class SellPresenter {
    private ISell view;
    private TaiKhoan taiKhoan;
    private ChungKhoan ck;
    private RestObject restObject;
    private String gia;
    private GiaoDich giaoDich;

    public SellPresenter(ISell view) {
        this.view = view;
    }

    public void seachStock(String ma_ck) {
        CompositeSubscription subscription = new CompositeSubscription();
        if (Utils.isNetworkAvailable()) {
            subscription.add(ApiClientImp.getInstance().getChungKhoanById("get_chungkhoan", ma_ck)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<RestObject>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                            view.connectServerFail();
                        }

                        @Override
                        public void onNext(RestObject chungKhoan) {
                            if (chungKhoan.getChungkhoan() == null) {
                                view.getCKFail();
                            } else {
                                ck = chungKhoan.getChungkhoan();
                                if (ck.getMaCk() == null) {
                                    view.findStockFail();
                                } else {
                                    view.getCKDone(ck);
                                }
                            }

                        }
                    }));

            view.onLoad();

            getTTCKByMaCK(ma_ck);

        } else {
            view.connectNetworkFail();
        }
    }

    public void getTTCKByMaCK(String maCk) {
        Utils apiClient = new Utils();
        Retrofit retrofit = apiClient.getRetrofit(Api.API_GRATEWAY);

        Api myService = retrofit.create(Api.class);
        Call<String> stringCall = myService.getStringTTCK("quotes2", maCk);
        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String responseString = response.body();
                    if (responseString.equals("")) {

                    } else {
                        splitTTCK(responseString);
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                view.connectServerFail();
            }
        });

        view.onLoad();
    }

    public void checkGiaoDich(TaiKhoan tk, String maCk, String khoiLuong, String loaiLenh, String gia, String banMin, String muaMax) {

//        checkTime3= getTimeNow().compareTo(covertStringToDate("11:30:00"));
//        checkTime4= getTimeNow().compareTo(covertStringToDate("13:00:00"));
//        checkTime5= getTimeNow().compareTo(covertStringToDate("14:30:00"));
//        checkTime6= getTimeNow().compareTo(covertStringToDate("14:45:00"));
//        checkTime7= getTimeNow().compareTo(covertStringToDate("15:00:00"));

        switch (loaiLenh) {
            case "LO":
                if (checkTien(tk.getSoDuTien(), khoiLuong, gia)) {
                    insertGiaoDich(tk, maCk, khoiLuong, loaiLenh, gia);
                } else {
                    view.failTransByMoney();
                }

                break;

            case "ATO":
                Date now = getTimeNow();
                int timeBeginATO = getTimeNow().compareTo(covertStringToDate("9:00:00"));
                int timeEndATO = getTimeNow().compareTo(covertStringToDate("9:15:00"));
                if (timeBeginATO >= 0 && timeEndATO <= 0) {
                    this.gia = ck.getGiaTC();

                    if (checkTien(tk.getSoDuTien(), khoiLuong, ck.getGiaTC())) {
                        insertGiaoDich(tk, maCk, khoiLuong, loaiLenh, ck.getGiaTC());

                    } else {
                        view.failTransByMoney();
                    }
                } else {
                    view.transactionFail();
                }
                break;

            case "MP":
//                int timeBeginMP = getTimeNow().compareTo(covertStringToDate("9:15:00"));
//                int timeEndMP = getTimeNow().compareTo(covertStringToDate("11:30:00"));
//                int timeBeginMP2 = getTimeNow().compareTo(covertStringToDate("13:00:00"));
//                int timeEndMP2 = getTimeNow().compareTo(covertStringToDate("14:30:00"));
//                if((timeBeginMP >= 0 && timeEndMP <=0) || (timeBeginMP2 >= 0 && timeEndMP2 <=0)){
//                    this.gia = banMin;
//
//                    if(checkTien(tk.getSoDuTien(), khoiLuong, this.gia)) {
//                        insertGiaoDich(tk, maCk, khoiLuong, loaiLenh, this.gia);
//                    } else {
//                        view.transactionFail();
//                    }
//                } else{
//                    view.transactionFail();
//                }
//
//                break;

            case "ATC":
//                int timeBeginATC = getTimeNow().compareTo(covertStringToDate("14:30:00"));
//                int timeEndATC = getTimeNow().compareTo(covertStringToDate("14:45:00"));
//                if(timeBeginATC >= 0 && timeEndATC <=0){
//                    this.gia = Double.parseDouble(gia);
//                } else{
//                    view.transactionFail();
//                }
//                break;

            case "MTL":
//                this.gia = Double.parseDouble(banMin);
                break;

//            case "MAK":
//                this.gia = Double.parseDouble(banMin);
//                break;
//
//            case "MOK":
//                this.gia = Double.parseDouble(banMin);
//                break;
//
//            default:
//                break;
        }


    }

    public void insertGiaoDich(TaiKhoan tk, String maCk, String khoiLuong, String loaiLenh, String gia) {
        taiKhoan = tk;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        giaoDich = new GiaoDich();
        giaoDich.setMaTK(tk.getMaTK());
        giaoDich.setMaCk(maCk);
        giaoDich.setGia(gia);
        giaoDich.setKhoiLuong(khoiLuong);
        giaoDich.setLoaiGd("Mua");
        giaoDich.setMaLenh(loaiLenh);
        giaoDich.setTinhTrang("Đang chờ");
        giaoDich.setNgayGd(dateFormat.format(date));

        if (Utils.isNetworkAvailable()) {
            try {
                Retrofit.Builder builder = new Retrofit.Builder()
                        .baseUrl(Define.API_URL)
                        .addConverterFactory(GsonConverterFactory.create());

                Retrofit retrofit = builder.build();

                ApiClient apiClient = retrofit.create(ApiClient.class);
                Call<RestObject> call = apiClient.insertGiaoDich(giaoDich, "insert_giaodich");

                call.enqueue(new Callback<RestObject>() {

                    @Override
                    public void onResponse(Call<RestObject> call, Response<RestObject> response) {
                        if (response.body().getCheckConnect()) {
                            view.transactionDone();
                            taiKhoan.setSoDuTien(String.valueOf(Double.parseDouble(taiKhoan.getSoDuTien()) - (Double.parseDouble(gia) * Integer.parseInt(khoiLuong))));
                            updateAccount(taiKhoan);

                            //update bang bao cao tai san
                            getAndUpdateTSCK(tk.getMaTK(), maCk, khoiLuong);
                        } else {
                            view.transactionFail();
                        }
                    }

                    @Override
                    public void onFailure(Call<RestObject> call, Throwable t) {
                        view.transactionFail();
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
                view.connectServerFail();
            }

        } else {
            view.connectNetworkFail();
        }
    }

    private void updateAccount(TaiKhoan tk) {
        try {
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(Define.API_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.build();

            ApiClient apiClient = retrofit.create(ApiClient.class);
            Call<ListTaiKhoanObject> call = apiClient.updateAccount(tk);

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

    private void splitTTCK(String body) {
        String s[] = body.split("\\|");

        try {
            if (s.length > 12) {
                String mua = s[6];
                String klMua = s[7];
                String ban = s[11];
                String klBan = s[12];

                view.getTTCKDone(ban, klBan, mua, klMua);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Date covertStringToDate(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private String coverDateToString(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String date = sdf.format(d);
        return date;
    }

    private Date getTimeNow() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return covertStringToDate(dateFormat.format(date));
    }

    private boolean checkTien(String soDuTien, String khoiLuong, String giaCK) {
        if (Double.parseDouble(soDuTien) >= (Double.parseDouble(khoiLuong) * Double.parseDouble(giaCK))) {
            return true;
        } else {
            return false;
        }
    }

    private void updateTaiSanCk(BaoCaoTaiSanCk taiSanCk) {
        try {
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(Define.API_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.build();

            ApiClient apiClient = retrofit.create(ApiClient.class);
            Call<RestObject> call = apiClient.updateTaiSanCK(taiSanCk, "update_baocao_ck");

            call.enqueue(new Callback<RestObject>() {
                @Override
                public void onResponse(Call<RestObject> call, Response<RestObject> bodyResponse) {
                    if (bodyResponse.body().getCheckConnect()) {
                        Log.d("Update", "Done");
                    } else {
                        Log.d("Update", "Fail");
                    }
                }

                @Override
                public void onFailure(Call<RestObject> call, Throwable t) {
                    Log.d("Update", "Fail");
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            view.connectServerFail();
        }
    }

    private void insertTaiSanCk(BaoCaoTaiSanCk taiSanCk) {
        try {
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(Define.API_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.build();

            ApiClient apiClient = retrofit.create(ApiClient.class);
            Call<RestObject> call = apiClient.insertTaiSanCK(taiSanCk, "insert_baocao_ck");

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

    private void getAndUpdateTSCK(String maTk, String maCk, String khoiLuong) {
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.add(ApiClientImp.getInstance().getTaiSanCK("get_baocao_ck", maTk, maCk)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RestObject>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(RestObject restObject) {
                        if (restObject.getBaoCaoTaiSanCk().getMaTk() == null) {
                            BaoCaoTaiSanCk taiSanCk = new BaoCaoTaiSanCk();
                            taiSanCk.setMaTk(maTk);
                            taiSanCk.setMaCk(maCk);
                            taiSanCk.setKhoiLuongCho(khoiLuong);
                            taiSanCk.setKhoiLuong("0");

                            insertTaiSanCk(taiSanCk);

                        } else {
                            BaoCaoTaiSanCk taiSanCk = restObject.getBaoCaoTaiSanCk();
                            taiSanCk.setKhoiLuongCho(String.valueOf(Integer.parseInt(taiSanCk.getKhoiLuongCho()) + Integer.parseInt(khoiLuong)));
                            updateTaiSanCk(taiSanCk);
                        }
                    }
                }));
    }
}

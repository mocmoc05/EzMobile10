package com.trang.ez_mobile.util.api_json;

import com.trang.ez_mobile.view.place_orders.object.BaoCaoTaiSanCk;
import com.trang.ez_mobile.view.place_orders.object.RestObject;
import com.trang.ez_mobile.view.place_orders.object.GiaoDich;
import com.trang.ez_mobile.view.place_orders.object.UngTien;
import com.trang.ez_mobile.view.user.login.TaiKhoan;
import com.trang.ez_mobile.view.user.object.ListTaiKhoanObject;
import com.trang.ez_mobile.view.user.object.TaiKhoanObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by TraPTH on 5/19/2018.
 */
public interface ApiClient {

    @POST("TaiKhoanController?type=get_list")
    Observable<ListTaiKhoanObject> getListTaiKhoan();

    @POST("TaiKhoanController")
    Observable<TaiKhoanObject> getTaiKhoanById(@Query("type") String type, @Query("ma_tk") String ma_tk);

    @POST("TaiKhoanController?type=insert_taikhoan")
    Call<ListTaiKhoanObject> insertAccount(@Body TaiKhoan taiKhoan);

    @POST("TaiKhoanController?type=update_taikhoan")
    Call<ListTaiKhoanObject> updateAccount(@Body TaiKhoan taiKhoan);

    @POST("ChungKhoanController")
    Observable<RestObject> getChungKhoanById(@Query("type") String type, @Query("ma_ck") String ma_ck);

    @POST("GiaoDichController")
    Observable<RestObject> getListGiaoDichByTk(@Query("type") String type, @Query("ma_tk") String ma_tk);

    @POST("GiaoDichController")
    Call<RestObject> insertGiaoDich(@Body GiaoDich giaoDich, @Query("type") String type);

    @POST("BaoCaoTaiSanCKController")
    Observable<RestObject> getTaiSanListCk(@Query("type") String type, @Query("ma_tk") String ma_tk);

    @POST("BaoCaoTaiSanCKController")
    Observable<RestObject> getTaiSanCK(@Query("type") String type, @Query("ma_tk") String ma_tk, @Query("ma_ck") String ma_ck);

    @POST("BaoCaoTaiSanCKController")
    Call<RestObject> insertTaiSanCK(@Body BaoCaoTaiSanCk taiSanCk, @Query("type") String type);

    @POST("BaoCaoTaiSanCKController")
    Call<RestObject> updateTaiSanCK(@Body BaoCaoTaiSanCk taiSanCk, @Query("type") String type);

    @POST("UngTienController")
    Observable<RestObject> getListUngTienByTk(@Query("type") String type, @Query("ma_tk") String ma_tk);

    @POST("UngTienController")
    Call<RestObject> insertUngTien(@Body UngTien ungTien, @Query("type") String type);
}

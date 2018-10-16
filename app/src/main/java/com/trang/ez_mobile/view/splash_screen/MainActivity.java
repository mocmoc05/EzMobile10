package com.trang.ez_mobile.view.splash_screen;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.ActivityMainBinding;
import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.util.Utils;
import com.trang.ez_mobile.util.api_json.ApiClientImp;
import com.trang.ez_mobile.view.advance_report.AdvanceReportFragment;
import com.trang.ez_mobile.view.asset_report.AssetReportFragment;
import com.trang.ez_mobile.view.chart.ChartFragment;
import com.trang.ez_mobile.view.events.EventsFragment;
import com.trang.ez_mobile.view.home.HomeFrag2;
import com.trang.ez_mobile.view.marketOverview.MarketOverviewFragment;
import com.trang.ez_mobile.view.place_orders.PlaceOrdersFragment;
import com.trang.ez_mobile.view.news.home.HomeNewsFragment;
import com.trang.ez_mobile.view.user.login.LoginFragment;
import com.trang.ez_mobile.view.user.login.TaiKhoan;
import com.trang.ez_mobile.view.user.navi.CustomNavigation;
import com.trang.ez_mobile.view.user.object.TaiKhoanObject;
import com.trang.ez_mobile.view.user.sign_up.SignUpFragment;
import com.trang.ez_mobile.view.watchlist.WatchlistFrag;
import com.trang.ez_mobile.view.world_indeces.WorldIndecesFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

import static com.trang.ez_mobile.App.getInstance;
import static com.trang.ez_mobile.util.Define.LANGUAGE_EN;
import static com.trang.ez_mobile.util.Define.LANGUAGE_VI;
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_LANGUAGE;
import static com.trang.ez_mobile.util.Utils.checkInTime;
import static com.trang.ez_mobile.util.Utils.setLanguage;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, IMainListener {
    ActivityMainBinding mainBinding;
    private int page;

    //Luu trang thai
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String keyShered = "account";
    private String keyCheck = "check_account";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        sharedPreferences = App.getInstance().getSharedPreferences(Define.SHARED_PREFERENCES_ACCOUNT, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if(getTaiKhoan()!= null) {
            getAccount(getTaiKhoan().getMaTK());
        }

        setSupportActionBar(mainBinding.appBarMain.toolbar);
        mainBinding.appBarMain.toolbar.setNavigationIcon(R.drawable.ic_dehaze_black_24dp);
        mainBinding.appBarMain.toolbar.setNavigationOnClickListener(v -> {
            mainBinding.drawerLayout.openDrawer(Gravity.START);
        });
        initilize();

        checkInTime();
    }

    private void initilize() {
        SharedPreferences preferences = getInstance()
                .getSharedPreferences(SHARED_PREFRENCES_LANGUAGE, Context.MODE_PRIVATE);
        int language = preferences.getInt(SHARED_PREFRENCES_LANGUAGE, LANGUAGE_EN);
        setLanguage(language);
        new CustomNavigation(this, this, mainBinding.navUserLayout).onStart();

        page = Define.TYPE_MENU_HOME;
        setFragment(new HomeFrag2());
    }

    @Override
    public void onBackPressed() {
        if (mainBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mainBinding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.lang_vi:
                setLanguage(LANGUAGE_VI);
                break;
            case R.id.lang_en:
                setLanguage(LANGUAGE_EN);
                break;
            default:
                setLanguage(LANGUAGE_EN);
                break;
        }
        initilize();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        mainBinding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onReplaceFragment(int typeFragmet) {
        mainBinding.drawerLayout.closeDrawer(GravityCompat.START);
        TaiKhoan taiKhoan = getTaiKhoan();
        switch (typeFragmet) {

            case Define.TYPE_MENU_HOME:
                if (page == Define.TYPE_MENU_HOME) break;
                else {
                    setFragment(HomeFrag2.newInstance());
                    page = Define.TYPE_MENU_HOME;
                    mainBinding.appBarMain.contentMain.tvStatusMarket.setVisibility(View.VISIBLE);
                    break;
                }
            case Define.TYPE_MENU_MARKET_OVERRVIEW:
                if (page == Define.TYPE_MENU_MARKET_OVERRVIEW)
                    break;
                else {
                    setFragment(MarketOverviewFragment.newInstance());
                    page = Define.TYPE_MENU_MARKET_OVERRVIEW;
                    break;
                }
            case Define.TYPE_MENU_WATCHLIST:
                if (page == Define.TYPE_MENU_WATCHLIST)
                    break;
                else {
                    setFragment(WatchlistFrag.newInstance());
                    page = Define.TYPE_MENU_WATCHLIST;
                    break;
                }

            case Define.TYPE_MENU_NEWS:
                if (page == Define.TYPE_MENU_NEWS) break;
                else {
                    HomeNewsFragment homeNewsFragment = new HomeNewsFragment();
                    setFragment(homeNewsFragment);
                    page = Define.TYPE_MENU_NEWS;
                    break;
                }

            case Define.TYPE_MENU_EVENTS:
                if (page == Define.TYPE_MENU_EVENTS) break;
                else {
                    setFragment(new EventsFragment());
                    page = Define.TYPE_MENU_EVENTS;
                    break;
                }

            case Define.TYPE_MENU_CHART:
                if (page == Define.TYPE_MENU_CHART)
                    break;
                else {
                    setFragment(new ChartFragment());
                    page = Define.TYPE_MENU_CHART;
                    break;
                }

            case Define.TYPE_MENU_WORLD_INDEX:
                if (page == Define.TYPE_MENU_WORLD_INDEX) break;
                else {
                    WorldIndecesFragment worldIndecesFragment = new WorldIndecesFragment();
                    setFragment(worldIndecesFragment);
                    page = Define.TYPE_MENU_WORLD_INDEX;
                    break;
                }

//                MEMBER
            case Define.MENU_LOGIN:
                if (page == Define.MENU_LOGIN) break;
                else {
                    setFragment(new LoginFragment());
                    mainBinding.appBarMain.contentMain.tvStatusMarket.setVisibility(View.GONE);
                    break;
                }

            case Define.MENU_MO_TAI_KHOAN:
                if (page == Define.MENU_MO_TAI_KHOAN) break;
                else {
                    setFragment(new SignUpFragment());
                    mainBinding.appBarMain.contentMain.tvStatusMarket.setVisibility(View.GONE);
                    break;
                }

            case Define.MENU_DAT_LENH:
                if (taiKhoan== null || taiKhoan.getMaTK() == null) {
                    setFragment(new LoginFragment());
                    mainBinding.appBarMain.contentMain.tvStatusMarket.setVisibility(View.GONE);
                    break;
                } else {
                    if (page == Define.MENU_DAT_LENH) break;
                    else {
                        //Chuyen thong tin tai khoan
                        setFragment(PlaceOrdersFragment.newInstance(taiKhoan));
                        page = Define.MENU_DAT_LENH;
                    }
                }
                break;

            case Define.MENU_BAO_CAO_TAI_SAN:
                if (taiKhoan== null || taiKhoan.getMaTK() == null) {
                    setFragment(new LoginFragment());
                    mainBinding.appBarMain.contentMain.tvStatusMarket.setVisibility(View.GONE);
                    break;
                } else {
                    if (page == Define.MENU_BAO_CAO_TAI_SAN) break;
                    else {
                        setFragment(AssetReportFragment.newInstance(taiKhoan));
                        page = Define.MENU_BAO_CAO_TAI_SAN;
                        break;
                    }
                }

            case Define.MENU_LICH_SU_UNG_TRUOC:
                if (taiKhoan== null || taiKhoan.getMaTK()==null) {
                    setFragment(new LoginFragment());
                    mainBinding.appBarMain.contentMain.tvStatusMarket.setVisibility(View.GONE);
                    break;
                } else {
                    if (page == Define.MENU_LICH_SU_UNG_TRUOC) break;
                    else {
                        setFragment(AdvanceReportFragment.newInstance(taiKhoan));
                        page = Define.MENU_LICH_SU_UNG_TRUOC;
                        break;
                    }
                }

            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sharedPreferences = App.getInstance().getSharedPreferences(Define.SHARED_PREFERENCES_ACCOUNT, Context.MODE_PRIVATE);
        boolean checkAccount = sharedPreferences.getBoolean(keyCheck, false);
        if (!checkAccount) {
            saveTaiKhoan(new TaiKhoan());
        }
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(mainBinding.appBarMain.contentMain.contentview.getId(), fragment);
        ft.commit();
    }

    public TaiKhoan getTaiKhoan() {
        Gson gson = new Gson();
        String json = sharedPreferences.getString(keyShered, "");
        TaiKhoan obj = gson.fromJson(json, TaiKhoan.class);
        return obj;
    }

    public void saveTaiKhoan(TaiKhoan taiKhoan) {
        Gson gson = new Gson();
        String json = gson.toJson(taiKhoan);
        editor.putString(keyShered, json);
        editor.commit();
    }

    private void checkInTime() {
        Utils apiClient = new Utils();
        Retrofit retrofit = apiClient.getRetrofit(Api.API_GRATEWAY);

        Api myService = retrofit.create(Api.class);

        Call<String> stringCall = myService.getStringCheckTime("CheckDateTime");
        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String responseString = response.body();
                    if (responseString.equals("")) {
                        mainBinding.appBarMain.contentMain.tvStatusMarket.setText(R.string.market_closed);
                    } else {
                        String str = responseString.split("\\|")[1];
                        if (Double.parseDouble(str) == 1) {
                            mainBinding.appBarMain.contentMain.tvStatusMarket.setText(R.string.market_open);
                        } else {
                            mainBinding.appBarMain.contentMain.tvStatusMarket.setText(R.string.market_closed);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                mainBinding.appBarMain.contentMain.tvStatusMarket.setText(R.string.market_closed);
            }
        });
    }

    private void getAccount(String maTk) {
        CompositeSubscription subscription = new CompositeSubscription();
        if (Utils.isNetworkAvailable()) {
            subscription.add(ApiClientImp.getInstance().getTaiKhoanById("get_taikhoan", maTk)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<TaiKhoanObject>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onNext(TaiKhoanObject taiKhoan) {
                            saveTaiKhoan(taiKhoan.getTaikhoan());
                        }
                    }));
        } else {
        }
    }
}

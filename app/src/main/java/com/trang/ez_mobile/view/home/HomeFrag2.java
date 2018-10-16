package com.trang.ez_mobile.view.home;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.ActivityMainBinding;
import com.trang.ez_mobile.databinding.FragmentHomeBinding;
import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.view.home.custormHome.BigGroup;
import com.trang.ez_mobile.view.home.custormHome.BigGroupAdapter;
import com.trang.ez_mobile.view.marketOverview.MarketOverviewFragment;
import com.trang.ez_mobile.view.marketOverview.detail.DetailFrag;
import com.trang.ez_mobile.view.news.home.HomeNewsFragment;
import com.trang.ez_mobile.view.watchlist.WatchlistFrag;

import static android.view.LayoutInflater.from;
import static com.trang.ez_mobile.util.Define.HOME_TYPE_BANG_GIA_PHAI_SINH;
import static com.trang.ez_mobile.util.Define.HOME_TYPE_INDEXES;
import static com.trang.ez_mobile.util.Define.HOME_TYPE_NEWS;
import static com.trang.ez_mobile.util.Define.HOME_TYPE_WATCHLIST;
import static com.trang.ez_mobile.util.Define.HOME_TYPE_WORLD_INDEXES;

public class HomeFrag2 extends Fragment implements IHomeView, SwipeRefreshLayout.OnRefreshListener,
        IHomeView.IBiggroupCallBack {
    private FragmentHomeBinding homeBinding;
    private HomePresenter presenter;
    private IHomeView iHomeView;
    private BigGroupAdapter adapter;
    private ActivityMainBinding mainBinding;

    public static HomeFrag2 newInstance() {
        HomeFrag2 fragment = new HomeFrag2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iHomeView = this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false);
        mainBinding = ActivityMainBinding.inflate(from(getContext()));
        homeBinding.expandedListview.setChildIndicator(null);
        homeBinding.expandedListview.setGroupIndicator(null);
        //Hien ActionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().isShowing();

        return homeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.home);

        homeBinding.swipeRefreshLayout.setOnRefreshListener(this);
        getActivity().runOnUiThread(() -> new Handler().post(() -> {
            Log.w("HomeFrag2", "onViewCreated: ");
            presenter = new HomePresenter(iHomeView, getActivity());
        }));
    }

    @Override
    public void onRefresh() {
        presenter.onReload();
    }

    @Override
    public void onLoading() {
        homeBinding.progressBar.setVisibility(View.VISIBLE);
        homeBinding.swipeRefreshLayout.setRefreshing(false);
        homeBinding.expandedListview.setVisibility(View.GONE);
        if (getActivity() != null) {
            getActivity().setProgressBarIndeterminateVisibility(false);
        }
    }

    @Override
    public void onDisplay(SparseArray<BigGroup> sparseArray) {
        adapter = new BigGroupAdapter(sparseArray, getActivity(), this);
        homeBinding.expandedListview.setAdapter(adapter);
        for (int i = 0; i < adapter.getGroupCount(); i++) {
            homeBinding.expandedListview.expandGroup(i);
        }
        adapter.notifyDataSetChanged();
        homeBinding.swipeRefreshLayout.setRefreshing(false);
//        getActivity().runOnUiThread(() -> {
        homeBinding.progressBar.setVisibility(View.GONE);
        homeBinding.expandedListview.setVisibility(View.VISIBLE);
        if (getActivity() != null) {
            getActivity().setProgressBarIndeterminateVisibility(true);
        }
//        });
    }

    @Override
    public void onReplaceFragment(String marketCode, int type) {
        switch (type) {
            case HOME_TYPE_INDEXES:
                DetailFrag detailFrag = DetailFrag.newInstance(marketCode);
                setFragment(detailFrag);
                break;
            case HOME_TYPE_NEWS:
                break;
            case HOME_TYPE_WORLD_INDEXES:
                break;
            case HOME_TYPE_WATCHLIST:
                break;
            case HOME_TYPE_BANG_GIA_PHAI_SINH:
                break;
            default:
                break;
        }
    }

    @Override
    public void onReplaceFragment(int typeItem, Define.HOME_TYPE_ACTION typeAction) {
        switch (typeItem) {
            case HOME_TYPE_INDEXES:
                setFragment(new MarketOverviewFragment());
                break;
            case HOME_TYPE_NEWS:
                setFragment(new HomeNewsFragment());
                break;
            case HOME_TYPE_WORLD_INDEXES:
                break;
            case HOME_TYPE_WATCHLIST:
                switch (typeAction) {
                    case ACTION_ADD:
                        Toast.makeText(App.getInstance(), "add", Toast.LENGTH_SHORT).show();

                        break;
                    case ACTION_EDIT:
                        Toast.makeText(App.getInstance(), "edit", Toast.LENGTH_SHORT).show();
                        break;
                    case ACTION_DETAIL:
                        setFragment(WatchlistFrag.newInstance());
                        break;
                    default:
                        break;
                }
            case HOME_TYPE_BANG_GIA_PHAI_SINH:
                break;
            default:
                break;
        }
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        mainBinding = ActivityMainBinding.inflate(from(getContext()));
        transaction//.remove(this)
                .replace(mainBinding.appBarMain.contentMain.contentview.getId(), fragment);
        transaction.addToBackStack("");
        transaction.commit();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (presenter != null)
            presenter.onDestroy();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) presenter.onDestroy();
    }
}

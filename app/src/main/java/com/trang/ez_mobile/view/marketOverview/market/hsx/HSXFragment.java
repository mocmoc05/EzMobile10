package com.trang.ez_mobile.view.marketOverview.market.hsx;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.ActivityMainBinding;
import com.trang.ez_mobile.databinding.FragmentMarketOverviewHsxBinding;
import com.trang.ez_mobile.util.ErrorApp;
import com.trang.ez_mobile.view.marketOverview.detail.DetailFrag;
import com.trang.ez_mobile.view.marketOverview.market.IMarket_View;
import com.trang.ez_mobile.view.marketOverview.market.MarketAdapter;
import com.trang.ez_mobile.view.marketOverview.market.model.Market;

import java.util.ArrayList;
import java.util.List;

import static android.view.LayoutInflater.from;
import static android.widget.Toast.makeText;
import static com.trang.ez_mobile.App.getInstance;
import static com.trang.ez_mobile.databinding.FragmentMarketOverviewHsxBinding.inflate;
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_MARKETOVERVIEW;
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_MARKETOVERVIEW_ISCHANGE;
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_MARKETOVERVIEW_ISVALUE;

public class HSXFragment extends Fragment implements IMarket_View,
        IMarket_View.IOnclickListener,
        View.OnClickListener {

    FragmentMarketOverviewHsxBinding hsxBinding;

    List<Market> marketList = new ArrayList<>();
    MarketAdapter adapter;
    HSXPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        hsxBinding = inflate(inflater, container, false);
        return hsxBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hsxBinding.linearlayoutProgressbar.setVisibility(View.VISIBLE);
        hsxBinding.contentview.setVisibility(View.INVISIBLE);
        hsxBinding.linearLayoutChange.setOnClickListener(this);
        hsxBinding.linearLayoutValue.setOnClickListener(this);
        hsxBinding.textviewChange.setText(getInstance().getSharedPreferences(SHARED_PREFRENCES_MARKETOVERVIEW_ISCHANGE, Context.MODE_PRIVATE)
                .getBoolean(SHARED_PREFRENCES_MARKETOVERVIEW_ISCHANGE, true) ?
                getString(R.string.change_percent) :
                getString(R.string.change));

        hsxBinding.textviewValue.setText(getInstance().getSharedPreferences(SHARED_PREFRENCES_MARKETOVERVIEW, Context.MODE_PRIVATE)
                .getBoolean(SHARED_PREFRENCES_MARKETOVERVIEW_ISVALUE, true) ?
                getString(R.string.value_bil) :
                getString(R.string.volumn));

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter = new HSXPresenter(this);
    }

//    @Override
//    public void onLoading() {
//        if (hsxBinding == null) {
//            hsxBinding = inflate(from(getInstance()));
//        }
//        hsxBinding.linearlayoutProgressbar.setVisibility(View.VISIBLE);
//
//        if (getActivity() != null) {
//            getActivity().setProgressBarIndeterminateVisibility(false);
//        }
//    }

    @Override
    public void onDisplay(List<Market> marketList) {
        this.marketList = marketList;
        hsxBinding.linearlayoutProgressbar.setVisibility(View.GONE);
        hsxBinding.contentview.setVisibility(View.VISIBLE);
        if (getActivity() != null) {
            getActivity().setProgressBarIndeterminateVisibility(true);
        }
        adapter = new MarketAdapter(marketList, this);
        hsxBinding.recyclerView.setAdapter(adapter);
        hsxBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDisplayReplaceFragment(String marketCode) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        DetailFrag detailFrag = DetailFrag.newInstance(marketCode);

        ActivityMainBinding mainBinding = ActivityMainBinding.inflate(from(getContext()));
        transaction//.remove(this)
                .replace(mainBinding.appBarMain.contentMain.contentview.getId(), detailFrag);
        transaction.addToBackStack("");
        transaction.commit();
    }

    @Override
    public void onDisplayError(ErrorApp error) {
        switch (error) {
            case ERROR_CONNECT_SERVER:
                break;
            case ERROR_NETWORK:
                makeText(getInstance(), getString(R.string.network_error), Toast.LENGTH_SHORT).show();
                break;
            case NULL:
                break;
            case EXCEPTION:
                break;
            default:
                break;
        }
//        hsxBinding.setIsProgressBarVisible(false);
    }

    @Override
    public void onItemClick(String marketName) {
        presenter.OnClickItem(marketName);
    }

    @Override
    public void onItemClick(String marketName, boolean isChecked) {
        presenter.OnClickItem(marketName, isChecked);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences preferences = getInstance().getSharedPreferences(SHARED_PREFRENCES_MARKETOVERVIEW, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        if (v.getId() == hsxBinding.linearLayoutChange.getId()) {
            boolean isChange = preferences.getBoolean(SHARED_PREFRENCES_MARKETOVERVIEW_ISCHANGE, true);
            isChange = !isChange;
            hsxBinding.textviewChange.setText(isChange ?
                    getString(R.string.change_percent) :
                    getString(R.string.change));
            editor.putBoolean(SHARED_PREFRENCES_MARKETOVERVIEW_ISCHANGE, isChange);
            adapter.notifyDataSetChanged();

        } else if (v.getId() == hsxBinding.linearLayoutValue.getId()) {
            boolean isValue = preferences.getBoolean(SHARED_PREFRENCES_MARKETOVERVIEW_ISVALUE, true);
            isValue = !isValue;
            hsxBinding.textviewValue.setText(isValue ? getString(R.string.value_bil) :
                    getString(R.string.volumn));
            editor.putBoolean(SHARED_PREFRENCES_MARKETOVERVIEW_ISVALUE, isValue);
            adapter.notifyDataSetChanged();
        }

        editor.apply();
        editor.commit();
    }


    @Override
    public void onPause() {
        super.onPause();
        presenter.destroy();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }
}
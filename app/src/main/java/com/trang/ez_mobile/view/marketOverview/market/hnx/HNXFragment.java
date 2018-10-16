package com.trang.ez_mobile.view.marketOverview.market.hnx;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.ActivityMainBinding;
import com.trang.ez_mobile.databinding.FragmentMarketOverviewHnxBinding;
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
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_MARKETOVERVIEW;
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_MARKETOVERVIEW_ISCHANGE;
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_MARKETOVERVIEW_ISVALUE;

public class HNXFragment extends Fragment implements IMarket_View,
        IMarket_View.IOnclickListener, View.OnClickListener {

    List<Market> marketList = new ArrayList<>();
    MarketAdapter adapter;
    FragmentMarketOverviewHnxBinding hnxBinding;
    HNXPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        hnxBinding = FragmentMarketOverviewHnxBinding.inflate(inflater, container, false);
        return hnxBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hnxBinding.progressBar.setVisibility(View.VISIBLE);
        hnxBinding.contentview.setVisibility(View.INVISIBLE);
        hnxBinding.linearLayoutChange.setOnClickListener(this);
        hnxBinding.linearLayoutValue.setOnClickListener(this);
        hnxBinding.textviewChange.setText(getInstance().getSharedPreferences(SHARED_PREFRENCES_MARKETOVERVIEW_ISCHANGE, Context.MODE_PRIVATE)
                .getBoolean(SHARED_PREFRENCES_MARKETOVERVIEW_ISCHANGE, true) ?
                getString(R.string.change_percent) :
                getString(R.string.change));

        hnxBinding.textviewValue.setText(getInstance().getSharedPreferences(SHARED_PREFRENCES_MARKETOVERVIEW, Context.MODE_PRIVATE)
                .getBoolean(SHARED_PREFRENCES_MARKETOVERVIEW_ISVALUE, true) ?
                getString(R.string.value_bil) :
                getString(R.string.volumn));
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter = new HNXPresenter(this);
    }

    @Override
    public void onDisplay(List<Market> marketList) {
        Log.w("HNXFragment", "onDisplay: " + marketList.size());
        this.marketList = marketList;
        hnxBinding.linearlayoutProgressbar.setVisibility(View.GONE);
        hnxBinding.contentview.setVisibility(View.VISIBLE);
        if (getActivity() != null) {
            getActivity().setProgressBarIndeterminateVisibility(true);
        }
        adapter = new MarketAdapter(marketList, this);
        hnxBinding.recyclerView.setAdapter(adapter);
        hnxBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
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
                if (getContext() != null)
                    makeText(getInstance(), getString(R.string.network_error), Toast.LENGTH_SHORT).show();
                break;
            case NULL:
                break;
            case EXCEPTION:
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(String marketName) {
        presenter.OnClickItem(marketName);
    }

    //save state
    @Override
    public void onItemClick(String marketName, boolean isChecked) {
        presenter.OnClickItem(marketName, isChecked);

    }

    @Override
    public void onClick(View v) {
        SharedPreferences preferences = getInstance().getSharedPreferences(SHARED_PREFRENCES_MARKETOVERVIEW, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        if (v.getId() == hnxBinding.linearLayoutChange.getId()) {
            boolean isChange = preferences.getBoolean(SHARED_PREFRENCES_MARKETOVERVIEW_ISCHANGE, true);
            isChange = !isChange;
            hnxBinding.textviewChange.setText(isChange ? getString(R.string.change_percent) :
                    getString(R.string.change));

            editor.putBoolean(SHARED_PREFRENCES_MARKETOVERVIEW_ISCHANGE, isChange);
            adapter.notifyDataSetChanged();

        } else if (v.getId() == hnxBinding.linearLayoutValue.getId()) {
            boolean isValue = preferences.getBoolean(SHARED_PREFRENCES_MARKETOVERVIEW_ISVALUE, true);
            isValue = !isValue;
            hnxBinding.textviewValue.setText(isValue ? getString(R.string.value_bil) :
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

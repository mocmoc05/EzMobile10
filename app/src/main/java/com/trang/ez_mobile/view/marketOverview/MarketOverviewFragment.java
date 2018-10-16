package com.trang.ez_mobile.view.marketOverview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.base.adapter.PagerAdapter;
import com.trang.ez_mobile.databinding.FragmentMarketOverviewBinding;
import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.view.marketOverview.market.hnx.HNXFragment;
import com.trang.ez_mobile.view.marketOverview.market.hsx.HSXFragment;

public class MarketOverviewFragment extends Fragment {
    FragmentMarketOverviewBinding overviewBinding;

    private PagerAdapter adapter;

    public static MarketOverviewFragment newInstance() {
        MarketOverviewFragment fragment = new MarketOverviewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        overviewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_market_overview, container, false);
        return overviewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.market_overview);
        FragmentManager manager = getActivity().getSupportFragmentManager();
        adapter = new PagerAdapter(manager);

        setupViewPager(overviewBinding.viewpager);
        overviewBinding.tabLayout.setupWithViewPager(overviewBinding.viewpager);
        overviewBinding.viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(overviewBinding.tabLayout));
        adapter.notifyDataSetChanged();
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new PagerAdapter(getChildFragmentManager());
        adapter.addFragment(new HSXFragment(), Define.STOCK_ORDER_EXCHANGE_HSX);
        adapter.addFragment(new HNXFragment(), Define.STOCK_ORDER_EXCHANGE_HNX);
        viewPager.setAdapter(adapter);
    }
}

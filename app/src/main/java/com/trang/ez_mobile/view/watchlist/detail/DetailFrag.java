package com.trang.ez_mobile.view.watchlist.detail;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.base.adapter.PagerAdapter;
import com.trang.ez_mobile.databinding.FragmentWatchlistDetailBinding;
import com.trang.ez_mobile.util.ColorTr;
import com.trang.ez_mobile.view.watchlist.detail.chart.ChartFrag;
import com.trang.ez_mobile.view.watchlist.detail.financeOverview.FinanceOverviewFrag;
import com.trang.ez_mobile.view.watchlist.detail.financialFigures.FinancialFiguresFrag;
import com.trang.ez_mobile.view.watchlist.detail.foreignOwnership.ForeignOwnershipFrag;
import com.trang.ez_mobile.view.watchlist.detail.news.NewsFrag;
import com.trang.ez_mobile.view.watchlist.detail.trading.TradingFrag;
import com.trang.ez_mobile.view.watchlist.model.Stock;

import java.util.List;

public class DetailFrag extends Fragment implements IDetailView {

    private String symbol;
    private String color;
    private String name;
    private String code;
    FragmentWatchlistDetailBinding detailBinding;
    private PagerAdapter adapter;

    public static DetailFrag newInstance(String symbol, String color, String name, String code) {
        Bundle args = new Bundle();
        args.putString("symbol", symbol);
        args.putString("color", color);
        args.putString("name", name);
        args.putString("code", code);
        DetailFrag fragment = new DetailFrag();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            symbol = getArguments().getString("symbol");
            color = getArguments().getString("color");
            name = getArguments().getString("name");
            code = getArguments().getString("code");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        detailBinding = FragmentWatchlistDetailBinding.inflate(inflater, container, false);
        return detailBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(symbol + " - " + name);

        switch (color) {

            case "b":///trắng
                detailBinding.icon.setVisibility(View.GONE);
                break;
            case "c"://tím
                detailBinding.icon.setImageResource(R.drawable.ic_up_violet);
                break;
            case "u":///green
                detailBinding.icon.setImageResource(R.drawable.ic_up_green);
                break;
            case "d"://đỏ
                detailBinding.icon.setImageResource(R.drawable.ic_down_red);
                break;
            case "r"://vàng
                detailBinding.icon.setImageResource(R.drawable.ic_minus);
                break;
            case "f"://blue
                detailBinding.icon.setImageResource(R.drawable.ic_down_blue);
                break;
        }

        setupViewPager(detailBinding.viewpager);
        detailBinding.tablayout.setupWithViewPager(detailBinding.viewpager);
        detailBinding.viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(detailBinding.tablayout));

        new DetailPresenter(this, symbol);
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new PagerAdapter(getChildFragmentManager());//(fragmentActivity.getSupportFragmentManager(), symbol);
        adapter.addFragment(TradingFrag.newInstance(symbol), App.getInstance().getResources().getString(R.string.trading));
        adapter.addFragment(NewsFrag.newInstance(symbol), App.getInstance().getResources().getString(R.string.news1));
        adapter.addFragment(ForeignOwnershipFrag.newInstance(symbol), App.getInstance().getResources().getString(R.string.foreign_ownership));
//        adapter.addFragment(FinanceOverviewFrag.newInstance(symbol), App.getInstance().getResources().getString(R.string.finance_overview));
        adapter.addFragment(FinancialFiguresFrag.newInstance(symbol), App.getInstance().getResources().getString(R.string.financial_figures));
        adapter.addFragment(ChartFrag.newInstance(symbol), App.getInstance().getResources().getString(R.string.chart));
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onDisplay(List<Stock> data) {
        if (data.size() > 0) {
            Stock item = data.get(0);
            detailBinding.textviewGia.setText(item.getLastPrice());
            detailBinding.textviewThaydoi.setText(item.getChange() + " ("
                    + ColorTr.percent(item.getLastPrice(), item.getChange()) + "%)");
            detailBinding.textviewKhoiluong.setText(item.getVolume());
            detailBinding.textviewTran.setText(item.getCeil());
            detailBinding.textviewTc.setText(item.getRef());

            detailBinding.textviewSan.setText(item.getFloor());
            detailBinding.textviewMax.setText(item.getHigh());
            detailBinding.textviewMin.setText(item.getLow());

            detailBinding.nnmua.setText(ColorTr.formatNumber(item.getForeignBuy()));
            detailBinding.nnban.setText(ColorTr.formatNumber(item.getForeignSell()));
        }
    }
}

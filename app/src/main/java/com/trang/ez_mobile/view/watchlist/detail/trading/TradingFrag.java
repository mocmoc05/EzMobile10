package com.trang.ez_mobile.view.watchlist.detail.trading;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.FragmentWatchlistTradingBinding;
import com.trang.ez_mobile.util.ColorTr;
import com.trang.ez_mobile.view.watchlist.model.Stock;

public class TradingFrag extends Fragment implements ITradingView {
    private String symbol;
    FragmentWatchlistTradingBinding binding;

    public TradingFrag() {
    }

    public static TradingFrag newInstance(String symbol) {
        TradingFrag fragment = new TradingFrag();
        Bundle args = new Bundle();
        args.putString("symbol", symbol);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            symbol = getArguments().getString("symbol");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWatchlistTradingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new TradingPresenter(this, symbol);

    }

    @Override
    public void display(Stock item) {
        if (item != null) {
            binding.txtB1MrkValue.setText(item.getBuyPrice1());
            if (item.getBuyPrice1().equals("ATC") || item.getBuyPrice1().equals("ATO")) {
                binding.txtB1MrkValue.setTextColor(ColorTr.DRAY_TEXT_COLOR);
            } else {
                ColorTr.setQuotesColorTextViewMrkB(item.getBuyPrice1(), binding.txtB1MrkValue, item);
            }

            binding.txtB2MrkValue.setText(item.getBuyPrice2());
            ColorTr.setQuotesColorTextViewMrkB(item.getBuyPrice2(), binding.txtB2MrkValue, item);


            binding.txtB3MrkValue.setText(item.getBuyPrice3());
            ColorTr.setQuotesColorTextViewMrkB(item.getBuyPrice3(), binding.txtB3MrkValue, item);


            binding.txtS1MrkValue.setText(item.getSellPrice1());
            if (item.getSellPrice1().equals("ATC") || item.getSellPrice1().equals("ATO")) {
                binding.txtS1MrkValue.setTextColor(ColorTr.DRAY_TEXT_COLOR);
            } else {
                ColorTr.setQuotesColorTextViewMrkB(item.getBuyPrice1(), binding.txtS1MrkValue, item);
            }

            binding.txtS2MrkValue.setText(item.getSellPrice2());
            ColorTr.setQuotesColorTextViewMrkB(item.getSellPrice2(), binding.txtS2MrkValue, item);


            binding.txtS3MrkValue.setText(item.getSellPrice3());
            ColorTr.setQuotesColorTextViewMrkB(item.getSellPrice3(), binding.txtS3MrkValue, item);


            binding.txtB1VolValue.setText(ColorTr.formatNumber(item.getBuyQty1()));

            binding.txtB2VolValue.setText(ColorTr.formatNumber(item.getBuyQty2()));

            binding.txtB3VolValue.setText(ColorTr.formatNumber(item.getBuyQty3()));

            binding.txtS1VolValue.setText(ColorTr.formatNumber(item.getSellQty1()));

            binding.txtS2VolValue.setText(ColorTr.formatNumber(item.getSellQty2()));

            binding.txtS3VolValue.setText(ColorTr.formatNumber(item.getSellQty3()));


        }
    }
}

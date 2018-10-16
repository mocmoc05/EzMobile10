package com.trang.ez_mobile.view.watchlist.detail.financeOverview;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trang.ez_mobile.databinding.FragmentWatchlistFinanceOverviewBinding;
import com.trang.ez_mobile.view.watchlist.detail.financialFigures.Finance;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FinanceOverviewFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FinanceOverviewFrag extends Fragment implements IFinanceOverviewView {
    private String symbol;
    FragmentWatchlistFinanceOverviewBinding binding;

    public FinanceOverviewFrag() {
    }

    public static FinanceOverviewFrag newInstance(String symbol) {
        FinanceOverviewFrag fragment = new FinanceOverviewFrag();
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
        // Inflate the layout for this fragment
        binding = FragmentWatchlistFinanceOverviewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new FinanceOverviewPresenter(this, symbol);
    }

    @Override
    public void display(List<Finance> data) {
        Log.w("FinanceOverviewFrag", "display: " + data.size());
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        Adapter_tc adapter = new Adapter_tc(  data);

        binding.list.setAdapter(adapter);
        binding.list.setLayoutManager(mLayoutManager);
    }
}

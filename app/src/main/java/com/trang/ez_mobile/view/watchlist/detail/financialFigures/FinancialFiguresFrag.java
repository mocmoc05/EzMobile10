package com.trang.ez_mobile.view.watchlist.detail.financialFigures;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.FragmentWatchlistFinancialFiguresBinding;
import com.trang.ez_mobile.view.watchlist.detail.financeOverview.Adapter_tc;

import java.util.List;

public class FinancialFiguresFrag extends Fragment implements IFinancialFiguresView {
    private String symbol;

    FinancialFiguresPresenter presenter;
    FragmentWatchlistFinancialFiguresBinding binding;

    public FinancialFiguresFrag() {
    }

    public static FinancialFiguresFrag newInstance(String symbol) {
        FinancialFiguresFrag fragment = new FinancialFiguresFrag();
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
        binding = FragmentWatchlistFinancialFiguresBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new FinancialFiguresPresenter(this, symbol);

        binding.chiso.setOnClickListener(v -> {
            presenter.LoadDatachiso();
            binding.chitieu.setBackgroundResource(R.drawable.bg_item_financialfiguresw2);
            binding.chiso.setBackgroundResource(R.drawable.bg_item_financialfigures1);
        });
        binding.chitieu.setOnClickListener(v -> {

            binding.chitieu.setBackgroundResource(R.drawable.bg_item_financialfigures2);
            binding.chiso.setBackgroundResource(R.drawable.bg_item_financialfiguresw1);
            presenter.LoadDatachitieu();
        });
    }

    @Override
    public void display(List<Finance> data) {
        Log.w("FinancialFiguresFrag", "display: " + data.size());
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        Adapter_tc adapter = new Adapter_tc(data);

        binding.list.setAdapter(adapter);
        binding.list.setLayoutManager(mLayoutManager);
        adapter.notifyDataSetChanged();
    }
}

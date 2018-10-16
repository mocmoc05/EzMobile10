package com.trang.ez_mobile.view.watchlist.detail.financeOverview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.BR;
import com.trang.ez_mobile.databinding.FragmentWatchlistFinanceOverviewBinding;
import com.trang.ez_mobile.databinding.ItemWatchlistFinancialBinding;
import com.trang.ez_mobile.view.watchlist.detail.financialFigures.Finance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by FIT-thuctap22 on 1/15/2018.
 */

public class Adapter_tc extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    List<Finance> data;

    public Adapter_tc(List<Finance> data) {
        inflater = LayoutInflater.from(App.getInstance());
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemWatchlistFinancialBinding binding = ItemWatchlistFinancialBinding.inflate(inflater, parent, false);
        return new MyHolder(binding);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final Finance current = data.get(position);
        final MyHolder myHolder = (MyHolder) holder;
        myHolder.bind(current);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        ItemWatchlistFinancialBinding binding;

        public MyHolder(ItemWatchlistFinancialBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bind(Finance obj) {
            binding.label.setText(obj.getKeyFinace());
            binding.value.setText(obj.getValueFinace());
            binding.executePendingBindings();
        }
    }
}

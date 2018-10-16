package com.trang.ez_mobile.view.watchlist.detail.foreignOwnership;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.FragmentWatchlistForeignOwnershipBinding;
import com.trang.ez_mobile.view.watchlist.model.Stock;

public class ForeignOwnershipFrag extends Fragment implements IForeignOwnershipView {
    FragmentWatchlistForeignOwnershipBinding binding;
    private String symbol;

    public ForeignOwnershipFrag() {
    }

    public static ForeignOwnershipFrag newInstance(String symbol) {
        ForeignOwnershipFrag fragment = new ForeignOwnershipFrag();
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
        binding = FragmentWatchlistForeignOwnershipBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void display(Stock item) {
        if (item != null) {
            binding.klm.setText(item.getRoom());
            binding.khht.setText(item.getCurrentRoom());
            binding.klcl.setText(item.getRemainRoom());
            binding.tyle.setText(item.getRatios());
            binding.update.setText(item.getDateUpdate());

        }
    }
}
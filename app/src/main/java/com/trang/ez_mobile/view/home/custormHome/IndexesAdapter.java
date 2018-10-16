package com.trang.ez_mobile.view.home.custormHome;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.ItemHomeIndexesItemviewBinding;
import com.trang.ez_mobile.model.entity.StockMarket;
import com.trang.ez_mobile.view.home.IHomeView;

import java.util.List;

public class IndexesAdapter extends RecyclerView.Adapter {
    private List<StockMarket> stockMarketList;
    private IHomeView.IAdapterCallback iAdapterCallback;
    private ItemHomeIndexesItemviewBinding binding;

    public IndexesAdapter(List<StockMarket> stockMarketList, IHomeView.IAdapterCallback iAdapterCallback) {
        this.stockMarketList = stockMarketList;
        this.iAdapterCallback = iAdapterCallback;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemHomeIndexesItemviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new IndexesHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        StockMarket market = stockMarketList.get(position);
        binding.textviewValue.setText(market.getMarketToTalValue() + " " + App.getInstance().getResources().getString(R.string.bil));
        binding.textviewPrice.setText(market.getMarketPrice());
        binding.textviewName.setText(market.getMarketName());

        switch (market.getMarketColorCode()) {
            case "u":
                binding.textviewChange.setText(Html.fromHtml(App.getInstance().getResources().getString(R.string.home_indexes_item_change_up,
                        market.getMarketValueChange(), market.getMarketValueChangeRatio())));
                binding.textviewChange.setTextColor(App.getInstance().getResources().getColor(R.color.green));
                binding.textviewPrice.setTextColor(App.getInstance().getResources().getColor(R.color.green));
                break;
            case "d":
                binding.textviewChange.setText(Html.fromHtml(App.getInstance().getResources().getString(R.string.home_indexes_item_change_down,
                        market.getMarketValueChange(), market.getMarketValueChangeRatio())));
                binding.textviewChange.setTextColor(App.getInstance().getResources().getColor(R.color.red));
                binding.textviewPrice.setTextColor(App.getInstance().getResources().getColor(R.color.red));
                break;
            case "c":
                binding.textviewChange.setText(Html.fromHtml(App.getInstance().getResources().getString(R.string.home_indexes_item_change_top,
                        market.getMarketValueChange(), market.getMarketValueChangeRatio())));
                binding.textviewChange.setTextColor(App.getInstance().getResources().getColor(R.color.purple));
                binding.textviewPrice.setTextColor(App.getInstance().getResources().getColor(R.color.purple));
                break;
            case "r":
                binding.textviewChange.setText(Html.fromHtml(App.getInstance().getResources().getString(R.string.home_indexes_item_change_average,
                        market.getMarketValueChange(), market.getMarketValueChangeRatio())));
                binding.textviewChange.setTextColor(App.getInstance().getResources().getColor(R.color.orange));
                binding.textviewPrice.setTextColor(App.getInstance().getResources().getColor(R.color.orange));
                break;
            case "f":
                binding.textviewChange.setText(Html.fromHtml(App.getInstance().getResources().getString(R.string.home_indexes_item_change_floor,
                        market.getMarketValueChange(), market.getMarketValueChangeRatio())));
                binding.textviewChange.setTextColor(App.getInstance().getResources().getColor(R.color.blue_text));
                binding.textviewPrice.setTextColor(App.getInstance().getResources().getColor(R.color.blue_text));
                break;
            case "o":
                binding.textviewChange.setText(Html.fromHtml(App.getInstance().getResources().getString(R.string.home_indexes_item_change_up,
                        market.getMarketValueChange(), market.getMarketValueChangeRatio())));
                binding.textviewChange.setTextColor(App.getInstance().getResources().getColor(R.color.green));
                binding.textviewPrice.setTextColor(App.getInstance().getResources().getColor(R.color.green));
                break;
            default:
                binding.textviewChange.setText(Html.fromHtml(App.getInstance().getResources().getString(R.string.home_indexes_item_change_up,
                        market.getMarketValueChange(), market.getMarketValueChangeRatio())));
                binding.textviewChange.setTextColor(App.getInstance().getResources().getColor(R.color.green));
                binding.textviewPrice.setTextColor(App.getInstance().getResources().getColor(R.color.green));
                break;
        }
        binding.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iAdapterCallback != null) {
                    iAdapterCallback.onReplaceFragment(market.getMarketName());
                }
            }
        });
//        binding.linearLayout.setOnClickListener(new View.OnClickListener())
    }

    @Override
    public int getItemCount() {
        return stockMarketList.size();
    }

    private class IndexesHolder extends RecyclerView.ViewHolder {
        public IndexesHolder(ItemHomeIndexesItemviewBinding binding) {
            super(binding.getRoot());
        }
    }
}

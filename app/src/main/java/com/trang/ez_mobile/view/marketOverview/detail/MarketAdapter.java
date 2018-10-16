package com.trang.ez_mobile.view.marketOverview.detail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.ItemMarketOverviewRecyclerviewMarketDetailBinding;
import com.trang.ez_mobile.model.entity.Market;
import com.trang.ez_mobile.util.ColorTr;

import java.util.Collections;
import java.util.List;

import static com.trang.ez_mobile.util.Define.COLOR_CEILING;
import static com.trang.ez_mobile.util.Define.COLOR_DOWN;
import static com.trang.ez_mobile.util.Define.COLOR_FLOOR;
import static com.trang.ez_mobile.util.Define.COLOR_REF;
import static com.trang.ez_mobile.util.Define.COLOR_UP;

/**
 * Created by TraPTH on 2/25/2018.
 */

public class MarketAdapter extends RecyclerView.Adapter {
    ItemMarketOverviewRecyclerviewMarketDetailBinding detailBinding;
    List<Market> marketList = Collections.emptyList();

    public MarketAdapter(List<Market> marketList) {
        this.marketList = marketList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        detailBinding = ItemMarketOverviewRecyclerviewMarketDetailBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DetailHolder(detailBinding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Market market = marketList.get(position);
        detailBinding.textViewPriceOpen.setTextColor(getColor(market.getMarketPriceOpenColor()));
        detailBinding.textviewPriceClose.setTextColor(getColor(market.getMarketPriceCloseColor()));
        detailBinding.textviewPriceHigh.setTextColor(getColor(market.getMarketPriceHighColor()));
        detailBinding.textviewPriceLow.setTextColor(getColor(market.getMarketPriceLowColor()));

        detailBinding.textviewName.setText(market.getMarketName());
        detailBinding.textViewPriceOpen.setText(market.getMarketPriceOpen());
        detailBinding.textviewPriceClose.setText(market.getMarketPriceClose());
        detailBinding.textviewPriceHigh.setText(market.getMarketPriceHigh());
        detailBinding.textviewPriceLow.setText(market.getMarketPriceLow());
        detailBinding.textviewVolumn.setText(market.getMarketVolumn());
        detailBinding.textviewChange.setText(market.getMarketValueChangeRatio());
    }

    private int getColor(int color) {
        switch (color) {
            case COLOR_UP:
                return  App.getInstance().getResources().getColor(R.color.green);
            case COLOR_CEILING:
                return App.getInstance().getResources().getColor(R.color.purple);
            case COLOR_REF:
                return   App.getInstance().getResources().getColor(R.color.orange);
            case COLOR_DOWN:
                return  App.getInstance().getResources().getColor(R.color.red);
            case COLOR_FLOOR:
                return  App.getInstance().getResources().getColor(R.color.blue_text);
            default:
                return App.getInstance().getResources().getColor(R.color.black);
        }
    }

    @Override
    public int getItemCount() {
        return marketList.size();
    }

    class DetailHolder extends RecyclerView.ViewHolder {
        ItemMarketOverviewRecyclerviewMarketDetailBinding binding;

        public DetailHolder(ItemMarketOverviewRecyclerviewMarketDetailBinding detailBinding) {
            super(detailBinding.getRoot());
            this.binding = detailBinding;
        }
    }
}

package com.trang.ez_mobile.view.marketOverview.market;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.ItemMarketOverviewRecyclerviewMarketBinding;
import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.view.marketOverview.market.model.Market;

import java.util.List;

import static com.trang.ez_mobile.App.getInstance;
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_MARKETOVERVIEW_ISCHANGE;
import static com.trang.ez_mobile.util.Define.SHARED_PREFRENCES_MARKETOVERVIEW_ISVALUE;
import static java.lang.Double.parseDouble;

/**
 * Created by TraPTH on 2/21/2018.
 */
public class MarketAdapter extends RecyclerView.Adapter {
    private List<Market> markets;
    MarketAdapterPresenter presenter;
    ItemMarketOverviewRecyclerviewMarketBinding marketBinding;
    IMarket_View.IOnclickListener listener;

    public MarketAdapter(List<Market> markets, IMarket_View.IOnclickListener listener) {
        this.markets = markets;
        this.listener = listener;
        presenter = new MarketAdapterPresenter();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        marketBinding = ItemMarketOverviewRecyclerviewMarketBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MarketHolder(marketBinding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Market market = markets.get(position);
        ((MarketHolder) holder).bind(market);
    }

    @Override
    public int getItemCount() {
        return markets.size();
    }

    class MarketHolder extends RecyclerView.ViewHolder {
        ItemMarketOverviewRecyclerviewMarketBinding binding;

        public MarketHolder(ItemMarketOverviewRecyclerviewMarketBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Market market) {
            Double color;
            try {
                color = parseDouble(market.getMarketValueChangeRatio());
            } catch (Exception e) {
                color = 0d;
            }
            if (color > 0) {
                binding.textviewMarketChange.setTextColor(getInstance().getResources().getColor(R.color.green));
                binding.textviewMarketLastPrice.setTextColor(getInstance().getResources().getColor(R.color.green));
            } else if (color == 0) {
                binding.textviewMarketChange.setTextColor(getInstance().getResources().getColor(R.color.orange));
                binding.textviewMarketLastPrice.setTextColor(getInstance().getResources().getColor(R.color.orange));
            } else {
                binding.textviewMarketChange.setTextColor(getInstance().getResources().getColor(R.color.red));
                binding.textviewMarketLastPrice.setTextColor(getInstance().getResources().getColor(R.color.red));
            }

            SharedPreferences preferences = getInstance().getSharedPreferences(Define.SHARED_PREFRENCES_MARKETOVERVIEW, Context.MODE_PRIVATE);
            binding.textviewMarketName.setText(market.getMarketName());
            binding.textviewMarketLastPrice.setText(market.getMarketLastPrice());
            binding.textviewMarketChange.setText(preferences.getBoolean(SHARED_PREFRENCES_MARKETOVERVIEW_ISCHANGE, true) ?
                    market.getMarketValueChangeRatio() : market.getMarketValueChange());
            binding.textviewMarketValue.setText(preferences.getBoolean(SHARED_PREFRENCES_MARKETOVERVIEW_ISVALUE, true) ?
                    market.getMarketVolumn() : market.getMarketQuantity());

            binding.contentview.setOnClickListener(v -> listener.onItemClick(market.getMarketName()));
//            final boolean[] isChecked = {presenter.getChecked(market.getMarketName())};
//            if (market.isMarketIsChecked()) {
//                binding.imageChecked.setImageResource(R.drawable.ic_star_black_24dp);
//            } else {
//                binding.imageChecked.setImageResource(R.drawable.ic_star_border_black_24dp);
//            }
//            binding.imageChecked.setOnClickListener(v -> {
//                isChecked[0] = !isChecked[0];
//                binding.imageChecked.setImageResource(
//                        isChecked[0] ? R.drawable.ic_star_black_24dp : R.drawable.ic_star_border_black_24dp);
//                market.setMarketIsChecked(!market.isMarketIsChecked());
//                listener.onItemClick(market.getMarketName(), market.isMarketIsChecked());
//            });
        }
    }
}

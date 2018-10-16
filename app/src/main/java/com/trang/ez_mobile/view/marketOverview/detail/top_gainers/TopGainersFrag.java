package com.trang.ez_mobile.view.marketOverview.detail.top_gainers;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.FragmentMarketoverviewDetailTopGainersBinding;
import com.trang.ez_mobile.model.entity.Market;
import com.trang.ez_mobile.util.ErrorApp;
import com.trang.ez_mobile.view.marketOverview.detail.IDetail_View;
import com.trang.ez_mobile.view.marketOverview.detail.MarketAdapter;

import java.util.List;

import static android.widget.Toast.makeText;
import static com.trang.ez_mobile.App.getInstance;
import static com.trang.ez_mobile.util.Define.TYPE_PRICE_UP;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopGainersFrag extends Fragment implements IDetail_View.IDetailPrice_View {
    FragmentMarketoverviewDetailTopGainersBinding topGainersBinding;
    TopGainers_Presenter presenter;
    private static final String ARG_PARAM_MARKET_NAME = "ARG_PARAM_MARKET_NAME";
    private static final String ARG_PARAM_MARKET_TYPE = "ARG_PARAM_MARKET_TYPE";
    private String marketName;
    private int type = TYPE_PRICE_UP;

    public TopGainersFrag() {
        // Required empty public constructor
    }


    public static TopGainersFrag newInstance(String marketName) {
        TopGainersFrag fragment = new TopGainersFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_MARKET_NAME, marketName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            marketName = getArguments().getString(ARG_PARAM_MARKET_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        topGainersBinding = FragmentMarketoverviewDetailTopGainersBinding.inflate(inflater, container, false);
        return topGainersBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new TopGainers_Presenter(this, marketName, type);
        topGainersBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        topGainersBinding.recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), 1));
    }

    @Override
    public void onError(ErrorApp error) {
        switch (error) {
            case ERROR_CONNECT_SERVER:
                break;
            case ERROR_NETWORK:
                makeText(getInstance(), getInstance().getResources().getString(R.string.network_error), Toast.LENGTH_SHORT).show();
                break;
            case NULL:
                break;
            case EXCEPTION:
                break;
            default:
                break;
        }
    }

    @Override
    public void onDisplay(List<Market> marketList) {
        MarketAdapter adapter = new MarketAdapter(marketList);
        topGainersBinding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}

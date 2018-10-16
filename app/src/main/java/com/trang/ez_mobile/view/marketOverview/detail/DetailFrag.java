package com.trang.ez_mobile.view.marketOverview.detail;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.FragmentMarketOverviewDetailBinding;
import com.trang.ez_mobile.model.entity.DetailMarket;
import com.trang.ez_mobile.util.ColorTr;
import com.trang.ez_mobile.util.ErrorApp;
import com.trang.ez_mobile.base.adapter.PagerAdapter;
import com.trang.ez_mobile.view.marketOverview.detail.chart.ChartFrag;
import com.trang.ez_mobile.view.marketOverview.detail.most_active.MostActiveFrag;
import com.trang.ez_mobile.view.marketOverview.detail.top_gainers.TopGainersFrag;
import com.trang.ez_mobile.view.marketOverview.detail.top_losers.TopLosersFragment;

import static com.trang.ez_mobile.App.getInstance;
import static com.trang.ez_mobile.util.Define.COLOR_FLOOR;
import static com.trang.ez_mobile.util.Define.COLOR_REF;
import static com.trang.ez_mobile.util.Define.COLOR_UP;

public class DetailFrag extends DialogFragment implements IDetail_View {
    private static final String ARG_PARAM_MARKET_CODE = "ARG_PARAM_MARKET_CODE";
    private FragmentMarketOverviewDetailBinding detailBinding;
    private String marketCode;
    private Detail_Presenter presenter;
    private PagerAdapter adapter;

    public DetailFrag() {
    }

    public static DetailFrag newInstance(String marketCode) {
        DetailFrag fragment = new DetailFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_MARKET_CODE, marketCode);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            marketCode = getArguments().getString(ARG_PARAM_MARKET_CODE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        detailBinding = FragmentMarketOverviewDetailBinding.inflate(inflater, container, false);
        return detailBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new Detail_Presenter(getInstance(), this, marketCode);
        FragmentManager manager = getActivity().getSupportFragmentManager();
        adapter = new PagerAdapter(manager);
    }

    @Override
    public void onLoading() {
        detailBinding.progressBar.setVisibility(View.VISIBLE);
        if (getActivity() != null) {
            getActivity().setProgressBarIndeterminateVisibility(false);
        }
    }

    @Override
    public void onDisplay(DetailMarket detailMarket, int textColor) {
        detailBinding.progressBar.setVisibility(View.GONE);

        if (getActivity() != null) {
            getActivity().setProgressBarIndeterminateVisibility(true);
        }
        detailMarket.setDetailMarketName(marketCode);

        setupViewPager(detailBinding.viewpager);
        detailBinding.tablayout.setupWithViewPager(detailBinding.viewpager);
        detailBinding.textviewMatchPrice.setText(Html.fromHtml(getString(R.string.market_overview_match_price,
                detailMarket.getDetailMarketName() != null ? detailMarket.getDetailMarketName() : " ",
                detailMarket.getDetailMarketMatchPrice() != null ? detailMarket.getDetailMarketMatchPrice() : "")));
        detailBinding.textviewPriceQuantity.setText(Html.fromHtml(getString(R.string.market_overview_detail_price_val,
                detailMarket.getDetailMarketVal() != null ? detailMarket.getDetailMarketVal() : "")));
        detailBinding.textviewPriceValue.setText(Html.fromHtml(getString(R.string.market_overview_detail_price_qty,
                detailMarket.getDetailMarketQty() != null ? detailMarket.getDetailMarketQty() : "")));
        detailBinding.textviewPriceUp.setText(Html.fromHtml(getString(R.string.market_overview_detail_price_up,
                detailMarket.getDetailMarketPriceUp() != null ? detailMarket.getDetailMarketPriceUp() : "")));
        detailBinding.textviewPriceAverage.setText(Html.fromHtml(getString(R.string.market_overview_detail_price_average,
                detailMarket.getDetailMarketPriceAverage() != null ? detailMarket.getDetailMarketPriceAverage() : "")));
        detailBinding.textviewPriceDown.setText(Html.fromHtml(getString(R.string.market_overview_detail_price_down,
                detailMarket.getDetailMarketPriceDown() != null ? detailMarket.getDetailMarketPriceDown() : "")));
        detailBinding.textviewForeignQty.setText(Html.fromHtml(getString(R.string.market_overview_detail_foreign_qty,
                detailMarket.getDetailMarketValueForeignQty() != null ? detailMarket.getDetailMarketValueForeignQty() : "")));
        detailBinding.textviewForeignVal.setText(Html.fromHtml(getString(R.string.market_overview_detail_foreign_val,
                detailMarket.getDetailMarketValueForeignVal() != null ? detailMarket.getDetailMarketValueForeignVal() : "")));
        switch (textColor) {
            case COLOR_UP:
                detailBinding.textviewMatchPrice.setTextColor(App.getInstance().getResources().getColor(R.color.green));
                detailBinding.textviewChange.setText(Html.fromHtml(getString(R.string.market_overview_detail_change_value_up,
                        detailMarket.getDetailMarketChangeValue() != null ? detailMarket.getDetailMarketChangeValue() : "",
                        detailMarket.getDetailMarketChangeValueRatio() != null ? detailMarket.getDetailMarketChangeValueRatio() : "")));
                break;
            case COLOR_FLOOR:
                detailBinding.textviewMatchPrice.setTextColor(App.getInstance().getResources().getColor(R.color.red));
                detailBinding.textviewChange.setText(Html.fromHtml(getString(R.string.market_overview_detail_change_value_down,
                        detailMarket.getDetailMarketChangeValue() != null ? detailMarket.getDetailMarketChangeValue() : "",
                        detailMarket.getDetailMarketChangeValueRatio() != null ? detailMarket.getDetailMarketChangeValueRatio() : "")));
                break;
            case COLOR_REF:
                detailBinding.textviewMatchPrice.setTextColor(ColorTr.ORANGE_TEXT_COLOR);
                detailBinding.textviewChange.setText(Html.fromHtml(getString(R.string.market_overview_detail_change_value_average,
                        detailMarket.getDetailMarketChangeValue() != null ? detailMarket.getDetailMarketChangeValue() : "",
                        detailMarket.getDetailMarketChangeValueRatio() != null ? detailMarket.getDetailMarketChangeValueRatio() : "")));
                break;
            default:
                detailBinding.textviewMatchPrice.setTextColor(App.getInstance().getResources().getColor(R.color.green));
                detailBinding.textviewChange.setText(Html.fromHtml(getString(R.string.market_overview_detail_change_value_up,
                        detailMarket.getDetailMarketChangeValue() != null ? detailMarket.getDetailMarketChangeValue() : "",
                        detailMarket.getDetailMarketChangeValueRatio() != null ? detailMarket.getDetailMarketChangeValueRatio() : "")));
                break;
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDisplayError(ErrorApp error) {
        switch (error) {
            case ERROR_CONNECT_SERVER:
                break;
            case ERROR_NETWORK:
                Toast.makeText(getInstance(), getInstance().getResources().getString(R.string.network_error), Toast.LENGTH_SHORT).show();
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
    public void onUpdateTitle(String title) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        this.dismiss();
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new PagerAdapter(getChildFragmentManager());
        adapter.addFragment(ChartFrag.newInstance(marketCode), getInstance().getResources().getString(R.string.chart));
        adapter.addFragment(TopGainersFrag.newInstance(marketCode), getInstance().getResources().getString(R.string.top_gainers));
        adapter.addFragment(TopLosersFragment.newInstance(marketCode), getInstance().getResources().getString(R.string.top_losers));
        adapter.addFragment(MostActiveFrag.newInstance(marketCode), getInstance().getResources().getString(R.string.most_active));
        viewPager.setAdapter(adapter);
    }
}


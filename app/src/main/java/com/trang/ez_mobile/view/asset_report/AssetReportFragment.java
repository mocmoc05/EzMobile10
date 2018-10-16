package com.trang.ez_mobile.view.asset_report;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.FragmentAssetReportBinding;
import com.trang.ez_mobile.view.asset_report.cash_balance.CashBalanceFragment;
import com.trang.ez_mobile.view.asset_report.stock_balance.StockBalanceFragment;
import com.trang.ez_mobile.view.my_adapter.ViewPagerAdapter;
import com.trang.ez_mobile.view.user.login.TaiKhoan;

/**
 * Created by TraPTH on 5/16/2018.
 */
public class AssetReportFragment extends Fragment {
    private FragmentAssetReportBinding binding;
    private ViewPagerAdapter viewPagerAdapter;
    private TaiKhoan tk;

    public static AssetReportFragment newInstance(TaiKhoan taiKhoan) {
        AssetReportFragment fragment = new AssetReportFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tai_khoan", taiKhoan);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_asset_report, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.asset_report);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tk = (TaiKhoan) getArguments().getSerializable("tai_khoan");

        setupViewPager(binding.viewPagerAssetReport);
        binding.tabsAssetReport.setupWithViewPager(binding.viewPagerAssetReport);
    }

    private void setupViewPager(ViewPager viewPager) {
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(StockBalanceFragment.newInstance(tk), getString(R.string.stock));
        viewPagerAdapter.addFragment(CashBalanceFragment.newInstance(), getString(R.string.cash));
        viewPager.setAdapter(viewPagerAdapter);
    }
}

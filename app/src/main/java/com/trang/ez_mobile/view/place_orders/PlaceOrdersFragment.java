package com.trang.ez_mobile.view.place_orders;

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
import com.trang.ez_mobile.databinding.FragmentPlaceOrdersBinding;
import com.trang.ez_mobile.view.my_adapter.ViewPagerAdapter;
import com.trang.ez_mobile.view.place_orders.buy.BuyFragment;
import com.trang.ez_mobile.view.place_orders.sell.SellFragment;
import com.trang.ez_mobile.view.user.login.TaiKhoan;

import java.io.Serializable;


/**
 * Created by TraPTH on 5/15/2018.
 */
public class PlaceOrdersFragment extends Fragment{
    private ViewPagerAdapter viewPagerAdapter;
    private FragmentPlaceOrdersBinding binding;
    private TaiKhoan tk;

    public static PlaceOrdersFragment newInstance(TaiKhoan taiKhoan){
        PlaceOrdersFragment fragment= new PlaceOrdersFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tai_khoan", taiKhoan);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_place_orders, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.place_orders);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tk= (TaiKhoan) getArguments().getSerializable("tai_khoan");

        setupViewPager(binding.viewPagerPlaceOrders);
        binding.tabsPlaceOrders.setupWithViewPager(binding.viewPagerPlaceOrders);


    }

    private void setupViewPager(ViewPager viewPager) {
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(SellFragment.newInstance(tk), getString(R.string.sell));
        viewPagerAdapter.addFragment(BuyFragment.newInstance(tk), getString(R.string.buy));
        viewPager.setAdapter(viewPagerAdapter);
    }

}

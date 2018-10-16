package com.trang.ez_mobile.view.news.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.util.custormView.TabLayoutFont;
import com.trang.ez_mobile.view.my_adapter.ViewPagerAdapter;
import com.trang.ez_mobile.view.news.home.bao_cao_nganh.BaoCaoNganhFragment;
import com.trang.ez_mobile.view.news.home.doanh_nghiep.DoanhNghiepFragment;
import com.trang.ez_mobile.view.news.home.phan_tich_binh_luan.PhanTichBinhLuanFragment;
import com.trang.ez_mobile.view.news.home.tin_fpts.TinFPTSFragment;
import com.trang.ez_mobile.view.news.home.tin_thi_truong.TinThiTruongFragment;


/**
 * Created by TraPTH on 2/22/2018.
 */

@SuppressLint("ValidFragment")
public class HomeNewsFragment extends Fragment {
    private ViewPagerAdapter viewPagerAdapter;

    //Anh xa
    private TabLayoutFont tabs;
    private ViewPager viewPager;

    public HomeNewsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home_news, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.news);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabs= (TabLayoutFont) view.findViewById(R.id.tabs);
        viewPager= (ViewPager) view.findViewById(R.id.viewPager);

        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);

        //Keo vuot man hinh sang tab new
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//        tabLayout.setTabsFromPagerAdapter(viewPagerAdapter);
    }

    private void setupViewPager(ViewPager viewPager) {
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(new TinThiTruongFragment(), getString(R.string.market_news));
        viewPagerAdapter.addFragment(new BaoCaoNganhFragment(), getString(R.string.department_report));
        viewPagerAdapter.addFragment(new DoanhNghiepFragment(), getString(R.string.concern));
        viewPagerAdapter.addFragment(new PhanTichBinhLuanFragment(), getString(R.string.analysis_comment));
        viewPagerAdapter.addFragment(new TinFPTSFragment(), getString(R.string.FPTS_news));
        viewPager.setAdapter(viewPagerAdapter);
    }

}

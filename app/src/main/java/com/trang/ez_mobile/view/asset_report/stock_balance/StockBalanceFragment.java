package com.trang.ez_mobile.view.asset_report.stock_balance;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.FragmentStockBalanceBinding;
import com.trang.ez_mobile.view.place_orders.object.BaoCaoTaiSanCk;
import com.trang.ez_mobile.view.user.login.TaiKhoan;

import java.util.List;

/**
 * Created by TraPTH on 5/18/2018.
 */
public class StockBalanceFragment extends Fragment implements IStockBalance{
    private FragmentStockBalanceBinding binding;
    private StockBalancePresenter presenter;
    private TaiKhoan tk;
    private StockBalanceAdapter adapter;

    public static StockBalanceFragment newInstance(TaiKhoan taiKhoan) {
        StockBalanceFragment fragment= new StockBalanceFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tai_khoan", taiKhoan);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_stock_balance, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tk = (TaiKhoan) getArguments().getSerializable("tai_khoan");

        presenter= new StockBalancePresenter(this);
        presenter.getData(tk.getMaTK());
    }

    @Override
    public void getDataDone(List<BaoCaoTaiSanCk> baoCaoTaiSanCkList) {
        binding.llProgressFragmentStockBalance.setVisibility(View.GONE);
        adapter= new StockBalanceAdapter(baoCaoTaiSanCkList);
        binding.rcvBaocaotaisanCk.setAdapter(adapter);
        binding.rcvBaocaotaisanCk.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void connectNetworkFail() {
        binding.llProgressFragmentStockBalance.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Connect Network Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectServerFail() {
        binding.llProgressFragmentStockBalance.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Connect Server Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoad() {
        binding.llProgressFragmentStockBalance.setVisibility(View.VISIBLE);
    }

    @Override
    public void getDataFail() {
        binding.llProgressFragmentStockBalance.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Get Data Fail", Toast.LENGTH_SHORT).show();
    }
}

package com.trang.ez_mobile.view.place_orders.buy;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.FragmentBuyBinding;
import com.trang.ez_mobile.view.place_orders.buy.detail_buy.DetailBuyDialogFragment;
import com.trang.ez_mobile.view.place_orders.object.BaoCaoTaiSanCk;
import com.trang.ez_mobile.view.place_orders.object.GiaoDich;
import com.trang.ez_mobile.view.user.login.TaiKhoan;

import java.util.List;

/**
 * Created by TraPTH on 5/15/2018.
 */
public class BuyFragment extends Fragment implements IBuy {
    private FragmentBuyBinding binding;
    private TaiKhoan tk;
    private BuyPresenter presenter;
    private BuyAdapter adapter;

    public static BuyFragment newInstance(TaiKhoan taiKhoan) {
        BuyFragment fragment = new BuyFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tai_khoan", taiKhoan);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_buy, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tk = (TaiKhoan) getArguments().getSerializable("tai_khoan");
        presenter = new BuyPresenter(this);
        presenter.getData(tk.getMaTK());

    }

    @Override
    public void getDataDone(List<BaoCaoTaiSanCk> taiSanCkList) {
        binding.llProgressFragmentBuy.setVisibility(View.GONE);
        adapter = new BuyAdapter(taiSanCkList, this);
        binding.rcvDatLenhBan.setAdapter(adapter);
        binding.rcvDatLenhBan.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getDataFail() {
        binding.llProgressFragmentBuy.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Get Data Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectNetworkFail() {
        binding.llProgressFragmentBuy.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Connect Network Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectServerFail() {
        binding.llProgressFragmentBuy.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Connect Server Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void moveFragmentBuy(String maCK, String khoiLuong) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        DetailBuyDialogFragment dialogFragment = DetailBuyDialogFragment.newInstance(maCK, khoiLuong, tk);
        dialogFragment.show(fragmentManager, null);
    }

    @Override
    public void onLoad() {
        binding.llProgressFragmentBuy.setVisibility(View.VISIBLE);
    }
}

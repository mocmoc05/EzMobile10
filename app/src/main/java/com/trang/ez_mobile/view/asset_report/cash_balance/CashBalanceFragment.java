package com.trang.ez_mobile.view.asset_report.cash_balance;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.FragmentCashBalanceBinding;
import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.view.user.login.TaiKhoan;

/**
 * Created by TraPTH on 5/18/2018.
 */
public class CashBalanceFragment extends Fragment implements ICashBalance {
    private FragmentCashBalanceBinding binding;
    private CashBalancePresenter presenter;

    public static CashBalanceFragment newInstance() {
        CashBalanceFragment fragment = new CashBalanceFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cash_balance, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new CashBalancePresenter(this);
        presenter.getData();
    }

    @Override
    public void getDataDone(TaiKhoan taiKhoan) {
        Double tong = Double.parseDouble(taiKhoan.getSoDuTien()) + Double.parseDouble(taiKhoan.getTienDangVe());
        binding.tvValueSoDuTien.setText(Define.formatDouble(tong));
        binding.tvValueUngTruoc.setText(Define.formatDouble(Double.parseDouble(taiKhoan.getSoTienUng())));
        binding.tvValueDangTreo.setText(Define.formatDouble(Double.parseDouble(taiKhoan.getTienDangVe())));
        binding.tvValueSoDuHienTai.setText(Define.formatDouble(Double.parseDouble(taiKhoan.getSoDuTien())));
    }
}

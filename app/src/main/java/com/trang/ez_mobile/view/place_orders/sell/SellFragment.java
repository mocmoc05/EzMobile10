package com.trang.ez_mobile.view.place_orders.sell;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.FragmentSellBinding;
import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.view.place_orders.object.ChungKhoan;
import com.trang.ez_mobile.view.splash_screen.MainActivity;
import com.trang.ez_mobile.view.user.login.TaiKhoan;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TraPTH on 5/15/2018.
 */
public class SellFragment extends Fragment implements ISell {
    private FragmentSellBinding binding;
    private List<String> listType;
    private TaiKhoan tk;
    private SellPresenter presenter;
    private String[] termHNX = {"LO", "MTL", "MAK", "MOK", "ATC"};
    private String[] termHSX = {"LO", "ATO", "MP", "ATC"};
    private String[] termUPCOM = {"LO"};
    private double soDuTien;
    private String banMin, muaMax;
    private String gia;

    public static SellFragment newInstance(TaiKhoan taiKhoan) {
        SellFragment fragment = new SellFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tai_khoan", taiKhoan);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sell, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listType = new ArrayList<>();
        tk = (TaiKhoan) getArguments().getSerializable("tai_khoan");
        presenter = new SellPresenter(this);

        try {
            soDuTien = Double.valueOf(tk.getSoDuTien());
            binding.tvAvailableCash.setText(Define.formatDouble(soDuTien));
        } catch (Exception e) {
            e.printStackTrace();
        }

        initAction();
    }

    private void initAction() {
        binding.imgMaCk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.edtValueMaCk.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "Bạn chưa nhập mã Chứng khoán", Toast.LENGTH_SHORT).show();
                } else {
                    presenter.seachStock(binding.edtValueMaCk.getText().toString());
                }
            }
        });

        binding.spnValueLoaiLenh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (binding.spnValueLoaiLenh.getSelectedItem().equals("LO")) {
                    binding.edtValueGiaMua.setVisibility(View.VISIBLE);
                    binding.edtValueGiaMua.setText(gia);
                } else {
                    binding.edtValueGiaMua.setText("");
                    binding.edtValueGiaMua.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.btnXacNhanMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.edtValueSoLuong.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "Bạn chưa nhập khối lượng giao dịch", Toast.LENGTH_SHORT).show();
                } else {
                    int khoiLuong = Integer.parseInt(binding.edtValueSoLuong.getText().toString());
                    switch (binding.tvValueSanGd.getText().toString()) {
                        case "HSX":
                            if (khoiLuong % 10 == 0) {
                                checkPassword();
                            } else {
                                Toast.makeText(getContext(), "Số lượng phải là bội số của 10", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "HNX":
                            if (khoiLuong % 100 == 0) {
                                checkPassword();
                            } else {
                                Toast.makeText(getContext(), "Số lượng phải là bội số của 100", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "UPCOM":
                            if (khoiLuong % 100 == 0) {
                                checkPassword();
                            } else {
                                Toast.makeText(getContext(), "Số lượng phải là bội số của 100", Toast.LENGTH_SHORT).show();
                            }
                            break;
                    }
                }
            }
        });
    }

    private void customSpinner(String[] listType) {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, listType);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spnValueLoaiLenh.setAdapter(dataAdapter);
    }

    private void checkPassword() {
        if (binding.edtValueMatKhau.getText().toString().equals(tk.getMatKhau())) {
            presenter.checkGiaoDich(tk, binding.edtValueMaCk.getText().toString(), binding.edtValueSoLuong.getText().toString(),
                    binding.spnValueLoaiLenh.getSelectedItem().toString(), binding.edtValueGiaMua.getText().toString(), banMin, muaMax);

            binding.llProgressFragmentSell.setVisibility(View.VISIBLE);

        } else {
            Toast.makeText(getContext(), "Sai mật khẩu!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getCKFail() {
        binding.llProgressFragmentSell.setVisibility(View.GONE);
        Toast.makeText(getContext(), R.string.find_stock_fail, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getCKDone(ChungKhoan chungKhoan) {
        binding.llProgressFragmentSell.setVisibility(View.GONE);
        binding.llTtCk.setVisibility(View.VISIBLE);
        binding.tvMaCk.setText(chungKhoan.getMaCk());
        binding.tvGiaTran.setText(Define.formatDouble(Double.parseDouble(chungKhoan.getGiaTran())));
        binding.tvGiaThamChieu.setText(Define.formatDouble(Double.parseDouble(chungKhoan.getGiaTC())));
        binding.tvGiaSan.setText(Define.formatDouble(Double.parseDouble(chungKhoan.getGiaSan())));

        binding.tvValueSanGd.setText(chungKhoan.getSanGd());

        switch (chungKhoan.getSanGd()) {
            case "HSX":
                customSpinner(termHSX);
                break;
            case "HNX":
                customSpinner(termHNX);
                break;
            case "UPCOM":
                customSpinner(termUPCOM);
                break;
            default:
                break;
        }
    }

    @Override
    public void getTTCKDone(String ban, String klBan, String mua, String klMua) {
        binding.llProgressFragmentSell.setVisibility(View.GONE);
        binding.tvGiaBanMin.setText(Define.formatDouble(Double.parseDouble(ban)* 1000));
        binding.tvKhoiLuongBan.setText(Define.formatDouble(Double.valueOf(klBan)));
        binding.giaMuaMax.setText(Define.formatDouble(Double.parseDouble(mua)* 1000));
        binding.tvKhoiLuongMua.setText(Define.formatDouble(Double.valueOf(klMua)));
        binding.edtValueGiaMua.setText(binding.tvGiaBanMin.getText().toString());
        this.gia= String.valueOf(Double.parseDouble(ban)* 1000);
        banMin= String.valueOf(Double.parseDouble(ban)* 1000);
        muaMax= String.valueOf(Double.parseDouble(mua)* 1000);
    }

    @Override
    public void connectNetworkFail() {
        binding.llProgressFragmentSell.setVisibility(View.GONE);
        Toast.makeText(getContext(), R.string.connect_net_fail, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectServerFail() {
        binding.llProgressFragmentSell.setVisibility(View.GONE);
        Toast.makeText(getContext(), R.string.connect_server_fail, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void transactionFail() {
        binding.llProgressFragmentSell.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Giao dịch lỗi! Đặt loại lệnh không trong giờ giao dịch", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void transactionDone() {
        binding.llProgressFragmentSell.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Giao dịch thành công!", Toast.LENGTH_SHORT).show();

        getActivity().finish();
        getActivity().startActivity(new Intent(getContext(), MainActivity.class));
    }

    @Override
    public void findStockFail() {
        binding.llProgressFragmentSell.setVisibility(View.GONE);
        Toast.makeText(getContext(), R.string.dont_find_stock, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoad() {
        binding.llProgressFragmentSell.setVisibility(View.VISIBLE);
    }

    @Override
    public void failTransByMoney() {
        binding.llProgressFragmentSell.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Số tiền bạn có không đủ giao dịch này!", Toast.LENGTH_SHORT).show();
    }
}

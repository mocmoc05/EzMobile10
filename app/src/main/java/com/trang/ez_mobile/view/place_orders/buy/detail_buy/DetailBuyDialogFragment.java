package com.trang.ez_mobile.view.place_orders.buy.detail_buy;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.DialogFragmentBuyBinding;
import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.view.place_orders.object.ChungKhoan;
import com.trang.ez_mobile.view.splash_screen.MainActivity;
import com.trang.ez_mobile.view.user.login.TaiKhoan;

/**
 * Created by TraPTH on 5/23/2018.
 */
public class DetailBuyDialogFragment extends DialogFragment implements IDetailBuy {
    private DialogFragmentBuyBinding binding;
    private TaiKhoan tk;
    private ChungKhoan chungKhoan;
    private String maCk;
    private String khoiLuong;
    private DetailBuyPresenter presenter;
    private String[] termHNX = {"LO", "MTL", "MAK", "MOK", "ATC"};
    private String[] termHSX = {"LO", "ATO", "MP", "ATC"};
    private String[] termUPCOM = {"LO"};
    private String banMin;
    private String muaMax;

    public static DetailBuyDialogFragment newInstance(String ma_ck, String khoiLuong, TaiKhoan taiKhoan) {
        DetailBuyDialogFragment dialogFragment= new DetailBuyDialogFragment();
        Bundle args = new Bundle();
        args.putString("ma_ck", ma_ck);
        args.putString("khoi_luong", khoiLuong);
        args.putSerializable("tai_khoan", taiKhoan);
        dialogFragment.setArguments(args);
        return dialogFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, R.layout.dialog_fragment_buy, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tk = (TaiKhoan) getArguments().getSerializable("tai_khoan");
        maCk= getArguments().getString("ma_ck");
        khoiLuong= getArguments().getString("khoi_luong");
        binding.tvValueStockBalance.setText(khoiLuong);

        presenter= new DetailBuyPresenter(this);
        presenter.seachStock(maCk);

        initAction();

    }

    private void initAction() {
        binding.spnValueLoaiLenh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (binding.spnValueLoaiLenh.getSelectedItem().equals("LO")) {
                    binding.tvValueGiaMua.setVisibility(View.VISIBLE);
                    binding.tvValueGiaMua.setText(binding.tvGiaMuaTotNhat.getText().toString());
                } else {
                    binding.tvValueGiaMua.setText("");
                    binding.tvValueGiaMua.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.btnXacNhanMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.tvValueSoLuong.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "Bạn chưa nhập khối lượng giao dịch", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(khoiLuong) < Integer.parseInt(binding.tvValueSoLuong.getText().toString())) {
                    Toast.makeText(getContext(), "Khối lượng đặt bán vượt quá khối lượng bạn có", Toast.LENGTH_SHORT).show();
                } else {
                    int khoiLuong = Integer.parseInt(binding.tvValueSoLuong.getText().toString());
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

    private void checkPassword() {
        if (binding.tvValueMatKhau.getText().toString().equals(tk.getMatKhau())) {
            presenter.checkGiaoDich(tk, binding.tvValueMaCk.getText().toString(), binding.tvValueSoLuong.getText().toString(),
                    binding.spnValueLoaiLenh.getSelectedItem().toString(), binding.tvValueGiaMua.getText().toString(), banMin, muaMax);
        } else {
            Toast.makeText(getContext(), "Sai mật khẩu!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getCKFail() {
        Toast.makeText(getContext(), R.string.find_stock_fail, Toast.LENGTH_SHORT).show();
        getDialog().dismiss();
    }

    @Override
    public void getCKDone(ChungKhoan chungKhoan) {
        binding.tvValueMaCk.setText(maCk);
        binding.tvMaCk.setText(maCk);
        binding.tvGiaTran.setText(Define.formatDouble(Double.parseDouble(chungKhoan.getGiaTran())));
        binding.tvGiaThamChieu.setText(Define.formatDouble(Double.parseDouble(chungKhoan.getGiaTC())));
        binding.tvGiaSan.setText(Define.formatDouble(Double.parseDouble(chungKhoan.getGiaSan())));
        binding.tvValueSanGd.setText(chungKhoan.getSanGd());
        binding.tvValueSoLuong.setText(khoiLuong);
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
    public void connectNetworkFail() {
        Toast.makeText(getContext(), R.string.connect_net_fail, Toast.LENGTH_SHORT).show();
        getDialog().dismiss();
    }

    @Override
    public void connectServerFail() {
        Toast.makeText(getContext(), R.string.connect_server_fail, Toast.LENGTH_SHORT).show();
        getDialog().dismiss();
    }

    @Override
    public void transactionFail() {
        Toast.makeText(getContext(), "Giao dịch lỗi! Đặt loại lệnh không trong giờ giao dịch", Toast.LENGTH_SHORT).show();
        getDialog().dismiss();
    }

    @Override
    public void transactionDone() {
        Toast.makeText(getContext(), "Giao dịch thành công!", Toast.LENGTH_SHORT).show();
        getDialog().dismiss();

        getActivity().finish();
        getActivity().startActivity(new Intent(getContext(), MainActivity.class));
    }

    @Override
    public void findStockFail() {
        Toast.makeText(getContext(), R.string.dont_find_stock, Toast.LENGTH_SHORT).show();
        getDialog().dismiss();
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void getTTCKDone(String ban, String klBan, String mua, String klMua) {
        banMin= String.valueOf(Double.parseDouble(ban)*1000);
        muaMax= String.valueOf(Double.parseDouble(mua)*1000);

        binding.tvGiaMuaTotNhat.setText(Define.formatString(muaMax));
        binding.tvKhoiLuongMua.setText(Define.formatString(klMua));
        binding.tvGiaBanTotNhat.setText(Define.formatString(banMin));
        binding.tvKhoiLuongBan.setText(Define.formatString(klBan));
        binding.tvValueGiaMua.setText(muaMax);
    }

    private void customSpinner(String[] listType) {
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, listType);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        binding.spnValueLoaiLenh.setAdapter(dataAdapter);
    }
}

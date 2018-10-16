package com.trang.ez_mobile.view.advance_report.ungtien;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.DialogAdvanceReportBinding;
import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.view.splash_screen.MainActivity;
import com.trang.ez_mobile.view.user.login.TaiKhoan;

/**
 * Created by TraPTH on 5/27/2018.
 */
public class UngTienDialogFragment extends DialogFragment implements IUngTien{
    private DialogAdvanceReportBinding binding;
    private TaiKhoan tk;
    private UngTienPresenter presenter;

    public static UngTienDialogFragment newInstance(TaiKhoan taiKhoan) {
        UngTienDialogFragment fragment= new UngTienDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tai_khoan", taiKhoan);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, R.layout.dialog_advance_report, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tk = (TaiKhoan) getArguments().getSerializable("tai_khoan");
        binding.tvValueSotiendangco.setText(Define.formatDouble(Double.parseDouble(tk.getSoDuTien())));
        binding.tvMaxTienung.setText(Define.formatDouble(Double.parseDouble(tk.getTienDangVe())- Double.parseDouble(tk.getSoTienUng())));

        presenter= new UngTienPresenter(this, tk);
//        presenter.checkUngTien();
        initAction();
    }

    private void initAction() {
        binding.btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.edtNhaptienung.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "Bạn chưa nhập số tiền ứng", Toast.LENGTH_SHORT).show();
                } else {
                    presenter.checkUngTien(binding.edtNhaptienung.getText().toString());
                }
            }
        });
    }

    @Override
    public void UngTienDone() {
        getDialog().dismiss();
        Toast.makeText(getContext(), "Ứng tiền thành công", Toast.LENGTH_SHORT).show();

        getActivity().finish();
        getActivity().startActivity(new Intent(getContext(), MainActivity.class));
    }

    @Override
    public void UngTienFail() {
        Toast.makeText(getContext(), "Số tiền ứng vượt quá số cho phép", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectServerFail() {
        Toast.makeText(getContext(), R.string.connect_server_fail, Toast.LENGTH_SHORT).show();
        getDialog().dismiss();
    }

    @Override
    public void connectNetworkFail() {
        Toast.makeText(getContext(), R.string.connect_net_fail, Toast.LENGTH_SHORT).show();
        getDialog().dismiss();
    }
}

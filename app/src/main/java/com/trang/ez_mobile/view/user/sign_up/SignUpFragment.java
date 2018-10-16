package com.trang.ez_mobile.view.user.sign_up;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.FragmentSignUpBinding;
import com.trang.ez_mobile.view.splash_screen.MainActivity;

/**
 * Created by TraPTH on 5/14/2018.
 */
public class SignUpFragment extends Fragment implements ISignUp {
    private FragmentSignUpBinding binding;
    private SignUpPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false);

        //An ActionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new SignUpPresenter(this);

        initAction();
    }

    private void initAction() {
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.edtAccountSign.getText().toString() == null || binding.edtAccountSign.getText().toString().equals("")) {
                    Toast.makeText(getContext(), getString(R.string.you_dont_account), Toast.LENGTH_SHORT).show();
                } else if (binding.edtPasswordSign.getText().toString() == null || binding.edtPasswordSign.getText().toString().equals("")) {
                    Toast.makeText(getContext(), getString(R.string.you_dont_password), Toast.LENGTH_SHORT).show();
                } else {
                    binding.llProgressFragmentSignUp.setVisibility(View.VISIBLE);
                    presenter.insertAccount(binding.edtAccountSign.getText().toString(), binding.edtPasswordSign.getText().toString());
                }
            }
        });

        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
                getActivity().startActivity(new Intent(getContext(), MainActivity.class));
            }
        });
    }

    @Override
    public void insertDone() {
        binding.llProgressFragmentSignUp.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Đăng ký tài khoản thành công", Toast.LENGTH_SHORT).show();
        getActivity().finish();
        getActivity().startActivity(new Intent(getContext(), MainActivity.class));
    }

    @Override
    public void insertFail() {
        binding.llProgressFragmentSignUp.setVisibility(View.GONE);
        try {
            Toast.makeText(getContext(), "Mã tài khoản đã có", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connectServerFail() {
        binding.llProgressFragmentSignUp.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Connect Server Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectNetworkFail() {
        binding.llProgressFragmentSignUp.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Connect Network Fail", Toast.LENGTH_SHORT).show();
    }
}

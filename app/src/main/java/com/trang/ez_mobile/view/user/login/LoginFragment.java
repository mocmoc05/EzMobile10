package com.trang.ez_mobile.view.user.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.ContentMainBinding;
import com.trang.ez_mobile.databinding.FragmentLoginBinding;
import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.view.home.HomeFrag2;
import com.trang.ez_mobile.view.splash_screen.MainActivity;
import com.trang.ez_mobile.view.user.navi.CustomNavigation;
import com.trang.ez_mobile.view.user.sign_up.SignUpFragment;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TraPTH on 4/14/2018.
 */
public class LoginFragment extends Fragment implements ILogin {
    private FragmentLoginBinding binding;
    private String strAccount;
    private String strPassword;
    private LoginPresenter presenter;

    //Luu trang thai
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String keyShered = "account";
    private String keyCheck= "check_account";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);

        //An ActionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new LoginPresenter(this);
        sharedPreferences = App.getInstance().getSharedPreferences(Define.SHARED_PREFERENCES_ACCOUNT, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        initAction();
    }

    private void initAction() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strAccount = binding.edtAccount.getText().toString();
                strPassword = binding.edtPassword.getText().toString();

                if (strAccount == null || strAccount.equals("")) {
                    Toast.makeText(getContext(), getString(R.string.you_dont_account), Toast.LENGTH_SHORT).show();
                } else if (strPassword == null || strPassword.equals("")) {
                    Toast.makeText(getContext(), getString(R.string.you_dont_password), Toast.LENGTH_SHORT).show();
                } else {
                    presenter.checkConnect(strAccount, strPassword);
                }

            }
        });

        binding.tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new SignUpFragment());
            }
        });
    }

    @Override
    public void loginSuccess(TaiKhoan taiKhoan) {
        Toast.makeText(getContext(), "Login Successful", Toast.LENGTH_SHORT).show();
        if (binding.cbLuuMk.isChecked()) {
            editor.putBoolean(keyCheck, true);
        } else {
            editor.putBoolean(keyCheck, false);
        }
        saveTaiKhoan(taiKhoan);

        getActivity().finish();
        getActivity().startActivity(new Intent(getContext(), MainActivity.class));
    }

    @Override
    public void loginFail() {
        Toast.makeText(getContext(), "Tài khoản hoặc mật khẩu sai", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoad() {
    }

    @Override
    public void errorConnect() {
        Toast.makeText(getContext(), "Error Connect", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void errorConnectServer() {
        Toast.makeText(getContext(), "Error Connect Server", Toast.LENGTH_SHORT).show();
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ContentMainBinding mainBinding = ContentMainBinding.inflate(LayoutInflater.from(getContext()));

        ft.replace(mainBinding.contentview.getId(), fragment);
        ft.commit();
    }

//    public List<TaiKhoan> getList(String key) {
//        Gson gson = new Gson();
//        List<TaiKhoan> list = new ArrayList<>();
//
//        String json = get(key);
//        Type type = new TypeToken<List<TaiKhoan>>() {
//        }.getType();
//        list = gson.fromJson(json, type);
//
//        return list;
//    }
//
//    public String get(String key) {
//        return sharedPreferences.getString(key, "");
//    }
//
//    public <T> void setList(String key, List<T> list) {
//        Gson gson = new Gson();
//        String json = gson.toJson(list);
//
//        set(key, json);
//    }
//
//    public void set(String key, String value) {
//        editor.putString(key, value);
//        editor.commit();
//    }

    public void saveTaiKhoan(TaiKhoan taiKhoan) {
        Gson gson = new Gson();
        String json = gson.toJson(taiKhoan);
        editor.putString(keyShered, json);
        editor.commit();
    }
}

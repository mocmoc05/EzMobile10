package com.trang.ez_mobile.view.advance_report;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.FragmentAdvanceReportBinding;
import com.trang.ez_mobile.view.advance_report.ungtien.UngTienDialogFragment;
import com.trang.ez_mobile.view.asset_report.stock_balance.StockBalanceAdapter;
import com.trang.ez_mobile.view.place_orders.buy.detail_buy.DetailBuyDialogFragment;
import com.trang.ez_mobile.view.place_orders.object.UngTien;
import com.trang.ez_mobile.view.user.login.TaiKhoan;

import java.util.List;

/**
 * Created by TraPTH on 5/18/2018.
 */
public class AdvanceReportFragment extends Fragment implements IAdvanceReport {
    private FragmentAdvanceReportBinding binding;
    private TaiKhoan tk;
    private AdvanceReportPresenter presenter;
    private AdvanceReportAdaptor adapter;

    public static AdvanceReportFragment newInstance(TaiKhoan taiKhoan) {
        AdvanceReportFragment fragment = new AdvanceReportFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tai_khoan", taiKhoan);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_advance_report, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.advance_report);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tk = (TaiKhoan) getArguments().getSerializable("tai_khoan");

        presenter = new AdvanceReportPresenter(this);
        presenter.getData(tk.getMaTK());

        initAction();
    }

    private void initAction() {
        binding.btnUngtien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                UngTienDialogFragment dialogFragment = UngTienDialogFragment.newInstance(tk);
                dialogFragment.show(fragmentManager, null);
            }
        });
    }

    @Override
    public void getDataDone(List<UngTien> ungTienList) {
        binding.llProgressFragmentAdvanceReport.setVisibility(View.GONE);
        adapter = new AdvanceReportAdaptor(ungTienList);
        binding.rcvListUngtruoc.setAdapter(adapter);
        binding.rcvListUngtruoc.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getDataFail() {
        binding.llProgressFragmentAdvanceReport.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Get Data Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectServerFail() {
        binding.llProgressFragmentAdvanceReport.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Connect Server Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectNetworkFail() {
        binding.llProgressFragmentAdvanceReport.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Connect Network Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoad() {
        binding.llProgressFragmentAdvanceReport.setVisibility(View.VISIBLE);
    }
}

package com.trang.ez_mobile.view.world_indeces;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.util.custormView.TextViewFont;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TraPTH on 3/16/2018.
 */

public class WorldIndecesFragment extends Fragment implements WorldIndecesInterface.View {
    private List<WorldIndeces> list;
    private WorldIndecesInterface.Presenter presenter;
    private WorldIndecesAdapter adapter;

    private TextViewFont tv_title_chiso, tv_title_gia, tv_title_thaydoi, tv_title_thaydoi_ptram;
    private RecyclerView rcv_world_indeces;
    private LinearLayout ll_progress_world;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_world_indeces, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.world_index);

        initView(view);
        ll_progress_world.setVisibility(View.VISIBLE);

        list = new ArrayList<>();

        presenter = new WorldIndecesPresenter(getContext(), this, list);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.callData();
            }
        }, 100);

        return view;
    }

    private void initView(View view) {
        tv_title_chiso = (TextViewFont) view.findViewById(R.id.tv_title_chiso);
        tv_title_gia = (TextViewFont) view.findViewById(R.id.tv_title_gia);
        tv_title_thaydoi = (TextViewFont) view.findViewById(R.id.tv_title_thaydoi);
        tv_title_thaydoi_ptram = (TextViewFont) view.findViewById(R.id.tv_title_thaydoi_ptram);
        rcv_world_indeces = (RecyclerView) view.findViewById(R.id.rcv_world_indeces);
        ll_progress_world= (LinearLayout) view.findViewById(R.id.ll_progress_world);

        tv_title_chiso.setText(getString(R.string.indexes));
        tv_title_gia.setText(getString(R.string.last));
        tv_title_thaydoi.setText(getString(R.string.change));
        tv_title_thaydoi_ptram.setText(getString(R.string.change_percent));
    }

    @Override
    public void dataDone(List<WorldIndeces> worldIndecesList) {
        adapter = new WorldIndecesAdapter(worldIndecesList, getContext());
        rcv_world_indeces.setAdapter(adapter);
        //Them dong ke giua item
        rcv_world_indeces.addItemDecoration(new DividerItemDecoration(getContext(), 1));

        adapter.notifyDataSetChanged();

        ll_progress_world.setVisibility(View.GONE);
    }

    @Override
    public void dataFail() {
        ll_progress_world.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Data Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoad() {
        ll_progress_world.setVisibility(View.VISIBLE);
    }

    @Override
    public void connectFail() {
        ll_progress_world.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Connect Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectServerFail() {
        ll_progress_world.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Connect Server Fail", Toast.LENGTH_SHORT).show();
    }
}

package com.trang.ez_mobile.view.news.home.tin_fpts;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.view.news.detail.NewsDetailFragment;
import com.trang.ez_mobile.view.news.home.TinTuc;
import com.trang.ez_mobile.view.news.home.TinTucAdapter;
import com.trang.ez_mobile.view.news.home.TinTucInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TraPTH on 2/22/2018.
 */

@SuppressLint("ValidFragment")
public class TinFPTSFragment extends Fragment implements TinTucInterface.View {
    private TinTucInterface.Presenter presenter;
    private List<TinTuc> tinTucList;
    private TinTucAdapter adapter;

    //Anh xa
    private RecyclerView lvTinTuc;
    private LinearLayout ll_progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tin_thi_truong, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvTinTuc = (RecyclerView) view.findViewById(R.id.lvTinThiTruong);
        ll_progressBar = (LinearLayout) view.findViewById(R.id.ll_progressBar);

        tinTucList = new ArrayList<>();
        presenter = new TinFPTSPresenter(App.getInstance(), this, tinTucList);
        presenter.getData();

    }

    @Override
    public void getDataDone(List<TinTuc> tinTucList, String folder) {
        adapter = new TinTucAdapter(tinTucList, App.getInstance(), folder, this);
        lvTinTuc.setAdapter(adapter);
        lvTinTuc.setLayoutManager(new LinearLayoutManager(getContext()));
        lvTinTuc.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        adapter.notifyDataSetChanged();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ll_progressBar.setVisibility(View.GONE);
            }
        }, 1000);
    }

    @Override
    public void getDataFail() {
        ll_progressBar.setVisibility(View.GONE);
        Toast.makeText(getActivity(), "ErrorDatabase", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoad() {
        ll_progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void connectFail() {
        ll_progressBar.setVisibility(View.GONE);
        Toast.makeText(getActivity(), "ErrorConnect", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void moveFragmentView(String id, String img, String folder) {
//        ContentMainBinding mainBinding = ContentMainBinding.inflate(LayoutInflater.from(getContext()));

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

//        transaction.replace(mainBinding.fragmentFrame.getId(), new NewsDetailFragment(id, img, folder));
        transaction.replace(R.id.contentview, new NewsDetailFragment(id, img, folder));

        transaction.addToBackStack("");
        transaction.commit();

    }

    @Override
    public void connectServerFail() {
        ll_progressBar.setVisibility(View.GONE);
        Toast.makeText(getActivity(), "Error Connect Server, Check Your Network", Toast.LENGTH_SHORT).show();
    }
}

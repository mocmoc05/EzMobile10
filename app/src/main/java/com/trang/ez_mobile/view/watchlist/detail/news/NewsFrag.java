package com.trang.ez_mobile.view.watchlist.detail.news;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.model.entity.NewsArticle;

import java.util.List;

public class NewsFrag extends Fragment implements INewsView {
    private String symbol;
    NewsPresenter presenter;
    NewsAdapter adapter;

    RecyclerView recyclerView;

    public NewsFrag() {
    }

    public static NewsFrag newInstance(String symbol) {
        NewsFrag fragment = new NewsFrag();
        Bundle args = new Bundle();
        args.putString("symbol", symbol);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            symbol = getArguments().getString("symbol");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_watchlist_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerview);

        presenter = new NewsPresenter(this, symbol);

    }

    @Override
    public void Display(List<NewsArticle> articles) {

        adapter = new NewsAdapter(articles);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(App.getInstance()));

        adapter.notifyDataSetChanged();
    }
}

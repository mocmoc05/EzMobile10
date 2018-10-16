package com.trang.ez_mobile.view.watchlist.detail.news;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.model.entity.NewsArticle;
import com.trang.ez_mobile.util.custormView.SquareImageView;
import com.trang.ez_mobile.util.custormView.TextViewFont;

import java.util.List;

/**
 * Created by FIT-thuctap22 on 3/23/2018.
 */

public class NewsAdapter extends RecyclerView.Adapter {
    List<NewsArticle> newsArticleList;

    public NewsAdapter(List<NewsArticle> newsArticleList) {
        this.newsArticleList = newsArticleList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_watchlist_news, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyHolder) holder).bind(newsArticleList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsArticleList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextViewFont title;
        SquareImageView icon;

        public MyHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textview_title);
            icon = itemView.findViewById(R.id.square_imageview_icon);
        }

        public void bind(NewsArticle obj) {
            title.setText(obj.getNewsTitle());
            icon.setImageDrawable(App.getInstance().getResources().getDrawable(R.drawable.icon_app));
        }
    }
}

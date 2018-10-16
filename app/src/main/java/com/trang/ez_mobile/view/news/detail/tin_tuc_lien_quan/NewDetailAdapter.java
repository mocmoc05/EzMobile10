package com.trang.ez_mobile.view.news.detail.tin_tuc_lien_quan;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.util.custormView.TextViewFont;
import com.trang.ez_mobile.view.news.detail.NewsDetailInterface;

import java.util.List;

/**
 * Created by TraPTH on 2/12/2018.
 */

public class NewDetailAdapter extends RecyclerView.Adapter<NewDetailAdapter.MyViewHolder> {
    private List<TinTucLienQuan> newList;
    private Context context;
    private String folder;
    private NewsDetailInterface.View v;

    public NewDetailAdapter(List<TinTucLienQuan> newList, Context context, String folder, NewsDetailInterface.View v) {
        this.newList = newList;
        this.context = context;
        this.folder = folder;
        this.v = v;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tin_lien_quan, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvTitle.setText(newList.get(position).getStringTitle());
        holder.tvDate.setText(newList.get(position).getStringDate());

        if (newList.get(position).getStringImg().equals("")) {
            holder.imgNews.setImageResource(R.drawable.icon_app);
        } else {
            loadImg(holder.imgNews, newList.get(position).getStringImg());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v.moveFragment(newList.get(position).getStringId(), newList.get(position).getStringImg(), folder);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newList.size();
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImg(ImageView imageView, String url) {
        if (!url.equals("")) {
            Glide.with(imageView.getContext())
                    .load(url)
                    .into(imageView);
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgNews;
        TextViewFont tvTitle, tvDate;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgNews= (ImageView) itemView.findViewById(R.id.imgNews);
            tvTitle= (TextViewFont) itemView.findViewById(R.id.tvTitle);
            tvDate= (TextViewFont) itemView.findViewById(R.id.tvDate);
        }
    }
}

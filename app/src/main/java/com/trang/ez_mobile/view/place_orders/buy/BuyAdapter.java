package com.trang.ez_mobile.view.place_orders.buy;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.util.custormView.TextViewFont;
import com.trang.ez_mobile.databinding.ItemFragmentBuyBinding;
import com.trang.ez_mobile.view.place_orders.object.BaoCaoTaiSanCk;
import com.trang.ez_mobile.view.place_orders.object.GiaoDich;

import java.util.List;

/**
 * Created by TraPTH on 5/23/2018.
 */
public class BuyAdapter extends RecyclerView.Adapter<BuyAdapter.MyViewHolder> {
    private List<BaoCaoTaiSanCk> taiSanCkList;
    private IBuy v;
    private ItemFragmentBuyBinding binding;

    public BuyAdapter(List<BaoCaoTaiSanCk> taiSanCkList, IBuy v) {
       this.taiSanCkList= taiSanCkList;
       this.v= v;
    }

    @NonNull
    @Override
    public BuyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_fragment_buy, parent, false);

        return new BuyAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BuyAdapter.MyViewHolder holder, int position) {
        holder.binding.tvMaCkItemFragBuy.setText(taiSanCkList.get(position).getMaCk());
        holder.binding.tvSoLuongItemFragBuy.setText(taiSanCkList.get(position).getKhoiLuong());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v.moveFragmentBuy(taiSanCkList.get(position).getMaCk(), taiSanCkList.get(position).getKhoiLuong());
            }
        });
    }

    @Override
    public int getItemCount() {
        return taiSanCkList.size();
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
        ItemFragmentBuyBinding binding;

        public MyViewHolder(ItemFragmentBuyBinding binding) {
            super(binding.getRoot());
            this.binding= binding;
        }
    }
}

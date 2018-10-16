package com.trang.ez_mobile.view.asset_report.stock_balance;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.ItemStockBalanceBinding;
import com.trang.ez_mobile.view.place_orders.buy.IBuy;
import com.trang.ez_mobile.view.place_orders.object.BaoCaoTaiSanCk;

import java.util.List;

/**
 * Created by TraPTH on 5/27/2018.
 */
public class StockBalanceAdapter extends RecyclerView.Adapter<StockBalanceAdapter.MyViewHolder> {
    private List<BaoCaoTaiSanCk> taiSanCkList;
    private ItemStockBalanceBinding binding;

    public StockBalanceAdapter(List<BaoCaoTaiSanCk> taiSanCkList) {
        this.taiSanCkList = taiSanCkList;
    }

    @NonNull
    @Override
    public StockBalanceAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_stock_balance, parent, false);

        return new StockBalanceAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StockBalanceAdapter.MyViewHolder holder, int position) {
        holder.binding.tvMaCkStockBalance.setText(taiSanCkList.get(position).getMaCk());
        int tongKl = Integer.parseInt(taiSanCkList.get(position).getKhoiLuongCho()) + Integer.parseInt(taiSanCkList.get(position).getKhoiLuong());
        holder.binding.tvTongSl.setText(String.valueOf(tongKl));
        holder.binding.tvDangChoVe.setText(taiSanCkList.get(position).getKhoiLuongCho());
        holder.binding.tvSlHienTai.setText(taiSanCkList.get(position).getKhoiLuong());

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
        ItemStockBalanceBinding binding;

        public MyViewHolder(ItemStockBalanceBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

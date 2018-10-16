package com.trang.ez_mobile.view.advance_report;

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
import com.trang.ez_mobile.databinding.ItemFragAdvanceReportBinding;
import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.view.place_orders.buy.IBuy;
import com.trang.ez_mobile.view.place_orders.object.BaoCaoTaiSanCk;
import com.trang.ez_mobile.view.place_orders.object.UngTien;

import java.util.List;

/**
 * Created by TraPTH on 5/27/2018.
 */
public class AdvanceReportAdaptor extends RecyclerView.Adapter<AdvanceReportAdaptor.MyViewHolder>{
    private List<UngTien> ungTienList;
    private ItemFragAdvanceReportBinding binding;

    public AdvanceReportAdaptor(List<UngTien> ungTienList) {
        this.ungTienList= ungTienList;
    }

    @NonNull
    @Override
    public AdvanceReportAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_frag_advance_report, parent, false);

        return new AdvanceReportAdaptor.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdvanceReportAdaptor.MyViewHolder holder, int position) {
        holder.binding.tvNgayung.setText(ungTienList.get(position).getNgayUng());
        holder.binding.tvSotien.setText(Define.formatDouble(Double.parseDouble(ungTienList.get(position).getSoTien())));
        holder.binding.tvTinhtrang.setText(ungTienList.get(position).getTinhTrang());
    }

    @Override
    public int getItemCount() {
        return ungTienList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemFragAdvanceReportBinding binding;

        public MyViewHolder(ItemFragAdvanceReportBinding binding) {
            super(binding.getRoot());
            this.binding= binding;
        }
    }
}

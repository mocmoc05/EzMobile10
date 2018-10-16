package com.trang.ez_mobile.view.world_indeces;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trang.ez_mobile.R;

import java.util.List;

/**
 * Created by TraPTH on 3/16/2018.
 */

public class WorldIndecesAdapter extends RecyclerView.Adapter<WorldIndecesAdapter.MyViewHolder> {
    private List<WorldIndeces> list;
    private Context context;

    public WorldIndecesAdapter(List<WorldIndeces> list, Context context) {
        this.list = list;
        this.context = context;
//        this.list.add(new WorldIndeces("a", "1", "1", "1"));
//        this.list.add(new WorldIndeces("b", "1", "0", "0"));
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_world_indeces, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.binding.setWorldIndeces(list.get(position));
        if (Float.parseFloat(list.get(position).getThayDoi()) < 0) {
            holder.tv_value_gia.setTextColor(Color.parseColor("#ff4444"));
            holder.tv_value_thaydoi.setTextColor(Color.parseColor("#ff4444"));
            holder.tv_value_thaydoi_ptram.setTextColor(Color.parseColor("#ff4444"));

        } else if (Float.parseFloat(list.get(position).getThayDoi()) > 0) {
            holder.tv_value_gia.setTextColor(Color.parseColor("#11a12c"));
            holder.tv_value_thaydoi.setTextColor(Color.parseColor("#11a12c"));
            holder.tv_value_thaydoi_ptram.setTextColor(Color.parseColor("#11a12c"));

        } else {
            holder.tv_value_gia.setTextColor(Color.parseColor("#f2c80d"));
            holder.tv_value_thaydoi.setTextColor(Color.parseColor("#f2c80d"));
            holder.tv_value_thaydoi_ptram.setTextColor(Color.parseColor("#f2c80d"));
        }

        holder.tv_value_chiso.setText(list.get(position).getChiSo());
        holder.tv_value_gia.setText(list.get(position).getGia());
        holder.tv_value_thaydoi.setText(list.get(position).getThayDoi());
        holder.tv_value_thaydoi_ptram.setText(list.get(position).getThayDoiPhanTram());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_value_chiso, tv_value_gia, tv_value_thaydoi, tv_value_thaydoi_ptram;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_value_chiso = (TextView) itemView.findViewById(R.id.tv_value_chiso);
            tv_value_gia = (TextView) itemView.findViewById(R.id.tv_value_gia);
            tv_value_thaydoi = (TextView) itemView.findViewById(R.id.tv_value_thaydoi);
            tv_value_thaydoi_ptram = (TextView) itemView.findViewById(R.id.tv_value_thaydoi_ptram);
        }
    }
}

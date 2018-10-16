package com.trang.ez_mobile.view.events;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.ItemEventFragmentBinding;

import java.util.List;

/**
 * Created by TraPTH on 3/19/2018.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {
    private ItemEventFragmentBinding binding;
    private List<Event> list;
    private Context context;

    public EventAdapter(List<Event> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_event_fragment, parent, false);
        View view = binding.getRoot();

        return new MyViewHolder(view, binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.setEvent(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemEventFragmentBinding binding;

        public MyViewHolder(View itemView, ItemEventFragmentBinding binding) {
            super(itemView);
            this.binding = binding;
        }
    }
}

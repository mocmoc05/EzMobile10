package com.trang.ez_mobile.view.chart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.trang.ez_mobile.util.custormView.TextViewFont;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FIT-thuctap22 on 2/27/2018.
 */
public class Adapter_filter extends BaseAdapter implements Filterable {

    private List<String> originalItems;
    private List<String> filteredItems;
    private int layoutResource;
    private Context context;

    public Adapter_filter(Context context, int resource, List<String> items) {
        this.context = context;
        this.layoutResource = resource;
        this.originalItems = items;
        this.filteredItems = new ArrayList<String>(originalItems);
    }

    @Override
    public int getCount() {
        return filteredItems.size();
    }

    @Override
    public String getItem(int position) {
        return filteredItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        String item = getItem(position);
        if (convertView == null) {
            convertView = inflater.inflate(layoutResource, parent, false);
        }
        ((TextViewFont) convertView).setText(item);
        return convertView;
    }

    @Override
    public Filter getFilter() {
        return new SpecialFilter();
    }

    private class SpecialFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            // If there is no constraint, just return the original list of items
            if (constraint == null || constraint.length() == 0) {
                ArrayList<String> list = new ArrayList<String>(originalItems);
                results.values = list;
                results.count = list.size();
            }
            // Else, only return the strings that start with the constraint
            else {
                String prefixString = constraint.toString().toLowerCase();
                ArrayList<String> values = new ArrayList<String>(originalItems);
                final ArrayList<String> newValues = new ArrayList<String>();

                for (String value : values) {
                    final String valueText = value.toLowerCase();
                    if (valueText.startsWith(prefixString)) {
                        newValues.add(value);
                    }
                }

                results.values = newValues;
                results.count = newValues.size();
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredItems = (List<String>) results.values;
            if (results.count > 0) {
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }
    }
}
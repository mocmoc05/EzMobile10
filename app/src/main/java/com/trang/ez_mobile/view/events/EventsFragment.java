package com.trang.ez_mobile.view.events;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.FragmentEventBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TraPTH on 3/16/2018.
 */

public class EventsFragment extends Fragment implements EventsInterface.View {
    private FragmentEventBinding binding;
    private EventAdapter adapter;
    private List<Event> list;
    private EventsInterface.Presenter presenter;

    private SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
    private String date;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_event, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.events);

        View view = binding.getRoot();

        binding.llProgressFragmentEvent.setVisibility(View.VISIBLE);
        binding.llFragmentEvent.setVisibility(View.GONE);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Lay ngay hien tai
        date = formatDate.format(binding.calendarView.getDate());

        list = new ArrayList<>();
        presenter = new EventsPresenter(list, getContext(), this);
        presenter.callData(date);

        //lang nghe su kien khi click ngay
        binding.calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String thang, ngay;
                if (i2 < 10) {
                    ngay = "0" + i2;
                } else {
                    ngay = i2 + "";
                }

                if (i1 < 10) {
                    thang = "0" + (i1 + 1);
                } else {
                    thang = i1 + "";
                }

                presenter.onClickCalendarView(ngay + "/" + thang + "/" + i);
            }
        });
    }

    @Override
    public void dataDone(List<Event> list) {
        adapter = new EventAdapter(list, getContext());
        binding.rcvEvent.setAdapter(adapter);
        //Dau gach ngang giua cac item
        binding.rcvEvent.addItemDecoration(new DividerItemDecoration(getContext(), 1));

        adapter.notifyDataSetChanged();

        binding.llProgressFragmentEvent.setVisibility(View.GONE);
        binding.llFragmentEvent.setVisibility(View.VISIBLE);
    }

    @Override
    public void dataFail() {
        binding.llProgressFragmentEvent.setVisibility(View.GONE);
        binding.llFragmentEvent.setVisibility(View.VISIBLE);
        Toast.makeText(getContext(), "Get Data Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoad() {
        binding.llProgressFragmentEvent.setVisibility(View.VISIBLE);
        binding.llFragmentEvent.setVisibility(View.GONE);
    }

    @Override
    public void connectFail() {
        binding.llProgressFragmentEvent.setVisibility(View.GONE);
        binding.llFragmentEvent.setVisibility(View.VISIBLE);
        Toast.makeText(getContext(), "Connect Network Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectServerFail() {
        binding.llProgressFragmentEvent.setVisibility(View.GONE);
        binding.llFragmentEvent.setVisibility(View.VISIBLE);
        Toast.makeText(getContext(), "Connect Server Fail", Toast.LENGTH_SHORT).show();
    }
}

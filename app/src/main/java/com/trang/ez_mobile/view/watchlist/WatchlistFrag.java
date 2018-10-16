package com.trang.ez_mobile.view.watchlist;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bin.david.form.data.CellInfo;
import com.bin.david.form.data.Column;
import com.bin.david.form.data.format.bg.BaseCellBackgroundFormat;
import com.bin.david.form.data.format.bg.ICellBackgroundFormat;
import com.bin.david.form.data.format.draw.TextImageDrawFormat;
import com.bin.david.form.data.format.title.TitleImageDrawFormat;
import com.bin.david.form.data.style.FontStyle;
import com.bin.david.form.data.table.TableData;
import com.bin.david.form.utils.DensityUtils;
import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.ContentMainBinding;
import com.trang.ez_mobile.databinding.FragmentWatchlistBinding;
import com.trang.ez_mobile.util.ColorTr;
import com.trang.ez_mobile.view.watchlist.detail.DetailFrag;
import com.trang.ez_mobile.view.watchlist.model.Price;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class WatchlistFrag extends Fragment implements IWatchlistView {
    FragmentWatchlistBinding binding;
    private TableData<Price> tableData;
    private WatchlistPresenter presenter;
//    private ProgressDialog ringProgressDialog;
    //    IWatchlistView iWatchlistView;
    Typeface fontString;

    public WatchlistFrag() {
//        this.iWatchlistView = view;
    }

    public static WatchlistFrag newInstance() {
        WatchlistFrag frag = new WatchlistFrag();
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWatchlistBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.bang_gia);
        fontString = Typeface.createFromAsset(App.getInstance().getAssets(), "font/FreeSansBold.ttf");

        binding.smarttable.getConfig().setFixedTitle(true);
        binding.smarttable.getConfig().setContentBackgroundColor(getResources().getColor(R.color.colorBackground));
        binding.smarttable.getConfig().setFixedCountRow(false);
        binding.smarttable.getConfig().setShowYSequence(false);
        binding.smarttable.getConfig().setShowXSequence(false);
        binding.smarttable.setZoom(true, 1.5f, 0.5f);
        binding.smarttable.getConfig().setColumnTitleBackgroundColor(getResources().getColor(R.color.colorBackground));

        binding.smarttable.getConfig().setShowTableTitle(false);
        //sắp xếp
        binding.smarttable.setOnColumnClickListener(columnInfo -> {
            if (!columnInfo.column.getFieldName().equals("mack")) {
                binding.smarttable.setSortColumn(columnInfo.column, !columnInfo.column.isReverseSort());
            }
            presenter.destroy();
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        if (presenter != null)
            presenter.destroy();
        binding.smarttable.destroyDrawingCache();
    }

    @Override
    public void onResume() {
        super.onResume();
        super.onResume();
        presenter = new WatchlistPresenter(this);
    }

    @Override
    public void displayTable(TableData<Price> data) {
        int size = DensityUtils.dp2px(App.getInstance(), 15);
        data.setTitleDrawFormat(new TitleImageDrawFormat(size, size, TitleImageDrawFormat.RIGHT, 10) {
            @Override
            protected Context getContext() {
                return App.getInstance();
            }

            @Override
            protected int getResourceID(Column column) {
                if (!column.isParent()) {
                    if (data.getSortColumn() == column) {
                        setDirection(TextImageDrawFormat.LEFT);
                        if (column.isReverseSort()) {
                            return R.mipmap.sort_up;
                        }
                        return R.mipmap.sort_down;
                    }
                    return 0;
                }
                return 0;
            }
        });

        setBackground(data);
        binding.smarttable.getConfig().setHorizontalPadding(50);
        binding.smarttable.getConfig().setVerticalPadding(15);
        binding.smarttable.getConfig().setColumnTitleHorizontalPadding(50);
        binding.smarttable.getConfig().setColumnTitleVerticalPadding(15);

        FontStyle fontStyle = new FontStyle();
        FontStyle fontStyle1 = new FontStyle();

        fontStyle.setTextColor(App.getInstance().getResources().getColor(R.color.colorFont));
        fontStyle1.setTextColor(App.getInstance().getResources().getColor(R.color.colorFont));

        fontStyle.setTypeface(fontString);
        fontStyle.setAlign(Paint.Align.RIGHT);
        fontStyle1.setAlign(Paint.Align.RIGHT);

        binding.smarttable.getConfig().setContentStyle(fontStyle);
        binding.smarttable.getConfig().setColumnTitleStyle(fontStyle1);
        binding.smarttable.setTableData(data);
        this.tableData = data;
    }

    @Override
    public void moveFragment(String symbol, String color, String name, String code) {
        ContentMainBinding mainBinding = ContentMainBinding.inflate(LayoutInflater.from(getContext()));
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(mainBinding.contentview.getId(), new DetailFrag().newInstance(symbol, color, name, code));
        transaction.addToBackStack("");
        transaction.commit();
    }

    @Override
    public void loading() {
//        ringProgressDialog = ProgressDialog.show(getContext(), "Loading...", null, true);
        binding.progressBar.setVisibility(View.VISIBLE);
        if (getActivity() != null) {
            getActivity().setProgressBarIndeterminateVisibility(false);
        }
    }

    @Override
    public void loadSuccess() {
        if (getActivity() != null) {
            getActivity().setProgressBarIndeterminateVisibility(true);
        }
        binding.progressBar.setVisibility(View.GONE);
//        ringProgressDialog.dismiss();
    }

    private void setBackground(final TableData<Price> data) {
        ICellBackgroundFormat<CellInfo> backgroundFormat = new BaseCellBackgroundFormat<CellInfo>() {

            @Override
            public int getBackGroundColor(CellInfo cellInfo) {
                Price item1 = tableData.getT().get(cellInfo.position);
                Price item = data.getT().get(cellInfo.position);
//                if (!ColorTr.changeColor(item1.getKl(), item.getKl()) && cellInfo.column.getFieldName().equals("kl"))
//                    return getResources().getColor(R.color.colorChange);
                return getResources().getColor(R.color.colorBackground);
            }

            @Override
            public int getTextColor(CellInfo cellInfo) {
                Price item = data.getT().get(cellInfo.position);
                if (cellInfo.column.getFieldName().equals("nnban"))
                    return ColorTr.PURPLE_TEXT_COLOR;
                if (cellInfo.column.getFieldName().equals("san")) return ColorTr.BLUE_TEXT_COLOR;
                if (cellInfo.column.getFieldName().equals("tc")) return ColorTr.PURPLE_TEXT_COLOR;
                if (cellInfo.column.getFieldName().equals("di"))
                    return ColorTr.setWacthListDetailColor(item, item.getGiakhop());
                if (cellInfo.column.getFieldName().equals("mack"))
                    return ColorTr.changeColormck(item.getColor());
                if (cellInfo.column.getFieldName().equals("gm3"))
                    return ColorTr.setQuotesColorTextViewMrkBWL(item.getGm3(), item);
                if (cellInfo.column.getFieldName().equals("gm2"))
                    return ColorTr.setQuotesColorTextViewMrkBWL(item.getGm2(), item);
                if (cellInfo.column.getFieldName().equals("gm1"))
                    return ColorTr.setQuotesColorTextViewMrkBWL(item.getGm1(), item);
                if (cellInfo.column.getFieldName().equals("gb1"))
                    return ColorTr.setQuotesColorTextViewMrkBWL(item.getGb1(), item);
                if (cellInfo.column.getFieldName().equals("gb2"))
                    return ColorTr.setQuotesColorTextViewMrkBWL(item.getGb2(), item);
                if (cellInfo.column.getFieldName().equals("gb3"))
                    return ColorTr.setQuotesColorTextViewMrkBWL(item.getGb3(), item);
                if (cellInfo.column.getFieldName().equals("mo"))
                    return ColorTr.setTextViewColorOpen(item.getMo(), item.getTc());
                if (cellInfo.column.getFieldName().equals("thap"))
                    return ColorTr.setTextViewColorOpen(item.getThap(), item.getTc());
                if (cellInfo.column.getFieldName().equals("cao"))
                    return ColorTr.setTextViewColorOpen(item.getCao(), item.getTc());
                return getResources().getColor(R.color.colorFont);
            }
        };
        binding.smarttable.getConfig().setContentBackgroundFormat(backgroundFormat);
    }
}

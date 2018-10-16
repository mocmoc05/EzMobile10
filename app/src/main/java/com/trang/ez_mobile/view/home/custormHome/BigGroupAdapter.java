package com.trang.ez_mobile.view.home.custormHome;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.databinding.ItemHomeIndexesLayoutBinding;
import com.trang.ez_mobile.databinding.LayoutHomeHeaderSubNumberBinding;
import com.trang.ez_mobile.databinding.LayoutHomeHeaderSubTextBinding;
import com.trang.ez_mobile.databinding.LayoutHomeItemNumberBinding;
import com.trang.ez_mobile.databinding.LayoutHomeItemheaderBinding;
import com.trang.ez_mobile.model.entity.StockMarket;
import com.trang.ez_mobile.util.Define;
import com.trang.ez_mobile.util.ErrorApp;
import com.trang.ez_mobile.view.home.IHomeView;
import com.trang.ez_mobile.view.user.navi.INavView;

import java.util.ArrayList;
import java.util.List;

import static com.trang.ez_mobile.util.Define.HOME_TYPE_BANG_GIA_PHAI_SINH;
import static com.trang.ez_mobile.util.Define.HOME_TYPE_INDEXES;
import static com.trang.ez_mobile.util.Define.HOME_TYPE_NEWS;
import static com.trang.ez_mobile.util.Define.HOME_TYPE_WATCHLIST;
import static com.trang.ez_mobile.util.Define.HOME_TYPE_WORLD_INDEXES;

/**
 * Created by TraPTH on 2/1/2018.
 */

public class BigGroupAdapter extends BaseExpandableListAdapter implements INavView.IOnClickListener {
    private SparseArray<BigGroup> sparseArray;
    IHomeView.IBiggroupCallBack iBiggroupCallBack;
    Activity activity;
    List<View> indexesView;
    List<View> watchListView;
    List<View> newsView;
    List<View> worldIndexView;

    public BigGroupAdapter(SparseArray<BigGroup> sparseArray, Activity activity,
                           IHomeView.IBiggroupCallBack iBiggroupCallBack) {
        this.sparseArray = sparseArray;
        this.activity = activity;
        watchListView = new ArrayList<>();
        this.iBiggroupCallBack = iBiggroupCallBack;
        newsView = new ArrayList<>();
        worldIndexView = new ArrayList<>();
        indexesView = new ArrayList<>();
    }

    @Override
    public int getGroupCount() {
        return sparseArray.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (sparseArray.get(groupPosition) != null)
            return sparseArray.get(groupPosition).getGroupSparseArray().size();
        else return 0;
    }

    @Override
    public BigGroup getGroup(int groupPosition) {
        if (sparseArray != null)
            return sparseArray.get(groupPosition);
        else return new BigGroup(HOME_TYPE_INDEXES, "", new SparseArray<>());
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public ItemHomeChild getChild(int groupPosition, int childPosition) {
        return sparseArray.get(groupPosition).getGroupSparseArray().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, final boolean isExpanded, View convertView, ViewGroup parent) {
        if (groupPosition == 0) {
            //INDEXES
            if (indexesView.size() > groupPosition) {
                return indexesView.get(0);
            }
            indexesView = new ArrayList<>();
            final ItemHomeIndexesLayoutBinding indexesLayoutBinding =
                    ItemHomeIndexesLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            new BigGroupPresenter(new IHomeView.IBigGroupView() {
                @Override
                public void onDisplay(List<StockMarket> stockMarkets) {
                    indexesLayoutBinding.recyclerView.setAdapter(new IndexesAdapter(stockMarkets, marketCode -> {
                        if (iBiggroupCallBack != null) {
                            iBiggroupCallBack.onReplaceFragment(marketCode, HOME_TYPE_INDEXES);
                        }
                    }));
                    indexesLayoutBinding.recyclerView.setLayoutManager(
                            new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
                }

                @Override
                public void onError(ErrorApp error) {
                }
            });
//            return new IndexesHolder(indexesLayoutBinding).itemView;
            indexesView.add(new IndexesHolder(indexesLayoutBinding).itemView);
            return indexesView.get(0);
        }

        final LayoutHomeItemheaderBinding headerBinding =
                LayoutHomeItemheaderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        headerBinding.txtTitleHeader.setText(getGroup(groupPosition).getTitle());
        switch (getGroup(groupPosition).getType()) {
            case HOME_TYPE_NEWS:
                headerBinding.imageviewAdd.setVisibility(View.GONE);
                headerBinding.imageviewEdit.setVisibility(View.GONE);
                headerBinding.imageviewDetail.setVisibility(View.VISIBLE);
                headerBinding.imageviewDetail.setOnClickListener(v -> iBiggroupCallBack.onReplaceFragment(HOME_TYPE_NEWS, Define.HOME_TYPE_ACTION.ACTION_DETAIL));
                break;
            case HOME_TYPE_WORLD_INDEXES:
                headerBinding.imageviewAdd.setVisibility(View.GONE);
                headerBinding.imageviewEdit.setVisibility(View.GONE);
                headerBinding.imageviewDetail.setVisibility(View.VISIBLE);
                headerBinding.imageviewDetail.setOnClickListener(v -> iBiggroupCallBack.onReplaceFragment(HOME_TYPE_WORLD_INDEXES, Define.HOME_TYPE_ACTION.ACTION_DETAIL));
                break;

            case HOME_TYPE_WATCHLIST:
                headerBinding.imageviewAdd.setVisibility(View.VISIBLE);
                headerBinding.imageviewEdit.setVisibility(View.VISIBLE);
                headerBinding.imageviewDetail.setVisibility(View.VISIBLE);
                headerBinding.imageviewAdd.setOnClickListener(v -> iBiggroupCallBack.onReplaceFragment(HOME_TYPE_WATCHLIST, Define.HOME_TYPE_ACTION.ACTION_ADD));
                headerBinding.imageviewEdit.setOnClickListener(v -> iBiggroupCallBack.onReplaceFragment(HOME_TYPE_WATCHLIST, Define.HOME_TYPE_ACTION.ACTION_EDIT));
                headerBinding.imageviewDetail.setOnClickListener(v -> iBiggroupCallBack.onReplaceFragment(HOME_TYPE_WATCHLIST, Define.HOME_TYPE_ACTION.ACTION_DETAIL));
                break;
            case HOME_TYPE_BANG_GIA_PHAI_SINH:
                headerBinding.imageviewAdd.setVisibility(View.VISIBLE);
                headerBinding.imageviewEdit.setVisibility(View.VISIBLE);
                headerBinding.imageviewDetail.setVisibility(View.VISIBLE);
                headerBinding.imageviewAdd.setOnClickListener(v -> iBiggroupCallBack.onReplaceFragment(HOME_TYPE_BANG_GIA_PHAI_SINH, Define.HOME_TYPE_ACTION.ACTION_ADD));
                headerBinding.imageviewEdit.setOnClickListener(v -> iBiggroupCallBack.onReplaceFragment(HOME_TYPE_BANG_GIA_PHAI_SINH, Define.HOME_TYPE_ACTION.ACTION_EDIT));
                headerBinding.imageviewDetail.setOnClickListener(v -> iBiggroupCallBack.onReplaceFragment(HOME_TYPE_BANG_GIA_PHAI_SINH, Define.HOME_TYPE_ACTION.ACTION_DETAIL));
                break;
            default:
                break;
        }

        return (new HeaderHolder(headerBinding)).itemView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ItemHomeChild itemHomeChild = sparseArray.get(groupPosition).getGroupSparseArray().get(childPosition);
        switch (itemHomeChild.getTypeView()) {
            case HOME_TYPE_WATCHLIST:
                if (watchListView.size() > childPosition) {
                    return watchListView.get(childPosition);
                }
                break;
            case HOME_TYPE_NEWS:
                if (newsView.size() > childPosition) {
                    return newsView.get(childPosition);
                }
                break;
            case HOME_TYPE_BANG_GIA_PHAI_SINH:
                break;
            case HOME_TYPE_INDEXES:
                break;
            case HOME_TYPE_WORLD_INDEXES:
                if (worldIndexView.size() > childPosition) {
                    return worldIndexView.get(childPosition);
                }
            default:
                break;
        }
        switch (itemHomeChild.getTypeView()) {
            case HOME_TYPE_WATCHLIST: {
                if (childPosition == 0) {
                    watchListView = new ArrayList<>();
                    LayoutHomeHeaderSubNumberBinding subNumerBinding =
                            LayoutHomeHeaderSubNumberBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                    ItemHeaderNumber itemHeaderNumber = (ItemHeaderNumber) itemHomeChild;
                    subNumerBinding.txtIndices.setText(itemHeaderNumber.getIndices());
                    subNumerBinding.txtLast.setText(itemHeaderNumber.getLast());
                    subNumerBinding.txtChange.setText(itemHeaderNumber.getChange());
                    subNumerBinding.txtQty.setText(itemHeaderNumber.getQty());
                    watchListView.add(new SubHeaderHolder(subNumerBinding).itemView);
                    return watchListView.get(0);
                } else {
                    LayoutHomeItemNumberBinding numberBinding =
                            LayoutHomeItemNumberBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                    ItemNumber itemNumber = (ItemNumber) itemHomeChild;
                    numberBinding.txtIndices.setText(itemNumber.getIndices());
                    numberBinding.txtIndices.setTextColor(App.getInstance().getResources().getColor(R.color.blue_text));
                    numberBinding.txtLast.setText(itemNumber.getLast());
                    numberBinding.txtChange.setText(itemNumber.getChange());
                    numberBinding.txtQty.setText(itemNumber.getQty());
                    switch (itemNumber.getColorCode()) {
                        case "u":
                            numberBinding.txtChange.setTextColor(App.getInstance().getResources().getColor(R.color.green));
                            numberBinding.txtLast.setTextColor(App.getInstance().getResources().getColor(R.color.green));
                            break;
                        case "d":
                            numberBinding.txtChange.setTextColor(App.getInstance().getResources().getColor(R.color.red));
                            numberBinding.txtLast.setTextColor(App.getInstance().getResources().getColor(R.color.red));
                            break;
                        case "r":
                            numberBinding.txtChange.setTextColor(App.getInstance().getResources().getColor(R.color.orange));
                            numberBinding.txtLast.setTextColor(App.getInstance().getResources().getColor(R.color.orange));
                            break;
                        case "c":
                            numberBinding.txtChange.setTextColor(App.getInstance().getResources().getColor(R.color.purple));
                            numberBinding.txtLast.setTextColor(App.getInstance().getResources().getColor(R.color.purple));
                            break;
                        case "f":
                            numberBinding.txtChange.setTextColor(App.getInstance().getResources().getColor(R.color.blue_text));
                            numberBinding.txtLast.setTextColor(App.getInstance().getResources().getColor(R.color.blue_text));
                            break;
                        case "o":
                            numberBinding.txtChange.setTextColor(App.getInstance().getResources().getColor(R.color.green));
                            numberBinding.txtLast.setTextColor(App.getInstance().getResources().getColor(R.color.green));
                            break;
                        case "b"://không giao dịch
                            numberBinding.txtChange.setTextColor(App.getInstance().getResources().getColor(R.color.orange));
                            numberBinding.txtLast.setTextColor(App.getInstance().getResources().getColor(R.color.orange));
                        default:
                            break;
                    }
                    watchListView.add(new ChildHolder(numberBinding).itemView);
                    return watchListView.get(watchListView.size() > 0 ? watchListView.size() - 1 : 0);
                }
            }
            case HOME_TYPE_NEWS: {
                LayoutHomeHeaderSubTextBinding textBinding =
                        LayoutHomeHeaderSubTextBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                ItemNewsEvents newsEvents = (ItemNewsEvents) itemHomeChild;
                textBinding.txtTextContent.setText(newsEvents.getTitle());
                textBinding.txtDate.setText(newsEvents.getDateTime());
                newsView.add(new NewsEventHolder(textBinding).itemView);
                return newsView.get(newsView.size() > 0 ? newsView.size() - 1 : 0);
            }
            case HOME_TYPE_BANG_GIA_PHAI_SINH:
            case HOME_TYPE_INDEXES:
            case HOME_TYPE_WORLD_INDEXES:
            default:
                if (childPosition == 0) {
                    worldIndexView = new ArrayList<>();
                    LayoutHomeHeaderSubNumberBinding subNumerBinding =
                            LayoutHomeHeaderSubNumberBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                    ItemHeaderNumber itemHeaderNumber = (ItemHeaderNumber) itemHomeChild;
                    subNumerBinding.txtIndices.setText(itemHeaderNumber.getIndices());
                    subNumerBinding.txtLast.setText(itemHeaderNumber.getLast());
                    subNumerBinding.txtChange.setText(itemHeaderNumber.getChange());
                    subNumerBinding.txtQty.setText(itemHeaderNumber.getChangeRatio());
                    worldIndexView.add(new SubHeaderHolder(subNumerBinding).itemView);
                    return worldIndexView.get(0);
                } else {
                    LayoutHomeItemNumberBinding numberBinding =
                            LayoutHomeItemNumberBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                    ItemNumber itemNumber = (ItemNumber) itemHomeChild;
                    numberBinding.txtIndices.setText(itemNumber.getIndices());
                    numberBinding.txtLast.setText(itemNumber.getLast());
                    numberBinding.txtChange.setText(itemNumber.getChange());
                    numberBinding.txtQty.setText(itemNumber.getChangeRatio());
                    try {
                        double color = Double.parseDouble(itemNumber.getChange());
                        if (color > 0) {
                            numberBinding.txtChange.setTextColor(App.getInstance().getResources().getColor(R.color.green));
                            numberBinding.txtLast.setTextColor(App.getInstance().getResources().getColor(R.color.green));
                            numberBinding.txtQty.setTextColor(App.getInstance().getResources().getColor(R.color.green));
                        } else if (color == 0) {
                            numberBinding.txtChange.setTextColor(App.getInstance().getResources().getColor(R.color.orange));
                            numberBinding.txtLast.setTextColor(App.getInstance().getResources().getColor(R.color.orange));
                            numberBinding.txtQty.setTextColor(App.getInstance().getResources().getColor(R.color.orange));
                        } else {
                            numberBinding.txtChange.setTextColor(App.getInstance().getResources().getColor(R.color.red));
                            numberBinding.txtLast.setTextColor(App.getInstance().getResources().getColor(R.color.red));
                            numberBinding.txtQty.setTextColor(App.getInstance().getResources().getColor(R.color.red));
                        }
                    } catch (Exception e) {
                    }
                    worldIndexView.add(new ChildHolder(numberBinding).itemView);
                    return worldIndexView.get(worldIndexView.size() - 1);
                }
        }
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public void onClickItemListener(int id, int type) {
//        iOnClickListener.onClickItemListener(id, type);
    }

    class HeaderHolder extends RecyclerView.ViewHolder {
        LayoutHomeItemheaderBinding binding;

        public HeaderHolder(LayoutHomeItemheaderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    class ChildHolder extends RecyclerView.ViewHolder {
        LayoutHomeItemNumberBinding numberBinding;

        public ChildHolder(LayoutHomeItemNumberBinding numberBinding) {
            super(numberBinding.getRoot());
            this.numberBinding = numberBinding;
        }
    }

    class NewsEventHolder extends RecyclerView.ViewHolder {
        public NewsEventHolder(LayoutHomeHeaderSubTextBinding textBinding) {
            super(textBinding.getRoot());
        }
    }

    class SubHeaderHolder extends RecyclerView.ViewHolder {
        public SubHeaderHolder(LayoutHomeHeaderSubNumberBinding subNumerBinding) {
            super(subNumerBinding.getRoot());
        }
    }

    class IndexesHolder extends RecyclerView.ViewHolder {

        public IndexesHolder(ItemHomeIndexesLayoutBinding indexesLayoutBinding) {
            super(indexesLayoutBinding.getRoot());
        }
    }
}

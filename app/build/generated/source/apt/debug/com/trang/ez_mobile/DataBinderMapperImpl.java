package com.trang.ez_mobile;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.trang.ez_mobile.databinding.ActivityCrashBindingImpl;
import com.trang.ez_mobile.databinding.ActivityMainBindingImpl;
import com.trang.ez_mobile.databinding.AppBarMainBindingImpl;
import com.trang.ez_mobile.databinding.ContentMainBindingImpl;
import com.trang.ez_mobile.databinding.DialogAdvanceReportBindingImpl;
import com.trang.ez_mobile.databinding.DialogChartCustomBindingImpl;
import com.trang.ez_mobile.databinding.DialogFragmentBuyBindingImpl;
import com.trang.ez_mobile.databinding.FragmentAdvanceReportBindingImpl;
import com.trang.ez_mobile.databinding.FragmentAssetReportBindingImpl;
import com.trang.ez_mobile.databinding.FragmentBuyBindingImpl;
import com.trang.ez_mobile.databinding.FragmentCashBalanceBindingImpl;
import com.trang.ez_mobile.databinding.FragmentChartBindingImpl;
import com.trang.ez_mobile.databinding.FragmentEventBindingImpl;
import com.trang.ez_mobile.databinding.FragmentHomeBindingImpl;
import com.trang.ez_mobile.databinding.FragmentLoginBindingImpl;
import com.trang.ez_mobile.databinding.FragmentMarketOverviewBindingImpl;
import com.trang.ez_mobile.databinding.FragmentMarketOverviewChartBindingImpl;
import com.trang.ez_mobile.databinding.FragmentMarketOverviewDetailBindingImpl;
import com.trang.ez_mobile.databinding.FragmentMarketOverviewHnxBindingImpl;
import com.trang.ez_mobile.databinding.FragmentMarketOverviewHsxBindingImpl;
import com.trang.ez_mobile.databinding.FragmentMarketoverviewDetailMostActiveBindingImpl;
import com.trang.ez_mobile.databinding.FragmentMarketoverviewDetailTopGainersBindingImpl;
import com.trang.ez_mobile.databinding.FragmentMarketoverviewDetailTopLosersBindingImpl;
import com.trang.ez_mobile.databinding.FragmentNewsBindingImpl;
import com.trang.ez_mobile.databinding.FragmentPlaceOrdersBindingImpl;
import com.trang.ez_mobile.databinding.FragmentSellBindingImpl;
import com.trang.ez_mobile.databinding.FragmentSignUpBindingImpl;
import com.trang.ez_mobile.databinding.FragmentStockBalanceBindingImpl;
import com.trang.ez_mobile.databinding.FragmentWatchlistBindingImpl;
import com.trang.ez_mobile.databinding.FragmentWatchlistChartBindingImpl;
import com.trang.ez_mobile.databinding.FragmentWatchlistDetailBindingImpl;
import com.trang.ez_mobile.databinding.FragmentWatchlistFinanceOverviewBindingImpl;
import com.trang.ez_mobile.databinding.FragmentWatchlistFinancialFiguresBindingImpl;
import com.trang.ez_mobile.databinding.FragmentWatchlistForeignOwnershipBindingImpl;
import com.trang.ez_mobile.databinding.FragmentWatchlistNewsBindingImpl;
import com.trang.ez_mobile.databinding.FragmentWatchlistStatisticsBindingImpl;
import com.trang.ez_mobile.databinding.FragmentWatchlistTradingBindingImpl;
import com.trang.ez_mobile.databinding.ItemEventFragmentBindingImpl;
import com.trang.ez_mobile.databinding.ItemFragAdvanceReportBindingImpl;
import com.trang.ez_mobile.databinding.ItemFragmentBuyBindingImpl;
import com.trang.ez_mobile.databinding.ItemHomeIndexesItemviewBindingImpl;
import com.trang.ez_mobile.databinding.ItemHomeIndexesLayoutBindingImpl;
import com.trang.ez_mobile.databinding.ItemMainMenuBiggroupContentBindingImpl;
import com.trang.ez_mobile.databinding.ItemMainMenuBiggroupHeaderAccountBindingImpl;
import com.trang.ez_mobile.databinding.ItemMainMenuBiggroupHeaderBindingImpl;
import com.trang.ez_mobile.databinding.ItemMainMenuGroupContentBindingImpl;
import com.trang.ez_mobile.databinding.ItemMainMenuGroupHeaderBindingImpl;
import com.trang.ez_mobile.databinding.ItemMainMenuRecyclerviewContentBindingImpl;
import com.trang.ez_mobile.databinding.ItemMarketOverviewRecyclerviewMarketBindingImpl;
import com.trang.ez_mobile.databinding.ItemMarketOverviewRecyclerviewMarketDetailBindingImpl;
import com.trang.ez_mobile.databinding.ItemStockBalanceBindingImpl;
import com.trang.ez_mobile.databinding.ItemWatchlistFinancialBindingImpl;
import com.trang.ez_mobile.databinding.ItemWatchlistNewsBindingImpl;
import com.trang.ez_mobile.databinding.LayoutHomeHeaderSubNumberBindingImpl;
import com.trang.ez_mobile.databinding.LayoutHomeHeaderSubTextBindingImpl;
import com.trang.ez_mobile.databinding.LayoutHomeItemNumberBindingImpl;
import com.trang.ez_mobile.databinding.LayoutHomeItemheaderBindingImpl;
import com.trang.ez_mobile.databinding.NavUserLayoutBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYCRASH = 1;

  private static final int LAYOUT_ACTIVITYMAIN = 2;

  private static final int LAYOUT_APPBARMAIN = 3;

  private static final int LAYOUT_CONTENTMAIN = 4;

  private static final int LAYOUT_DIALOGADVANCEREPORT = 5;

  private static final int LAYOUT_DIALOGCHARTCUSTOM = 6;

  private static final int LAYOUT_DIALOGFRAGMENTBUY = 7;

  private static final int LAYOUT_FRAGMENTADVANCEREPORT = 8;

  private static final int LAYOUT_FRAGMENTASSETREPORT = 9;

  private static final int LAYOUT_FRAGMENTBUY = 10;

  private static final int LAYOUT_FRAGMENTCASHBALANCE = 11;

  private static final int LAYOUT_FRAGMENTCHART = 12;

  private static final int LAYOUT_FRAGMENTEVENT = 13;

  private static final int LAYOUT_FRAGMENTHOME = 14;

  private static final int LAYOUT_FRAGMENTLOGIN = 15;

  private static final int LAYOUT_FRAGMENTMARKETOVERVIEW = 16;

  private static final int LAYOUT_FRAGMENTMARKETOVERVIEWCHART = 17;

  private static final int LAYOUT_FRAGMENTMARKETOVERVIEWDETAIL = 18;

  private static final int LAYOUT_FRAGMENTMARKETOVERVIEWHNX = 19;

  private static final int LAYOUT_FRAGMENTMARKETOVERVIEWHSX = 20;

  private static final int LAYOUT_FRAGMENTMARKETOVERVIEWDETAILMOSTACTIVE = 21;

  private static final int LAYOUT_FRAGMENTMARKETOVERVIEWDETAILTOPGAINERS = 22;

  private static final int LAYOUT_FRAGMENTMARKETOVERVIEWDETAILTOPLOSERS = 23;

  private static final int LAYOUT_FRAGMENTNEWS = 24;

  private static final int LAYOUT_FRAGMENTPLACEORDERS = 25;

  private static final int LAYOUT_FRAGMENTSELL = 26;

  private static final int LAYOUT_FRAGMENTSIGNUP = 27;

  private static final int LAYOUT_FRAGMENTSTOCKBALANCE = 28;

  private static final int LAYOUT_FRAGMENTWATCHLIST = 29;

  private static final int LAYOUT_FRAGMENTWATCHLISTCHART = 30;

  private static final int LAYOUT_FRAGMENTWATCHLISTDETAIL = 31;

  private static final int LAYOUT_FRAGMENTWATCHLISTFINANCEOVERVIEW = 32;

  private static final int LAYOUT_FRAGMENTWATCHLISTFINANCIALFIGURES = 33;

  private static final int LAYOUT_FRAGMENTWATCHLISTFOREIGNOWNERSHIP = 34;

  private static final int LAYOUT_FRAGMENTWATCHLISTNEWS = 35;

  private static final int LAYOUT_FRAGMENTWATCHLISTSTATISTICS = 36;

  private static final int LAYOUT_FRAGMENTWATCHLISTTRADING = 37;

  private static final int LAYOUT_ITEMEVENTFRAGMENT = 38;

  private static final int LAYOUT_ITEMFRAGADVANCEREPORT = 39;

  private static final int LAYOUT_ITEMFRAGMENTBUY = 40;

  private static final int LAYOUT_ITEMHOMEINDEXESITEMVIEW = 41;

  private static final int LAYOUT_ITEMHOMEINDEXESLAYOUT = 42;

  private static final int LAYOUT_ITEMMAINMENUBIGGROUPCONTENT = 43;

  private static final int LAYOUT_ITEMMAINMENUBIGGROUPHEADER = 44;

  private static final int LAYOUT_ITEMMAINMENUBIGGROUPHEADERACCOUNT = 45;

  private static final int LAYOUT_ITEMMAINMENUGROUPCONTENT = 46;

  private static final int LAYOUT_ITEMMAINMENUGROUPHEADER = 47;

  private static final int LAYOUT_ITEMMAINMENURECYCLERVIEWCONTENT = 48;

  private static final int LAYOUT_ITEMMARKETOVERVIEWRECYCLERVIEWMARKET = 49;

  private static final int LAYOUT_ITEMMARKETOVERVIEWRECYCLERVIEWMARKETDETAIL = 50;

  private static final int LAYOUT_ITEMSTOCKBALANCE = 51;

  private static final int LAYOUT_ITEMWATCHLISTFINANCIAL = 52;

  private static final int LAYOUT_ITEMWATCHLISTNEWS = 53;

  private static final int LAYOUT_LAYOUTHOMEHEADERSUBNUMBER = 54;

  private static final int LAYOUT_LAYOUTHOMEHEADERSUBTEXT = 55;

  private static final int LAYOUT_LAYOUTHOMEITEMNUMBER = 56;

  private static final int LAYOUT_LAYOUTHOMEITEMHEADER = 57;

  private static final int LAYOUT_NAVUSERLAYOUT = 58;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(58);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.activity_crash, LAYOUT_ACTIVITYCRASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.app_bar_main, LAYOUT_APPBARMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.content_main, LAYOUT_CONTENTMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.dialog_advance_report, LAYOUT_DIALOGADVANCEREPORT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.dialog_chart_custom, LAYOUT_DIALOGCHARTCUSTOM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.dialog_fragment_buy, LAYOUT_DIALOGFRAGMENTBUY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_advance_report, LAYOUT_FRAGMENTADVANCEREPORT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_asset_report, LAYOUT_FRAGMENTASSETREPORT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_buy, LAYOUT_FRAGMENTBUY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_cash_balance, LAYOUT_FRAGMENTCASHBALANCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_chart, LAYOUT_FRAGMENTCHART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_event, LAYOUT_FRAGMENTEVENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_market_overview, LAYOUT_FRAGMENTMARKETOVERVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_market_overview_chart, LAYOUT_FRAGMENTMARKETOVERVIEWCHART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_market_overview_detail, LAYOUT_FRAGMENTMARKETOVERVIEWDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_market_overview_hnx, LAYOUT_FRAGMENTMARKETOVERVIEWHNX);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_market_overview_hsx, LAYOUT_FRAGMENTMARKETOVERVIEWHSX);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_marketoverview_detail_most_active, LAYOUT_FRAGMENTMARKETOVERVIEWDETAILMOSTACTIVE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_marketoverview_detail_top_gainers, LAYOUT_FRAGMENTMARKETOVERVIEWDETAILTOPGAINERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_marketoverview_detail_top_losers, LAYOUT_FRAGMENTMARKETOVERVIEWDETAILTOPLOSERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_news, LAYOUT_FRAGMENTNEWS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_place_orders, LAYOUT_FRAGMENTPLACEORDERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_sell, LAYOUT_FRAGMENTSELL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_sign_up, LAYOUT_FRAGMENTSIGNUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_stock_balance, LAYOUT_FRAGMENTSTOCKBALANCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_watchlist, LAYOUT_FRAGMENTWATCHLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_watchlist_chart, LAYOUT_FRAGMENTWATCHLISTCHART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_watchlist_detail, LAYOUT_FRAGMENTWATCHLISTDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_watchlist_finance_overview, LAYOUT_FRAGMENTWATCHLISTFINANCEOVERVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_watchlist_financial_figures, LAYOUT_FRAGMENTWATCHLISTFINANCIALFIGURES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_watchlist_foreign_ownership, LAYOUT_FRAGMENTWATCHLISTFOREIGNOWNERSHIP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_watchlist_news, LAYOUT_FRAGMENTWATCHLISTNEWS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_watchlist_statistics, LAYOUT_FRAGMENTWATCHLISTSTATISTICS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.fragment_watchlist_trading, LAYOUT_FRAGMENTWATCHLISTTRADING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.item_event_fragment, LAYOUT_ITEMEVENTFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.item_frag_advance_report, LAYOUT_ITEMFRAGADVANCEREPORT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.item_fragment_buy, LAYOUT_ITEMFRAGMENTBUY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.item_home_indexes_itemview, LAYOUT_ITEMHOMEINDEXESITEMVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.item_home_indexes_layout, LAYOUT_ITEMHOMEINDEXESLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.item_main_menu_biggroup_content, LAYOUT_ITEMMAINMENUBIGGROUPCONTENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.item_main_menu_biggroup_header, LAYOUT_ITEMMAINMENUBIGGROUPHEADER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.item_main_menu_biggroup_header_account, LAYOUT_ITEMMAINMENUBIGGROUPHEADERACCOUNT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.item_main_menu_group_content, LAYOUT_ITEMMAINMENUGROUPCONTENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.item_main_menu_group_header, LAYOUT_ITEMMAINMENUGROUPHEADER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.item_main_menu_recyclerview_content, LAYOUT_ITEMMAINMENURECYCLERVIEWCONTENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.item_market_overview_recyclerview_market, LAYOUT_ITEMMARKETOVERVIEWRECYCLERVIEWMARKET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.item_market_overview_recyclerview_market_detail, LAYOUT_ITEMMARKETOVERVIEWRECYCLERVIEWMARKETDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.item_stock_balance, LAYOUT_ITEMSTOCKBALANCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.item_watchlist_financial, LAYOUT_ITEMWATCHLISTFINANCIAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.item_watchlist_news, LAYOUT_ITEMWATCHLISTNEWS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.layout_home_header_sub_number, LAYOUT_LAYOUTHOMEHEADERSUBNUMBER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.layout_home_header_sub_text, LAYOUT_LAYOUTHOMEHEADERSUBTEXT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.layout_home_item_number, LAYOUT_LAYOUTHOMEITEMNUMBER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.layout_home_itemheader, LAYOUT_LAYOUTHOMEITEMHEADER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.trang.ez_mobile.R.layout.nav_user_layout, LAYOUT_NAVUSERLAYOUT);
  }

  private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ACTIVITYCRASH: {
        if ("layout/activity_crash_0".equals(tag)) {
          return new ActivityCrashBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_crash is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMAIN: {
        if ("layout/activity_main_0".equals(tag)) {
          return new ActivityMainBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
      }
      case  LAYOUT_APPBARMAIN: {
        if ("layout/app_bar_main_0".equals(tag)) {
          return new AppBarMainBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for app_bar_main is invalid. Received: " + tag);
      }
      case  LAYOUT_CONTENTMAIN: {
        if ("layout/content_main_0".equals(tag)) {
          return new ContentMainBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for content_main is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGADVANCEREPORT: {
        if ("layout/dialog_advance_report_0".equals(tag)) {
          return new DialogAdvanceReportBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_advance_report is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGCHARTCUSTOM: {
        if ("layout/dialog_chart_custom_0".equals(tag)) {
          return new DialogChartCustomBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_chart_custom is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGFRAGMENTBUY: {
        if ("layout/dialog_fragment_buy_0".equals(tag)) {
          return new DialogFragmentBuyBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_fragment_buy is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTADVANCEREPORT: {
        if ("layout/fragment_advance_report_0".equals(tag)) {
          return new FragmentAdvanceReportBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_advance_report is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTASSETREPORT: {
        if ("layout/fragment_asset_report_0".equals(tag)) {
          return new FragmentAssetReportBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_asset_report is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTBUY: {
        if ("layout/fragment_buy_0".equals(tag)) {
          return new FragmentBuyBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_buy is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCASHBALANCE: {
        if ("layout/fragment_cash_balance_0".equals(tag)) {
          return new FragmentCashBalanceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_cash_balance is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCHART: {
        if ("layout/fragment_chart_0".equals(tag)) {
          return new FragmentChartBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_chart is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTEVENT: {
        if ("layout/fragment_event_0".equals(tag)) {
          return new FragmentEventBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_event is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTHOME: {
        if ("layout/fragment_home_0".equals(tag)) {
          return new FragmentHomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTLOGIN: {
        if ("layout/fragment_login_0".equals(tag)) {
          return new FragmentLoginBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_login is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMARKETOVERVIEW: {
        if ("layout/fragment_market_overview_0".equals(tag)) {
          return new FragmentMarketOverviewBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_market_overview is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMARKETOVERVIEWCHART: {
        if ("layout/fragment_market_overview_chart_0".equals(tag)) {
          return new FragmentMarketOverviewChartBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_market_overview_chart is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMARKETOVERVIEWDETAIL: {
        if ("layout/fragment_market_overview_detail_0".equals(tag)) {
          return new FragmentMarketOverviewDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_market_overview_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMARKETOVERVIEWHNX: {
        if ("layout/fragment_market_overview_hnx_0".equals(tag)) {
          return new FragmentMarketOverviewHnxBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_market_overview_hnx is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMARKETOVERVIEWHSX: {
        if ("layout/fragment_market_overview_hsx_0".equals(tag)) {
          return new FragmentMarketOverviewHsxBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_market_overview_hsx is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMARKETOVERVIEWDETAILMOSTACTIVE: {
        if ("layout/fragment_marketoverview_detail_most_active_0".equals(tag)) {
          return new FragmentMarketoverviewDetailMostActiveBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_marketoverview_detail_most_active is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMARKETOVERVIEWDETAILTOPGAINERS: {
        if ("layout/fragment_marketoverview_detail_top_gainers_0".equals(tag)) {
          return new FragmentMarketoverviewDetailTopGainersBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_marketoverview_detail_top_gainers is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMARKETOVERVIEWDETAILTOPLOSERS: {
        if ("layout/fragment_marketoverview_detail_top_losers_0".equals(tag)) {
          return new FragmentMarketoverviewDetailTopLosersBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_marketoverview_detail_top_losers is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTNEWS: {
        if ("layout/fragment_news_0".equals(tag)) {
          return new FragmentNewsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_news is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPLACEORDERS: {
        if ("layout/fragment_place_orders_0".equals(tag)) {
          return new FragmentPlaceOrdersBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_place_orders is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSELL: {
        if ("layout/fragment_sell_0".equals(tag)) {
          return new FragmentSellBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_sell is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSIGNUP: {
        if ("layout/fragment_sign_up_0".equals(tag)) {
          return new FragmentSignUpBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_sign_up is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSTOCKBALANCE: {
        if ("layout/fragment_stock_balance_0".equals(tag)) {
          return new FragmentStockBalanceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_stock_balance is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTWATCHLIST: {
        if ("layout/fragment_watchlist_0".equals(tag)) {
          return new FragmentWatchlistBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_watchlist is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTWATCHLISTCHART: {
        if ("layout/fragment_watchlist_chart_0".equals(tag)) {
          return new FragmentWatchlistChartBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_watchlist_chart is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTWATCHLISTDETAIL: {
        if ("layout/fragment_watchlist_detail_0".equals(tag)) {
          return new FragmentWatchlistDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_watchlist_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTWATCHLISTFINANCEOVERVIEW: {
        if ("layout/fragment_watchlist_finance_overview_0".equals(tag)) {
          return new FragmentWatchlistFinanceOverviewBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_watchlist_finance_overview is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTWATCHLISTFINANCIALFIGURES: {
        if ("layout/fragment_watchlist_financial_figures_0".equals(tag)) {
          return new FragmentWatchlistFinancialFiguresBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_watchlist_financial_figures is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTWATCHLISTFOREIGNOWNERSHIP: {
        if ("layout/fragment_watchlist_foreign_ownership_0".equals(tag)) {
          return new FragmentWatchlistForeignOwnershipBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_watchlist_foreign_ownership is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTWATCHLISTNEWS: {
        if ("layout/fragment_watchlist_news_0".equals(tag)) {
          return new FragmentWatchlistNewsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_watchlist_news is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTWATCHLISTSTATISTICS: {
        if ("layout/fragment_watchlist_statistics_0".equals(tag)) {
          return new FragmentWatchlistStatisticsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_watchlist_statistics is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTWATCHLISTTRADING: {
        if ("layout/fragment_watchlist_trading_0".equals(tag)) {
          return new FragmentWatchlistTradingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_watchlist_trading is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMEVENTFRAGMENT: {
        if ("layout/item_event_fragment_0".equals(tag)) {
          return new ItemEventFragmentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_event_fragment is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMFRAGADVANCEREPORT: {
        if ("layout/item_frag_advance_report_0".equals(tag)) {
          return new ItemFragAdvanceReportBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_frag_advance_report is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMFRAGMENTBUY: {
        if ("layout/item_fragment_buy_0".equals(tag)) {
          return new ItemFragmentBuyBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_fragment_buy is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMHOMEINDEXESITEMVIEW: {
        if ("layout/item_home_indexes_itemview_0".equals(tag)) {
          return new ItemHomeIndexesItemviewBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_home_indexes_itemview is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMHOMEINDEXESLAYOUT: {
        if ("layout/item_home_indexes_layout_0".equals(tag)) {
          return new ItemHomeIndexesLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_home_indexes_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMAINMENUBIGGROUPCONTENT: {
        if ("layout/item_main_menu_biggroup_content_0".equals(tag)) {
          return new ItemMainMenuBiggroupContentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_main_menu_biggroup_content is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMAINMENUBIGGROUPHEADER: {
        if ("layout/item_main_menu_biggroup_header_0".equals(tag)) {
          return new ItemMainMenuBiggroupHeaderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_main_menu_biggroup_header is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMAINMENUBIGGROUPHEADERACCOUNT: {
        if ("layout/item_main_menu_biggroup_header_account_0".equals(tag)) {
          return new ItemMainMenuBiggroupHeaderAccountBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_main_menu_biggroup_header_account is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMAINMENUGROUPCONTENT: {
        if ("layout/item_main_menu_group_content_0".equals(tag)) {
          return new ItemMainMenuGroupContentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_main_menu_group_content is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMAINMENUGROUPHEADER: {
        if ("layout/item_main_menu_group_header_0".equals(tag)) {
          return new ItemMainMenuGroupHeaderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_main_menu_group_header is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMAINMENURECYCLERVIEWCONTENT: {
        if ("layout/item_main_menu_recyclerview_content_0".equals(tag)) {
          return new ItemMainMenuRecyclerviewContentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_main_menu_recyclerview_content is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMARKETOVERVIEWRECYCLERVIEWMARKET: {
        if ("layout/item_market_overview_recyclerview_market_0".equals(tag)) {
          return new ItemMarketOverviewRecyclerviewMarketBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_market_overview_recyclerview_market is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMARKETOVERVIEWRECYCLERVIEWMARKETDETAIL: {
        if ("layout/item_market_overview_recyclerview_market_detail_0".equals(tag)) {
          return new ItemMarketOverviewRecyclerviewMarketDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_market_overview_recyclerview_market_detail is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ITEMSTOCKBALANCE: {
        if ("layout/item_stock_balance_0".equals(tag)) {
          return new ItemStockBalanceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_stock_balance is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMWATCHLISTFINANCIAL: {
        if ("layout/item_watchlist_financial_0".equals(tag)) {
          return new ItemWatchlistFinancialBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_watchlist_financial is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMWATCHLISTNEWS: {
        if ("layout/item_watchlist_news_0".equals(tag)) {
          return new ItemWatchlistNewsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_watchlist_news is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYOUTHOMEHEADERSUBNUMBER: {
        if ("layout/layout_home_header_sub_number_0".equals(tag)) {
          return new LayoutHomeHeaderSubNumberBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for layout_home_header_sub_number is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYOUTHOMEHEADERSUBTEXT: {
        if ("layout/layout_home_header_sub_text_0".equals(tag)) {
          return new LayoutHomeHeaderSubTextBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for layout_home_header_sub_text is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYOUTHOMEITEMNUMBER: {
        if ("layout/layout_home_item_number_0".equals(tag)) {
          return new LayoutHomeItemNumberBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for layout_home_item_number is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYOUTHOMEITEMHEADER: {
        if ("layout/layout_home_itemheader_0".equals(tag)) {
          return new LayoutHomeItemheaderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for layout_home_itemheader is invalid. Received: " + tag);
      }
      case  LAYOUT_NAVUSERLAYOUT: {
        if ("layout/nav_user_layout_0".equals(tag)) {
          return new NavUserLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for nav_user_layout is invalid. Received: " + tag);
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      // find which method will have it. -1 is necessary becausefirst id starts with 1;
      int methodIndex = (localizedLayoutId - 1) / 50;
      switch(methodIndex) {
        case 0: {
          return internalGetViewDataBinding0(component, view, localizedLayoutId, tag);
        }
        case 1: {
          return internalGetViewDataBinding1(component, view, localizedLayoutId, tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(5);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "event_presenter");
      sKeys.put(2, "eventPresenter");
      sKeys.put(3, "event");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(58);

    static {
      sKeys.put("layout/activity_crash_0", com.trang.ez_mobile.R.layout.activity_crash);
      sKeys.put("layout/activity_main_0", com.trang.ez_mobile.R.layout.activity_main);
      sKeys.put("layout/app_bar_main_0", com.trang.ez_mobile.R.layout.app_bar_main);
      sKeys.put("layout/content_main_0", com.trang.ez_mobile.R.layout.content_main);
      sKeys.put("layout/dialog_advance_report_0", com.trang.ez_mobile.R.layout.dialog_advance_report);
      sKeys.put("layout/dialog_chart_custom_0", com.trang.ez_mobile.R.layout.dialog_chart_custom);
      sKeys.put("layout/dialog_fragment_buy_0", com.trang.ez_mobile.R.layout.dialog_fragment_buy);
      sKeys.put("layout/fragment_advance_report_0", com.trang.ez_mobile.R.layout.fragment_advance_report);
      sKeys.put("layout/fragment_asset_report_0", com.trang.ez_mobile.R.layout.fragment_asset_report);
      sKeys.put("layout/fragment_buy_0", com.trang.ez_mobile.R.layout.fragment_buy);
      sKeys.put("layout/fragment_cash_balance_0", com.trang.ez_mobile.R.layout.fragment_cash_balance);
      sKeys.put("layout/fragment_chart_0", com.trang.ez_mobile.R.layout.fragment_chart);
      sKeys.put("layout/fragment_event_0", com.trang.ez_mobile.R.layout.fragment_event);
      sKeys.put("layout/fragment_home_0", com.trang.ez_mobile.R.layout.fragment_home);
      sKeys.put("layout/fragment_login_0", com.trang.ez_mobile.R.layout.fragment_login);
      sKeys.put("layout/fragment_market_overview_0", com.trang.ez_mobile.R.layout.fragment_market_overview);
      sKeys.put("layout/fragment_market_overview_chart_0", com.trang.ez_mobile.R.layout.fragment_market_overview_chart);
      sKeys.put("layout/fragment_market_overview_detail_0", com.trang.ez_mobile.R.layout.fragment_market_overview_detail);
      sKeys.put("layout/fragment_market_overview_hnx_0", com.trang.ez_mobile.R.layout.fragment_market_overview_hnx);
      sKeys.put("layout/fragment_market_overview_hsx_0", com.trang.ez_mobile.R.layout.fragment_market_overview_hsx);
      sKeys.put("layout/fragment_marketoverview_detail_most_active_0", com.trang.ez_mobile.R.layout.fragment_marketoverview_detail_most_active);
      sKeys.put("layout/fragment_marketoverview_detail_top_gainers_0", com.trang.ez_mobile.R.layout.fragment_marketoverview_detail_top_gainers);
      sKeys.put("layout/fragment_marketoverview_detail_top_losers_0", com.trang.ez_mobile.R.layout.fragment_marketoverview_detail_top_losers);
      sKeys.put("layout/fragment_news_0", com.trang.ez_mobile.R.layout.fragment_news);
      sKeys.put("layout/fragment_place_orders_0", com.trang.ez_mobile.R.layout.fragment_place_orders);
      sKeys.put("layout/fragment_sell_0", com.trang.ez_mobile.R.layout.fragment_sell);
      sKeys.put("layout/fragment_sign_up_0", com.trang.ez_mobile.R.layout.fragment_sign_up);
      sKeys.put("layout/fragment_stock_balance_0", com.trang.ez_mobile.R.layout.fragment_stock_balance);
      sKeys.put("layout/fragment_watchlist_0", com.trang.ez_mobile.R.layout.fragment_watchlist);
      sKeys.put("layout/fragment_watchlist_chart_0", com.trang.ez_mobile.R.layout.fragment_watchlist_chart);
      sKeys.put("layout/fragment_watchlist_detail_0", com.trang.ez_mobile.R.layout.fragment_watchlist_detail);
      sKeys.put("layout/fragment_watchlist_finance_overview_0", com.trang.ez_mobile.R.layout.fragment_watchlist_finance_overview);
      sKeys.put("layout/fragment_watchlist_financial_figures_0", com.trang.ez_mobile.R.layout.fragment_watchlist_financial_figures);
      sKeys.put("layout/fragment_watchlist_foreign_ownership_0", com.trang.ez_mobile.R.layout.fragment_watchlist_foreign_ownership);
      sKeys.put("layout/fragment_watchlist_news_0", com.trang.ez_mobile.R.layout.fragment_watchlist_news);
      sKeys.put("layout/fragment_watchlist_statistics_0", com.trang.ez_mobile.R.layout.fragment_watchlist_statistics);
      sKeys.put("layout/fragment_watchlist_trading_0", com.trang.ez_mobile.R.layout.fragment_watchlist_trading);
      sKeys.put("layout/item_event_fragment_0", com.trang.ez_mobile.R.layout.item_event_fragment);
      sKeys.put("layout/item_frag_advance_report_0", com.trang.ez_mobile.R.layout.item_frag_advance_report);
      sKeys.put("layout/item_fragment_buy_0", com.trang.ez_mobile.R.layout.item_fragment_buy);
      sKeys.put("layout/item_home_indexes_itemview_0", com.trang.ez_mobile.R.layout.item_home_indexes_itemview);
      sKeys.put("layout/item_home_indexes_layout_0", com.trang.ez_mobile.R.layout.item_home_indexes_layout);
      sKeys.put("layout/item_main_menu_biggroup_content_0", com.trang.ez_mobile.R.layout.item_main_menu_biggroup_content);
      sKeys.put("layout/item_main_menu_biggroup_header_0", com.trang.ez_mobile.R.layout.item_main_menu_biggroup_header);
      sKeys.put("layout/item_main_menu_biggroup_header_account_0", com.trang.ez_mobile.R.layout.item_main_menu_biggroup_header_account);
      sKeys.put("layout/item_main_menu_group_content_0", com.trang.ez_mobile.R.layout.item_main_menu_group_content);
      sKeys.put("layout/item_main_menu_group_header_0", com.trang.ez_mobile.R.layout.item_main_menu_group_header);
      sKeys.put("layout/item_main_menu_recyclerview_content_0", com.trang.ez_mobile.R.layout.item_main_menu_recyclerview_content);
      sKeys.put("layout/item_market_overview_recyclerview_market_0", com.trang.ez_mobile.R.layout.item_market_overview_recyclerview_market);
      sKeys.put("layout/item_market_overview_recyclerview_market_detail_0", com.trang.ez_mobile.R.layout.item_market_overview_recyclerview_market_detail);
      sKeys.put("layout/item_stock_balance_0", com.trang.ez_mobile.R.layout.item_stock_balance);
      sKeys.put("layout/item_watchlist_financial_0", com.trang.ez_mobile.R.layout.item_watchlist_financial);
      sKeys.put("layout/item_watchlist_news_0", com.trang.ez_mobile.R.layout.item_watchlist_news);
      sKeys.put("layout/layout_home_header_sub_number_0", com.trang.ez_mobile.R.layout.layout_home_header_sub_number);
      sKeys.put("layout/layout_home_header_sub_text_0", com.trang.ez_mobile.R.layout.layout_home_header_sub_text);
      sKeys.put("layout/layout_home_item_number_0", com.trang.ez_mobile.R.layout.layout_home_item_number);
      sKeys.put("layout/layout_home_itemheader_0", com.trang.ez_mobile.R.layout.layout_home_itemheader);
      sKeys.put("layout/nav_user_layout_0", com.trang.ez_mobile.R.layout.nav_user_layout);
    }
  }
}

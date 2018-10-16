package com.trang.ez_mobile.util;

import java.text.DecimalFormat;

/**
 * Created by HaiNT2 on 12/4/2017.
 */

public class Define {
    //LANGUAGE
    public static final int LANGUAGE_EN = 2;
    public static final int LANGUAGE_VI = 1;
    public static final String SHARED_PREFRENCES_APP = "SHARED_PREFRENCES_APP";
    public static final String SHARED_PREFRENCES_LANGUAGE = "SHARED_PREFRENCES_LANGUAGE";

    //type stock
    public static final String STOCK_TYPE_ATO = "ATO";
    public static final String STOCK_TYPE_ATC = "ATC";
    public static final String STOCK_TYPE_MP = "MP";
    public static final String STOCK_TYPE_LO = "LO";
    public static final String STOCK_TYPE_MAK = "MAK";
    public static final String STOCK_TYPE_MOK = "MOK";
    public static final String STOCK_TYPE_MTL = "MTL";

    //status stock
    public static final String STOCK_STATUS_INPROCESS = "INPROCESS"; //chờ gửi
    public static final String STOCK_STATUS_ACCEPTED = "ACCEPTED"; //đã gửi
    public static final String STOCK_STATUS_SEND_EXCHANGE = "SEND EXCHANGE"; //đã gửi
    public static final String STOCK_STATUS_PARTLY_TRADED = "PARTLY TRADED"; //khớp 1 phần
    public static final String STOCK_STATUS_TRADED = "TRADED"; //đã gửi
    public static final String STOCK_STATUS_CANCELLED = "CANCELLED"; //đã hủy
    public static final String STOCK_STATUS_EXPIRED = "EXPIRED"; // hết hiệu lực
    public static final String STOCK_STATUS_REJECTED = "REJECTED"; // bị từ chối

    //order Type stock
    public static final String STOCK_ORDER_TYPE_ADD = "ADD";  // lệnh mới
    public static final String STOCK_ORDER_TYPE_MODIFY = "MODIFY"; // lệnh sửa
    public static final String STOCK_ORDER_TYPE_CANCEL = "CANCEL";// lệnh hủy

    //Stock Exchange
    public static final String STOCK_ORDER_EXCHANGE_HSX = "HSX";
    public static final String STOCK_ORDER_EXCHANGE_HNX = "HNX";
    public static final String STOCK_ORDER_EXCHANGE_HNX_LISTED = "HNX.LISTED";
    public static final String STOCK_ORDER_EXCHANGE_HNX_UPCOM = "HNX.UPCOM";
    //BUY Sell
    public static final String STOCK_ORDER_BUY = "BUY";
    public static final String STOCK_ORDER_SELL = "SELL";

    //MarketData Overview
    public static final int MARKET_OVERVIEW_TYPE_HSX = 1;
    public static final int MARKET_OVERVIEW_TYPE_HNX = 2;
    public static final int TYPE_PRICE_UP = 1;
    public static final int TYPE_PRICE_DOWN = 2;
    public static final int TYPE_QUANTITY_UP = 3;
    public static final int TYPE_QUANTITY_DOWN = 4;
    public static final int TYPE_VALUE_UP = 5;
    public static final int TYPE_VALUE_DOWN = 6;

    //Chart
    //HOME DETAIL CHART
    public static final int TYPE_CHART_ONE_DAY = 0;
    public static final int TYPE_CHART_ONE_WEEK = 1;
    public static final int TYPE_CHART_ONE_MONTH = 2;
    public static final int TYPE_CHART_THREE_MONTH = 3;
    public static final int TYPE_CHART_SIX_MONTH = 4;
    public static final int TYPE_CHART_ONE_YEAR = 5;
    public static final int TYPE_CHART_TWO_YEAR = 6;
    public static final int TYPE_CHART_ALL = 7;
    public static final String SHARED_PREFRENCES_MARKETOVERVIEW = "SHARED_PREFRENCES_MARKETOVERVIEW";
    public static final String SHARED_PREFRENCES_MARKETOVERVIEW_LISTMARKET_HNX = "SHARED_PREFRENCES_MARKETOVERVIEW_LISTMARKET_HNX";
    public static final String SHARED_PREFRENCES_MARKETOVERVIEW_LISTMARKET_HSX = "SHARED_PREFRENCES_MARKETOVERVIEW_LISTMARKET_HSX";
    public static final String SHARED_PREFRENCES_MARKETOVERVIEW_DATAMARKET_CHART_ONEDAY = "SHARED_PREFRENCES_MARKETOVERVIEW_DATAMARKET_CHART_ONEDAY";
    public static final String SHARED_PREFRENCES_MARKETOVERVIEW_DATAMARKET_CHART_ALL = "SHARED_PREFRENCES_MARKETOVERVIEW_DATAMARKET_CHART_ALL";
    public static final String SHARED_PREFERENCES_MARKETOVERVIEW_DATAMARKET_DETAIL_TOP_GAINERS = "SHARED_PREFERENCES_MARKETOVERVIEW_DATAMARKET_DETAIL_TOP_GAINERS";
    public static final String SHARED_PREFERENCES_MARKETOVERVIEW_DATAMARKET_DETAIL_TOP_LOSERS = "SHARED_PREFERENCES_MARKETOVERVIEW_DATAMARKET_DETAIL_TOP_LOSERS";
    public static final String SHARED_PREFERENCES_MARKETOVERVIEW_DATAMARKET_DETAIL_MOST_ACTIVE = "SHARED_PREFERENCES_MARKETOVERVIEW_DATAMARKET_DETAIL_MOST_ACTIVE";
    public static final String SHARED_PREFERENCES_MARKETOVERVIEW_DATAMARKET_DETAIL = "SHARED_PREFERENCES_MARKETOVERVIEW_DATAMARKET_DETAIL";

    public static final String SHARED_PREFRENCES_MARKETOVERVIEW_ISCHANGE = "SHARED_PREFRENCES_MARKETOVERVIEW_ISCHANGE";
    public static final String SHARED_PREFRENCES_MARKETOVERVIEW_ISVALUE = "SHARED_PREFRENCES_MARKETOVERVIEW_ISVALUE";
    //     User - Menu
    public static final String CATEGORY_DB = "DATABASE_MENU_CATEGORY";
    public static final String CATEGORYCHILD_DB = "DATABASE_MENU_CATEGORYCHILD";
    public static final int TYPE_MENU_CATEGORY = 2001;
    public static final int TYPE_MENU_CATEGORYCHILD = 2002;

    //      Database
    public static final int TYPE_HEADER_ACCOUNT = 1001;
    public static final int TYPE_DATABASE_FEATURES = 1002;
    public static final int TYPE_DATABASE_MEMBER = 1003;
    public static final int TYPE_DATABASE_SETTING = 1004;
    public static final int TYPE_DATABASE_TITLE = 1005;
    public static final int TYPE_DATABASE_UTILS = 1006;
    public static final int TYPE_DATABASE_HELP = 1007;
    public static final int VERSION_DATABASE = 2;

    //      User -
    public static final String SHARED_PREFERENCES_USER = "SHARED_PREFERENCES_USER";
    public static final String SHARED_PREFERENCES_USER_CLIENTCODE = "SHARED_PREFERENCES_USER_CLIENTCODE";
    public static final String SHARED_PREFERENCES_USER_SESSIONNO = "SHARED_PREFERENCES_USER_SESSIONNO";

    //MENU
    public static final int TYPE_MENU_HOME = 3001;
    public static final int TYPE_MENU_MARKET_OVERRVIEW = 3002;
    public static final int TYPE_MENU_WATCHLIST = 3004;
    public static final int MENU_BANG_GIA_PHAI_SINH = 3005;
    public static final int TYPE_MENU_NEWS = 3006;
    public static final int TYPE_MENU_EVENTS = 3007;
    public static final int TYPE_MENU_CHART = 3008;
    public static final int TYPE_MENU_WORLD_INDEX = 3009;

    public static final int MENU_DAT_LENH = 3010;
    public static final int MENU_BAO_CAO_GIAO_DICH = 3011;
    public static final int MENU_BAO_CAO_GIAO_DICH_CHILD_TRA_CUU_SO_DU = 3012;
    public static final int MENU_BAO_CAO_GIAO_DICH_CHILD_LENH_CHO_KHOP = 3013;
    public static final int MENU_BAO_CAO_GIAO_DICH_CHILD_KQ_KHOP_LENH = 3014;
    public static final int MENU_BAO_CAO_GIAO_DICH_CHILD_LENH_TRONG_NGAY = 3015;
    public static final int MENU_BAO_CAO_GIAO_DICH_CHILD_CHO_THANH_TOAN = 3016;
    public static final int MENU_CHUYEN_TIEN = 3017;
    public static final int MENU_CHUYEN_TIEN_CHILD_LAP_LENH = 3018;
    public static final int MENU_CHUYEN_TIEN_CHILD_MAU_CHUYEN_TIEN = 3019;
    public static final int MENU_CHUYEN_TIEN_CHILD_LICH_SU_CHUYEN_TIEN = 3020;
    public static final int MENU_BAN_LO_LE = 3021;
    public static final int MENU_BAN_LO_LE_CHILD_LAP_LENH = 3022;
    public static final int MENU_BAN_LO_LE_CHILD_LICH_SU_BAN = 3023;

    public static final int MENU_THUC_HIEN_QUYEN = 3024;
    public static final int MENU_STOPLOSS = 3025;
    public static final int MENU_STOPLOSS_CHILD_LAP_LENH = 3026;
    public static final int MENU_STOPLOSS_CHILD_LICH_SU_DAT_TIEN = 3027;
    public static final int MENU_KY_QUY = 3028;
    public static final int MENU_KY_QUY_CHILD_DANH_SACH_HOP_DONG = 3029;
    public static final int MENU_KY_QUY_CHILD_CAM_CO = 3030;
    public static final int MENU_KY_QUY_CHILD_TRA_TIEN_HOP_DONG = 3031;
    public static final int MENU_KY_QUY_CHILD_GIA_HAN = 3032;
    public static final int MENU_KY_QUY_CHILD_THAY_DOI_HAN_MUC = 3033;
    public static final int MENU_LUU_KY_CHUNG_KHOAN = 3034;
    public static final int MENU_KY_QUY_UNG_TRUOC = 3035;
    public static final int MENU_KY_QUY_UNG_TRUOC_CHILD_UNG_TIEN_CO_TUC = 3036;
    public static final int MENU_KY_QUY_UNG_TRUOC_CHILD_LICH_SU_UNG_TRUOC = 3037;
    public static final int MENU_BAO_CAO_TAI_SAN = 3038;
    public static final int MENU_LICH_SU_UNG_TRUOC = 3039;
    public static final int MENU_FPTS_NHAN_DINH = 3040;
    public static final int MENU_FPTS_NHAN_DINH_CHILD_THI_TRUONG = 3041;
    public static final int MENU_FPTS_NHAN_DINH_CHILD_DOANHNGHIEP = 3042;
    public static final int MENU_FPTS_NHAN_DINH_CHILD_NGANH = 3043;
    public static final int MENU_FPTS_NHAN_DINH_CHILD_BAN_TIN_FPTS = 3044;
    public static final int MENU_THI_TRUONG_TAI_CHINH = 3045;
    public static final int MENU_THI_TRUONG_TAI_CHINH_CHILD_TI_GIA = 3046;
    public static final int MENU_THI_TRUONG_TAI_CHINH_CHILD_LAI_SUAT = 3047;
    public static final int MENU_THI_TRUONG_TAI_CHINH_CHILD_GIA_VANG = 3048;
    public static final int MENU_THI_TRUONG_TAI_CHINH_CHILD_GIA_DAU = 3049;
    public static final int MENU_THONG_BAO_TU_FPTS = 3050;
    public static final int MENU_MO_TAI_KHOAN = 3051;
    public static final int MENU_LIEN_HE = 3052;
    public static final int MENU_GOP_Y = 3053;
    public static final int MENU_HUONG_DAN_SU_DUNG = 3054;

    public static final int MENU_NGON_NGU = 3055;
    public static final int MENU_GHI_NHO_TAI_KHOAN = 3056;

    //COLOR
    public static final int COLOR_UP = 4001;
    public static final int COLOR_CEILING = 4002;
    public static final int COLOR_REF = 4003;
    public static final int COLOR_FLOOR = 4004;
    public static final int COLOR_DOWN = 4005;
    public static final int COLOR_NO_CHANGE = 4006;

    //WATCHLIST
    public static final String WATCHLIST_DB = "WATCHLIST_DB";

    //HOME
    public static final int HOME_TYPE_INDEXES = 5000;
    public static final int HOME_TYPE_WATCHLIST = 5001;
    public static final int HOME_TYPE_BANG_GIA_PHAI_SINH = 5002;
    public static final int HOME_TYPE_NEWS = 5003;
    public static final int HOME_TYPE_WORLD_INDEXES = 5004;
    public static final String HOME_SHARED_PREFERENCES = "HOME_SHARED_PREFERENCES";
    public static final String HOME_SHARED_PREFERENCES_NEWS = "HOME_SHARED_PREFERENCES_NEWS_LIST";
    public static final String HOME_SHARED_PREFERENCES_WORLDINDEXES_LIST = "HOME_SHARED_PREFERENCES_WORLDINDEXES_LIST";
    public static final String HOME_SHARED_PREFERENCES_WATCHLIST_LIST = "HOME_SHARED_PREFERENCES_WATCHLIST_LIST";
    public static final String HOME_SHARED_PREFERENCES_WATCHLIST = "HOME_SHARED_PREFERENCES_WATCHLIST";

    //WORLD INDEXES
    public static final String SHARED_PREFERENCES_SECURITIES_PUBLIC = "FILE PUBLIC";
    public static final String SHARED_PREFERENCES_ACCOUNT = "FILE ACCOUNT";


    public enum HOME_TYPE_ACTION {
        ACTION_ADD,
        ACTION_EDIT,
        ACTION_DETAIL
    }

    //NAV
    public static final int MENU_LOGIN = 6000;
    public static final int MENU_SIGN_UP = 6001;

    //DRESS SERVER
    public static final String API_URL = "http://f8a5a4ac.ngrok.io/EzMobile_API/";

    //FORMAT DOUBLE
    public static String formatDouble(double d) {
        DecimalFormat df = new DecimalFormat("###,###,###.##");
        return df.format(d);
    }

    //FORMAT STRING
    public static String formatString(String s) {
        DecimalFormat df = new DecimalFormat("###,###,###.##");
        return df.format(s);
    }
}

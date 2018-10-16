package com.trang.ez_mobile.view.watchlist;

import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Handler;

import com.bin.david.form.data.Column;
import com.bin.david.form.data.table.TableData;
import com.trang.ez_mobile.App;
import com.trang.ez_mobile.model.entity.chart.WatchlistData;
import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.Utils;
import com.trang.ez_mobile.view.watchlist.model.CompanyName;
import com.trang.ez_mobile.view.watchlist.model.MixColumns;
import com.trang.ez_mobile.view.watchlist.model.Price;
import com.trang.ez_mobile.view.watchlist.model.StockQuote;
import com.trang.ez_mobile.view.watchlist.model.TableDatabase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.schedulers.Schedulers;

import static android.arch.persistence.room.Room.databaseBuilder;
import static com.trang.ez_mobile.util.Api.API_GRATEWAY;
import static com.trang.ez_mobile.util.Define.WATCHLIST_DB;
import static com.trang.ez_mobile.util.Utils.getRetrofit;
import static com.trang.ez_mobile.util.Utils.isNetworkAvailable;
import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;
import static io.reactivex.schedulers.Schedulers.io;

/**
 * Created by FIT-thuctap22 on 3/21/2018.
 */
public class WatchlistPresenter {
    private Api api;
    private IWatchlistView view;


    private boolean isLoadingName = false;
    private boolean isLoadingAll = false;

    private List<CompanyName> companyNameList = new ArrayList<>();
    TableDatabase tableDatabase;

    public WatchlistPresenter(IWatchlistView view) {
        this.view = view;
        tableDatabase = databaseBuilder(App.getInstance(), TableDatabase.class, WATCHLIST_DB)
                .addMigrations(TableDatabase.MIGRATION_1_2)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries().build();

        LoadData loadData = new LoadData();
        loadData.execute();
    }

    final Handler handler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            getData();

            handler.postDelayed(runnable, 1000);
        }
    };

    public void destroy() {
        if (handler != null)
            handler.removeCallbacks(runnable);
    }

    private class LoadData extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            //load
            view.loading();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            Loadname();
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            ///ok
            handler.post(runnable);
            view.loadSuccess();
            super.onPostExecute(result);
        }
    }

    private void getData() {
        if (isLoadingAll) {
            return;
        }
        if (!isNetworkAvailable()) {
            return;
        }
        if (api == null) {
            api = getRetrofit(API_GRATEWAY).create(Api.class);
            getData();
            return;
        }
        final List<StockQuote> data = new ArrayList<>();
        isLoadingAll = true;
        api.getString("quotes2", "FPT,FTS,GAS,VNM,ACB,ABT,ACM,AGM,AAA,CDN,ACC,ASP,SAB,SAM,SAV,SBA,SBT,SCR,CDO,SFI,HAG,HAI,HAX,HBC,HCM,HMC,HNG,HAD," +
                "lmb,mmb,mcg,mdg,nbb,nct,nlg,pit,ral,rdp,ree,pxi,pvt,pvd,shi,sha,sgt,sfi,sll," +
                "svi,tac,tbc,tcd,tch,tcl,tms,tpc,tni,tnt,tmt,vds,vfg,vhg,vcf,uic,vnm,vph,vos,vns,vph,vpb,vmd")
                .subscribeOn(io())
                .map(s -> s)
                .observeOn(mainThread())
                .subscribe((String r) -> {
                    String[] line1 = r.split("@");

                    for (int i = 0; i < line1.length; i++) {
                        String line2 = line1[i].replace("{", "#").replace("|", "#").replace("}", "#");
                        String[] line = line2.split("#", -1);

                        if (line.length < 2) {
                            return;
                        }
                        StockQuote stockQuote = new StockQuote();
                        try {
                            stockQuote.setSymbol(line[0]);
                        } catch (Exception e) {
                            stockQuote.setSymbol("0");
                        }
                        try {
                            stockQuote.setPricecolor(line[1]);
                        } catch (Exception e) {
                            stockQuote.setPricecolor("0");
                        }
                        try {
                            stockQuote.setMatchprice(Integer.valueOf(line[2]));
                        } catch (Exception e) {
                            stockQuote.setMatchprice(0);
                        }
                        try {
                            stockQuote.setChangePct(Double.valueOf(line[3]));
                        } catch (Exception e) {
                            stockQuote.setChangePct(Double.valueOf("0"));
                        }
                        try {
                            stockQuote.setVolume(Integer.valueOf(line[4]));
                        } catch (Exception e) {
                            stockQuote.setVolume(0);
                        }
                        try {
                            stockQuote.setCeiling(Double.valueOf(line[6]));
                        } catch (Exception e) {
                            stockQuote.setCeiling(Double.valueOf("0"));
                        }
                        try {
                            stockQuote.setFloor(Double.valueOf(line[7]));
                        } catch (Exception e) {
                            stockQuote.setFloor(Double.valueOf("0"));
                        }
                        try {
                            stockQuote.setReference(Double.valueOf(line[8]));
                        } catch (Exception e) {
                            stockQuote.setReference(Double.valueOf("0"));
                        }
                        try {
                            stockQuote.setBuy3(Double.valueOf(line[11]));
                        } catch (Exception e) {
                            stockQuote.setBuy3(Double.valueOf("0"));
                        }
                        try {
                            stockQuote.setBuy3Volume(Integer.valueOf(line[12]));
                        } catch (Exception e) {
                            stockQuote.setBuy3Volume(0);
                        }
                        try {
                            stockQuote.setBuy2(Double.valueOf(line[13]));
                        } catch (Exception e) {
                            stockQuote.setBuy2(Double.valueOf("0"));
                        }
                        try {
                            stockQuote.setBuy2Volume(Integer.valueOf(line[14]));
                        } catch (Exception e) {
                            stockQuote.setBuy2Volume(0);
                        }
                        try {
                            stockQuote.setBuy1(Double.valueOf(line[15]));
                        } catch (Exception e) {
                            stockQuote.setBuy1(Double.valueOf("0"));
                        }
                        try {
                            stockQuote.setBuy1Volume(Integer.valueOf(line[16]));
                        } catch (Exception e) {
                            stockQuote.setBuy1Volume(0);
                        }

                        try {
                            stockQuote.setMatch(Double.valueOf(line[17]));
                        } catch (Exception e) {
                            stockQuote.setMatch(Double.valueOf("0"));
                        }
                        try {
                            stockQuote.setMatchprice(Integer.valueOf(line[18]));
                        } catch (Exception e) {
                            stockQuote.setMatchprice(0);
                        }
                        try {
                            stockQuote.setChangPrice(Double.valueOf(line[19]));
                        } catch (Exception e) {
                            stockQuote.setChangPrice(Double.valueOf("0"));
                        }
                        try {
                            stockQuote.setSell1(Double.valueOf(line[20]));
                        } catch (Exception e) {
                            stockQuote.setSell1(Double.valueOf("0"));
                        }
                        try {
                            stockQuote.setSell1Volume(Integer.valueOf(line[21]));
                        } catch (Exception e) {
                            stockQuote.setSell1Volume(0);
                        }

                        try {
                            stockQuote.setSell2(Double.valueOf(line[22]));
                        } catch (Exception e) {
                            stockQuote.setSell2(Double.valueOf("0"));
                        }
                        try {
                            stockQuote.setSell2Volume(Integer.valueOf(line[23]));
                        } catch (Exception e) {
                            stockQuote.setSell2Volume(0);
                        }
                        try {
                            stockQuote.setSell3(Double.valueOf(line[24]));
                        } catch (Exception e) {
                            stockQuote.setSell3(Double.valueOf("0"));
                        }

                        try {
                            stockQuote.setSell3Volume(Integer.valueOf(line[25]));
                        } catch (Exception e) {
                            stockQuote.setSell3Volume(0);
                        }
                        try {
                            stockQuote.setTotalQtty(Integer.valueOf(line[26]));
                        } catch (Exception e) {
                            stockQuote.setTotalQtty(0);
                        }

                        if (line.length == 33) {
                            try {
                                stockQuote.setOpenPrice(Double.valueOf(line[27]));
                            } catch (Exception e) {
                                stockQuote.setOpenPrice(Double.valueOf("0"));
                            }
                            try {
                                stockQuote.setHighestPrice(Double.valueOf(line[28]));
                            } catch (Exception e) {
                                stockQuote.setHighestPrice(Double.valueOf("0"));
                            }
                            try {
                                stockQuote.setLowest(Double.valueOf(line[29]));
                            } catch (Exception e) {
                                stockQuote.setLowest(Double.valueOf("0"));
                            }
                            try {
                                stockQuote.setForeignBuy(Integer.valueOf(line[30]));
                            } catch (Exception e) {
                                stockQuote.setForeignBuy(0);
                            }
                            try {
                                stockQuote.setForeignSell(Integer.valueOf(line[31]));
                            } catch (Exception e) {
                                stockQuote.setForeignSell(0);
                            }
                        } else {
                            if (line.length == 34) {
                                try {
                                    stockQuote.setOpenPrice(Double.valueOf(line[28]));
                                } catch (Exception e) {
                                    stockQuote.setOpenPrice(Double.valueOf("0"));
                                }
                                try {
                                    stockQuote.setHighestPrice(Double.valueOf(line[29]));
                                } catch (Exception e) {
                                    stockQuote.setHighestPrice(Double.valueOf("0"));
                                }
                                try {
                                    stockQuote.setLowest(Double.valueOf(line[30]));
                                } catch (Exception e) {
                                    stockQuote.setLowest(Double.valueOf("0"));
                                }
                                try {
                                    stockQuote.setForeignBuy(Integer.valueOf(line[31]));
                                } catch (Exception e) {
                                    stockQuote.setForeignBuy(0);
                                }
                                try {
                                    stockQuote.setForeignSell(Integer.valueOf(line[32]));
                                } catch (Exception e) {
                                    stockQuote.setForeignSell(0);
                                }
                            }
                        }
                        data.add(stockQuote);
                    }
                    ///view
                    List<Price> testData = new ArrayList<>();
                    for (int i = 0; i < data.size(); i++) {
                        StockQuote stock = data.get(i);
                        Price userData = new Price(stock.getSymbol(), stock.getMatch(), stock.getMatchprice(), stock.getChangPrice(), stock.getTotalQtty(), stock.getBuy3(),
                                stock.getBuy3Volume(), stock.getBuy2(), stock.getBuy2Volume(), stock.getBuy1(), stock.getBuy1Volume(), stock.getSell1(),
                                stock.getSell1Volume(), stock.getSell2(), stock.getSell2Volume(), stock.getSell3(), stock.getSell3Volume(), stock.getCeiling(), stock.getFloor(), stock.getReference(), stock.getOpenPrice(), stock.getHighestPrice(), stock.getLowest(), stock.getForeignBuy(), stock.getForeignSell(), stock.getPricecolor());
                        testData.add(userData);
                    }
                    onLoadData(testData);
                }, throwable -> {
                    //exception
                    isLoadingAll = false;
                    throwable.printStackTrace();
                }, () -> {
                    //action
                    isLoadingAll = false;
                });

    }

    public void onLoadData(final List<Price> testData) {

        Column<String> column4 = new Column<>("Mã CK", "mack");
        column4.setTextAlign(Paint.Align.CENTER);
        column4.setFixed(true);
        Column<Double> column5 = new Column<>("Giá khớp", "giakhop");
        Column<Integer> column6 = new Column<>("Kl khớp", "kl");
        Column<Double> column7 = new Column<>("+/-", "di");
        Column<Integer> column8 = new Column<>("Khối Lượng", "khoiluong");
        Column<Double> column9 = new Column<>("G.M3", "gm3");

        Column<Integer> timeColumn = new Column<>(" KL.M3", "klm3");
        Column<Double> timeColumn2 = new Column<>(" G.M2", "gm2");
        Column<Integer> timeColumn3 = new Column<>(" KL.M2", "klm2");
        Column<Double> timeColumn4 = new Column<>(" G.M1", "gm1");
        Column<Integer> timeColumn5 = new Column<>(" KL.M1", "klm1");
        Column<Double> timeColumn6 = new Column<>(" G.B1", "gb1");
        Column<Integer> timeColumn7 = new Column<>(" KL.B1", "klb1");
        Column<Double> timeColumn8 = new Column<>(" G.B2", "gb2");
        Column<Integer> timeColumn9 = new Column<>(" KL.B2", "klb2");
        Column<Double> timeColumn10 = new Column<>(" G.B3", "gb3");
        Column<Integer> timeColumn11 = new Column<>(" KL.B3", "klb3");
        Column<Double> timeColumn12 = new Column<>(" Trần", "tran");
        Column<Double> timeColumn13 = new Column<>(" Sàn", "san");
        Column<Double> timeColumn14 = new Column<>(" TC", "tc");
        Column<Double> timeColumn15 = new Column<>(" Mở", "mo");
        Column<Double> timeColumn16 = new Column<>(" Cao", "cao");
        Column<Double> timeColumn17 = new Column<>(" Thấp", "thap");
        Column<Integer> timeColumn18 = new Column<>(" NN mua", "nnmua");
        Column<Integer> timeColumn19 = new Column<>(" NN bán", "nnban");

        if (!companyNameList.isEmpty()) {
            column5.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            column4.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(value, testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, value)).getcompanyname(), companyNameList.get(searchKey(companyNameList, value)).getCode()));
            column6.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            column7.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            column8.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            column9.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            timeColumn.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            timeColumn2.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            timeColumn3.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            timeColumn4.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            timeColumn5.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            timeColumn6.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            timeColumn7.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            timeColumn8.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            timeColumn9.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            timeColumn10.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            timeColumn11.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            timeColumn12.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            timeColumn13.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            timeColumn14.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            timeColumn15.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            timeColumn16.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            timeColumn17.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            timeColumn18.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
            timeColumn19.setOnColumnItemClickListener((column, value, s, position) -> view.moveFragment(testData.get(position).getMack(), testData.get(position).getColor(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getcompanyname(), companyNameList.get(searchKey(companyNameList, testData.get(position).getMack())).getCode()));
        }
        final TableData<Price> tableData = new TableData<>("trade", testData, column4, column5, column6, column7, column8, column9,
                timeColumn, timeColumn2, timeColumn3, timeColumn4, timeColumn5, timeColumn6, timeColumn7, timeColumn8, timeColumn9, timeColumn10,
                timeColumn11, timeColumn12, timeColumn13, timeColumn14, timeColumn15, timeColumn16, timeColumn17, timeColumn18, timeColumn19);
        List<MixColumns> datas = new ArrayList<>();
        datas.add(new MixColumns(column4, column5, column6, column7, column8, column9,
                timeColumn, timeColumn2, timeColumn3, timeColumn4, timeColumn5, timeColumn6, timeColumn7, timeColumn8, timeColumn9, timeColumn10,
                timeColumn11, timeColumn12, timeColumn13, timeColumn14, timeColumn15, timeColumn16, timeColumn17, timeColumn18, timeColumn19));

        List<Column> m = new ArrayList<>();

        Column[] cs = datas.get(0).getColumns();
        if (tableDatabase.userDao().count() <= 0) {

            for (int i = 1; i < datas.get(0).getColumns().length; i++) {
                if (i < cs.length)
                    //dts.add(new Ent(cs[i].getColumnName(), i, 0));
                    tableDatabase.userDao().insertav(new WatchlistData(cs[i].getColumnName(), i, true));
            }
        }
        if (tableDatabase.userDao().count() > 0) {
            m.add(cs[0]);
            for (int i = 0; i < tableDatabase.userDao().getAll().size(); i++) {
                if (tableDatabase.userDao().getAll().get(i).getCheck())
                    m.add(cs[tableDatabase.userDao().getAll().get(i).getSort()]);
            }
            tableData.setColumns(m);
        }
        tableData.setShowCount(false);
        view.displayTable(tableData);
    }

    public int searchKey(List<CompanyName> datas, String codestock) {
        int index = 0;
        for (int i = 0; i < datas.size(); i++) {
            if (datas.get(i).getstockcode().equals(codestock)) {
                index = i;
            }
        }
        return index;
    }

    private void Loadname() {
        if (isLoadingName) {
            return;
        }
        if (api == null) {
            api = Utils.getRetrofit(API_GRATEWAY).create(Api.class);
            Loadname();
            return;
        }
        isLoadingName = true;
        this.companyNameList = new ArrayList<>();
        api.getNameCompany("codename2", "0", "1")
                .subscribeOn(Schedulers.io())
                .map(s -> s)
                .observeOn(mainThread())
                .subscribe(s -> {
                    CompanyName name;

                    String[] lines = s.split("@");
                    for (int i = 0; i < lines.length - 1; i++) {

                        String[] parts = lines[i].split("#");
                        name = new CompanyName();
                        try {
                            name.setCode(parts[0]);
                        } catch (Exception e) {
                            name.setCode("");
                        }
                        try {
                            name.setstockcode(parts[1]);
                        } catch (Exception e) {
                            name.setstockcode("");
                        }
                        try {
                            name.setcompanyname(parts[2]);
                        } catch (Exception e) {

                            name.setcompanyname("");
                        }
                        this.companyNameList.add(name);
                    }

                }, throwable -> {
                    throwable.printStackTrace();
                    isLoadingName = false;
                }, () -> isLoadingName = false);
    }
}

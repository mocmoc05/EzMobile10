package com.trang.ez_mobile.view.watchlist.detail.trading;

import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.Utils;
import com.trang.ez_mobile.view.watchlist.model.Stock;

import io.reactivex.android.schedulers.AndroidSchedulers;

import static com.trang.ez_mobile.util.Api.API_GRATEWAY;
import static io.reactivex.schedulers.Schedulers.io;

public class TradingPresenter {
    private ITradingView view;
    private String symbol;

    private Api api;
    boolean isRequesting = false;

    public TradingPresenter(ITradingView view, String symbol) {
        this.view = view;
        this.symbol = symbol;
        LoadData();
    }

    private void LoadData() {
        if (isRequesting) {
            return;
        }

        if (!Utils.isNetworkAvailable()) {
            return;
        }

        if (api == null) {
            api = Utils.getRetrofit(API_GRATEWAY).create(Api.class);
            LoadData();
            return;
        }

        isRequesting = true;
        api.getString("quotes2", symbol)
                .subscribeOn(io()).map(s -> s)
                .observeOn(AndroidSchedulers.mainThread())
                .map(s -> s)
                .subscribe(s -> {
                    Stock stockQuote = new Stock();
                    String[] line1 = s.split("@");
                    for (int i = 0; i < line1.length; i++) {
                        String line2 = line1[i].replace("{", "#")
                                .replace("|", "#").replace("}", "#");
                        String[] line = line2.split("#", -1);
                        if (line.length < 2) {
                            break;
                        }
                        try {
                            stockQuote.setSymbol(line[0]);
                        } catch (Exception e) {
                            stockQuote.setSymbol("0");
                        }
                        try {
                            stockQuote.setLastPrice(line[2]);
                        } catch (Exception e) {
                            stockQuote.setLastPrice("0");
                        }
                        try {
                            stockQuote.setChange(line[3]);
                            double kq = Double.parseDouble(line[3]) * 100.0 / Double.parseDouble(line[8]);
                            stockQuote.setChangePer(String.valueOf(kq));
                        } catch (Exception e) {
                            stockQuote.setChange("0");
                            stockQuote.setChangePer("0");
                        }
                        try {
                            stockQuote.setVolume(line[4]);
                        } catch (Exception e) {
                            stockQuote.setVolume("0");
                        }
                        try {
                            stockQuote.setCeil(line[6]);
                        } catch (Exception e) {
                            stockQuote.setCeil("0");
                        }
                        try {
                            stockQuote.setFloor(line[7]);
                        } catch (Exception e) {
                            stockQuote.setFloor("0");
                        }
                        try {
                            stockQuote.setRef(line[8]);
                        } catch (Exception e) {
                            stockQuote.setRef("0");
                        }
                        try {
                            stockQuote.setBuyPrice3(line[11]);
                        } catch (Exception e) {
                            stockQuote.setBuyPrice3("0");
                        }
                        try {
                            stockQuote.setBuyQty3(line[12]);
                        } catch (Exception e) {
                            stockQuote.setBuyQty3("0");
                        }

                        try {
                            stockQuote.setBuyPrice2(line[13]);
                        } catch (Exception e) {
                            stockQuote.setBuyPrice2("0");
                        }
                        try {
                            stockQuote.setBuyQty2(line[14]);
                        } catch (Exception e) {
                            stockQuote.setBuyQty2("0");
                        }

                        try {
                            stockQuote.setBuyPrice1(line[15]);
                        } catch (Exception e) {
                            stockQuote.setBuyPrice1("0");
                        }
                        try {
                            stockQuote.setBuyQty1(line[16]);
                        } catch (Exception e) {
                            stockQuote.setBuyQty1("0");
                        }
                        try {
                            stockQuote.setSellPrice1(line[20]);
                        } catch (Exception e) {
                            stockQuote.setSellPrice1("0");
                        }
                        try {
                            stockQuote.setSellQty1(line[21]);
                        } catch (Exception e) {
                            stockQuote.setSellQty1("0");
                        }
                        try {
                            stockQuote.setSellPrice2(line[22]);
                        } catch (Exception e) {
                            stockQuote.setSellPrice2("0");
                        }
                        try {
                            stockQuote.setSellQty2(line[23]);
                        } catch (Exception e) {
                            stockQuote.setSellQty2("0");
                        }
                        try {
                            stockQuote.setSellPrice3(line[24]);
                        } catch (Exception e) {
                            stockQuote.setSellPrice1("0");
                        }
                        try {
                            stockQuote.setSellQty3(line[25]);
                        } catch (Exception e) {
                            stockQuote.setSellQty3("0");
                        }
                        if (line.length == 33) {
                            try {
                                stockQuote.setLow(line[29]);
                            } catch (Exception e) {
                                stockQuote.setLow("0");
                            }
                            try {
                                stockQuote.setHigh(line[28]);
                            } catch (Exception e) {
                                stockQuote.setHigh("0");
                            }
                            try {
                                stockQuote.setForeignBuy(line[30]);
                            } catch (Exception e) {
                                stockQuote.setForeignBuy("0");
                            }

                            try {
                                stockQuote.setForeignSell(line[31]);
                            } catch (Exception e) {
                                stockQuote.setForeignSell("0");
                            }
                        } else {
                            if (line.length == 34) {
                                try {
                                    stockQuote.setLow(line[30]);
                                } catch (Exception e) {
                                    stockQuote.setLow("0");
                                }
                                try {
                                    stockQuote.setHigh(line[29]);
                                } catch (Exception e) {
                                    stockQuote.setHigh("0");
                                }

                                try {
                                    stockQuote.setForeignBuy(line[31]);
                                } catch (Exception e) {
                                    stockQuote.setForeignBuy("0");
                                }
                                try {
                                    stockQuote.setForeignSell(line[32]);
                                } catch (Exception e) {
                                    stockQuote.setForeignSell("0");
                                }
                            }
                        }

                    }
                    view.display(stockQuote);
                    isRequesting = false;
                }, throwable -> {
                    isRequesting = false;
                }, () -> {
                    isRequesting = false;
                });


    }


}

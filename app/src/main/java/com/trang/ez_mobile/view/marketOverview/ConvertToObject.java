package com.trang.ez_mobile.view.marketOverview;

import android.util.Log;

import com.trang.ez_mobile.model.entity.DetailMarket;
import com.trang.ez_mobile.model.entity.Market;
import com.trang.ez_mobile.view.marketOverview.detail.chart.ChartIndex;

import java.util.ArrayList;
import java.util.List;

import static com.trang.ez_mobile.util.Define.COLOR_CEILING;
import static com.trang.ez_mobile.util.Define.COLOR_DOWN;
import static com.trang.ez_mobile.util.Define.COLOR_FLOOR;
import static com.trang.ez_mobile.util.Define.COLOR_NO_CHANGE;
import static com.trang.ez_mobile.util.Define.COLOR_REF;
import static com.trang.ez_mobile.util.Define.COLOR_UP;

/**
 * Created by TraPTH on 3/1/2018.
 */

public class ConvertToObject {
//    public static List<Market> convertStringToListMarket(String string) {
//        List<Market> marketList = new ArrayList<>();
//        try {
//            if (string != null && string != "") {
//                String[] lines = string.split("@");
//                for (String line : lines) {
//                    Market market = new Market();
//                    String[] item = line.split("\\|");
//                    try {
//                        market.setMarketName(item[0]);
//                    } catch (Exception e) {
//                        market.setMarketName("");
//                    }
//                    try {
//                        market.setMarketLastPrice(item[1]);
//                    } catch (Exception e) {
//                        market.setMarketLastPrice("");
//                    }
//                    try {
//                        market.setMarketVolumn(item[2]);
//                    } catch (Exception e) {
//                        market.setMarketVolumn("");
//                    }
//                    try {
//                        market.setMarketQuantity(item[3]);
//                    } catch (Exception e) {
//                        market.setMarketQuantity("");
//                    }
//                    try {
//                        market.setMarketValueChange(item[4]);
//                    } catch (Exception e) {
//                        market.setMarketValueChange("");
//                    }
//                    try {
//                        market.setMarketValueChangeRatio(item[5]);
//                    } catch (Exception e) {
//                        market.setMarketValueChangeRatio("0");
//                    }
//                    marketList.add(market);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return marketList;
//    }

    public static DetailMarket convertStringToDetailMarket(String s, String marketCode) {
        DetailMarket detailMarket = new DetailMarket();
        detailMarket.setDetailMarketName(marketCode);
        if (s == null || s == "") {
            return detailMarket;
        }
        try {
            String[] lines = s.split("▲|▼|■");
            try {
                detailMarket.setDetailMarketMatchPrice(lines[0].split("~")[2]);
            } catch (Exception e) {
                detailMarket.setDetailMarketMatchPrice("0");
            }
            try {
                detailMarket.setDetailMarketChangeValue(lines[1].split("~")[1]);
            } catch (Exception e) {
                detailMarket.setDetailMarketChangeValue("0");
            }
            try {
                detailMarket.setDetailMarketChangeValueRatio(lines[1].split("~")[2]);
            } catch (Exception e) {
                detailMarket.setDetailMarketChangeValueRatio("0");
            }
            try {
                detailMarket.setDetailMarketQty(lines[1].split("~")[3]);
            } catch (Exception e) {
                detailMarket.setDetailMarketQty("0");
            }
            try {
                detailMarket.setDetailMarketVal(lines[1].split("~")[4]);
            } catch (Exception e) {
                detailMarket.setDetailMarketVal("0");
            }
            try {
                detailMarket.setDetailMarketPriceUp(lines[1].split("~")[6]);
            } catch (Exception e) {
                detailMarket.setDetailMarketPriceUp("0");
            }
            try {
                detailMarket.setDetailMarketPriceAverage(lines[1].split("~")[7]);
            } catch (Exception e) {
                detailMarket.setDetailMarketPriceAverage("0");
            }
            try {
                detailMarket.setDetailMarketPriceDown(lines[1].split("~")[8]);
            } catch (Exception e) {
                detailMarket.setDetailMarketPriceDown("0");
            }
            try {
                detailMarket.setDetailMarketValueForeignQty(lines[1].split("~")[9]);
            } catch (Exception e) {
                detailMarket.setDetailMarketValueForeignQty("0");
            }
            try {
                detailMarket.setDetailMarketValueForeignVal(lines[1].split("~")[10]);
            } catch (Exception e) {
                detailMarket.setDetailMarketValueForeignVal("0");
            }
        } catch (Exception e) {
            detailMarket.setDetailMarketMatchPrice("0");
            detailMarket.setDetailMarketChangeValue("0");
            detailMarket.setDetailMarketChangeValueRatio("0");
            detailMarket.setDetailMarketQty("0");
            detailMarket.setDetailMarketVal("0");
            detailMarket.setDetailMarketPriceUp("0");
            detailMarket.setDetailMarketPriceAverage("0");
            detailMarket.setDetailMarketPriceDown("0");
            detailMarket.setDetailMarketValueForeignQty("0");
            detailMarket.setDetailMarketValueForeignVal("0");
            e.printStackTrace();
        }
        return detailMarket;
    }

    public static List<ChartIndex> convertStringToListChartIndex(String s, boolean isOneday) {
        Log.w("ConvertToObject", "convertStringToListChartIndex: " + s);
        if (s == null || s == "") {
            return new ArrayList<>();
        }

        List<ChartIndex> chartIndexDataList = new ArrayList<>();
        String[] lines = s.replace("[[", "")
                .replace("]]", "")
                .split("\\],\\[");

        for (String line : lines) {
            ChartIndex chartIndexData = new ChartIndex();

            String[] tem = line.replace("\"\"", "").split(",");
            try {
                String time = tem[0].replace("\"", "");
                if (!isOneday) {
                    chartIndexData.setChartIndexTime(time.split(" ")[0]);
                } else {
                    chartIndexData.setChartIndexTime(time.substring(11, time.length()));
                }
            } catch (Exception e) {
                chartIndexData.setChartIndexTime("");
            }
            try {
                chartIndexData.setChartIndexOpen(tem[1]);
            } catch (Exception e) {
                chartIndexData.setChartIndexOpen("0");
            }
            try {
                chartIndexData.setChartIndexHigh(tem[2]);
            } catch (Exception e) {
                chartIndexData.setChartIndexHigh("0");
            }
            try {
                chartIndexData.setChartIndexLow(tem[3]);
            } catch (Exception e) {
                chartIndexData.setChartIndexLow("0");
            }
            try {
                chartIndexData.setChartIndexClose(tem[4]);
            } catch (Exception e) {
                chartIndexData.setChartIndexClose("0");
            }
            try {
                chartIndexData.setChartIndexVolumn(tem[5]);
            } catch (Exception e) {
                chartIndexData.setChartIndexVolumn("0");
            }
            chartIndexDataList.add(chartIndexData);
        }
        return chartIndexDataList;
    }

    public static List<Market> convertStringToListMarket(String str, int category) {
        List<Market> marketList = new ArrayList<>();
        String[] lines = str.split("@");
        for (String line : lines) {
            Market market = new Market();
            try {
                String[] tem = line.split("#");
//                            PLX#88.70#77.10#77.50#78.40#82.90#81.49#82.90#78.20#5.40#6.97%#2,058,340#167,732
                if (category == 1 || category == 2 || category == 3) {
                    try {
                        market.setMarketName(tem[0]);
                    } catch (Exception e) {
                        market.setMarketName("");
                    }
                    try {
                        market.setMarketPriceCeiling(tem[1]);
                    } catch (Exception e) {
                        market.setMarketPriceCeiling("0");
                    }
                    try {
                        market.setMarketPriceFloor(tem[2]);
                    } catch (Exception e) {
                        market.setMarketPriceFloor("0");
                    }
                    try {
                        market.setMarketPriceReference(tem[3]);
                    } catch (Exception e) {
                        market.setMarketPriceReference("0");
                    }
                    try {
                        market.setMarketPriceOpen(tem[4]);
                    } catch (Exception e) {
                        market.setMarketPriceOpen("0");
                    }
                    try {
                        market.setMarketPriceClose(tem[5]);
                    } catch (Exception e) {
                        market.setMarketPriceClose("0");
                    }
                    try {
                        market.setMarketPriceHigh(tem[7]);
                    } catch (Exception e) {
                        market.setMarketPriceHigh("0");
                    }
                    try {
                        market.setMarketPriceLow(tem[8]);
                    } catch (Exception e) {
                        market.setMarketPriceLow("0");
                    }
                    try {
                        market.setMarketValueChangeRatio(tem[10]);
                    } catch (Exception e) {
                        market.setMarketValueChangeRatio("0");
                    }
                    try {
                        market.setMarketVolumn(tem[11]);
                    } catch (Exception e) {
                        market.setMarketVolumn("0");
                    }
                } else if (category == 4 || category == 5) {
                    try {
                        market.setMarketName(tem[0]);
                    } catch (Exception e) {
                        market.setMarketName("");
                    }
                    try {
                        market.setMarketPriceCeiling(tem[1]);
                    } catch (Exception e) {
                        market.setMarketPriceCeiling("0");
                    }
                    try {
                        market.setMarketPriceFloor(tem[2]);
                    } catch (Exception e) {
                        market.setMarketPriceFloor("0");
                    }
                    try {
                        market.setMarketPriceReference(tem[3]);
                    } catch (Exception e) {
                        market.setMarketPriceReference("0");
                    }
                    try {
                        market.setMarketPriceOpen(tem[4]);
                    } catch (Exception e) {
                        market.setMarketPriceOpen("0");
                    }
                    try {
                        market.setMarketPriceClose(tem[5]);
                    } catch (Exception e) {
                        market.setMarketPriceClose("0");
                    }
                    try {
                        market.setMarketPriceHigh(tem[6]);
                    } catch (Exception e) {
                        market.setMarketPriceHigh("0");
                    }
                    try {
                        market.setMarketPriceLow(tem[7]);
                    } catch (Exception e) {
                        market.setMarketPriceLow("0");
                    }
                    try {
                        market.setMarketValueChangeRatio(tem[9]);
                    } catch (Exception e) {
                        market.setMarketValueChangeRatio("0");
                    }
                    try {
                        market.setMarketVolumn(tem[10]);
                    } catch (Exception e) {
                        market.setMarketVolumn("0");
                    }
                }
            } catch (Exception e) {
                market.setMarketName("");
                market.setMarketPriceCeiling("0");
                market.setMarketPriceFloor("0");
                market.setMarketPriceReference("0");
                market.setMarketPriceOpen("0");
                market.setMarketPriceClose("0");
                market.setMarketPriceHigh("0");
                market.setMarketPriceLow("0");
                market.setMarketValueChangeRatio("0");
                market.setMarketVolumn("0");
            }
            //SET COLOR
            market.setMarketPriceOpenColor(getColor(market, market.getMarketPriceOpen()));
            market.setMarketPriceCloseColor(getColor(market, market.getMarketPriceClose()));
            market.setMarketPriceHighColor(getColor(market, market.getMarketPriceHigh()));
            market.setMarketPriceLowColor(getColor(market, market.getMarketPriceLow()));
            marketList.add(market);
        }
        return marketList;
    }

    private static int getColor(Market market, String values) {
        double val = 0;
        try {
            val = Double.parseDouble(values);
        } catch (Exception e) {
            val = 0;
        }
        try {
            double ref, ceiling, floor;
            try {
                ref = Double.parseDouble(market.getMarketPriceReference());
            } catch (Exception e) {
                ref = 0;
            }
            try {
                ceiling = Double.parseDouble(market.getMarketPriceCeiling());
            } catch (Exception e) {
                ceiling = 0;
            }
            try {
                floor = Double.parseDouble(market.getMarketPriceFloor());
            } catch (Exception e) {
                floor = 0;
            }
            if (val >= ceiling) {
                return COLOR_CEILING;
            } else if (val == ref) {
                return COLOR_REF;
            } else if (val == floor) {
                return COLOR_FLOOR;
            } else if (val < ref && val > floor) {
                return COLOR_DOWN;
            } else if (val > ref && val < ceiling) {
                return COLOR_UP;
            }
        } catch (Exception e) {
            return COLOR_NO_CHANGE;
        }
        return COLOR_NO_CHANGE;
    }
}
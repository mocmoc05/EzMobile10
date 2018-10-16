package com.trang.ez_mobile.util;

import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.widget.TextView;

import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.view.watchlist.model.Price;
import com.trang.ez_mobile.view.watchlist.model.Stock;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created by FIT-thuctap22 on 1/31/2018.
 */

public class ColorTr {
    public static int checkF = 1;
    public final static int RED_TEXT_COLOR = Color.rgb(221, 65, 65);
    public final static int ORANGE_TEXT_COLOR = Color.rgb(255, 126, 43);
    public final static int BLUE_TEXT_COLOR = Color.rgb(20, 150, 200);
    public final static int GREEN_TEXT_COLOR = Color.rgb(77, 183, 72);
    public final static int PURPLE_TEXT_COLOR = Color.rgb(255, 0, 255);
    public final static int DRAY_TEXT_COLOR = Color.rgb(44, 62, 80);
    public final static int DRAY_BG_COLOR = Color.rgb(204, 204, 204);

    public final static int HINT_TEXT_COLOR = Color.rgb(255, 255, 255);
    public final static DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.ENGLISH);
    public final static DecimalFormat numberformatter = new DecimalFormat("###,###,###,###", symbol);


    public static int changeColormck(String colora) {

        int color = App.getInstance().getResources().getColor(R.color.colorFont);

        switch (colora) {

            case "b":///trắng

                color = App.getInstance().getResources().getColor(R.color.colorFont);
                break;
            case "c"://tím
                color = App.getInstance().getResources().getColor(R.color.purple);
                break;
            case "u":///green

                color = App.getInstance().getResources().getColor(R.color.green);
                break;
            case "d"://đỏ

                color = App.getInstance().getResources().getColor(R.color.red);
                break;
            case "r"://vàng

                color = App.getInstance().getResources().getColor(R.color.yellow);
                break;
            case "f"://blue

                color = App.getInstance().getResources().getColor(R.color.blue_text);
                break;


        }


        return color;
    }

    public static void setQuotesColorTextViewMrkB(String valueTextView, TextView linearLayout, Stock stockQuotesArrayList1) {

        String strMrkB1 = stockQuotesArrayList1.getBuyPrice1();
        String strMrkB2 = stockQuotesArrayList1.getBuyPrice2();
        String strMrkB3 = stockQuotesArrayList1.getBuyPrice3();
        String strMrkS1 = stockQuotesArrayList1.getSellPrice1();
        String strMrkS2 = stockQuotesArrayList1.getSellPrice2();
        String strMrkS3 = stockQuotesArrayList1.getSellPrice3();

        //float matchprice = Float.parseFloat(stockQuotesArrayList1.get(0).getMatchprice());
        float valueTextView1 = valueTextView.compareTo("") == 0 || valueTextView.compareTo("ATC") == 0 || valueTextView.compareTo("ATO") == 0 ? 0 : Float.parseFloat(valueTextView);

        float MrkB1 = strMrkB1.compareTo("") == 0 || strMrkB1.compareTo("ATC") == 0 || strMrkB1.compareTo("ATO") == 0 ? 0 : Float.parseFloat(strMrkB1);
        float MrkB2 = strMrkB2.compareTo("") == 0 ? 0 : Float.parseFloat(strMrkB2);
        float MrkB3 = strMrkB3.compareTo("") == 0 ? 0 : Float.parseFloat(strMrkB3);
        float MrkS1 = strMrkS1.compareTo("") == 0 || strMrkS1.compareTo("ATC") == 0 || strMrkS1.compareTo("ATO") == 0 ? 0 : Float.parseFloat(strMrkS1);
        float MrkS2 = strMrkS2.compareTo("") == 0 ? 0 : Float.parseFloat(strMrkS2);
        float MrkS3 = strMrkS3.compareTo("") == 0 ? 0 : Float.parseFloat(strMrkS3);


        if (MrkB1 == valueTextView1) {
            testMrk(valueTextView1, linearLayout, stockQuotesArrayList1);
        } else {
            if (MrkB2 == valueTextView1) {
                testMrk(valueTextView1, linearLayout, stockQuotesArrayList1);
            } else {
                if (MrkB3 == valueTextView1) {
                    testMrk(valueTextView1, linearLayout, stockQuotesArrayList1);
                } else {
                    if (MrkS1 == valueTextView1) {
                        testMrk(valueTextView1, linearLayout, stockQuotesArrayList1);
                    } else {
                        if (MrkS2 == valueTextView1) {
                            testMrk(valueTextView1, linearLayout, stockQuotesArrayList1);
                        } else {
                            if (MrkS3 == valueTextView1) {
                                testMrk(valueTextView1, linearLayout, stockQuotesArrayList1);
                            }
                        }
                    }
                }
            }
        }


    }


    public static void testMrk(Float valueTextView, TextView linearLayout, Stock stockQuotesArrayList1) {
        float ref = 0;
        float floor = 0;
        float cei = 0;

        try {
            if (stockQuotesArrayList1.getRef().compareTo("") == 0) {

            } else {
                ref = Float.parseFloat(stockQuotesArrayList1.getRef());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (stockQuotesArrayList1.getFloor().compareTo("") == 0) {

            } else {
                floor = Float.parseFloat(stockQuotesArrayList1.getFloor());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (stockQuotesArrayList1.getCeil().compareTo("") == 0) {

            } else {
                cei = Float.parseFloat(stockQuotesArrayList1.getCeil());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (valueTextView == ref) {
            linearLayout.setTextColor(ORANGE_TEXT_COLOR);//cam
        } else {
            if (valueTextView < ref) {
                if (Math.abs(valueTextView - floor) > 0.0000000001) {
                    linearLayout.setTextColor(RED_TEXT_COLOR);
                } else {
                    linearLayout.setTextColor(BLUE_TEXT_COLOR);//xanh lam
                }
            } else {
                if (valueTextView > ref) {
                    if (Math.abs(valueTextView - cei) > 0.0000000001) {
                        linearLayout.setTextColor(GREEN_TEXT_COLOR);
                    } else {
                        linearLayout.setTextColor(PURPLE_TEXT_COLOR);
                    }
                }

            }
        }
    }

    public static int setWacthListDetailColor(Price item, Double MatchPrice) {



        if (MatchPrice == item.getTc()) {
            return ORANGE_TEXT_COLOR;//cam
        } else {
            if (MatchPrice < item.getTc()) {
                if (Math.abs(MatchPrice - item.getSan()) > 0.0000000001) {
                    return RED_TEXT_COLOR;
                } else {
                    return BLUE_TEXT_COLOR;//xanh lam
                }
            } else {
                if (MatchPrice > item.getTc()) {
                    if (Math.abs(MatchPrice - item.getTran()) > 0.0000000001) {
                        return GREEN_TEXT_COLOR;
                    } else {
                        return PURPLE_TEXT_COLOR;
                    }
                }

            }
        }
        if (MatchPrice == 0) {
            return ORANGE_TEXT_COLOR;
        }
        return HINT_TEXT_COLOR;
    }

    public static int testMrkWl(Double valueTextView, Price item) {

        if (valueTextView == item.getTc()) {
            return ORANGE_TEXT_COLOR;//cam
        } else {
            if (valueTextView < item.getTc()) {
                if (Math.abs(valueTextView - item.getSan()) > 0.0000000001) {
                    return RED_TEXT_COLOR;
                } else {
                    return BLUE_TEXT_COLOR;//xanh lam
                }
            } else {
                if (valueTextView > item.getTc()) {
                    if (Math.abs(valueTextView - item.getTran()) > 0.0000000001) {
                        return GREEN_TEXT_COLOR;
                    } else {
                        return PURPLE_TEXT_COLOR;
                    }
                }

            }
        }
        return HINT_TEXT_COLOR;
    }

    public static int setQuotesColorTextViewMrkBWL(Double valueTextView, Price item) {


        if (item.getGm1() == valueTextView) {
            return testMrkWl(valueTextView, item);
        } else {
            if (item.getGm2() == valueTextView) {
                return testMrkWl(valueTextView, item);
            } else {
                if (item.getGm3() == valueTextView) {
                    return testMrkWl(valueTextView, item);
                } else {
                    if (item.getGb1() == valueTextView) {
                        return testMrkWl(valueTextView, item);
                    } else {
                        if (item.getGb2() == valueTextView) {
                            return testMrkWl(valueTextView, item);
                        } else {
                            if (item.getGb3() == valueTextView) {
                                return testMrkWl(valueTextView, item);
                            }
                        }
                    }
                }
            }
        }

        return HINT_TEXT_COLOR;
    }

    public static int setTextViewColorOpen(Double strValue, Double strRef) {
        try {

            if (strValue > strRef) {
                return GREEN_TEXT_COLOR;
            } else if (strValue < strRef) {
                return RED_TEXT_COLOR;
            } else {
                return ORANGE_TEXT_COLOR;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HINT_TEXT_COLOR;
    }

    public static Boolean changeColor(String old, String New) {

        if (old.equals(New)) {
            return true;
        }


        return false;

    }

    public static void Changecl(final Activity activity) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        }, 1000);


    }
    public static String percent(String gia, String tc){

        try {
            double a = (Float.parseFloat(tc) / Float.parseFloat(gia)) * 100;
            return String.valueOf((double)Math.round(a*100)/100);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return "0";

    }

    public static String formatNumber(String _number) {

        String num = "0";
        if(!_number.equals("")){


            try {
                //symbol.setDecimalSeparator('.');
                //symbol.setGroupingSeparator(',');
                double number = Double.parseDouble(_number);
                num = numberformatter.format(number);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return num;
    }

}

package com.trang.ez_mobile.view.watchlist.detail.financialFigures;

import com.trang.ez_mobile.util.Api;
import com.trang.ez_mobile.util.Utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.trang.ez_mobile.util.Api.API_GRATEWAY;

/**
 * Created by FIT-thuctap22 on 3/23/2018.
 */

public class FinancialFiguresPresenter {
    private IFinancialFiguresView view;
    private Api api;
    private Boolean isRequesting = false;

    private List<Finance> financeList = new ArrayList<>();
    private String symbol;

    public FinancialFiguresPresenter(IFinancialFiguresView view, String symbol) {
        this.view = view;
        this.symbol = symbol;
        LoadDatachitieu();
    }

    public void LoadDatachitieu() {

        Api api = Utils.getRetrofit(API_GRATEWAY).create(Api.class);

        final List<Finance> data = new ArrayList<>();
        api.getString("ezs_report", symbol).subscribeOn(Schedulers.io())
                .map(s -> s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    String line[] = s.split("@");
                    ArrayList<String> listContent = new ArrayList<>();
                    for (String strLine : line) {
                        String subLine[] = strLine.split("\\|");
                        for (String strSubLine : subLine) {
                            listContent.add(strSubLine);
                        }
                    }

                    ArrayList<String> listTitle = new ArrayList<String>();
                    String comType = listContent.get(listContent.size() - 1);

                    if (comType.compareToIgnoreCase("0") == 0) //Doanh nghiệp thường
                    {
                        listTitle.add("Doanh thu bán hàng & dịch vụ");
                        listTitle.add("Lợi nhuận gộp bán hàng & dịch vụ");
                        listTitle.add("Lợi nhuận thuần từ HĐKD");
                        listTitle.add("Lợi nhuận (lỗ) kế toán trước thuế");
                        listTitle.add("Lợi nhuận (lỗ) sau thuế TNDN");
                        listTitle.add("Tài sản ngắn hạn");
                        listTitle.add("Tổng tài sản");
                        listTitle.add("Nợ ngắn hạn");
                        listTitle.add("Nợ dài hạn");
                        listTitle.add("Vốn CSH");
                        listTitle.add("Vốn đầu tư CSH");
                        listTitle.add(listContent.get(22));
                    } else if (comType.compareToIgnoreCase("1") == 0) //Ngân hàng
                    {
                        listTitle.add("Thu nhập lãi và thu nhập tương tự");
                        listTitle.add("Lãi/Lỗ thuần từ HĐDV");
                        listTitle.add("LNT HĐKD trước CPDP RR Tín dụng");
                        listTitle.add("Lợi nhuận sau thuế");
                        listTitle.add("Tổng tài sản");
                        listTitle.add("Cho vay khách hàng");
                        listTitle.add("Tiền gửi khách hàng");
                        listTitle.add("Tổng vốn CSH");
                        listTitle.add(listContent.get(16));
                    } else if (comType.compareToIgnoreCase("2") == 0) //Công ty Chứng khoán
                    {
                        listTitle.add("Doanh thu hoạt động");
                        listTitle.add("Chi phí hoạt động");
                        listTitle.add("Kết quả hoạt động");
                        listTitle.add("Lợi nhuận kế toán trước thuế");
                        listTitle.add("Lợi nhuận kế toán sau thuế");
                        listTitle.add("Tổng tài sản");
                        listTitle.add("Tài sản ngắn hạn");
                        listTitle.add("Nợ phải trả");
                        listTitle.add("Nợ phải trả ngắn hạn");
                        listTitle.add("Nợ phải trả dài hạn");
                        listTitle.add("Vốn đầu tư CSH");
                        listTitle.add("Vốn góp của CSH");
                        listTitle.add(listContent.get(24));
                    } else if (comType.compareToIgnoreCase("3") == 0) //Bảo hiểm
                    {
                        listTitle.add("Doanh thu thuần hoạt động kinh doanh bảo hiểm");
                        listTitle.add("Lợi nhuận sau thuế TNDN");
                        listTitle.add("Tổng cộng tài sản");
                        listTitle.add("Vốn CSH");
                        listTitle.add(listContent.get(7));
                    } else if (comType.compareToIgnoreCase("4") == 0) //Chứng chỉ quĩ
                    {
                        listTitle.add("Tổng tài sản");
                        listTitle.add("Đầu tư chứng khoán");
                        listTitle.add("Nguồn vốn CSH");
                        listTitle.add("Thu nhập từ HĐ đầu tư đã thực hiện");
                        listTitle.add("KQHĐ ròng đã thực hiện trong kỳ");
                        listTitle.add("Lợi nhuận trong năm");
                        listTitle.add(listContent.get(12));
                    }

                    DecimalFormat df = new DecimalFormat("###,###,###.##");
                    try {
                        for (int j = 0; j < listContent.size(); j = j + 2) {
                            Finance statementFinance = new Finance();

                            if ((j + 1) != listContent.size() - 1) {
                                statementFinance.setKeyFinace(listTitle.get(j / 2));
                                try {
                                    statementFinance.setValueFinace(df.format(Double.parseDouble(listContent.get(j + 1))));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                statementFinance.setKeyFinace(listTitle.get(j / 2));
                                statementFinance.setValueFinace("");
                            }

                            data.add(statementFinance);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    view.display(data);

                }, throwable -> {
                }, () -> {
                });


    }

    public void LoadDatachiso() {
        Api api = Utils.getRetrofit(API_GRATEWAY).create(Api.class);

        final List<Finance> data = new ArrayList<>();
        api.getString("ezs_finance", symbol)
                .subscribeOn(Schedulers.io())
                .map(s -> s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                            String result = s;

                            result = result.replace("@|@", "@0|0@");
                            result = result.replace("|@", "|0@");

                            String line[] = result.split("@");
                            ArrayList<String> listContent = new ArrayList<>();
                            for (String strLine : line) {
                                String subLine[] = strLine.split("\\|");
                                for (String strSubLine : subLine) {
                                    listContent.add(strSubLine);
                                }
                            }

                            ArrayList<String> listTitle = new ArrayList<>();
                            ArrayList<String> listValue = new ArrayList<>();

                            if (listContent.size() == 25) //Doanh nghiệp thường
                            {
                                for (int j = 0; j < listContent.size(); j++) {
                                    if (j % 2 == 0 && (j != 6 && j != 12 && j != 18)) {
                                        listTitle.add(listContent.get(j));
                                    }
                                    if ((j - 1) % 2 == 0 && (j != 7 && j != 13 && j != 19)) {
                                        listValue.add(listContent.get(j));
                                    }
                                }
                            } else if (listContent.size() == 19) //Ngân hàng
                            {
                                for (int j = 0; j < listContent.size(); j++) {
                                    if (j % 2 == 0 && (j != 6 && j != 12)) {
                                        listTitle.add(listContent.get(j));
                                    }
                                    if ((j - 1) % 2 == 0 && (j != 7 && j != 13)) {
                                        listValue.add(listContent.get(j));
                                    }
                                }
                            } else if (listContent.size() == 35) //Công ty Chứng khoán
                            {
                                listTitle.add("Tăng trưởng doanh thu");
                                listTitle.add("Tăng trưởng lợi nhuận thuần");
                                listTitle.add("Tăng trưởng tổng tài sản");
                                listTitle.add("ROE");
                                listTitle.add("ROA");
                                listTitle.add("Chỉ tiêu đầu tư tự doanh");
                                listTitle.add("Khả năng thanh toán hiện hành");
                                listTitle.add("Nợ thanh toán GDCK/nguồn vốn");
                                listTitle.add("Khả năng thanh toán nhanh");
                                listTitle.add("Trích dự phòng giảm giá CK");
                                listTitle.add("Tổng nợ/Vốn CSH");
                                listTitle.add("Đòn bẩy (Tổng TS/Vốn CSH)");
                                listTitle.add("Tỷ lệ chi phí HĐKD CK");
                                listTitle.add("Tổng nợ/Tổng tài sản");
                                listTitle.add(listContent.get(34));

                                for (int j = 0; j < listContent.size(); j++) {
                                    if ((j - 1) % 2 == 0 && (j != 7 && j != 15 && j != 23)) {
                                        listValue.add(listContent.get(j));
                                    }
                                }
                            } else if (listContent.size() == 27) //Bảo hiểm
                            {
                                listTitle.add("Tổng DT phí BH/nguồn vốn");
                                listTitle.add("DT phí BH thuần/nguồn vốn");
                                listTitle.add("Trợ vốn/nguồn vốn");
                                listTitle.add("Tỷ lệ bồi thường");
                                listTitle.add("Tỷ lệ chi phí HDKD");
                                listTitle.add("Tỷ lệ kết hợp");
                                listTitle.add("Tỷ suất lợi nhuận đầu tư");
                                listTitle.add("Công nợ/tài sản thanh khoản");
                                listTitle.add("Nợ phí/nguồn vốn");
                                listTitle.add("Dự phòng bồi thường/phí BH");
                                listTitle.add(listContent.get(26));

                                for (int j = 0; j < listContent.size(); j++) {
                                    if ((j - 1) % 2 == 0 && (j != 11 && j != 15 && j != 23)) {
                                        listValue.add(listContent.get(j));
                                    }
                                }
                            } else if (listContent.size() == 15) //Chứng chỉ quĩ
                            {
                                listTitle.add("GT TS ròng đâu năm");
                                listTitle.add("Thay đổi GT TS ròng trong năm");
                                listTitle.add("Trong đó: ");
                                listTitle.add("Vốn góp nhà đầu tư");
                                listTitle.add("Thay đổi GT TS ròng do HĐ đầu tư");
                                listTitle.add("Thay đổi GT TS ròng do phân phối thu nhập");
                                listTitle.add("Giá trị TS ròng cuối năm");
                                listTitle.add(listContent.get(14));

                                for (int j = 0; j < listContent.size(); j++) {
                                    if ((j - 1) % 2 == 0) {
                                        if (j == 5) {
                                            listValue.add("");
                                        } else {
                                            listValue.add(listContent.get(j));
                                        }
                                    }
                                }
                            }

                            DecimalFormat df = new DecimalFormat("###,###,###.##");

                            for (int i = 0; i < listTitle.size(); i++) {
                                Finance ratioQuote = new Finance();
                                ratioQuote.setKeyFinace(listTitle.get(i));

                                if (i == listValue.size()) {
                                    ratioQuote.setValueFinace("");
                                } else {
                                    ratioQuote.setValueFinace(df.format(Double.parseDouble(listValue.get(i))));
                                }

                                data.add(ratioQuote);
                            }


                            view.display(data);
                        },
                        throwable -> {
                        }, () -> {
                        });


    }
}

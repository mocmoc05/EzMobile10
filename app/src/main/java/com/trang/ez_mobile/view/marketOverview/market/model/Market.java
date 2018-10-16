package com.trang.ez_mobile.view.marketOverview.market.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Market {
    private String MarketName;
    private String MarketLastPrice;
    private String MarketVolumn;
    private String MarketQuantity;
    private String MarketValueChange;
    private String MarketValueChangeRatio;

    public Market(String marketName, String marketLastPrice, String marketVolumn, String marketQuantity, String marketValueChange,
                  String marketValueChangeRatio) {
        MarketName = marketName;
        MarketLastPrice = marketLastPrice;
        MarketVolumn = marketVolumn;
        MarketQuantity = marketQuantity;
        MarketValueChange = marketValueChange;
        MarketValueChangeRatio = marketValueChangeRatio;
    }

    public String getMarketName() {
        return MarketName;
    }

    public void setMarketName(String marketName) {
        MarketName = marketName;
    }

    public String getMarketLastPrice() {
        return MarketLastPrice;
    }

    public void setMarketLastPrice(String marketLastPrice) {
        MarketLastPrice = marketLastPrice;
    }

    public String getMarketVolumn() {
        return MarketVolumn;
    }

    public void setMarketVolumn(String marketVolumn) {
        MarketVolumn = marketVolumn;
    }

    public String getMarketQuantity() {
        return MarketQuantity;
    }

    public void setMarketQuantity(String marketQuantity) {
        MarketQuantity = marketQuantity;
    }

    public String getMarketValueChange() {
        return MarketValueChange;
    }

    public void setMarketValueChange(String marketValueChange) {
        MarketValueChange = marketValueChange;
    }

    public String getMarketValueChangeRatio() {
        return MarketValueChangeRatio;
    }

    public void setMarketValueChangeRatio(String marketValueChangeRatio) {
        MarketValueChangeRatio = marketValueChangeRatio;
    }
}

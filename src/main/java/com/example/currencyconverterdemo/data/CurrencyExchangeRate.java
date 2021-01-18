package com.example.currencyconverterdemo.data;

import javax.validation.constraints.NotNull;

/**
 * Entity object to store the exchange rates
 */
public class CurrencyExchangeRate {
    @NotNull
    private String currencyCode;

    @NotNull
    private String name;

    @NotNull
    private Double rate;

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return this.rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}

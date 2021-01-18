package com.example.currencyconverterdemo.data;

import java.util.List;

/**
 * Repository interface to handle data access
 */
public interface IRepository {
    public CurrencyExchangeRate addOrUpdateCurrencyExchangeRate(String currencyCode, String name, Double rate);
    public CurrencyExchangeRate getCurrencyExchangeRate(String currencyCode);
    public List<String> listCurrencyCodes();
    public CalculationAuditTrail addAuditEntry(String currencyCode, Double rate, Double amount, Double convertedAmount);
}

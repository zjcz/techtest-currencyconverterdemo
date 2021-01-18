package com.example.currencyconverterdemo.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Data repository for exchange rate data, storing the information in memory
 */
public class MemoryDataRepository implements IRepository {
    private List<CurrencyExchangeRate> exchangeRates;
    private List<CalculationAuditTrail> auditTrail;

    public MemoryDataRepository() {
        exchangeRates = new ArrayList<CurrencyExchangeRate>();
        auditTrail = new ArrayList<CalculationAuditTrail>();
    }

    /** 
     * Add or update the exchange rate data
     */
    public CurrencyExchangeRate addOrUpdateCurrencyExchangeRate(String currencyCode, String name, Double rate) {
        // check to see if a rate exists for this currency code first;
        CurrencyExchangeRate exchangeRate = getCurrencyExchangeRate(currencyCode);
        if (exchangeRate == null) {
            exchangeRate = new CurrencyExchangeRate();
            exchangeRate.setCurrencyCode(currencyCode);
            exchangeRates.add(exchangeRate);
        }

        exchangeRate.setName(name);
        exchangeRate.setRate(rate);
        
        return exchangeRate;
    }

    /**
     * Find the exchange rate data for the currency code
     */
    public CurrencyExchangeRate getCurrencyExchangeRate(String currencyCode) {
        return exchangeRates.stream().filter(rate -> rate.getCurrencyCode().equalsIgnoreCase(currencyCode)).findFirst().orElse(null);
    }
    
    /**
     * List all the currency codes in the system
     */
    public List<String> listCurrencyCodes() {
        List<String> currencyCodes = exchangeRates.stream().map(rate -> rate.getCurrencyCode()).collect(Collectors.toList());
        Collections.sort(currencyCodes);

        return currencyCodes;
    }

    /**
     * Add an audit trail entry
     */
    public CalculationAuditTrail addAuditEntry(String currencyCode, Double rate, Double amount, Double convertedAmount) {
        CalculationAuditTrail auditTrailEntry = new CalculationAuditTrail();
        auditTrailEntry.setCurrencyCode(currencyCode);
        auditTrailEntry.setRate(rate);
        auditTrailEntry.setAmount(amount);
        auditTrailEntry.setConvertedAmount(convertedAmount);
        auditTrailEntry.setAuditDate(LocalDate.now());
        auditTrail.add(auditTrailEntry);

        return auditTrailEntry;
    }
}

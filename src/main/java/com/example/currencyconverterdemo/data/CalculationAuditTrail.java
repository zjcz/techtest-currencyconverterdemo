package com.example.currencyconverterdemo.data;

import java.time.LocalDate;

/**
 * Entity object to store an entry of the audit trail every time a currency conversion is calculated
 */
public class CalculationAuditTrail {    
    private String currencyCode; 
    private Double exchangeRate;
    private Double amount;
    private Double convertedAmount;
    private LocalDate auditDate;

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Double getRate() {
        return this.exchangeRate;
    }

    public void setRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public Double getConvertedAmount() {
        return this.convertedAmount;
    }

    public void setConvertedAmount(Double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
    
    public LocalDate getAuditDate() {
        return this.auditDate;
    }

    public void setAuditDate(LocalDate auditDate) {
        this.auditDate = auditDate;
    }    
}

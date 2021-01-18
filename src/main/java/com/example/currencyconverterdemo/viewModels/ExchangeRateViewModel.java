package com.example.currencyconverterdemo.viewModels;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class ExchangeRateViewModel {

	@NotNull(message = "please specify a currency")
	private String currencyCode;

	@NotNull(message = "please enter an amount")
	@Digits(integer = 10, fraction = 2)
	@Positive
	private Double baseAmount;

	private Double exchangeRate;
	private Double convertedAmount;

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Double getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(Double baseAmount) {
		this.baseAmount = baseAmount;
	}

	public Double getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(Double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}	

	public boolean getIsResultCalculated() {
		return exchangeRate != null;
	}
}

package com.example.currencyconverterdemo.controllers;

import javax.validation.Valid;

import com.example.currencyconverterdemo.data.CurrencyExchangeRate;
import com.example.currencyconverterdemo.data.IRepository;
import com.example.currencyconverterdemo.viewModels.ExchangeRateViewModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class WebController implements WebMvcConfigurer {

    private final IRepository repository;
    
    public WebController(IRepository repository) {
        this.repository = repository;
    }

	@GetMapping("/")
    public String showForm(ExchangeRateViewModel exchangeRateViewModel, Model model) {
        // add the currency codes for the drop down
        model.addAttribute("currencyCodes", repository.listCurrencyCodes());
		return "form";
	}

	@PostMapping("/")
	public String getExchangeRate(@Valid ExchangeRateViewModel exchangeRateViewModel, BindingResult bindingResult, Model model) {

		if (!bindingResult.hasErrors()) {
            // get the exchange rate to use
            CurrencyExchangeRate exchangeRateData = repository.getCurrencyExchangeRate(exchangeRateViewModel.getCurrencyCode());
            if (exchangeRateData == null) {
                bindingResult.addError(new ObjectError("exchangeRateViewModel", "Please enter a valid currency"));
            } else {
                Double convertedAmount = exchangeRateData.getRate() * exchangeRateViewModel.getBaseAmount();
                exchangeRateViewModel.setExchangeRate(exchangeRateData.getRate());
                exchangeRateViewModel.setConvertedAmount(convertedAmount);

                // Add an entry to the audit table
                repository.addAuditEntry(exchangeRateViewModel.getCurrencyCode(), exchangeRateData.getRate(), exchangeRateViewModel.getBaseAmount(), convertedAmount);
            }
		}

        // add the currency codes for the drop down
        model.addAttribute("currencyCodes", repository.listCurrencyCodes());
		return "form";
	}
}
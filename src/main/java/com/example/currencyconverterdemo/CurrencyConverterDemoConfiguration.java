package com.example.currencyconverterdemo;

import com.example.currencyconverterdemo.data.IRepository;
import com.example.currencyconverterdemo.data.MemoryDataRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurrencyConverterDemoConfiguration {

    /**
     * Setup the repository with some base data
     * @return Repository implementation to use
     */
    @Bean
    public IRepository setupRepository() {
        IRepository repository = new MemoryDataRepository();
        repository.addOrUpdateCurrencyExchangeRate("USD", "US Dollars", 1.36);
        repository.addOrUpdateCurrencyExchangeRate("AUD", "Australian Dollars", 1.76);
        repository.addOrUpdateCurrencyExchangeRate("EUR", "Euros", 1.12);

        return repository;
    }
}

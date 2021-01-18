package com.example.currencyconverterdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CurrencyConverterDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterDemoApplication.class, args);
	}
}

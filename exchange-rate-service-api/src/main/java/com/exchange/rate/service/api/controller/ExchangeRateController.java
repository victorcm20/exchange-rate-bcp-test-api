package com.exchange.rate.service.api.controller;

import com.exchange.rate.service.api.business.ExchangeRateService;
import com.exchange.rate.service.api.model.request.ExchangeRateRegisterRequest;
import com.exchange.rate.service.api.model.request.ExchangeRateRequest;
import com.exchange.rate.service.api.model.response.ExchangeRateResponse;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/exchange/rate")
public class ExchangeRateController {
	
	@Autowired
	private ExchangeRateService exchangeRateService;

	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Single<String> registerExchangeRate(@RequestBody ExchangeRateRegisterRequest request){	
		System.out.println("*****************request body ->" +request);
		return exchangeRateService.register(request);
	}
	
	@PostMapping(value = "/calculate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Single<ExchangeRateResponse> calculateExchangeRate(@RequestBody ExchangeRateRequest request){	
		System.out.println("*****************request body ->" +request);
		return exchangeRateService.calculate(request);
	}
}

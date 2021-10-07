package com.exchange.rate.service.api.business;

import com.exchange.rate.service.api.model.request.ExchangeRateRegisterRequest;
import com.exchange.rate.service.api.model.request.ExchangeRateRequest;
import com.exchange.rate.service.api.model.response.ExchangeRateResponse;

import io.reactivex.Single;

public interface ExchangeRateService {
	
	Single<String> register(ExchangeRateRegisterRequest request);
	
	Single<ExchangeRateResponse> calculate(ExchangeRateRequest request);
}

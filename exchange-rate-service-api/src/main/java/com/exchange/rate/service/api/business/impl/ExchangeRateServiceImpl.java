package com.exchange.rate.service.api.business.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Function;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.exchange.rate.service.api.business.ExchangeRateService;
import com.exchange.rate.service.api.model.entity.ExchangeRate;
import com.exchange.rate.service.api.model.request.ExchangeRateRegisterRequest;
import com.exchange.rate.service.api.model.request.ExchangeRateRequest;
import com.exchange.rate.service.api.model.response.ExchangeRateResponse;
import com.exchange.rate.service.api.repository.ExchangeRateReposity;
import io.reactivex.Single;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

	private final ExchangeRateReposity exchangeRateReposity;
	
	@Override
	public Single<String> register(ExchangeRateRegisterRequest request) {
		// TODO Auto-generated method stub
		System.out.println("**********register*************");
		System.out.println("****request ->" +request);
		return Single.create(singleSubscriber -> {
			ExchangeRate existsExchangeRate =  exchangeRateReposity
					.findExchangeRate(LocalDate.now(), request.getFromCurrency(), request.getToCurrency());
			if( existsExchangeRate != null) {
				System.out.println("**********update exchange rate*************");
				System.out.println("*****existsExchangeRate ->"+existsExchangeRate);
				existsExchangeRate.setRate(request.getRate());
				String id = exchangeRateReposity.save(existsExchangeRate).getId();
				singleSubscriber.onSuccess("actualizo el tipo de cambio para hoy ->" + id);
			} else {
				System.out.println("**********save exchange rate*************");
				ExchangeRate exchangeRate = new ExchangeRate();
				exchangeRate.setCreated(request.getDate());
				exchangeRate.setFromCurrency(request.getFromCurrency());
				exchangeRate.setToCurrency(request.getToCurrency());
				exchangeRate.setRate(request.getRate());
				String id = exchangeRateReposity.save(exchangeRate).getId();
				singleSubscriber.onSuccess(id);				
			}
		});
	}
	
	@Override
	public Single<ExchangeRateResponse> calculate(ExchangeRateRequest request) {
		// TODO Auto-generated method stub
		return Single.create(singleSubscriber -> {
			ExchangeRate exchangeRate =  exchangeRateReposity
					.findExchangeRate(LocalDate.now(), request.getFromCurrency(), request.getToCurrency());
			if (exchangeRate != null) {
				ExchangeRateResponse response = new ExchangeRateResponse();
				response.setBaseAmount(request.getAmount());
				response.setConvertedAmount(calculate(request.getAmount(), exchangeRate.getRate()));
				response.setSourceCurrency(request.getFromCurrency());
				response.setTargetCurrency(request.getToCurrency());
				response.setRate(exchangeRate.getRate());
				singleSubscriber.onSuccess(response);
			} else {
				singleSubscriber.onError(new EntityNotFoundException("No existe tipo de cambio para hoy en esta moneda, registre uno nuevo"));
			}
		});
	}
	
	private BigDecimal calculate(BigDecimal baseAmount, BigDecimal rate) { 
        return baseAmount.multiply(rate); 
    }

}

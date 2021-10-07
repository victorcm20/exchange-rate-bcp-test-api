package com.exchange.rate.service.api.model.request;

import java.math.BigDecimal;

import com.exchange.rate.service.api.model.enums.Currency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExchangeRateRequest {

	private BigDecimal amount;
	private Currency fromCurrency;
	private Currency toCurrency;
}

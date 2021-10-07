package com.exchange.rate.service.api.model.response;

import java.math.BigDecimal;

import com.exchange.rate.service.api.model.enums.Currency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExchangeRateResponse {

	private BigDecimal baseAmount;
	private BigDecimal convertedAmount;
	private Currency sourceCurrency;
	private Currency targetCurrency;
	private BigDecimal rate;
}

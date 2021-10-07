package com.exchange.rate.service.api.model.request;

import com.exchange.rate.service.api.model.enums.Currency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExchangeRateRegisterRequest {
	private LocalDate date;
	private Currency fromCurrency;
	private Currency toCurrency;
	private BigDecimal rate;
}

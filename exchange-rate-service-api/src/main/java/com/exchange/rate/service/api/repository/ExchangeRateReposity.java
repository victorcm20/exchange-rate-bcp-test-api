package com.exchange.rate.service.api.repository;

import com.exchange.rate.service.api.model.entity.ExchangeRate;
import com.exchange.rate.service.api.model.enums.Currency;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateReposity extends CrudRepository<ExchangeRate, String>{

	@Query("select e from ExchangeRate e where e.created = ?1 And e.fromCurrency = ?2 And e.toCurrency = ?3")
	ExchangeRate findExchangeRate(LocalDate created, Currency fromCurrency, Currency toCurrency);
}

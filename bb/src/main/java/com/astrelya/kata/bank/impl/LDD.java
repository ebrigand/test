package com.astrelya.kata.bank.impl;

import java.math.BigDecimal;

import com.astrelya.kata.bank.Product;
import org.apache.commons.lang3.NotImplementedException;


public class LDD implements Product {

	private Double rate = 1D;
	private Double amount;
	
	public LDD(Double amount) {
		this.amount = amount;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public Double getRate() {
		return rate;
	}
	
	public BigDecimal getMonthlyValue() {
		return BigDecimal.valueOf(amount * (rate/100) / 12.);
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}
}

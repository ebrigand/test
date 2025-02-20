package com.astrelya.kata.bank;

import java.math.BigDecimal;

public interface Product {

    Double getAmount();

    Double getRate();

    BigDecimal getMonthlyValue();

}

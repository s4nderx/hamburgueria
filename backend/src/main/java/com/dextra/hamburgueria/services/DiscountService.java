package com.dextra.hamburgueria.services;

import com.dextra.hamburgueria.entities.Hamburguer;

import java.math.BigDecimal;

public interface DiscountService {

    BigDecimal getDiscount(Hamburguer hamburguer);

}

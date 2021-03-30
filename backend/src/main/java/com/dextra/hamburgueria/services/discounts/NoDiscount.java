package com.dextra.hamburgueria.services.discounts;

import com.dextra.hamburgueria.entities.Hamburguer;

import java.math.BigDecimal;

public class NoDiscount extends Discount{

    public NoDiscount() {
        super(null);
    }

    @Override
    public BigDecimal applyCalculation(Hamburguer hamburguer) {
        return BigDecimal.ZERO;
    }

    @Override
    public boolean isApplicable(Hamburguer hamburguer) {
        return true;
    }

}

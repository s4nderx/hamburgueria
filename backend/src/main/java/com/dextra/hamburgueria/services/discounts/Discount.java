package com.dextra.hamburgueria.services.discounts;

import com.dextra.hamburgueria.entities.Hamburguer;

import java.math.BigDecimal;

public abstract class Discount {

    protected Discount next;

    public Discount(Discount next) {
        this.next = next;
    }

    public Discount() {
    }

    public BigDecimal calculate(Hamburguer hamburguer) {

        if (isApplicable(hamburguer)) {
            return applyCalculation(hamburguer);
        }

        return next.calculate(hamburguer);

    }

    public abstract BigDecimal applyCalculation(Hamburguer hamburguer);
    public abstract boolean isApplicable(Hamburguer hamburguer);

}

package com.dextra.hamburgueria.services.discounts;

import com.dextra.hamburgueria.entities.Hamburguer;

import java.math.BigDecimal;

public class Light extends Discount{

    public Light(Discount next) {
        super(next);
    }

    @Override
    public BigDecimal applyCalculation(Hamburguer hamburguer) {
        return hamburguer.getPrice().multiply(new BigDecimal("0.1"));
    }

    @Override
    public boolean isApplicable(Hamburguer hamburguer) {
        return hasIngedient("Alface", hamburguer) && !hasIngedient("Bacon", hamburguer);
    }

    private boolean hasIngedient(String ingredientName, Hamburguer hamburguer){
        return hamburguer.getHamburguerIngredients().stream()
                .anyMatch(hamburguerIngredient -> ingredientName.equalsIgnoreCase(hamburguerIngredient.getIngredient().getName()));
    }
}

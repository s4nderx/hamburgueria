package com.dextra.hamburgueria.services.discounts;

import com.dextra.hamburgueria.entities.Hamburguer;

import com.dextra.hamburgueria.entities.HamburguerIngredient;
import com.dextra.hamburgueria.services.IngredientService;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TakeTreePayTwo extends Discount {

    private final BigDecimal unityPrice;
    private final Long ingredientId;
    private Integer quantity = 0;

    public TakeTreePayTwo(Discount next, Long ingredientId, BigDecimal unityPrice) {
        super(next);
        this.unityPrice = unityPrice;
        this.ingredientId = ingredientId;
    }

    @Override
    public BigDecimal applyCalculation(Hamburguer hamburguer) {
        return this.unityPrice.multiply(new BigDecimal(this.quantity / 3));
    }

    @Override
    public boolean isApplicable(Hamburguer hamburguer) {
        List<HamburguerIngredient> hamburgerIngredient = hamburguer.getHamburguerIngredients()
                .stream()
                .filter(hamburguerIngredient -> hamburguerIngredient.getIngredient().getId().equals(this.ingredientId)).collect(Collectors.toList());
        Integer quantity = hamburgerIngredient.get(0).getQuantity();
        if(quantity >= 3){
            this.quantity = quantity;
            return true;
        }
        return false;
    }

}

package com.dextra.hamburgueria.dto.response;

import com.dextra.hamburgueria.entities.HamburguerIngredient;
import com.dextra.hamburgueria.entities.Ingredient;

import java.math.BigDecimal;

public class IngredientResponseDTO {

    private final String name;
    private final Integer quantity;
    private final BigDecimal price;

    public IngredientResponseDTO(String name, Integer quantity, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public IngredientResponseDTO(HamburguerIngredient entity) {
        this.name = entity.getIngredient().getName();
        this.quantity = entity.getQuantity();
        this.price = entity.getPrice();
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

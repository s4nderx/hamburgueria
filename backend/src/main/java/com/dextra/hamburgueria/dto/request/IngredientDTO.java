package com.dextra.hamburgueria.dto.request;

import com.dextra.hamburgueria.entities.Ingredient;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class IngredientDTO {

    @NotEmpty
    private String name;

    @NotNull
    private BigDecimal price;

    public IngredientDTO(Ingredient entity) {
        this.name = entity.getName();
        this.price = entity.getPrice();
    }

    public IngredientDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

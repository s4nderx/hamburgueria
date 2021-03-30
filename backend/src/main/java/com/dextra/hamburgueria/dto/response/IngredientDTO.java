package com.dextra.hamburgueria.dto.response;

import com.dextra.hamburgueria.entities.Ingredient;

import java.math.BigDecimal;

public class IngredientDTO {

    private Long id;
    private String name;
    private BigDecimal price;


    public IngredientDTO(Ingredient entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

package com.dextra.hamburgueria.dto.response;

import com.dextra.hamburgueria.entities.Hamburguer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HamburguerDTO {

    private Long id;
    private String name;
    private BigDecimal discount;
    private BigDecimal price;
    private BigDecimal finalPrice;
    private List<IngredientResponseDTO> ingredients = new ArrayList<>();

    public HamburguerDTO(String name, BigDecimal discount, BigDecimal price, BigDecimal finalPrice) {
        this.name = name;
        this.discount = discount;
        this.price = price;
        this.finalPrice = finalPrice;
    }

    public HamburguerDTO(Hamburguer entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.discount = entity.getDiscount();
        this.price = entity.getPrice();
        this.finalPrice = entity.getFinalPrice();
        entity.getHamburguerIngredients()
                .forEach(hamburguerIngredient -> this.ingredients.add(new IngredientResponseDTO(hamburguerIngredient)));
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

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public List<IngredientResponseDTO> getIngredients() {
        return ingredients;
    }

}

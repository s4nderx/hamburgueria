package com.dextra.hamburgueria.dto.request;

public class HamburguerIngredientInsertDTO {

    Long id;
    Integer quantity;

    public HamburguerIngredientInsertDTO() {
    }

    public HamburguerIngredientInsertDTO(Long id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

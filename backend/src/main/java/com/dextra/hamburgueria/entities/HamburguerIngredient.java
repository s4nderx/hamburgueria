package com.dextra.hamburgueria.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class HamburguerIngredient implements Serializable {
    private static final long serialVersionUID = -2994307973430360758L;

    @JsonIgnore
    @EmbeddedId
    private HamburguerIngredientPk id = new HamburguerIngredientPk();


    private Integer quantity;
    private BigDecimal price;

    public HamburguerIngredient(Hamburguer hamburguer, Ingredient ingredient, Integer quantity, BigDecimal price) {
        id.setHamburguer(hamburguer);
        id.setIngredient(ingredient);
        this.quantity = quantity;
        this.price = price;
    }

    public HamburguerIngredient() {
    }

    @JsonIgnore
    public Hamburguer getHamburguer(){
        return id.getHamburguer();
    }

    public void setHamburguer(Hamburguer hamburguer){
        id.setHamburguer(hamburguer);
    }

    public Ingredient getIngredient(){
        return id.getIngredient();
    }

    public void setIngredient(Ingredient ingredient){
        id.setIngredient(ingredient);
    }

    public HamburguerIngredientPk getId() {
        return id;
    }

    public void setId(HamburguerIngredientPk id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HamburguerIngredient that = (HamburguerIngredient) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

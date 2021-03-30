package com.dextra.hamburgueria.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class HamburguerIngredientPk implements Serializable {
    private static final long serialVersionUID = 2188171308078068365L;

    @ManyToOne
    @JoinColumn(name = "hamburguer_id")
    private Hamburguer hamburguer;

    @ManyToOne
    @JoinColumn(name = "ingedient_id")
    private Ingredient ingredient;

    public Hamburguer getHamburguer() {
        return this.hamburguer;
    }

    public void setHamburguer(Hamburguer hamburguer) {
        this.hamburguer = hamburguer;
    }

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HamburguerIngredientPk that = (HamburguerIngredientPk) o;
        return hamburguer.equals(that.hamburguer) &&
                ingredient.equals(that.ingredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hamburguer, ingredient);
    }
}

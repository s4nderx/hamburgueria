package com.dextra.hamburgueria.dto.request;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class HamburguerInsertDTO {

    @NotEmpty(message = "campo nome obrigatório.")
    String name;

    @NotEmpty(message = "Um hamburguer precisa ter ingredientes.")
    List<HamburguerIngredientInsertDTO> ingredients;

    public HamburguerInsertDTO(String name, List<HamburguerIngredientInsertDTO> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public HamburguerInsertDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HamburguerIngredientInsertDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<HamburguerIngredientInsertDTO> ingredients) {
        this.ingredients = ingredients;
    }
}

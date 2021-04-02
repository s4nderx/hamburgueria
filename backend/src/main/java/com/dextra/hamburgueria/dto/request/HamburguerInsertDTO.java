package com.dextra.hamburgueria.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class HamburguerInsertDTO {

    @NotEmpty(message = "campo nome obrigatório.")
    private String name;

    @NotEmpty(message = "Um hamburguer precisa ter ingredientes.")
    private List<@Valid HamburguerIngredientInsertDTO> ingredients;

    public HamburguerInsertDTO(String name) {
        this.name = name;
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

    public void addIngredient(HamburguerIngredientInsertDTO ingredient){
        this.ingredients.add(ingredient);
    }


}

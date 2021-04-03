package com.dextra.hamburgueria.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class NewHamburguerDTO {

    @NotEmpty(message = "campo nome obrigatório.")
    private String name;

    @NotEmpty(message = "Um hamburguer precisa ter ingredientes.")
    private List<@Valid HamburguerIngredientInsertDTO> ingredients;

    public NewHamburguerDTO(String name) {
        this.name = name;
    }

    public NewHamburguerDTO() {
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

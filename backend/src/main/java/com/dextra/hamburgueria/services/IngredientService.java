package com.dextra.hamburgueria.services;

import com.dextra.hamburgueria.dto.request.IngredientDTO;
import com.dextra.hamburgueria.entities.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient findById(Long id);

    List<Ingredient> findAll();

    Ingredient create(IngredientDTO dto);
}

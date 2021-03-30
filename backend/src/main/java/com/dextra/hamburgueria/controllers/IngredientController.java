package com.dextra.hamburgueria.controllers;

import com.dextra.hamburgueria.dto.response.IngredientDTO;
import com.dextra.hamburgueria.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/ingredients")
public class IngredientController {

    final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<IngredientDTO> findById(@PathVariable Long id){
        IngredientDTO obj = new IngredientDTO(ingredientService.findById(id));
        return  ResponseEntity.ok().body(obj);
    }

}

package com.dextra.hamburgueria.controllers;

import com.dextra.hamburgueria.dto.request.IngredientDTO;
import com.dextra.hamburgueria.entities.Ingredient;
import com.dextra.hamburgueria.repository.IngredientRepository;
import com.dextra.hamburgueria.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "api/ingredients")
public class IngredientController {

    final IngredientService ingredientService;

    @Autowired
    IngredientRepository repository;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<IngredientDTO> findById(@PathVariable Long id){
        IngredientDTO obj = new IngredientDTO(ingredientService.findById(id));
        return  ResponseEntity.ok().body(obj);
    }

    @GetMapping()
    public ResponseEntity<List<Ingredient>> findAll(){
        List<Ingredient> ingredients = ingredientService.findAll();
        return  ResponseEntity.ok().body(ingredients);
    }

    @PostMapping
    public ResponseEntity<Ingredient> create(@Valid @RequestBody IngredientDTO dto){
        Ingredient ingredient = ingredientService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ingredient.getId()).toUri();
        return ResponseEntity.created(uri).body(ingredient);
    }

}

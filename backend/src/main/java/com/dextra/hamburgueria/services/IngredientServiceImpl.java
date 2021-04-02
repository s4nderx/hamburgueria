package com.dextra.hamburgueria.services;

import com.dextra.hamburgueria.dto.request.IngredientDTO;
import com.dextra.hamburgueria.entities.Ingredient;
import com.dextra.hamburgueria.repository.IngredientRepository;
import com.dextra.hamburgueria.services.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository repository;

    public IngredientServiceImpl(IngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ingredient findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ingredient not found, id: " + id));
    }

    @Override
    public List<Ingredient> findAll() {
        return repository.findAll();
    }

    @Override
    public Ingredient create(IngredientDTO dto) {
        Ingredient ingredient = new Ingredient(dto.getName(), dto.getPrice());
        return repository.save(ingredient);
    }

}

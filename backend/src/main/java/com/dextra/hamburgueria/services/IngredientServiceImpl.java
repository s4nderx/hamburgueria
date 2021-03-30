package com.dextra.hamburgueria.services;

import com.dextra.hamburgueria.entities.Ingredient;
import com.dextra.hamburgueria.repository.IngredientRepository;
import com.dextra.hamburgueria.services.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

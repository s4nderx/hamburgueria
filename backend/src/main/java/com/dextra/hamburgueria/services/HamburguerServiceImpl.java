package com.dextra.hamburgueria.services;

import com.dextra.hamburgueria.dto.request.HamburguerIngredientInsertDTO;
import com.dextra.hamburgueria.dto.request.HamburguerInsertDTO;
import com.dextra.hamburgueria.dto.response.HamburguerDTO;
import com.dextra.hamburgueria.entities.Hamburguer;
import com.dextra.hamburgueria.entities.HamburguerIngredient;
import com.dextra.hamburgueria.entities.Ingredient;
import com.dextra.hamburgueria.repository.HamburguerIngredientReposiroty;
import com.dextra.hamburgueria.repository.HamburguerRepository;
import com.dextra.hamburgueria.services.exception.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class HamburguerServiceImpl implements HamburguerService {

    private final HamburguerRepository hamburguerRepository;

    private final IngredientService ingredientService;

    private final HamburguerIngredientReposiroty hamburguerIngredientReposiroty;

    private final DiscountService discountService;

    public HamburguerServiceImpl(HamburguerRepository hamburguerRepository, IngredientService ingredientService, HamburguerIngredientReposiroty hamburguerIngredientReposiroty, DiscountService discountService) {
        this.hamburguerRepository = hamburguerRepository;
        this.ingredientService = ingredientService;
        this.hamburguerIngredientReposiroty = hamburguerIngredientReposiroty;
        this.discountService = discountService;
    }


    @Override
    public Hamburguer findById(Long id) {
        Hamburguer hamburguer = hamburguerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hamburguer not found, id: " + id));
        return hamburguer;
    }

    @Override
    public Page<Hamburguer> findAll() {
        return null;
    }

    @Override
    public HamburguerDTO create(HamburguerInsertDTO dto) {

        Hamburguer entity = new Hamburguer(dto.getName());
        hamburguerRepository.save(entity);

        for(HamburguerIngredientInsertDTO ingredientDTO : dto.getIngredients()){
            Ingredient ingredient = ingredientService.findById(ingredientDTO.getId());
            HamburguerIngredient hamburguerIngredient = new HamburguerIngredient(entity,ingredient , ingredientDTO.getQuantity(), ingredient.getPrice());
            entity.getHamburguerIngredients().add(hamburguerIngredient);
        }

        entity.calculatePrice();
        entity.setDiscount(this.discountService.getDiscount(entity));
        entity.setFinalPrice(entity.getPrice().subtract(entity.getDiscount()));
        hamburguerIngredientReposiroty.saveAll(entity.getHamburguerIngredients());
        hamburguerRepository.save(entity);
        return new HamburguerDTO(entity);

    }

    private Hamburguer copyDtoToEntity(HamburguerDTO dto, Hamburguer entity){
        entity.setName(dto.getName());
        return entity;
    }
}

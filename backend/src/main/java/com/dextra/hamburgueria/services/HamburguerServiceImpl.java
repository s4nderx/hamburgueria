package com.dextra.hamburgueria.services;

import com.dextra.hamburgueria.dto.request.HamburguerIngredientInsertDTO;
import com.dextra.hamburgueria.dto.request.NewHamburguerDTO;
import com.dextra.hamburgueria.dto.response.HamburguerDTO;
import com.dextra.hamburgueria.entities.Hamburguer;
import com.dextra.hamburgueria.entities.HamburguerIngredient;
import com.dextra.hamburgueria.entities.Ingredient;
import com.dextra.hamburgueria.repository.HamburguerIngredientReposiroty;
import com.dextra.hamburgueria.repository.HamburguerRepository;
import com.dextra.hamburgueria.services.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        return hamburguerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hamburguer not found, id: " + id));
    }

    @Override
    public List<HamburguerDTO> findAll() {
        return hamburguerRepository.findAll().stream()
                .map(HamburguerDTO::new).collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public HamburguerDTO create(NewHamburguerDTO dto) {

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

}

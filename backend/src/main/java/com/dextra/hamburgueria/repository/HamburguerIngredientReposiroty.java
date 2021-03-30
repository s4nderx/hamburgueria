package com.dextra.hamburgueria.repository;

import com.dextra.hamburgueria.entities.HamburguerIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HamburguerIngredientReposiroty extends JpaRepository<HamburguerIngredient, Long> {
}

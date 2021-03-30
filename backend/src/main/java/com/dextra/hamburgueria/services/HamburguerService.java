package com.dextra.hamburgueria.services;

import com.dextra.hamburgueria.dto.request.HamburguerInsertDTO;
import com.dextra.hamburgueria.dto.response.HamburguerDTO;
import com.dextra.hamburgueria.entities.Hamburguer;
import com.dextra.hamburgueria.entities.Ingredient;
import org.springframework.data.domain.Page;

public interface HamburguerService {

    Hamburguer findById(Long id);
    Page<Hamburguer> findAll();
    HamburguerDTO create(HamburguerInsertDTO dto);

}

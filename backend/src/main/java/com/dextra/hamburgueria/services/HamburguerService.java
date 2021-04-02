package com.dextra.hamburgueria.services;

import com.dextra.hamburgueria.dto.request.HamburguerInsertDTO;
import com.dextra.hamburgueria.dto.response.HamburguerDTO;
import com.dextra.hamburgueria.entities.Hamburguer;

import java.util.List;

public interface HamburguerService {

    Hamburguer findById(Long id);
    List<HamburguerDTO> findAll();
    HamburguerDTO create(HamburguerInsertDTO dto);

}

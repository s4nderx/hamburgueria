package com.dextra.hamburgueria.controllers;

import com.dextra.hamburgueria.dto.request.HamburguerInsertDTO;
import com.dextra.hamburgueria.dto.response.HamburguerDTO;
import com.dextra.hamburgueria.dto.response.IngredientDTO;
import com.dextra.hamburgueria.services.HamburguerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "api/hamburguers")
public class HamburguerController {

    private final HamburguerService hamburguerService;

    public HamburguerController(HamburguerService hamburguerService) {
        this.hamburguerService = hamburguerService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<HamburguerDTO> findById(@PathVariable Long id){
        HamburguerDTO obj = new HamburguerDTO(this.hamburguerService.findById(id));
        return  ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<IngredientDTO> create(@RequestBody HamburguerInsertDTO dto){
        HamburguerDTO hamburguerDTO = hamburguerService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(hamburguerDTO.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}

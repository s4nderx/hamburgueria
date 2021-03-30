package com.dextra.hamburgueria.repository;

import com.dextra.hamburgueria.entities.Hamburguer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HamburguerRepository extends JpaRepository<Hamburguer, Long> {
}

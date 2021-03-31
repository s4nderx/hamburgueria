package com.dextra.hamburgueria.entities;

import com.dextra.hamburgueria.services.IngredientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

@SpringBootTest
public class HamburguerTests {

    @Test
    public void calculatePriceShouldCalculateCorrectPrice() {

        Hamburguer xBacon = new Hamburguer("X-Bacon");
        xBacon.setId(1L);

        Ingredient bacon = new Ingredient("Bacon", new BigDecimal("2"));
        bacon.setId(1L);
        Ingredient hamberguerDeCarne = new Ingredient("Hambúrguer de carne", new BigDecimal("3"));
        hamberguerDeCarne.setId(2L);
        Ingredient queijo = new Ingredient("Queijo", new BigDecimal("1.5"));
        queijo.setId(3L);

        HamburguerIngredient hi1 = new HamburguerIngredient(xBacon, bacon, 1, bacon.getPrice());
        HamburguerIngredient hi2 = new HamburguerIngredient(xBacon, hamberguerDeCarne, 2, hamberguerDeCarne.getPrice());
        HamburguerIngredient hi3 = new HamburguerIngredient(xBacon, queijo, 1, queijo.getPrice());

        xBacon.getHamburguerIngredients().addAll(Arrays.asList(hi1, hi2, hi3));

        bacon.getItens().addAll(Collections.singletonList(hi1));
        hamberguerDeCarne.getItens().addAll(Collections.singletonList(hi1));
        queijo.getItens().addAll(Collections.singletonList(hi1));

        BigDecimal price = xBacon.calculatePrice();

        Assertions.assertEquals(price, new BigDecimal("9.5"));

    }

}

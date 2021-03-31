package com.dextra.hamburgueria.services;

import com.dextra.hamburgueria.entities.Hamburguer;
import com.dextra.hamburgueria.entities.HamburguerIngredient;
import com.dextra.hamburgueria.entities.Ingredient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Collections;

@ExtendWith({SpringExtension.class})
@SpringBootTest
public class DiscontServiceTests {

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private DiscountService discountService;

    @Test
    public void getDiscountShouldApplyTakeTreePayToVeryMeat() {

        Hamburguer veryMeat = new Hamburguer("X-Meat");
        veryMeat.setId(5L);
        Ingredient hamberguerDeCarne = this.ingredientService.findById(3L);
        HamburguerIngredient hi1 = new HamburguerIngredient(veryMeat, hamberguerDeCarne, 7, hamberguerDeCarne.getPrice());
        veryMeat.getHamburguerIngredients().addAll(Collections.singletonList(hi1));
        hamberguerDeCarne.getItens().addAll(Collections.singletonList(hi1));
        veryMeat.calculatePrice();
        veryMeat.setDiscount(this.discountService.getDiscount(veryMeat));
        veryMeat.setFinalPrice(veryMeat.getPrice().subtract(veryMeat.getDiscount()));

        BigDecimal discount = hamberguerDeCarne.getPrice().multiply(new BigDecimal(7 / 3));

        Assertions.assertEquals(discount, veryMeat.getDiscount());

    }

    @Test
    public void getDiscountShouldApplyTakeTreePayToVeryCheese() {

        Hamburguer veryCheese = new Hamburguer("X-Cheese");
        veryCheese.setId(6L);
        Ingredient queijo = this.ingredientService.findById(5L);
        HamburguerIngredient hi1 = new HamburguerIngredient(veryCheese, queijo, 7, queijo.getPrice());
        veryCheese.getHamburguerIngredients().addAll(Collections.singletonList(hi1));
        queijo.getItens().addAll(Collections.singletonList(hi1));

        veryCheese.calculatePrice();
        veryCheese.setDiscount(this.discountService.getDiscount(veryCheese));
        veryCheese.setFinalPrice(veryCheese.getPrice().subtract(veryCheese.getDiscount()));

        BigDecimal discount = queijo.getPrice().multiply(new BigDecimal(7 / 3));

        Assertions.assertEquals(discount, veryCheese.getDiscount());

    }

    @Test
    public void getDiscountShouldApplyLight() {

        Hamburguer alfaceBurguer = new Hamburguer("X-Alface");
        alfaceBurguer.setId(7L);
        Ingredient alface = this.ingredientService.findById(1L);
        HamburguerIngredient hi1 = new HamburguerIngredient(alfaceBurguer, alface, 1, alface.getPrice());
        alfaceBurguer.getHamburguerIngredients().addAll(Collections.singletonList(hi1));
        alface.getItens().addAll(Collections.singletonList(hi1));

        alfaceBurguer.calculatePrice();
        alfaceBurguer.setDiscount(this.discountService.getDiscount(alfaceBurguer));
        alfaceBurguer.setFinalPrice(alfaceBurguer.getPrice().subtract(alfaceBurguer.getDiscount()));

        BigDecimal discount = alfaceBurguer.getPrice().multiply(new BigDecimal("0.1"));

        Assertions.assertEquals(discount, alfaceBurguer.getDiscount());

    }

    @Test
    public void getDiscountShouldApplyNoDiscount() {

        Hamburguer regularBurguer = new Hamburguer("X-Cheese");
        regularBurguer.setId(6L);
        Ingredient queijo = this.ingredientService.findById(5L);
        HamburguerIngredient hi1 = new HamburguerIngredient(regularBurguer, queijo, 2, queijo.getPrice());
        regularBurguer.getHamburguerIngredients().addAll(Collections.singletonList(hi1));
        queijo.getItens().addAll(Collections.singletonList(hi1));

        regularBurguer.calculatePrice();
        regularBurguer.setDiscount(this.discountService.getDiscount(regularBurguer));
        regularBurguer.setFinalPrice(regularBurguer.getPrice().subtract(regularBurguer.getDiscount()));

        Assertions.assertEquals(BigDecimal.ZERO, regularBurguer.getDiscount());
        Assertions.assertEquals(regularBurguer.getFinalPrice(), regularBurguer.getPrice());

    }

}

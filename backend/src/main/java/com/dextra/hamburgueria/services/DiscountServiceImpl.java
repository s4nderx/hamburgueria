package com.dextra.hamburgueria.services;

import com.dextra.hamburgueria.entities.Hamburguer;
import com.dextra.hamburgueria.services.discounts.Discount;
import com.dextra.hamburgueria.services.discounts.Light;
import com.dextra.hamburgueria.services.discounts.NoDiscount;
import com.dextra.hamburgueria.services.discounts.TakeTreePayTwo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final IngredientService ingredientService;

    public DiscountServiceImpl(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Override
    public BigDecimal getDiscount(Hamburguer hamburguer) {
        Discount discount = new Light(
                            new TakeTreePayTwo(
                            new TakeTreePayTwo(
                            new NoDiscount(),
                                    5L,
                                    ingredientService.findById(5L).getPrice()),
                            3L, ingredientService.findById(3L).getPrice()));
        return discount.calculate(hamburguer);
    }
}

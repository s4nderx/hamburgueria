package com.dextra.hamburgueria.services;

import com.dextra.hamburgueria.entities.Hamburguer;
import com.dextra.hamburgueria.entities.HamburguerIngredient;
import com.dextra.hamburgueria.entities.Ingredient;
import com.dextra.hamburgueria.repository.HamburguerIngredientReposiroty;
import com.dextra.hamburgueria.repository.HamburguerRepository;
import com.dextra.hamburgueria.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Arrays;

@Service
public class DbService {

    private final HamburguerRepository hamburguerRepository;

    private final IngredientRepository ingredientRepository;

    private final HamburguerIngredientReposiroty hamburguerIngredientReposiroty;

    public DbService(HamburguerRepository hamburguerRepository, IngredientRepository ingredientRepository, HamburguerIngredientReposiroty hamburguerIngredientReposiroty) {
        this.hamburguerRepository = hamburguerRepository;
        this.ingredientRepository = ingredientRepository;
        this.hamburguerIngredientReposiroty = hamburguerIngredientReposiroty;
    }

    public void instantiateTestDatabase() throws ParseException {

        //Instanciando Ingredients
        Ingredient alface = new Ingredient("Alface", new BigDecimal("0.4"));
        Ingredient bacon = new Ingredient("Bacon", new BigDecimal("2"));
        Ingredient hamberguerDeCarne = new Ingredient("Hambúrguer de carne", new BigDecimal("3"));
        Ingredient ovo = new Ingredient("Ovo", new BigDecimal("0.8"));
        Ingredient queijo = new Ingredient("Queijo", new BigDecimal("1.5"));
        ingredientRepository.saveAll(Arrays.asList(alface, bacon, hamberguerDeCarne, ovo, queijo));

        //Instanciando Hamburguers
        Hamburguer xBacon = new Hamburguer("X-Bacon");
        Hamburguer xBurguer = new Hamburguer("X-Burger");
        Hamburguer xEgg = new Hamburguer("X-Egg");
        Hamburguer xEggBacon = new Hamburguer("X-Egg Bacon");

        hamburguerRepository.saveAll(Arrays.asList(xBacon, xBurguer, xEgg, xEggBacon));

        //Montando Hamburguers
        //X-Bacon
        HamburguerIngredient hi1 = new HamburguerIngredient(xBacon, bacon, 1, bacon.getPrice());
        HamburguerIngredient hi2 = new HamburguerIngredient(xBacon, hamberguerDeCarne, 1, hamberguerDeCarne.getPrice());
        HamburguerIngredient hi3 = new HamburguerIngredient(xBacon, queijo, 1, queijo.getPrice());

        //X-Burger
        HamburguerIngredient hi4 = new HamburguerIngredient(xBurguer, hamberguerDeCarne, 1, hamberguerDeCarne.getPrice());
        HamburguerIngredient hi5 = new HamburguerIngredient(xBurguer, queijo, 1, queijo.getPrice());

        //X-Egg
        HamburguerIngredient hi6 = new HamburguerIngredient(xEgg, ovo, 1, ovo.getPrice());
        HamburguerIngredient hi7 = new HamburguerIngredient(xEgg, hamberguerDeCarne, 1, hamberguerDeCarne.getPrice());
        HamburguerIngredient hi8 = new HamburguerIngredient(xEgg, queijo, 1, queijo.getPrice());

        //X-Egg Bacon
        HamburguerIngredient hi9 = new HamburguerIngredient(xEggBacon, ovo, 1, ovo.getPrice());
        HamburguerIngredient hi10 = new HamburguerIngredient(xEggBacon, bacon, 1, bacon.getPrice());
        HamburguerIngredient hi11 = new HamburguerIngredient(xEggBacon, hamberguerDeCarne, 1, hamberguerDeCarne.getPrice());
        HamburguerIngredient hi12 = new HamburguerIngredient(xEggBacon, queijo, 1, queijo.getPrice());

        //Adicionando os igredientes e calculando preco
        xBacon.getHamburguerIngredients().addAll(Arrays.asList(hi1, hi2, hi3));
        xBacon.calculatePrice();
        xBurguer.getHamburguerIngredients().addAll(Arrays.asList(hi4, hi5));
        xBurguer.calculatePrice();
        xEgg.getHamburguerIngredients().addAll(Arrays.asList(hi5, hi7, hi8));
        xEgg.calculatePrice();
        xEggBacon.getHamburguerIngredients().addAll(Arrays.asList(hi9, hi10, hi11, hi12));
        xEggBacon.calculatePrice();

        //associando hamburguers a ingredientes para relacionamento
        bacon.getItens().addAll(Arrays.asList(hi10, hi1));
        hamberguerDeCarne.getItens().addAll(Arrays.asList(hi2, hi4, hi7, hi11));
        ovo.getItens().addAll(Arrays.asList(hi6, hi9));
        queijo.getItens().addAll(Arrays.asList(hi3, hi5, hi8, hi12));

        //salvando no banco
        hamburguerIngredientReposiroty.saveAll(Arrays.asList(hi1, hi2, hi3, hi4, hi5, hi6, hi7, hi8, hi9, hi10, hi11, hi12));
        hamburguerRepository.saveAll(Arrays.asList(xBacon, xBurguer, xEgg, xEggBacon));

    }
}

package com.dextra.hamburgueria.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_hamburguers")
public class Hamburguer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column( name = "price")
    private BigDecimal price;

    @Column( name = "final_price")
    private BigDecimal finalPrice;

    private BigDecimal discount = BigDecimal.ZERO;

    @OneToMany(mappedBy = "id.hamburguer")
    private final List<HamburguerIngredient> hamburguerIngredients = new ArrayList<>();

    public Hamburguer() {

    }

    public Hamburguer(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public List<HamburguerIngredient> getHamburguerIngredients() {
        return hamburguerIngredients;
    }

    public void calculatePrice() {
        this.price = hamburguerIngredients.stream()
        .map(hamburguerIngredient -> hamburguerIngredient.getPrice()
                .multiply(BigDecimal.valueOf(hamburguerIngredient.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        this.finalPrice = this.price;
    }

    @Override
    public String toString() {
        return "Hamburguer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", finalPrice=" + finalPrice +
                ", discount=" + discount +
                ", hamburguerIngredients=" + hamburguerIngredients +
                '}';
    }

}

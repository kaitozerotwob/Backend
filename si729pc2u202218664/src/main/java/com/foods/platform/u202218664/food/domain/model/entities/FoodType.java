package com.foods.platform.u202218664.food.domain.model.entities;

import com.foods.platform.u202218664.food.domain.model.valueobjects.Locate;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class FoodType {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false, unique = true)
    private Locate name;

    public FoodType() {
    }

    public FoodType(Locate locate) {
        this.name = locate;
    }

    public static FoodType fromLocateName(String name) {
        return new FoodType(Locate.valueOf(name));
    }
}
package com.foods.platform.u202218664.food.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class FoodId {
    private Long value;

    public FoodId() {}

    public FoodId(Long value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("Food ID must be greater than zero");
        }
        this.value = value;
    }
}

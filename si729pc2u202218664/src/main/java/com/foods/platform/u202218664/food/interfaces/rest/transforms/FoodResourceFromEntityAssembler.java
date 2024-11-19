package com.foods.platform.u202218664.food.interfaces.rest.transforms;

import com.foods.platform.u202218664.food.domain.model.aggregates.Food;
import com.foods.platform.u202218664.food.interfaces.rest.resources.FoodResource;

public class FoodResourceFromEntityAssembler {

    public static FoodResource toResourceFromEntity(Food entity) {
        return new FoodResource(
                entity.getId(),
                entity.getFoodId().getValue(),
                entity.getName(),
                entity.getOwnerEmailAddress().getAddress(),
                entity.getDescription(),
                entity.getLocate().name(),
                entity.getFoodDateAt().toString()
        );
    }
}
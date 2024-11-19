package com.foods.platform.u202218664.food.interfaces.rest.resources;

public record CreateFoodResource(
        String name,
        String ownerEmailAddress,
        String description,
        String locate
) {
}

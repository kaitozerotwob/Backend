package com.foods.platform.u202218664.food.interfaces.rest.resources;

public record FoodResource(
        Long id,
        Long foodId,
        String name,
        String ownerEmailAddress,
        String description,
        String locate,
        String foodDateAt
) {
}
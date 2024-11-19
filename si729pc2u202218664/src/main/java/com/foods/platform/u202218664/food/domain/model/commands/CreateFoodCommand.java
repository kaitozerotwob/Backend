package com.foods.platform.u202218664.food.domain.model.commands;

import com.foods.platform.u202218664.food.domain.model.valueobjects.FoodId;
import com.foods.platform.u202218664.food.domain.model.valueobjects.EmailAddress;
import com.foods.platform.u202218664.food.domain.model.valueobjects.Locate;

public record CreateFoodCommand(
        FoodId foodId,
        String name,
        EmailAddress ownerEmailAddress,
        String description,
        Locate locate
) {
    public CreateFoodCommand {
        if (foodId == null) {
            throw new IllegalArgumentException("FoodId is required");
        }
        if (name == null || name.isBlank() || name.length() > 50) {
            throw new IllegalArgumentException("Food name is required and must be less than 50 characters");
        }
        if (ownerEmailAddress == null) {
            throw new IllegalArgumentException("Owner email address is required");
        }
        if (description == null || description.isBlank() || description.length() > 250) {
            throw new IllegalArgumentException("Description is required and must be less than 250 characters");
        }
        if (locate == null) {
            throw new IllegalArgumentException("Locate is required");
        }
    }
}
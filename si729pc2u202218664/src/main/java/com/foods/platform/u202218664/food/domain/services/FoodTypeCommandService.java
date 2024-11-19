package com.foods.platform.u202218664.food.domain.services;

import com.foods.platform.u202218664.food.domain.model.commands.SeedFoodTypesCommand;

/**
 * Created by Angel Anampa Asto - A.K.A (Angel)
 * Project: foods
 */
public interface FoodTypeCommandService {
    
    void handle(SeedFoodTypesCommand command);
}

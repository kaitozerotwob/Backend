package com.foods.platform.u202218664.food.domain.services;

import com.foods.platform.u202218664.food.domain.model.aggregates.Food;
import com.foods.platform.u202218664.food.domain.model.commands.CreateFoodCommand;

import java.util.Optional;

/**
 * Created by Angel Anampa Asto - A.K.A (Angel)
 * Project: foods
 */
public interface FoodCommandService {

    Optional<Food> handle(CreateFoodCommand command);
}

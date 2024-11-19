package com.foods.platform.u202218664.food.application.internal.commandservices;

import com.foods.platform.u202218664.food.domain.model.aggregates.Food;
import com.foods.platform.u202218664.food.domain.model.commands.CreateFoodCommand;
import com.foods.platform.u202218664.food.domain.services.FoodCommandService;
import com.foods.platform.u202218664.food.infrastructure.persistence.jpa.repositories.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodCommandServiceImpl implements FoodCommandService {

    private final FoodRepository foodRepository;

    public FoodCommandServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Optional<Food> handle(CreateFoodCommand command) {
        if (foodRepository.existsByNameAndFoodIdAndLocate(command.name(), command.foodId(), command.locate())) {
            throw new RuntimeException("Food with name, foodId and locate already exists");
        }

        var food = new Food(command.foodId(), command.name(), command.ownerEmailAddress(), command.description(), command.locate());
        return Optional.of(foodRepository.save(food));
    }
}

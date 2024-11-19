package com.foods.platform.u202218664.food.application.internal.commandservices;

import com.foods.platform.u202218664.food.domain.model.commands.SeedFoodTypesCommand;
import com.foods.platform.u202218664.food.domain.model.entities.FoodType;
import com.foods.platform.u202218664.food.domain.model.valueobjects.Locate;
import com.foods.platform.u202218664.food.domain.services.FoodTypeCommandService;
import com.foods.platform.u202218664.food.infrastructure.persistence.jpa.repositories.FoodTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class FoodTypeCommandServiceImpl implements FoodTypeCommandService {

    private final FoodTypeRepository foodTypeRepository;

    public FoodTypeCommandServiceImpl(FoodTypeRepository foodTypeRepository) {
        this.foodTypeRepository = foodTypeRepository;
    }

    @Override
    public void handle(SeedFoodTypesCommand command) {
        Arrays.stream(Locate.values()).forEach(locate -> {
            if (!foodTypeRepository.existsByName(locate)) {
                foodTypeRepository.save(new FoodType(locate));
            }
        });
    }
}
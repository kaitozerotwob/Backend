package com.foods.platform.u202218664.food.interfaces.rest.transforms;

import com.foods.platform.u202218664.food.domain.model.commands.CreateFoodCommand;
import com.foods.platform.u202218664.food.domain.model.valueobjects.EmailAddress;
import com.foods.platform.u202218664.food.domain.model.valueobjects.FoodId;
import com.foods.platform.u202218664.food.domain.model.valueobjects.Locate;
import com.foods.platform.u202218664.food.interfaces.rest.resources.CreateFoodResource;

public class CreateFoodCommandFromResourceAssembler {

    public static CreateFoodCommand toCommandFromResource(Long foodId, CreateFoodResource resource) {
        return new CreateFoodCommand(
                new FoodId(foodId),
                resource.name(),
                new EmailAddress(resource.ownerEmailAddress()),
                resource.description(),
                Locate.valueOf(resource.locate().toUpperCase())
        );
    }
}

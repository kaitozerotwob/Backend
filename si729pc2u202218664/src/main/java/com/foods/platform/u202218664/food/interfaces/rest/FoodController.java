package com.foods.platform.u202218664.food.interfaces.rest;

import com.foods.platform.u202218664.food.domain.model.aggregates.Food;
import com.foods.platform.u202218664.food.domain.model.commands.CreateFoodCommand;
import com.foods.platform.u202218664.food.domain.model.valueobjects.FoodId;
import com.foods.platform.u202218664.food.domain.services.FoodCommandService;
import com.foods.platform.u202218664.food.interfaces.rest.resources.CreateFoodResource;
import com.foods.platform.u202218664.food.interfaces.rest.resources.FoodResource;
import com.foods.platform.u202218664.food.interfaces.rest.transforms.CreateFoodCommandFromResourceAssembler;
import com.foods.platform.u202218664.food.interfaces.rest.transforms.FoodResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/foods", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Foods", description = "Food management endpoints")
public class FoodController {

    private final FoodCommandService foodCommandService;

    public FoodController(FoodCommandService foodCommandService) {
        this.foodCommandService = foodCommandService;
    }

    @Operation(summary = "Create a new food", description = "Creates a new food item with the provided details")
    @PostMapping("/{foodId}")
    public ResponseEntity<FoodResource> createFood(@PathVariable Long foodId, @RequestBody CreateFoodResource resource) {
        var createFoodCommand = CreateFoodCommandFromResourceAssembler.toCommandFromResource(foodId, resource);

        var createdFood = foodCommandService.handle(createFoodCommand);

        return createdFood.map(food -> new ResponseEntity<>(FoodResourceFromEntityAssembler.toResourceFromEntity(food), HttpStatus.CREATED))
                .orElse(ResponseEntity.badRequest().build());
    }


}

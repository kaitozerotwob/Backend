package com.foods.platform.u202218664.food.application.internal.eventhandlers;

import com.foods.platform.u202218664.food.domain.model.commands.SeedFoodTypesCommand;
import com.foods.platform.u202218664.food.domain.services.FoodTypeCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Created by Angel Anampa Asto - (Angel)
 * Project: foods
 */
@Service
public class ApplicationReadyEventHandler {

    private final FoodTypeCommandService foodTypeCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(FoodTypeCommandService foodTypeCommandService) {
        this.foodTypeCommandService = foodTypeCommandService;
    }

    /**
     * This method is called when the application is ready.
     * It will verify if the foods types seeding is needed.
     *
     * @param event The event that indicates that the application is ready.
     * @author Angel Anampa
     */
    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getApplicationName();
        LOGGER.info("Application {} is ready, starting to verify if foods types seeding is needed.", applicationName);
        var seedCommand = new SeedFoodTypesCommand();
        foodTypeCommandService.handle(seedCommand);
        LOGGER.info("foods types seeding is done.");
    }
}

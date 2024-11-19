package com.foods.platform.u202218664.food.infrastructure.persistence.jpa.repositories;

import com.foods.platform.u202218664.food.domain.model.entities.FoodType;
import com.foods.platform.u202218664.food.domain.model.valueobjects.Locate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Angel Anampa Asto - A.K.A (Angel)
 * Project: foods
 */
@Repository
public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {

    /**
     * Query to check if the food type exists by name
     * @param name foodTypes
     * @return boolean
     * @author Angel Anampa
     */
    boolean existsByName(Locate name);
}

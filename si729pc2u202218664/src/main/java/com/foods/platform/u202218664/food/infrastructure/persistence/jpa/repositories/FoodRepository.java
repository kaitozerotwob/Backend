package com.foods.platform.u202218664.food.infrastructure.persistence.jpa.repositories;

import com.foods.platform.u202218664.food.domain.model.aggregates.Food;
import com.foods.platform.u202218664.food.domain.model.valueobjects.FoodId;
import com.foods.platform.u202218664.food.domain.model.valueobjects.Locate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    boolean existsByNameAndFoodIdAndLocate(String name, FoodId foodId, Locate locate);
}
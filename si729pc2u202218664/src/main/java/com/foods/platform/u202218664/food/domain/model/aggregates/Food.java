package com.foods.platform.u202218664.food.domain.model.aggregates;

import com.foods.platform.u202218664.food.domain.model.valueobjects.EmailAddress;
import com.foods.platform.u202218664.food.domain.model.valueobjects.FoodId;
import com.foods.platform.u202218664.food.domain.model.valueobjects.Locate;
import com.foods.platform.u202218664.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = "foods", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "food_id", "locate"})
})
public class Food extends AuditableAbstractAggregateRoot<Food> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Embedded
    private FoodId foodId;

    @Getter
    @NotBlank
    @Size(max = 50)
    @Column(length = 50, nullable = false)
    private String name;

    @Getter
    @Embedded
    private EmailAddress ownerEmailAddress;

    @Getter
    @NotBlank
    @Size(max = 250)
    @Column(length = 250, nullable = false)
    private String description;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Locate locate;

    @Getter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "food_date_at", nullable = false)
    private Date foodDateAt;

    public Food() {}

    public Food(FoodId foodId, String name, EmailAddress ownerEmailAddress, String description, Locate locate) {
        this.foodId = foodId;
        this.name = name;
        this.ownerEmailAddress = ownerEmailAddress;
        this.description = description;
        this.locate = locate;
        this.foodDateAt = new Date(); // Fecha actual al momento de creación
    }
}

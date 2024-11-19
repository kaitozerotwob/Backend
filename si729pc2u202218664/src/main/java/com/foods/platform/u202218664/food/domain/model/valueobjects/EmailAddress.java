package com.foods.platform.u202218664.food.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
@Embeddable
public class EmailAddress {
    @NotBlank
    @Email
    @Size(max = 50)
    private String address;

    public EmailAddress() {}

    public EmailAddress(String address) {
        if (address == null || address.isBlank() || address.length() > 50 || !address.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.address = address;
    }
}

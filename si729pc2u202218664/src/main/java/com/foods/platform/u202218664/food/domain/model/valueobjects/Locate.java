package com.foods.platform.u202218664.food.domain.model.valueobjects;

public enum Locate {
    EAST(1),
    WEST(2),
    CENTRAL_WEST(3),
    CENTRAL_EAST(4);

    private final int value;

    Locate(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Locate fromValue(int value) {
        for (Locate locate : values()) {
            if (locate.value == value) {
                return locate;
            }
        }
        throw new IllegalArgumentException("Invalid Locate value: " + value);
    }
}

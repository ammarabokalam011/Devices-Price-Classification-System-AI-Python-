package com.ammar.devicespriceclassificationsystem;

public enum PriceRange {
    low_code(0),
    medium_cost(1),
    high_cost(2),
    very_high_cost(3);

    private int value;
    PriceRange(int i) {
        value=i;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

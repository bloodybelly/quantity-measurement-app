package com.quantity.model;

public class Quantity {

    private double value;
    private String unit;

    public Quantity(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public boolean equals(Quantity other) {
        if (!this.unit.equals(other.unit)) {
            throw new IllegalArgumentException("Units must be same");
        }
        return this.value == other.value;
    }
}
package com.quantity.model;

public class Quantity {

    private double value;
    private Unit unit;

    public Quantity(double value, Unit unit) {

        if (Double.isNaN(value)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    public boolean equals(Quantity other) {

        if (other == null) {
            return false;
        }

        double thisInFeet = this.unit.toFeet(this.value);
        double otherInFeet = other.unit.toFeet(other.value);

        return thisInFeet == otherInFeet;
    }
}
package com.quantity.model;

public class Quantity {

    private double value; // value in feet

    public Quantity(double value) {

        if (Double.isNaN(value)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }

        this.value = value;
    }

    public boolean equals(Quantity other) {

        if (other == null) {
            return false;
        }

        return this.value == other.value;
    }
}
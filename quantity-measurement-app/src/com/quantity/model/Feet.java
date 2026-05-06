package com.quantity.model;

public class Feet {

    private double value;

    public Feet(double value) {

        if (Double.isNaN(value)) {
            throw new IllegalArgumentException("Invalid Feet value");
        }

        this.value = value;
    }

    public boolean equals(Feet other) {

        if (other == null) {
            return false;
        }

        return this.value == other.value;
    }
}
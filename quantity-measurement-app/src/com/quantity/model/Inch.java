package com.quantity.model;

public class Inch {

    private double value;

    public Inch(double value) {

        if (Double.isNaN(value)) {
            throw new IllegalArgumentException("Invalid Inch value");
        }

        this.value = value;
    }

    public boolean equals(Inch other) {

        if (other == null) {
            return false;
        }

        return this.value == other.value;
    }
}
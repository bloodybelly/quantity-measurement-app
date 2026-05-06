package com.quantity.model;

public enum Unit {

    FEET(1.0),
    INCH(1.0 / 12.0); // 1 inch = 1/12 feet

    private final double toFeet;

    Unit(double toFeet) {
        this.toFeet = toFeet;
    }

    public double toFeet(double value) {
        return value * toFeet;
    }
}
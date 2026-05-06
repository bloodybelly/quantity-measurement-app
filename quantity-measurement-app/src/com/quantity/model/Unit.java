package com.quantity.model;

public enum Unit {

    FEET(1.0),
    INCH(1.0 / 12.0),
    YARD(3.0),
    CM(0.0328084); // converted to feet

    private final double toFeet;

    Unit(double toFeet) {
        this.toFeet = toFeet;
    }

    public double toFeet(double value) {
        return value * toFeet;
    }
}
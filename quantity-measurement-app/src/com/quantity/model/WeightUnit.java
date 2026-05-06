package com.quantity.model;

public enum WeightUnit {

    KG(1.0),
    GRAM(1.0 / 1000.0),
    POUND(0.453592);

    private final double toKg;

    WeightUnit(double toKg) {
        this.toKg = toKg;
    }

    public double toKg(double value) {
        return value * toKg;
    }
}
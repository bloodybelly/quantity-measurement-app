package com.quantity.model;

public enum Unit {

    FEET(1.0),
    INCH(1.0 / 12.0),
    YARD(3.0),
    CM(0.0328084);

    private final double toFeetFactor;

    Unit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    // =========================
    // TO BASE UNIT (FEET)
    // =========================
    public double toBaseUnit(double value) {
        return value * toFeetFactor;
    }

    // =========================
    // FROM BASE UNIT (FEET → UNIT)
    // =========================
    public double fromBaseUnit(double baseValue) {
        return baseValue / toFeetFactor;
    }
}
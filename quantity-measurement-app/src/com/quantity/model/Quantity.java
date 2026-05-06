package com.quantity.model;

public class Quantity {

    private double value;
    private Unit unit;

    public Quantity(double value, Unit unit) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    // =========================
    // UC4: EQUALITY (unchanged but improved)
    // =========================
    public boolean equals(Quantity other) {

        if (other == null) return false;

        double thisFeet = this.unit.toFeet(this.value);
        double otherFeet = other.unit.toFeet(other.value);

        return Math.abs(thisFeet - otherFeet) < 0.0001;
    }

    // =========================
    // 🚀 UC5: CONVERSION API
    // =========================
    public double convertTo(Unit targetUnit) {

        // Step 1: convert to base (feet)
        double baseValue = this.unit.toFeet(this.value);

        // Step 2: convert base → target
        return baseValue / targetUnit.toFeet(1);
    }
}
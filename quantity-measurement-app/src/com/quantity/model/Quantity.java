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
    // UC4/UC5: EQUALITY
    // =========================
    public boolean equals(Quantity other) {

        if (other == null) return false;

        double thisFeet = this.unit.toFeet(this.value);
        double otherFeet = other.unit.toFeet(other.value);

        return Math.abs(thisFeet - otherFeet) < 0.0001;
    }

    // =========================
    // UC5: CONVERSION
    // =========================
    public double convertTo(Unit targetUnit) {

        double base = this.unit.toFeet(this.value);
        return base / targetUnit.toFeet(1);
    }

    // =========================
    // 🚀 UC6: ADDITION
    // =========================
    public Quantity add(Quantity other) {

        if (other == null) {
            throw new IllegalArgumentException("Cannot add null quantity");
        }

        // Step 1: convert both to base unit (feet)
        double thisFeet = this.unit.toFeet(this.value);
        double otherFeet = other.unit.toFeet(other.value);

        // Step 2: sum in base unit
        double sumFeet = thisFeet + otherFeet;

        // Step 3: convert back to FIRST operand unit
        double resultValue = sumFeet / this.unit.toFeet(1);

        return new Quantity(resultValue, this.unit);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
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
    // UC6 (still supported internally)
    // =========================
    public Quantity add(Quantity other) {

        if (other == null) {
            throw new IllegalArgumentException("Cannot add null quantity");
        }

        double sumFeet =
                this.unit.toFeet(this.value) +
                        other.unit.toFeet(other.value);

        double resultValue = sumFeet / this.unit.toFeet(1);

        return new Quantity(resultValue, this.unit);
    }

    // =========================
    // 🚀 UC7: ADD WITH TARGET UNIT
    // =========================
    public Quantity add(Quantity other, Unit targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException("Second operand is null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit is null");
        }

        // Step 1: convert both to base (feet)
        double sumFeet =
                this.unit.toFeet(this.value) +
                        other.unit.toFeet(other.value);

        // Step 2: convert to target unit
        double resultValue = sumFeet / targetUnit.toFeet(1);

        return new Quantity(resultValue, targetUnit);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
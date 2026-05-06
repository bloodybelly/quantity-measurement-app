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

        double thisBase = this.unit.toBaseUnit(this.value);
        double otherBase = other.unit.toBaseUnit(other.value);

        return Math.abs(thisBase - otherBase) < 0.0001;
    }

    // =========================
    // UC5: CONVERSION
    // =========================
    public double convertTo(Unit targetUnit) {

        double base = this.unit.toBaseUnit(this.value);
        return targetUnit.fromBaseUnit(base);
    }

    // =========================
    // UC6/UC7: ADDITION
    // =========================
    public Quantity add(Quantity other, Unit targetUnit) {

        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double sumBase =
                this.unit.toBaseUnit(this.value) +
                        other.unit.toBaseUnit(other.value);

        double result = targetUnit.fromBaseUnit(sumBase);

        return new Quantity(result, targetUnit);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
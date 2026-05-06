package com.quantity.model;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    // =========================
    // EQUALITY (UC10)
    // =========================
    public boolean equals(Quantity<U> other) {

        if (other == null) return false;

        double thisBase = this.unit.convertToBaseUnit(this.value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        return Math.abs(thisBase - otherBase) < 0.0001;
    }

    // =========================
    // CONVERSION
    // =========================
    public double convertTo(U targetUnit) {

        double base = this.unit.convertToBaseUnit(this.value);
        return targetUnit.convertFromBaseUnit(base);
    }

    // =========================
    // ADD (same unit result)
    // =========================
    public Quantity<U> add(Quantity<U> other) {

        double sumBase =
                this.unit.convertToBaseUnit(this.value) +
                        other.unit.convertToBaseUnit(other.value);

        double result = this.unit.convertFromBaseUnit(sumBase);

        return new Quantity<>(result, this.unit);
    }

    // =========================
    // ADD (target unit)
    // =========================
    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        double sumBase =
                this.unit.convertToBaseUnit(this.value) +
                        other.unit.convertToBaseUnit(other.value);

        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new Quantity<>(result, targetUnit);
    }

    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }
}
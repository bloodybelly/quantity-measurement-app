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
    // BASE CONVERSION
    // =========================
    private double toBase() {
        return unit.convertToBaseUnit(value);
    }

    private double fromBase(double baseValue, U targetUnit) {
        return targetUnit.convertFromBaseUnit(baseValue);
    }

    // =========================
    // EQUALITY (UC10+)
    // =========================
    public boolean equals(Quantity<U> other) {

        if (other == null) return false;

        return Math.abs(this.toBase() - other.toBase()) < 0.0001;
    }

    // =========================
    // ADDITION (UC10+)
    // =========================
    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        double resultBase = this.toBase() + other.toBase();
        double result = fromBase(resultBase, targetUnit);

        return new Quantity<>(result, targetUnit);
    }

    // =========================
    // 🚀 SUBTRACTION (UC12)
    // =========================
    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException("Cannot subtract null");
        }

        double resultBase = this.toBase() - other.toBase();
        double result = fromBase(resultBase, targetUnit);

        return new Quantity<>(result, targetUnit);
    }

    // =========================
    // 🚀 DIVISION (UC12)
    // =========================
    public double divide(Quantity<U> other) {

        if (other == null) {
            throw new IllegalArgumentException("Cannot divide by null");
        }

        if (other.toBase() == 0) {
            throw new ArithmeticException("Division by zero");
        }

        return this.toBase() / other.toBase();
    }

    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }
}
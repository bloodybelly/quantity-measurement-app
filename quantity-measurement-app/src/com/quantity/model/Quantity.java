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
    // BASE UTILITIES
    // =========================
    private double toBase() {
        return unit.convertToBaseUnit(value);
    }

    private double fromBase(double base, U targetUnit) {
        return targetUnit.convertFromBaseUnit(base);
    }

    // =========================
    // 🚀 CENTRALIZED HELPER (UC13)
    // =========================
    private double compute(Quantity<U> other, ArithmeticOperation op) {

        if (other == null) {
            throw new IllegalArgumentException("Operand cannot be null");
        }

        if (this.unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException("Incompatible unit types");
        }

        double a = this.toBase();
        double b = other.toBase();

        return switch (op) {
            case ADD -> a + b;
            case SUBTRACT -> a - b;
            case DIVIDE -> {
                if (b == 0) throw new ArithmeticException("Division by zero");
                yield a / b;
            }
        };
    }

    // =========================
    // EQUALITY (UNCHANGED)
    // =========================
    public boolean equals(Quantity<U> other) {

        if (other == null) return false;

        return Math.abs(this.toBase() - other.toBase()) < 0.0001;
    }

    // =========================
    // ADD (UC13 REFACTORED)
    // =========================
    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        double resultBase = compute(other, ArithmeticOperation.ADD);
        double result = fromBase(resultBase, targetUnit);

        return new Quantity<>(result, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    // =========================
    // SUBTRACT (UC13 REFACTORED)
    // =========================
    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        double resultBase = compute(other, ArithmeticOperation.SUBTRACT);
        double result = fromBase(resultBase, targetUnit);

        return new Quantity<>(result, targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    // =========================
    // DIVIDE (UC13 REFACTORED)
    // =========================
    public double divide(Quantity<U> other) {
        return compute(other, ArithmeticOperation.DIVIDE);
    }

    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }
}
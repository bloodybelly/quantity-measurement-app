package com.quantity.model;

public class QuantityWeight {

    private double value;
    private WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {

        if (Double.isNaN(value)) {
            throw new IllegalArgumentException("Invalid weight value");
        }

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    // =========================
    // EQUALITY (UC9 CORE)
    // =========================
    public boolean equals(QuantityWeight other) {

        if (other == null) {
            return false;
        }

        double thisInKg = this.unit.toKg(this.value);
        double otherInKg = other.unit.toKg(other.value);

        return Math.abs(thisInKg - otherInKg) < 0.0001;
    }

    // =========================
    // CONVERSION
    // =========================
    public double convertTo(WeightUnit targetUnit) {

        double baseKg = this.unit.toKg(this.value);
        return baseKg / targetUnit.toKg(1);
    }

    // =========================
    // ADDITION
    // =========================
    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {

        double sumKg =
                this.unit.toKg(this.value) +
                        other.unit.toKg(other.value);

        double convertedValue = sumKg / targetUnit.toKg(1);

        return new QuantityWeight(convertedValue, targetUnit);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
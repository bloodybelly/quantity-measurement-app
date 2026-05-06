package com.quantity.model;

public enum WeightUnit implements IMeasurable {

    KG(1.0),
    GRAM(1.0 / 1000.0),
    POUND(0.453592);

    private final double factor;

    WeightUnit(double factor) {
        this.factor = factor;
    }

    @Override
    public double getConversionFactor() {
        return factor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * factor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / factor;
    }

    @Override
    public String getUnitName() {
        return name();
    }
}
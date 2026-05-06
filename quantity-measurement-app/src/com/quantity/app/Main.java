package com.quantity.app;

import com.quantity.model.*;

public class Main {

    public static void main(String[] args) {

        // =========================
        // LENGTH
        // =========================
        Quantity<Unit> q1 = new Quantity<>(1, Unit.FEET);
        Quantity<Unit> q2 = new Quantity<>(12, Unit.INCH);

        System.out.println("Add: " + q1.add(q2, Unit.YARD));
        System.out.println("Sub: " + q1.subtract(q2, Unit.FEET));
        System.out.println("Div: " + q1.divide(q2));

        // =========================
        // WEIGHT
        // =========================
        Quantity<WeightUnit> w1 = new Quantity<>(10, WeightUnit.KG);
        Quantity<WeightUnit> w2 = new Quantity<>(5, WeightUnit.KG);

        System.out.println("Weight Add: " + w1.add(w2, WeightUnit.KG));
        System.out.println("Weight Sub: " + w1.subtract(w2, WeightUnit.KG));
        System.out.println("Weight Div: " + w1.divide(w2));

        // =========================
        // VOLUME
        // =========================
        Quantity<VolumeUnit> v1 = new Quantity<>(2, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(500, VolumeUnit.MILLILITRE);

        System.out.println("Volume Add: " + v1.add(v2, VolumeUnit.LITRE));
    }
}
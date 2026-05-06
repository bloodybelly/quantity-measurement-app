package com.quantity.app;

import com.quantity.model.*;

public class Main {

    public static void main(String[] args) {

        // =========================
        // LENGTH SUBTRACTION
        // =========================
        Quantity<Unit> q1 = new Quantity<>(5, Unit.FEET);
        Quantity<Unit> q2 = new Quantity<>(12, Unit.INCH);

        Quantity<Unit> subResult =
                q1.subtract(q2, Unit.FEET);

        System.out.println("5 ft - 12 in = " + subResult);

        // =========================
        // WEIGHT DIVISION
        // =========================
        Quantity<WeightUnit> w1 =
                new Quantity<>(10, WeightUnit.KG);

        Quantity<WeightUnit> w2 =
                new Quantity<>(5, WeightUnit.KG);

        double ratio = w1.divide(w2);

        System.out.println("10 kg / 5 kg = " + ratio);

        // =========================
        // VOLUME SUBTRACTION
        // =========================
        Quantity<VolumeUnit> v1 =
                new Quantity<>(2, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(500, VolumeUnit.MILLILITRE);

        System.out.println("2L - 500mL = " +
                v1.subtract(v2, VolumeUnit.LITRE));
    }
}
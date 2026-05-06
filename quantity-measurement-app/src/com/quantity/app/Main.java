package com.quantity.app;

import com.quantity.model.*;

public class Main {

    public static void main(String[] args) {

        // =========================
        // LENGTH
        // =========================
        Quantity<Unit> length1 = new Quantity<>(1, Unit.FEET);
        Quantity<Unit> length2 = new Quantity<>(12, Unit.INCH);

        System.out.println("Length equal: " + length1.equals(length2));
        System.out.println("Convert: " + length1.convertTo(Unit.INCH));

        System.out.println("Add: " +
                length1.add(length2, Unit.YARD));

        // =========================
        // WEIGHT
        // =========================
        Quantity<WeightUnit> w1 = new Quantity<>(1000, WeightUnit.GRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1, WeightUnit.KG);

        System.out.println("Weight equal: " + w1.equals(w2));
        System.out.println("Add weight: " +
                w1.add(w2, WeightUnit.KG));
    }
}
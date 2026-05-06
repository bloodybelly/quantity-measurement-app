package com.quantity.app;

import com.quantity.model.QuantityWeight;
import com.quantity.model.WeightUnit;

public class Main {

    public static void main(String[] args) {

        // =========================
        // EQUALITY TEST
        // =========================
        QuantityWeight w1 = new QuantityWeight(1000, WeightUnit.GRAM);
        QuantityWeight w2 = new QuantityWeight(1, WeightUnit.KG);

        System.out.println("1000g == 1kg: " + w1.equals(w2));

        // =========================
        // CONVERSION TEST
        // =========================
        QuantityWeight w3 = new QuantityWeight(2, WeightUnit.KG);
        System.out.println("2kg in grams: " + w3.convertTo(WeightUnit.GRAM));

        // =========================
        // ADDITION TEST
        // =========================
        QuantityWeight w4 = new QuantityWeight(500, WeightUnit.GRAM);
        QuantityWeight w5 = new QuantityWeight(1, WeightUnit.KG);

        QuantityWeight result =
                w4.add(w5, WeightUnit.KG);

        System.out.println("Sum in kg: " + result);
    }
}
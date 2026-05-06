package com.quantity.app;

import com.quantity.model.Quantity;
import com.quantity.model.Unit;

public class Main {

    public static void main(String[] args) {

        Quantity q1 = new Quantity(1, Unit.FEET);

        // =========================
        // CONVERSIONS
        // =========================
        System.out.println("1 ft → inches: " + q1.convertTo(Unit.INCH));
        System.out.println("1 ft → yards: " + q1.convertTo(Unit.YARD));
        System.out.println("1 ft → cm: " + q1.convertTo(Unit.CM));

        Quantity q2 = new Quantity(12, Unit.INCH);
        System.out.println("12 inch → feet: " + q2.convertTo(Unit.FEET));

        // =========================
        // STILL SUPPORTS UC4
        // =========================
        Quantity q3 = new Quantity(1, Unit.YARD);
        Quantity q4 = new Quantity(3, Unit.FEET);

        System.out.println("1 yard == 3 feet: " + q3.equals(q4));
    }
}
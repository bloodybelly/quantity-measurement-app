package com.quantity.app;

import com.quantity.model.Quantity;
import com.quantity.model.Unit;

public class Main {

    public static void main(String[] args) {

        // =========================
        // UC6 TEST CASES
        // =========================

        Quantity q1 = new Quantity(1, Unit.FEET);
        Quantity q2 = new Quantity(12, Unit.INCH);

        Quantity result1 = q1.add(q2);
        System.out.println("1 ft + 12 in = " + result1);

        Quantity q3 = new Quantity(1, Unit.YARD);
        Quantity q4 = new Quantity(1, Unit.FEET);

        Quantity result2 = q3.add(q4);
        System.out.println("1 yard + 1 ft = " + result2);

        Quantity q5 = new Quantity(100, Unit.CM);
        Quantity q6 = new Quantity(1, Unit.FEET);

        Quantity result3 = q5.add(q6);
        System.out.println("100 cm + 1 ft = " + result3);
    }
}
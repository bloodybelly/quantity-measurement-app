package com.quantity.app;

import com.quantity.model.Quantity;
import com.quantity.model.Unit;

public class Main {

    public static void main(String[] args) {

        // =========================
        // UC7 TEST CASES
        // =========================

        Quantity q1 = new Quantity(1, Unit.FEET);
        Quantity q2 = new Quantity(12, Unit.INCH);

        Quantity result1 = q1.add(q2, Unit.YARD);
        System.out.println("1 ft + 12 in = " + result1 + " (in yards)");

        Quantity q3 = new Quantity(2, Unit.YARD);
        Quantity q4 = new Quantity(3, Unit.FEET);

        Quantity result2 = q3.add(q4, Unit.FEET);
        System.out.println("2 yd + 3 ft = " + result2 + " (in feet)");

        Quantity q5 = new Quantity(100, Unit.CM);
        Quantity q6 = new Quantity(1, Unit.FEET);

        Quantity result3 = q5.add(q6, Unit.INCH);
        System.out.println("100 cm + 1 ft = " + result3 + " (in inches)");
    }
}
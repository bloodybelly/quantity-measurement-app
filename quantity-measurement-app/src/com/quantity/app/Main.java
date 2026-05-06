package com.quantity.app;

import com.quantity.model.Quantity;
import com.quantity.model.Unit;

public class Main {

    public static void main(String[] args) {

        try {

            Quantity q1 = new Quantity(1, Unit.FEET);
            Quantity q2 = new Quantity(12, Unit.INCH);

            Quantity q3 = new Quantity(1, Unit.YARD);
            Quantity q4 = new Quantity(3, Unit.FEET);

            Quantity q5 = new Quantity(30.48, Unit.CM); // 30.48 cm = 1 ft
            Quantity q6 = new Quantity(1, Unit.FEET);

            System.out.println("1 ft == 12 in: " + q1.equals(q2));
            System.out.println("1 yd == 3 ft: " + q3.equals(q4));
            System.out.println("30.48 cm == 1 ft: " + q5.equals(q6));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
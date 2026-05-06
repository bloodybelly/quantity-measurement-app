package com.quantity.app;

import com.quantity.model.Quantity;
import com.quantity.model.Unit;

public class Main {

    public static void main(String[] args) {

        try {
            // Same unit comparison
            Quantity q1 = new Quantity(5, Unit.FEET);
            Quantity q2 = new Quantity(5, Unit.FEET);

            // Cross unit comparison
            Quantity q3 = new Quantity(1, Unit.FEET);
            Quantity q4 = new Quantity(12, Unit.INCH);

            System.out.println("5 ft == 5 ft: " + q1.equals(q2));
            System.out.println("1 ft == 12 in: " + q3.equals(q4));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
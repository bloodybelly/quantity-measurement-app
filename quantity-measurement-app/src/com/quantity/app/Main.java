package com.quantity.app;

import com.quantity.model.Quantity;
import com.quantity.model.Unit;

public class Main {

    public static void main(String[] args) {

        Quantity q1 = new Quantity(1, Unit.FEET);
        Quantity q2 = new Quantity(12, Unit.INCH);

        System.out.println("Equality: " + q1.equals(q2));

        System.out.println("1 ft → inch: " + q1.convertTo(Unit.INCH));

        Quantity result =
                q1.add(q2, Unit.YARD);

        System.out.println("Addition in yards: " + result);
    }
}
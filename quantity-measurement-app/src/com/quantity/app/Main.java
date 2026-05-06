package com.quantity.app;

import com.quantity.model.Quantity;

public class Main {

    public static void main(String[] args) {

        Quantity q1 = new Quantity(10, "meter");
        Quantity q2 = new Quantity(10, "meter");

        if (q1.equals(q2)) {
            System.out.println("Quantities are equal");
        } else {
            System.out.println("Quantities are NOT equal");
        }
    }
}
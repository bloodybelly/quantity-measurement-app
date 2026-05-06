package com.quantity.app;

import com.quantity.model.Feet;
import com.quantity.model.Inch;

public class Main {

    public static void main(String[] args) {

        try {
            // Hardcoded values (as per UC)
            Feet f1 = new Feet(5.0);
            Feet f2 = new Feet(5.0);

            Inch i1 = new Inch(12.0);
            Inch i2 = new Inch(12.0);

            // Comparison
            boolean feetEqual = f1.equals(f2);
            boolean inchEqual = i1.equals(i2);

            System.out.println("Feet Equal: " + feetEqual);
            System.out.println("Inch Equal: " + inchEqual);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
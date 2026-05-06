package com.quantity.app;

import com.quantity.model.Quantity;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter first value in feet: ");
            double v1 = sc.nextDouble();

            System.out.print("Enter second value in feet: ");
            double v2 = sc.nextDouble();

            Quantity q1 = new Quantity(v1);
            Quantity q2 = new Quantity(v2);

            boolean result = q1.equals(q2);

            System.out.println("Are equal? " + result);

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter numeric values.");
        } finally {
            sc.close();
        }
    }
}
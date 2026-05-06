package com.quantity.app;

import com.quantity.model.*;

public class Main {

    public static void main(String[] args) {

        // =========================
        // VOLUME EQUALITY
        // =========================
        Quantity<VolumeUnit> v1 =
                new Quantity<>(1000, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(1, VolumeUnit.LITRE);

        System.out.println("1000 mL == 1 L: " + v1.equals(v2));

        // =========================
        // CONVERSION
        // =========================
        Quantity<VolumeUnit> v3 =
                new Quantity<>(1, VolumeUnit.GALLON);

        System.out.println("1 gallon → litres: " +
                v3.convertTo(VolumeUnit.LITRE));

        // =========================
        // ADDITION
        // =========================
        Quantity<VolumeUnit> v4 =
                new Quantity<>(2, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v5 =
                new Quantity<>(500, VolumeUnit.MILLILITRE);

        System.out.println("Sum in litres: " +
                v4.add(v5, VolumeUnit.LITRE));

        System.out.println("Sum in gallons: " +
                v4.add(v5, VolumeUnit.GALLON));
    }
}
package com.example.unitconverterapp;

import android.widget.Switch;

public class Conversions {
    public final static double DOLLAR_TO_EURO_MULTIPLIER = 0.939657;
    public final static double EURO_TO_DOLLAR_MULTIPLIER = 1.06424;
    public  final  static double MILE_TO_KILOMETER_MULTIPLIER = 1.609344;
    public final static double KILOMETER_TO_MILE_MULTIPLIER = 0.6213712;


    public static double dollarToEuro(double unit) {
        double dollarConverted = unit * DOLLAR_TO_EURO_MULTIPLIER;
        return dollarConverted;
    }

    public static double euroToDollar(double unit) {
        double euroConverted = unit * EURO_TO_DOLLAR_MULTIPLIER;
        return euroConverted;
    }

    public static double mileToKilometer(double unit){
        double milesConverted = unit * MILE_TO_KILOMETER_MULTIPLIER;
        return milesConverted;
    }

    public static double kilometerToMile(double unit){
        double kilometersConverted = unit * KILOMETER_TO_MILE_MULTIPLIER;
        return kilometersConverted;
    }

}


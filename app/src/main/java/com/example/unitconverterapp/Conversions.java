package com.example.unitconverterapp;

import android.os.Message;
import android.widget.Switch;
import android.widget.Toast;

public class Conversions {

    public final static double DOLLAR_TO_EURO_FINAL = 0.939657;
    public final static double EURO_TO_DOLLAR_FINAL = 1.06424;
    public final  static double MILE_TO_KILOMETER_FINAL = 1.609344;
    public final static double KILOMETER_TO_MILE_FINAL = 0.6213712;



    public static double euroToDollar(double unit) {
        double euroConverted = unit * EURO_TO_DOLLAR_FINAL;
        return euroConverted;
    }

    public static double dollarToEuro(double unit) {
        double dollarConverted = unit * DOLLAR_TO_EURO_FINAL;
        return dollarConverted;
    }


    public static double kilometerToMile(double unit){
        double kilometersConverted = unit * KILOMETER_TO_MILE_FINAL;
        return kilometersConverted;
    }

    public static double mileToKilometer(double unit){
        double milesConverted = unit * MILE_TO_KILOMETER_FINAL;
        return milesConverted;
    }

}


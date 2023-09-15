package com.example.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private RadioGroup mConvertRadioGroup;
    private EditText mUnitsToConvert;
    private TextView mOutputTextview;
    private RadioButton mEurosToDollarsRadio;
    private RadioButton mKilometersToMilesRadio;
    boolean switchOn = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mConvertRadioGroup = findViewById(R.id.convert_radio_group);
        mUnitsToConvert = findViewById(R.id.units_to_convert);
        mOutputTextview = findViewById(R.id.output_textview);
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch mUnitSwitch = findViewById(R.id.unit_switch);
        mKilometersToMilesRadio = findViewById(R.id.kilometers_to_miles_radio);
        mEurosToDollarsRadio = findViewById(R.id.euros_to_dollars_radio);

        //This is what monitors the switch, whenever the switch is toggled the switchOn bool is toggled here.
        mUnitSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(isChecked) {
                    switchOn = true;
                    mEurosToDollarsRadio.setText("Euros to Dollars");
                    mKilometersToMilesRadio.setText("Kilometers to Miles");
                } else {
                    switchOn = false;
                    mEurosToDollarsRadio.setText("Dollars to Euros");
                    mKilometersToMilesRadio.setText("Miles to Kilometers");
                }
            }
        });
    }

    public void convertClick(View view) {

        //copying most of the try catch from pizza party. IDK if it will work but we will see...
        double mainUnit;
        try {
            String mainUnitStr = mUnitsToConvert.getText().toString();
            mainUnit = Double.parseDouble(mainUnitStr);
        }
        catch (NumberFormatException ex) {
            mainUnit = 0;
        }
        //honestly... I barely know whats going on here with the try catch, just happy it works.

        /*get either currency or distance selection from radio button group also checks if the switch is on and makes this outputText the calculation
         using the appropriate method from Conversions.java */

        int checkedRadioButton = mConvertRadioGroup.getCheckedRadioButtonId();

        if(checkedRadioButton == R.id.euros_to_dollars_radio && switchOn) {
            String outputText = String.valueOf(Conversions.dollarToEuro(mainUnit));
            mOutputTextview.setText(outputText);
        } else if(checkedRadioButton == R.id.euros_to_dollars_radio) {
            String outputText = String.valueOf(Conversions.euroToDollar(mainUnit));
            mOutputTextview.setText(outputText);
        } else if (checkedRadioButton == R.id.kilometers_to_miles_radio && switchOn) {
            String outputText = String.valueOf(Conversions.mileToKilometer(mainUnit));
            mOutputTextview.setText(outputText);
        } else if (checkedRadioButton == R.id.kilometers_to_miles_radio) {
            String outputText = String.valueOf(Conversions.kilometerToMile(mainUnit));
            mOutputTextview.setText(outputText);
        }
    }
}
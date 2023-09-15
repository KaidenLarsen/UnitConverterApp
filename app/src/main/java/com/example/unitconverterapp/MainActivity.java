package com.example.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

/*

----------- TO DO LIST --------------
input wont accept doubles, gotta figure that out

gotta figure out how to use the switch

make sure the app doesn't crash when you don't select a unit

still suck at git and github

is this even in MVC format? I think so?
 */

public class MainActivity extends AppCompatActivity {

    private RadioGroup mConvertRadioGroup;
    private EditText mUnitsToConvert;
    private TextView mOutputTextview;
    private Switch mUnitSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mConvertRadioGroup = findViewById(R.id.convert_radio_group);
        mUnitsToConvert = findViewById(R.id.units_to_convert);
        mOutputTextview = findViewById(R.id.output_textview);
        mUnitSwitch = findViewById(R.id.unit_switch);
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

        //get either currency or distance selection from radio button group
        int checkedRadioButton = mConvertRadioGroup.getCheckedRadioButtonId();
        if (checkedRadioButton == R.id.euros_to_dollars_radio) {

            //The below code simply sets the output box to the calculated number from the euroToDollar() method in Conversions.java
            String outputText = String.valueOf(Conversions.euroToDollar(mainUnit));
            mOutputTextview.setText(outputText);
        } else if (checkedRadioButton == R.id.kilometers_to_miles_radio) {

            //Same thing as the code above, basically copy pasted
            String outputText = String.valueOf(Conversions.kilometerToMile(mainUnit));
            mOutputTextview.setText(outputText);
        }


    }
}
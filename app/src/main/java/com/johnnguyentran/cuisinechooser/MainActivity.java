package com.johnnguyentran.cuisinechooser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSpinnerFoodType();
    }

    private void setSpinnerFoodType(){
        // Get the spinner from the .xml
        Spinner spinnerFoodType = (Spinner)findViewById(R.id.spinnerFoodTypeDropdown);

        // Create the list of items
        String[] items = new String[]{"No preference", "Chinese", "Mexican", "Italian",
                "Japanese", "Thai", "Indian", "Mediterranean"};

        // Create an adapter to display items
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        // Set spinner from .xml to the created adapter
        spinnerFoodType.setAdapter(adapter);

    }

    private void setSeekBarPricing(){
        // Get the SeekBar from the .xml
        SeekBar seekBarPricing = (SeekBar)findViewById(R.id.seekBarPricing);
        
        // Set maximum of 5 options ($ to $$$$$)
        seekBarPricing.setMax(5);



    }

}
package com.johnnguyentran.cuisinechooser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Get the editText from the .xml
        EditText editTextZipCode = (EditText)findViewById(R.id.editTextZipCode);
        editTextZipCode.setInputType(InputType.TYPE_CLASS_NUMBER);


        // Get the spinner from the .xml
        Spinner spinnerFoodType = (Spinner)findViewById(R.id.spinnerFoodTypeDropdown);
        // Create the list of items
        String[] items = new String[]{"No preference", "Chinese", "Mexican", "Italian",
                "Japanese", "Thai", "Indian", "Mediterranean"};
        // Create an adapter to display items
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        // Set spinner from .xml to the created adapter
        spinnerFoodType.setAdapter(adapter);


        // Get the SeekBar from the .xml
        SeekBar seekBarPricing = (SeekBar)findViewById(R.id.seekBarPricing);
        TextView textSeekBarPricing = (TextView)findViewById(R.id.textSeekBarPricing);
        // Set maximum of 5 options ($ to $$$$$)
        seekBarPricing.setMax(4);

        // Listener will update text based on slider
        seekBarPricing.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                StringBuilder strBuilder = new StringBuilder();
                for(int i = 0; i < progress + 1; i++){
                    strBuilder.append("$");
                }

                textSeekBarPricing.setText(strBuilder);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        }





}
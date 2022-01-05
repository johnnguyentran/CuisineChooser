package com.johnnguyentran.cuisinechooser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
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
        EditText editTextZipCode = getZipCode();
        editTextZipCode.setInputType(InputType.TYPE_CLASS_NUMBER);


        // Get the spinner from the .xml
        Spinner spinnerFoodType = getFoodType();
        // Create the list of items
        String[] items = new String[]{"No preference", "American", "Chinese", "Mexican", "Italian",
                "Japanese", "Thai", "Indian", "Mediterranean"};
        // Create an adapter to display items
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        // Set spinner from .xml to the created adapter
        spinnerFoodType.setAdapter(adapter);


        // Get the SeekBar from the .xml
        SeekBar seekBarPricing = getSeekBarPricing();
        TextView textSeekBarPricing = getPricing();
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


    public void onStartChooseCuisineActivity(View view){
        Intent intent = new Intent(this, ChooseCuisineActivity.class);

        intent.putExtra("keyZipCode", getZipCode().getText());
        intent.putExtra("keyTypeFood", getFoodType().getSelectedItem().toString());
        intent.putExtra("keyPricing", getPricing().getText());

        startActivity(intent);
    }

    private EditText getZipCode(){
        return (EditText)findViewById(R.id.editTextZipCode);
    }

    private Spinner getFoodType(){
        return (Spinner)findViewById(R.id.spinnerFoodTypeDropdown);
    }

    private TextView getPricing(){
        return (TextView)findViewById(R.id.textSeekBarPricing);
    }

    private SeekBar getSeekBarPricing(){
        return (SeekBar)findViewById(R.id.seekBarPricing);
    }

}
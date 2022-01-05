package com.johnnguyentran.cuisinechooser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ChooseCuisineActivity extends AppCompatActivity {

    private String zipCode = "";
    private String typeFood = "";
    private String pricing= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_cuisine);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            setZipCode(bundle.getString("keyZipCode"));
            setTypeFood(bundle.getString("keyTypeFood"));
            setPricing(bundle.getString("keyPricing"));
        }


    }

    public String getZipCode(){
        return zipCode;
    }
    public String getTypeFood(){
        return typeFood;
    }
    public String getPricing(){
        return pricing;
    }
    public void setZipCode(String str){
        zipCode = str;
    }
    public void setTypeFood(String str){
        typeFood = str;
    }
    public void setPricing(String str){
        pricing = str;
    }
}
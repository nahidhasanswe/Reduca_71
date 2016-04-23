package com.example.nahid.nasaapps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by nahid on 4/22/16.
 */
public class SecondActivity extends Activity{

    private ProgressBar progressForest, progressAgriculture, progressIndustry, progressResidiantial, progressWater, progressEnergy, progressTransport;
    private TextView forestText, agricultureText, industryText, residiantialText, waterText, energyText, transportText, location;
    private Button suggestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        // Percentage TextView
        forestText = (TextView) findViewById(R.id.deforestText);
        agricultureText = (TextView) findViewById(R.id.agricultureText);
        industryText = (TextView) findViewById(R.id.industryText);
        residiantialText = (TextView) findViewById(R.id.residiantialText);
        waterText = (TextView) findViewById(R.id.waterText);
        energyText = (TextView) findViewById(R.id.energText);
        transportText = (TextView) findViewById(R.id.transportText);
        location = (TextView) findViewById(R.id.detectlocation);


        progressForest = (ProgressBar) findViewById(R.id.forest);
        progressAgriculture = (ProgressBar) findViewById(R.id.agriculture);
        progressIndustry = (ProgressBar) findViewById(R.id.industry);
        progressResidiantial = (ProgressBar) findViewById(R.id.residiantial);
        progressWater = (ProgressBar) findViewById(R.id.water);
        progressEnergy = (ProgressBar) findViewById(R.id.energy);
        progressTransport = (ProgressBar) findViewById(R.id.transport);

        suggestion=(Button)findViewById(R.id.suggestion);
        suggestion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Suggestion.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivityForResult(myIntent,0);
            }
        });


        try {
            initialize();
        }catch (Exception e){

        }
    }

    public void initialize(){
        // For Deforestation
        progressForest.setMax(1000);
        progressForest.setProgress(264);
        forestText.setText("26.4%");

        // For Agriculture Waste
        progressAgriculture.setMax(1000);
        progressAgriculture.setProgress(75);
        agricultureText.setText("7.5%");

        //For Industry Waste
        progressIndustry.setMax(1000);
        progressIndustry.setProgress(163);
        industryText.setText("16.3%");

        //For Residiantial
        progressResidiantial.setMax(1000);
        progressResidiantial.setProgress(79);
        residiantialText.setText("7.9%");

        //For Water Waste
        progressWater.setMax(1000);
        progressWater.setProgress(50);
        waterText.setText("5%");

        // For Energy Supply
        progressEnergy.setMax(1000);
        progressEnergy.setProgress(195);
        energyText.setText("19.5%");

        //For Transport Waste
        progressTransport.setMax(1000);
        progressTransport.setProgress(174);
        transportText.setText("17.4%");

        // Detect Location
        location.setText("Bangladesh");
    }
}

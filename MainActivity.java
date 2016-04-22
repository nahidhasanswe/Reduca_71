package com.example.nahid.nasaapps;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import org.w3c.dom.Text;

import Database.dataBase;

public class MainActivity extends ActionBarActivity {

    private ProgressBar progressForest, progressAgriculture, progressIndustry, progressResidiantial, progressWater, progressEnergy, progressTransport;
    private TextView forestText, agricultureText, industryText, residiantialText, waterText, energyText, transportText, location;
    private ProgressDialog progress;
    private Button locationDetect;
    dataBase mydb;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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


        try {
            initialize();
            mydb=new dataBase(this);
        }catch (Exception e){

        }

        locationDetect=(Button)findViewById(R.id.detect);
        locationDetect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                progress(view);
            }
        });



    }


    private void progress(final View view){
        progress = new ProgressDialog(this);
        progress.setMessage("Location Detection");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.setMax(100);
        progress.setProgress(0);
        progress.show();



        new Thread(new Runnable() {
            @Override
            public void run() {

                int time=0;
                try {
                    while (progress.getProgress() <= progress
                            .getMax()) {
                        Thread.sleep(200);

                        time=time+5;

                        if (time==50) {
                            progress.dismiss();
                            clicl(view);
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private void clicl(View view){

        Intent myIntent = new Intent(view.getContext(), SecondActivity.class);
        startActivityForResult(myIntent, 0);

    }

    public void initialize() {

        // For Deforestation
        progressForest.setMax(1000);
        progressForest.setProgress(175);
        forestText.setText("17.4%");

        // For Agriculture Waste
        progressAgriculture.setMax(1000);
        progressAgriculture.setProgress(135);
        agricultureText.setText("13.5%");

        //For Industry Waste
        progressIndustry.setMax(1000);
        progressIndustry.setProgress(194);
        industryText.setText("19.4%");

        //For Residiantial
        progressResidiantial.setMax(1000);
        progressResidiantial.setProgress(79);
        residiantialText.setText("7.9%");

        //For Water Waste
        progressWater.setMax(1000);
        progressWater.setProgress(25);
        waterText.setText("2.5%");

        // For Energy Supply
        progressEnergy.setMax(1000);
        progressEnergy.setProgress(259);
        energyText.setText("25.9%");

        //For Transport Waste
        progressTransport.setMax(1000);
        progressTransport.setProgress(139);
        transportText.setText("13.9%");

        // Detect Location
        location.setText("Basundhara Residiantial Area");

    }


}

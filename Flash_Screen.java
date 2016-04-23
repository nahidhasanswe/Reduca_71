package com.example.nahid.nasaapps;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by nahid on 4/23/16.
 */
public class Flash_Screen extends Activity{

    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash_screen);

        progress=(ProgressBar)findViewById(R.id.progress);
        progress.setMax(100);


        new Thread(new Runnable() {
            @Override
            public void run() {

                int time=0;
                try {
                    while (progress.getProgress() <= progress
                            .getMax()) {
                        Thread.sleep(200);

                        time=time+5;
                        progress.setProgress(time);

                        if (time==95) {
                            try{
                                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivityForResult(myIntent, 0);
                            }catch (Exception e){

                            }

                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}

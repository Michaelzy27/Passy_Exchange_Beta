package com.michael.passy_exchange_beta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Splashscreen extends AppCompatActivity {

    TextView Splashtext, We_balling ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Splashtext = findViewById(R.id.splashtxt);
        We_balling = findViewById(R.id.weballin);
        Splashtext.setTranslationY(-500f);
        Splashtext.animate().translationYBy(500f).setDuration(2500);
        We_balling.setTranslationY(500f);
        We_balling.animate().translationYBy(-500f).setDuration(2500);

//        logo = findViewById(R.id.logo);
//        logo.setTranslationY(-1000f);
//        logo.animate().translationYBy(1000f).setDuration(2500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Toast.makeText(Splashscreen.this, "Splashscreen done", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Splashscreen.this, OnboardingScreen.class);
                startActivity(intent);
                finish();
            }
        }, 3000);


    }
}
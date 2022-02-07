package com.michael.passy_exchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class Splashscreen extends AppCompatActivity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        logo = findViewById(R.id.logo);
        logo.setTranslationY(-1000f);
        logo.animate().translationYBy(1000f).setDuration(2500);

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
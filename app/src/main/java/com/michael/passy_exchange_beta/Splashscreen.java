package com.michael.passy_exchange_beta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

public class Splashscreen extends AppCompatActivity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);


        Log.e("dgd", "hdhd");

        String boy = "Michael";


        byte david = -127;

        short pen = -32767;

        int book = 50000000 + 500000000;

        long plate = 223377777;

        float spoons;
        double car;



        int x = 5;
        int y = 500;
        int f = y / x;

        int xx = 5 + 7;

        int price = 50;
        String name = "Benjamin";

        int box = 74;

        double spoon = 50;

        double total = box + spoon;

        boolean twin = true; //chidinma
        boolean twins = false;

        Log.i("result", String.valueOf(total));


































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
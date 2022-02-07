package com.michael.passy_exchange_beta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.michael.passy_exchange_beta.Utils.Helper;

import org.json.JSONObject;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    Helper helper;

    TextView signIn;
    EditText Username, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        helper = new Helper(this);

        Username = findViewById(R.id.login_email_username);
        Password = findViewById(R.id.login_password);

        signIn = findViewById(R.id.go_to_signin);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
    }

    public void loginApi(View view) {

        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
        finish();

        String username = Username.getText().toString();
        String password = Password.getText().toString();

//        helper.progressDialogStart("Logging in", "Please wait while we log you in");

    }
}
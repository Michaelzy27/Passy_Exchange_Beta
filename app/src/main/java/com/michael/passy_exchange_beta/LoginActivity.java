package com.michael.passy_exchange_beta;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
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

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        helper = new Helper(this);

        Username = findViewById(R.id.login_email_username);
        Password = findViewById(R.id.login_password);

        firebaseAuth =FirebaseAuth.getInstance();

        signIn = findViewById(R.id.go_to_signin);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
    }

    public void loginApi(View view) {

        String username = Username.getText().toString();
        String password = Password.getText().toString();

        if (username.length() == 0 || username.length() < 2) {
            Toast.makeText(this, "Invalid Username", Toast.LENGTH_SHORT).show();
        } else if (password.length() == 0) {
            Toast.makeText(this, "Please enter a password", Toast.LENGTH_SHORT).show();
        } else {
            helper.progressDialogStart(R.layout.custom_progress_dialog, false);

            firebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Log.i("Login status", task.getResult().toString());
                        helper.progressDialogEnd();

                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(i);
                        finish();

                    } else {
                        Toast.makeText(LoginActivity.this, "Login unsuccessful", Toast.LENGTH_SHORT).show();
                        helper.progressDialogEnd();
                        Log.i("Login", task.getException().toString());
                    }
                }
            });

        }
//        helper.progressDialogStart("Logging in", "Please wait while we log you in");

    }
}
package com.michael.passy_exchange_beta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.michael.passy_exchange_beta.Utils.Helper;
import com.michael.passy_exchange_beta.Utils.User;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SignUpActivity extends AppCompatActivity {

    Helper helper;
    //User user;

    TextView logIn;
    EditText DiscordID, Email, Password;
    Button SignUp;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        helper = new Helper(this);

        logIn = findViewById(R.id.go_to_login);
        DiscordID = findViewById(R.id.signup_email_username);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        SignUp = findViewById(R.id.sign_up);

        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();


        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(SignUpActivity.this, "Loading", Toast.LENGTH_SHORT).show();

                String username = DiscordID.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();

                if (username.isEmpty() && username.length() < 2){
                    Toast.makeText(SignUpActivity.this, "Please enter a Username (more than 2 characters", Toast.LENGTH_SHORT).show();
                }else if (email.isEmpty() && email.length() < 5){
                    Toast.makeText(SignUpActivity.this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
                }else if (password.isEmpty() && password.length() < 8){
                    Toast.makeText(SignUpActivity.this, "Please enter a password greater or equal to 8 characters", Toast.LENGTH_SHORT).show();
                }else {

                    //user = new User(username, email, firstName, lastName);

                    helper.progressDialogStart(R.layout.custom_progress_dialog, false);

                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                reference.child("htest").setValue(username);

                                helper.progressDialogEnd();
                                helper.progressDialogStart(R.layout.custom_success_dialog, true);
                                Toast.makeText(SignUpActivity.this, "Signup successful", Toast.LENGTH_SHORT).show();
                                Log.i("signup result", task.getResult().toString());
                            } else{
                                helper.progressDialogEnd();
                                Toast.makeText(SignUpActivity.this, "Signup unsuccessful", Toast.LENGTH_SHORT).show();
                                Log.i("Signup result", task.getException().toString());
                            }
                        }
                    });

                }

            }
        });

    }
}
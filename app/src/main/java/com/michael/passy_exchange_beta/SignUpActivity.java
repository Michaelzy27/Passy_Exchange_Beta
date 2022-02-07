package com.michael.passy_exchange_beta;

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

import com.michael.passy_exchange_beta.Utils.Helper;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SignUpActivity extends AppCompatActivity {

    Helper helper;

    TextView logIn;
    EditText Username, Email, Password, ConfirmPassword, FirstName, LastNmae;
    Button SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        helper = new Helper(this);

        logIn = findViewById(R.id.go_to_login);
        Username = findViewById(R.id.username);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        ConfirmPassword = findViewById(R.id.confirm_password);
        FirstName = findViewById(R.id.first_name);
        LastNmae = findViewById(R.id.last_name);
        SignUp = findViewById(R.id.sign_up);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignUpActivity.this, "Loading", Toast.LENGTH_SHORT).show();

                String username = Username.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                String confirmPassowrd = ConfirmPassword.getText().toString();
                String firstName = FirstName.getText().toString();
                String lastName = LastNmae.getText().toString();

                if (username.isEmpty() && username.length() < 2){
                    Toast.makeText(SignUpActivity.this, "Please enter a Username (more than 2 characters", Toast.LENGTH_SHORT).show();
                }else if (email.isEmpty() && email.length() < 5){
                    Toast.makeText(SignUpActivity.this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
                }else if (password.isEmpty() && password.length() < 8){
                    Toast.makeText(SignUpActivity.this, "Please enter a password greater or equal to 8 characters", Toast.LENGTH_SHORT).show();
                }else if (!password.equals(confirmPassowrd)){
                    Toast.makeText(SignUpActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }else if (firstName.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Please enter your First Name", Toast.LENGTH_SHORT).show();
                }else if (lastName.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Please enter your Last Name", Toast.LENGTH_SHORT).show();
                }else {

                    Signup signup = new Signup();
                    signup.execute(username,email,password,firstName,lastName);
                    helper.progressDialogStart("Sign up User", "Please wait while we sign up up!");

                }

            }
        });

    }

    public class Signup extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            OkHttpClient okHttpClient = new OkHttpClient();

            String usernamee = strings[0];
            String emaill = strings[1];
            String passwordd = strings[2];
            String trackk = "5f1c30521f6e7fa0fcbfa160";
            String firstNamee = strings[4];
            String lastNamee = strings[5];
            String locationn = strings[6];

            RequestBody requestBody = new FormBody.Builder()
                    .add("email", emaill)
                    .add("password", passwordd)
                    .add("firstName", firstNamee)
                    .add("lastName", lastNamee)
                    .add("location", locationn)
                    .add("userName", usernamee)
                    .add("trackId", trackk)
                    .build();

            Request request = new Request.Builder().url("https://hngboard.herokuapp.com/users/register").post(requestBody).build();

            try{
                Response response = okHttpClient.newCall(request).execute();//gets a response from the server
                Log.i("hhh", "hhh0");
                String result = response.body().string();
                Log.i("responseBody", result);
                helper.progressDialogEnd();
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);

            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }
    }
}
package com.example.quizzesforkids3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private EditText email, signUpUsername, signUpPassword, rePassword;
    private Button signUpButton;
    private TextView signInView;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().hide();

        dbHelper = new DatabaseHelper(this);

        email = (EditText) findViewById(R.id.email);
        signUpUsername = (EditText) findViewById(R.id.signUpUsername);
        signUpPassword = (EditText) findViewById(R.id.signUpPassword);
        rePassword = (EditText) findViewById(R.id.rePassword);
        signUpButton = (Button) findViewById(R.id.signUpButton);
        signInView = (TextView) findViewById(R.id.signInView);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                String Username = signUpUsername.getText().toString();
                String Password = signUpPassword.getText().toString();
                String RePassword = rePassword.getText().toString();
                boolean usernameValid = dbHelper.checkUsername(Username);
                boolean emailValid = dbHelper.checkEmail(Email);

                if (Email.equals("") || Username.equals("") || Password.equals("") || RePassword.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter all field.", Toast.LENGTH_SHORT).show();
                }
                else if (emailValid) {
                    Toast.makeText(getApplicationContext(), "This email is already used.", Toast.LENGTH_SHORT).show();
                }
                else if (usernameValid) {
                    Toast.makeText(getApplicationContext(), "This username is already used.", Toast.LENGTH_SHORT).show();
                }
                else if (!Password.equals(RePassword)) {
                    Toast.makeText(getApplicationContext(), "Retyped password does not match!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(SignUpActivity.this, "User created successfully!", Toast.LENGTH_SHORT).show();
                    dbHelper.addUser(Username, Password, Email, 0);
                    Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                    intent.putExtra("UsernameName", Username);
                    startActivity(intent);
                    finish();
                }
            }
        });

        signInView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
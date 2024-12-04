package com.example.quizzesforkids3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        DatabaseHelper dbHelper = new DatabaseHelper(this);

        String Username = getIntent().getStringExtra("UsernameForPasswordChange");

        EditText oldPassword = (EditText) findViewById(R.id.oldPassword);
        EditText newPassword = (EditText) findViewById(R.id.newPassword);
        EditText retypeNewPassword = (EditText) findViewById(R.id.retypeNewPassword);
        Button nextButton = (Button) findViewById(R.id.nextButton);
        Button confirmPasswordButton = (Button) findViewById(R.id.confirmPasswordButton);

        newPassword.setVisibility(View.INVISIBLE);
        retypeNewPassword.setVisibility(View.INVISIBLE);
        confirmPasswordButton.setVisibility(View.INVISIBLE);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getOldPassword = oldPassword.getText().toString();
                boolean passwordValid = dbHelper.checkPassword(getOldPassword);

                if (passwordValid) {
                    newPassword.setVisibility(View.VISIBLE);
                    retypeNewPassword.setVisibility(View.VISIBLE);
                    confirmPasswordButton.setVisibility(View.VISIBLE);
                    nextButton.setVisibility(View.INVISIBLE);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong password!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        confirmPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getNewPassword = newPassword.getText().toString();
                String getRetypeNewPassword = retypeNewPassword.getText().toString();
                boolean passwordValid = dbHelper.checkPassword(getNewPassword);

                if (getNewPassword.equals("") || getRetypeNewPassword.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter all fields.", Toast.LENGTH_SHORT).show();
                }
                else if(!getNewPassword.equals(getRetypeNewPassword)) {
                    Toast.makeText(getApplicationContext(), "Retyped new password does not match!", Toast.LENGTH_SHORT).show();
                }
                else if (passwordValid) {
                    Toast.makeText(getApplicationContext(), "New password is the same as old password.", Toast.LENGTH_SHORT).show();
                }
                else {
                    dbHelper.updatePassword(Username, getNewPassword);
                    Toast.makeText(getApplicationContext(), "Password changed successfully!", Toast.LENGTH_SHORT).show();
                    oldPassword.setText("");
                    newPassword.setText("");
                    retypeNewPassword.setText("");
                    newPassword.setVisibility(View.INVISIBLE);
                    retypeNewPassword.setVisibility(View.INVISIBLE);
                    confirmPasswordButton.setVisibility(View.INVISIBLE);
                    nextButton.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
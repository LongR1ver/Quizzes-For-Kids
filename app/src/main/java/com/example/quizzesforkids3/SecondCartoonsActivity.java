package com.example.quizzesforkids3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SecondCartoonsActivity extends AppCompatActivity {
    public static int cartoonPoint2 = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_cartoons);

        DatabaseHelper myDB = new DatabaseHelper(this);

        TextView setQuestion2 = (TextView) findViewById(R.id.setQuestion2);
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        RadioButton cartoon2A = (RadioButton) findViewById(R.id.cartoon2A);
        RadioButton cartoon2B = (RadioButton) findViewById(R.id.cartoon2B);
        RadioButton cartoon2C = (RadioButton) findViewById(R.id.cartoon2C);
        Button cartoonNext2 = (Button) findViewById(R.id.cartoonNext2);

        int a = HomeActivity.a.get(0);
        int b = HomeActivity.b.get(0);
        int c = HomeActivity.c.get(0);

        Cursor cursor = myDB.getCartoonQuestion(HomeActivity.question2);
        cursor.moveToFirst();
        setQuestion2.setText(cursor.getString(0));
        cartoon2A.setText(cursor.getString(a));
        cartoon2B.setText(cursor.getString(b));
        cartoon2C.setText(cursor.getString(c));

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.cartoon2A:
                        if (a == 1) {
                            cartoonPoint2 = 3;
                        }
                        else {
                            cartoonPoint2 = -1;
                        }
                        break;
                    case R.id.cartoon2B:
                        if (b == 1) {
                            cartoonPoint2 = 3;
                        }
                        else {
                            cartoonPoint2 = -1;
                        }
                        break;
                    case R.id.cartoon2C:
                        if (c == 1) {
                            cartoonPoint2 = 3;
                        }
                        else {
                            cartoonPoint2 = -1;
                        }
                        break;
                    default:
                        cartoonPoint2 = -1;
                }
            }
        });

        cartoonNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioGroup2.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please choose 1 answer.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(SecondCartoonsActivity.this, ThirdCartoonsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
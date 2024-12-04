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

public class ThirdCartoonsActivity extends AppCompatActivity {
    public static int cartoonPoint3 = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_cartoons);

        DatabaseHelper myDB = new DatabaseHelper(this);

        TextView setQuestion3 = (TextView) findViewById(R.id.setQuestion3);
        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.radioGroup3);
        RadioButton cartoon3A = (RadioButton) findViewById(R.id.cartoon3A);
        RadioButton cartoon3B = (RadioButton) findViewById(R.id.cartoon3B);
        RadioButton cartoon3C = (RadioButton) findViewById(R.id.cartoon3C);
        Button cartoonNext3 = (Button) findViewById(R.id.cartoonNext3);

        int a = HomeActivity.a.get(0);
        int b = HomeActivity.b.get(0);
        int c = HomeActivity.c.get(0);

        Cursor cursor = myDB.getCartoonQuestion(HomeActivity.question3);
        cursor.moveToFirst();
        setQuestion3.setText(cursor.getString(0));
        cartoon3A.setText(cursor.getString(a));
        cartoon3B.setText(cursor.getString(b));
        cartoon3C.setText(cursor.getString(c));

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.cartoon3A:
                        if (a == 1) {
                            cartoonPoint3 = 3;
                        }
                        else {
                            cartoonPoint3 = -1;
                        }
                        break;
                    case R.id.cartoon3B:
                        if (b == 1) {
                            cartoonPoint3 = 3;
                        }
                        else {
                            cartoonPoint3 = -1;
                        }
                        break;
                    case R.id.cartoon3C:
                        if (c == 1) {
                            cartoonPoint3 = 3;
                        }
                        else {
                            cartoonPoint3 = -1;
                        }
                        break;
                    default:
                        cartoonPoint3 = -1;
                }
            }
        });

        cartoonNext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioGroup3.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please choose 1 answer.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(ThirdCartoonsActivity.this, FourthCartoonsActivity.class);
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
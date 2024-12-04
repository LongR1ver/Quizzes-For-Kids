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

public class FirstCartoonsActivity extends AppCompatActivity {
    private RadioGroup radioGroup1;
    private RadioButton cartoon1A, cartoon1B, cartoon1C;
    private TextView setQuestion1;
    private Button cartoonNext1;
    public static int cartoonPoint1 = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_cartoons);

        DatabaseHelper myDB = new DatabaseHelper(this);

        setQuestion1 = (TextView) findViewById(R.id.setQuestion1);
        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        cartoon1A = (RadioButton) findViewById(R.id.cartoon1A);
        cartoon1B = (RadioButton) findViewById(R.id.cartoon1B);
        cartoon1C = (RadioButton) findViewById(R.id.cartoon1C);
        cartoonNext1 = (Button) findViewById(R.id.cartoonNext1);

        int a = HomeActivity.a.get(0);
        int b = HomeActivity.b.get(0);
        int c = HomeActivity.c.get(0);

        Cursor cursor = myDB.getCartoonQuestion(HomeActivity.question1);
        cursor.moveToFirst();
        setQuestion1.setText(cursor.getString(0));
        cartoon1A.setText(cursor.getString(a));
        cartoon1B.setText(cursor.getString(b));
        cartoon1C.setText(cursor.getString(c));

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.cartoon1A:
                        if (a == 1) {
                            cartoonPoint1 = 3;
                        }
                        else {
                            cartoonPoint1 = -1;
                        }
                        break;
                    case R.id.cartoon1B:
                        if (b == 1) {
                            cartoonPoint1 = 3;
                        }
                        else {
                            cartoonPoint1 = -1;
                        }
                        break;
                    case R.id.cartoon1C:
                        if (c == 1) {
                            cartoonPoint1 = 3;
                        }
                        else {
                            cartoonPoint1 = -1;
                        }
                        break;
                    default:
                        cartoonPoint1 = -1;
                }
            }
        });

        cartoonNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioGroup1.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please choose 1 answer.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(FirstCartoonsActivity.this, SecondCartoonsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void onBackPressed() {

    }
}
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

public class FourthCartoonsActivity extends AppCompatActivity {
    public static int cartoonPoint4 = -1;
    public static int totalPointAttempt;
    public static int newOverallScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_cartoons);

        DatabaseHelper myDB = new DatabaseHelper(this);

        TextView setQuestion4 = (TextView) findViewById(R.id.setQuestion4);
        RadioGroup radioGroup4 = (RadioGroup) findViewById(R.id.radioGroup4);
        RadioButton cartoon4A = (RadioButton) findViewById(R.id.cartoon4A);
        RadioButton cartoon4B = (RadioButton) findViewById(R.id.cartoon4B);
        RadioButton cartoon4C = (RadioButton) findViewById(R.id.cartoon4C);
        Button cartoonFinish = (Button) findViewById(R.id.cartoonFinish);

        int a = HomeActivity.a.get(0);
        int b = HomeActivity.b.get(0);
        int c = HomeActivity.c.get(0);

        Cursor cursor = myDB.getCartoonQuestion(HomeActivity.question4);
        cursor.moveToFirst();
        setQuestion4.setText(cursor.getString(0));
        cartoon4A.setText(cursor.getString(a));
        cartoon4B.setText(cursor.getString(b));
        cartoon4C.setText(cursor.getString(c));

        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.cartoon4A:
                        if (a == 1) {
                            cartoonPoint4 = 3;
                        }
                        else {
                            cartoonPoint4 = -1;
                        }
                        break;
                    case R.id.cartoon4B:
                        if (b == 1) {
                            cartoonPoint4 = 3;
                        }
                        else {
                            cartoonPoint4 = -1;
                        }
                        break;
                    case R.id.cartoon4C:
                        if (c == 1) {
                            cartoonPoint4 = 3;
                        }
                        else {
                            cartoonPoint4 = -1;
                        }
                        break;
                    default:
                        cartoonPoint4 = -1;
                }
            }
        });

        cartoonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioGroup4.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please choose 1 answer.", Toast.LENGTH_SHORT).show();
                }
                else {
                    totalPointAttempt = FirstCartoonsActivity.cartoonPoint1 + SecondCartoonsActivity.cartoonPoint2 + ThirdCartoonsActivity.cartoonPoint3 + cartoonPoint4;
                    newOverallScore = myDB.getOverallScore(HomeActivity.getUsername) + totalPointAttempt;

                    myDB.updateOverallScore(HomeActivity.getUsername, newOverallScore);
                    myDB.addAttempt(HomeActivity.getUsername, HomeActivity.field, HomeActivity.date, HomeActivity.time, totalPointAttempt);

                    Intent intent = new Intent(FourthCartoonsActivity.this, FinishActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
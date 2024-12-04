package com.example.quizzesforkids3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class FourthAnimalQuestionActivity extends AppCompatActivity {
    public static int animalPoint4;
    public static int totalPointAttempt;
    public static int newOverallScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_animal_question);

        ImageView animalImage4 = (ImageView) findViewById(R.id.animalImage4);
        EditText animalInput4 = (EditText) findViewById(R.id.animalInput4);
        Button finishButton4 = (Button) findViewById(R.id.finishButton4);

        DatabaseHelper myDB = new DatabaseHelper(this);

        int imageResource = myDB.getImageResourceForAnimal(HomeActivity.question4);
        animalImage4.setImageResource(imageResource);

        finishButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String animalAnswer4 = animalInput4.getText().toString().toLowerCase();
                boolean answerTrue = myDB.checkAnimalsAnswer(imageResource, animalAnswer4);

                if (answerTrue) {
                    animalPoint4 = 3;
                }
                else {
                    animalPoint4 = -1;
                }

                totalPointAttempt = FirstAnimalsQuestionActivity.animalPoint1 + SecondAnimalsQuestionActivity.animalPoint2 + ThirdAnimalsQuestionActivity.animalPoint3 + animalPoint4;
                newOverallScore = myDB.getOverallScore(HomeActivity.getUsername) + totalPointAttempt;

                myDB.updateOverallScore(HomeActivity.getUsername, newOverallScore);
                myDB.addAttempt(HomeActivity.getUsername, HomeActivity.field, HomeActivity.date, HomeActivity.time, totalPointAttempt);

                Intent intent = new Intent(FourthAnimalQuestionActivity.this, FinishActivity.class);
                startActivity(intent);
                finish();
            }
        });

        animalImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation move = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                animalImage4.startAnimation(move);
            }
        });
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
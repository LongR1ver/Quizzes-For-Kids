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

public class FirstAnimalsQuestionActivity extends AppCompatActivity {
    public static int animalPoint1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_animals_question);

        ImageView animalImage1 = (ImageView) findViewById(R.id.animalImage1);
        EditText animalInput1 = (EditText) findViewById(R.id.animalInput1);
        Button nextButton1 = (Button) findViewById(R.id.nextButton1);

        DatabaseHelper myDB = new DatabaseHelper(this);

        int imageResource = myDB.getImageResourceForAnimal(HomeActivity.question1);
        animalImage1.setImageResource(imageResource);

        nextButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String animalAnswer1 = animalInput1.getText().toString().toLowerCase();
                boolean answerTrue = myDB.checkAnimalsAnswer(imageResource, animalAnswer1);

                if (answerTrue) {
                    animalPoint1 = 3;
                }
                else {
                    animalPoint1 = -1;
                }

                Intent intent = new Intent(FirstAnimalsQuestionActivity.this, SecondAnimalsQuestionActivity.class);
                startActivity(intent);
            }
        });

        animalImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation fade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                animalImage1.startAnimation(fade);
            }
        });
    }

    public void onBackPressed() {

    }
}
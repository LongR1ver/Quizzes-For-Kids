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

public class ThirdAnimalsQuestionActivity extends AppCompatActivity {
    public static int animalPoint3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_animals_question);

        ImageView animalImage3 = (ImageView) findViewById(R.id.animalImage3);
        EditText animalInput3 = (EditText) findViewById(R.id.animalInput3);
        Button nextButton3 = (Button) findViewById(R.id.nextButton3);

        DatabaseHelper myDB = new DatabaseHelper(this);

        int imageResource = myDB.getImageResourceForAnimal(HomeActivity.question3);
        animalImage3.setImageResource(imageResource);

        nextButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String animalAnswer3 = animalInput3.getText().toString().toLowerCase();
                boolean answerTrue = myDB.checkAnimalsAnswer(imageResource, animalAnswer3);

                if (answerTrue) {
                    animalPoint3 = 3;
                }
                else {
                    animalPoint3 = -1;
                }

                Intent intent = new Intent(ThirdAnimalsQuestionActivity.this, FourthAnimalQuestionActivity.class);
                startActivity(intent);
            }
        });

        animalImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation scale = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
                animalImage3.startAnimation(scale);
            }
        });
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
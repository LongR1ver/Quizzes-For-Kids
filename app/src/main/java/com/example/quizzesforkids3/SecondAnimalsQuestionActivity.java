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

public class SecondAnimalsQuestionActivity extends AppCompatActivity {
    public static int animalPoint2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_animals_question);

        ImageView animalImage2 = (ImageView) findViewById(R.id.animalImage2);
        EditText animalInput2 = (EditText) findViewById(R.id.animalInput2);
        Button nextButton2 = (Button) findViewById(R.id.nextButton2);

        DatabaseHelper myDB = new DatabaseHelper(this);

        int imageResource = myDB.getImageResourceForAnimal(HomeActivity.question2);
        animalImage2.setImageResource(imageResource);

        nextButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answerAnimal2 = animalInput2.getText().toString().toLowerCase();
                boolean answerTrue = myDB.checkAnimalsAnswer(imageResource, answerAnimal2);

                if (answerTrue) {
                    animalPoint2 = 3;
                }
                else {
                    animalPoint2 = -1;
                }

                Intent intent = new Intent(SecondAnimalsQuestionActivity.this, ThirdAnimalsQuestionActivity.class);
                startActivity(intent);
            }
        });

        animalImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                animalImage2.startAnimation(rotate);
            }
        });
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
package com.example.quizzesforkids3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {
    int totalPointAttempt;
    int newOverallScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        DatabaseHelper myDB = new DatabaseHelper(this);

        switch (HomeActivity.field) {
            case "Animals":
                totalPointAttempt = FourthAnimalQuestionActivity.totalPointAttempt;
                newOverallScore = FourthAnimalQuestionActivity.newOverallScore;
                break;
            case "Cartoons":
                totalPointAttempt = FourthCartoonsActivity.totalPointAttempt;
                newOverallScore = FourthCartoonsActivity.newOverallScore;
                break;
        }

        TextView finishText = (TextView) findViewById(R.id.finishText);
        Button backMenuButton = (Button) findViewById(R.id.backMenuButton);

        if (totalPointAttempt == -4) {
            HomeActivity.numTrue = 0;
            HomeActivity.numFalse = 4;
        } else if (totalPointAttempt == 0) {
            HomeActivity.numTrue = 1;
            HomeActivity.numFalse = 3;
        } else if (totalPointAttempt == 4) {
            HomeActivity.numTrue = 2;
            HomeActivity.numFalse = 2;
        } else if (totalPointAttempt == 8) {
            HomeActivity.numTrue = 3;
            HomeActivity.numFalse = 1;
        }
        else {
            HomeActivity.numTrue = 4;
            HomeActivity.numFalse = 0;
        }

        String displayResult = String.format("Well done " + HomeActivity.getUsername + "!\n"
                + "You have finished the \"" + HomeActivity.field + "\" quiz with " + HomeActivity.numTrue + " correct and " + HomeActivity.numFalse + " incorrect answers.\n"
                + "You have " + totalPointAttempt + " points for this attempt.\n"
                + "Overall you have " + newOverallScore + " points."
        );
        finishText.setText(displayResult);
        HomeActivity.numTrue = 0;
        HomeActivity.numFalse = 0;

        backMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinishActivity.this, HomeActivity.class);
                intent.putExtra("UsernameName", HomeActivity.getUsername);
                startActivity(intent);
                finish();
            }
        });
    }

    public void onBackPressed() {

    }
}
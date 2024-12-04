package com.example.quizzesforkids3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.Random;

public class HomeActivity extends AppCompatActivity {
    private Button logOffButton, changePasswordButton, scoreButton, instructionButton;
    private CardView animalsCard, cartoonsCard;
    private TextView greetingView;
    public int minute, hour, day, month, year;
    public static String date, time, field, getUsername;
    public static int question1, question2, question3, question4;
    public static int numTrue = 0;
    public static int numFalse = 0;

    public static ArrayList<Integer> a = new ArrayList<>();
    public static ArrayList<Integer> b = new ArrayList<>();
    public static ArrayList<Integer> c = new ArrayList<>();
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        DatabaseHelper myDB = new DatabaseHelper(this);

        logOffButton = (Button) findViewById(R.id.logOffButton);
        changePasswordButton = (Button) findViewById(R.id.changePasswordButton);
        scoreButton = (Button) findViewById(R.id.scoreButton);
        instructionButton = (Button) findViewById(R.id.instructionButton);
        animalsCard = (CardView) findViewById(R.id.animalsCard);
        cartoonsCard = (CardView) findViewById(R.id.cartoonsCard);
        greetingView = (TextView) findViewById(R.id.greetingView);

        String Username = getIntent().getStringExtra("UsernameName");

        Calendar calendar = Calendar.getInstance();

        question1 = random.nextInt(12) + 1;
        question2 = random.nextInt(12) + 1;
        while (question2 == question1) {
            question2 = random.nextInt(12) + 1;
        }
        question3 = random.nextInt(12) + 1;
        while (question3 == question1 || question3 == question2) {
            question3 = random.nextInt(12) + 1;
        }
        question4 = random.nextInt(12) + 1;
        while (question4 == question1 || question4 == question2 || question4 == question3) {
            question4 = random.nextInt(12) + 1;
        }

        for (int i = 0; i < 4; i++) {
            a.add(random.nextInt(3) + 1);
            b.add(random.nextInt(3) + 1);
            while (Objects.equals(b.get(i), a.get(i))) {
                b.set(i, random.nextInt(3) + 1);
            }
            c.add(random.nextInt(3) + 1);
            while (c.get(i) == b.get(i) || c.get(i) == a.get(i)) {
                c.set(i, random.nextInt(3) + 1);
            }
        }

        greetingView.setText("Hello " + Username);

        scoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ViewAttemptScoreActivity.class);
                intent.putExtra("UsernameForView", Username);
                startActivity(intent);
            }
        });

        logOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CountDownTimer countDownTimer = new CountDownTimer(2000, 2000) {
                    @Override
                    public void onTick(long l) {
                        showMessage1(Username + ", overall you have " + myDB.getOverallScore(Username) + " scores.", "See you again!", 2000);
                    }

                    @Override
                    public void onFinish() {
                        Intent intent = new Intent(HomeActivity.this, SignInActivity.class);
                        startActivity(intent);
                        finish();
                    }
                };
                countDownTimer.start();
            }
        });

        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ChangePasswordActivity.class);
                intent.putExtra("UsernameForPasswordChange", Username);
                startActivity(intent);
            }
        });

        instructionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage("Instructions:", "" +
                        "Choose 1 of the fields below to start the quiz.\n" +
                        "Each field will have 4 questions.\n" +
                        "For animals, you will have to write the name of the animal displayed on the image.\n" +
                        "For cartoons, you will choose the main character name.\n" +
                        "Choose scores to see previous attempts.");
            }
        });

        animalsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minute = calendar.get(Calendar.MINUTE);
                hour = calendar.get(Calendar.HOUR_OF_DAY);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                month = calendar.get(Calendar.MONTH) + 1;
                year = calendar.get(Calendar.YEAR);
                time = String.format("%02d:%02d", hour, minute);
                date = String.format("%02d-%02d-%02d", day, month, year);
                field = "Animals";
                getUsername = Username;

                Intent intent = new Intent(HomeActivity.this, FirstAnimalsQuestionActivity.class);
                startActivity(intent);
                finish();
            }
        });
        cartoonsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minute = calendar.get(Calendar.MINUTE);
                hour = calendar.get(Calendar.HOUR_OF_DAY);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                month = calendar.get(Calendar.MONTH) + 1;
                year = calendar.get(Calendar.YEAR);
                time = String.format("%02d:%02d", hour, minute);
                date = String.format("%02d-%02d-%02d", day, month, year);
                field = "Cartoons";
                getUsername = Username;

                Intent intent = new Intent(HomeActivity.this, FirstCartoonsActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void showMessage(String title, String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }

    public void showMessage1(String title, String msg, int durationMillis) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);

        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                alertDialog.dismiss();
            }
        }, durationMillis);
    }

    public void onBackPressed() {
        /*
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit");
        builder.setMessage("Are you sure you want to exit the app?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Finish the activity and exit the app
                finish();
            }
        });
        builder.setNegativeButton("No", null);
        builder.show();
        */
    }
}
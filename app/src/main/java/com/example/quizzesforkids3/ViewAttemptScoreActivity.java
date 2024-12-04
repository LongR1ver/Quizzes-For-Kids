package com.example.quizzesforkids3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewAttemptScoreActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    String username;
    Cursor res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attempt_score);

        myDB = new DatabaseHelper(this);

        TextView viewAll = (TextView) findViewById(R.id.viewAll);
        TextView viewHeader = (TextView) findViewById(R.id.viewHeader);
        Button defaultButton = (Button) findViewById(R.id.defaultButton);
        Button fieldsButton = (Button) findViewById(R.id.fieldsButton);

        username = getIntent().getStringExtra("UsernameForView");

        res = myDB.viewAllAttempts(username);

        viewHeader.setText(username + ", overall you have " + myDB.getOverallScore(username) + " scores.");

        if (res.getCount() == 0) {
            viewAll.setText("You haven't had any attempts.");
        }
        else {
            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()) {
                buffer.append("\"" + res.getString(2) + "\" area, attempt started on " + res.getString(3) + ", " + res.getString(4) + ". ");
                buffer.append("Points earn " + res.getInt(5) + ".\n\n");
                viewAll.setText(buffer.toString());
            }
        }

        defaultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res1 = myDB.viewAllAttempts(username);
                if (res1.getCount() == 0) {
                    viewAll.setText("You haven't had any attempts.");
                }
                else {
                    StringBuffer buffer = new StringBuffer();
                    while (res1.moveToNext()) {
                        buffer.append("\"" + res1.getString(2) + "\" area, attempt started on " + res1.getString(3) + ", " + res1.getString(4) + ". ");
                        buffer.append("Points earn " + res1.getInt(5) + ".\n\n");
                        viewAll.setText(buffer.toString());
                    }
                }
            }
        });

        fieldsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res2 = myDB.viewAllAttemptsWithOrder(username);
                if (res2.getCount() == 0) {
                    viewAll.setText("You haven't had any attempts.");
                }
                else {
                    StringBuffer buffer = new StringBuffer();
                    while (res2.moveToNext()) {
                        buffer.append("\"" + res2.getString(2) + "\" area, attempt started on " + res2.getString(3) + ", " + res2.getString(4) + ". ");
                        buffer.append("Points earn " + res2.getInt(5) + ".\n\n");
                        viewAll.setText(buffer.toString());
                    }
                }
            }
        });

        /*
        if (res != null && res.moveToFirst()) {
            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()) {
                buffer.append("\"" + res.getString(2) + "\" area, attempt started on " + res.getString(3) + ", " + res.getString(4) + ". ");
                buffer.append("Points earn " + res.getInt(5) + "\n\n");
                viewAll.setText(buffer.toString());
            }
        }
        else {
            viewAll.setText("You haven't had any attempts.");
        }
        */
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AnswerHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_history);

        Intent intent = getIntent();

        String answerHistoryToDisplay = intent.getStringExtra("ANSWER-HISTORY");
        Log.i("mango", "received: " + answerHistoryToDisplay);

        TextView ansHist = findViewById(R.id.answerHistoryTextView);
        ansHist.setText(answerHistoryToDisplay);
    }

    /*
      This method returns the screen back to the mainActivity, without sending anything extra.
     */
    public void returnScreen(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
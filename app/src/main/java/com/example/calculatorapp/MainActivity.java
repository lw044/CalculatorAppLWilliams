package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // hi
    }

    //https://stackoverflow.com/questions/16611198/how-to-know-which-button-called-a-method
    // Code from StackOverflow that shows which button called this method when many buttons share
    // this method; the button is considered the view in the parameter and can be accessed by
    // accessing the view
    public void displayOperation(View view){
        int button = view.getId();
        Button b = findViewById(button);
        String operation = b.getText().toString();
        TextView t = findViewById(R.id.mathOperationTextView);
        t.setText(operation);
    }
}
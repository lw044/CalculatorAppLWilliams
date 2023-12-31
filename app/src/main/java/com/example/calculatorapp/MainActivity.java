package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String answerHistory = "Answer History:\n\n";   // A string that is used to hold answers
                                                    // that are calculated


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
      Parameter: A view, used to identify the view that called this method
      This method finds the id of the view that called this method, then displays the operation
      that corresponds to the button that called this method in the mainActivityTextView.
     */
    public void displayOperation(View view){
        //https://stackoverflow.com/questions/16611198/how-to-know-which-button-called-a-method
        // Code from StackOverflow that shows which button called this method when many buttons
        // share this method; the button is considered the view in the parameter and can be
        // accessed by accessing the view
        int button = view.getId();
        Button b = findViewById(button);
        String operation = b.getText().toString();
        TextView t = findViewById(R.id.mathOperationTextView);
        t.setText(operation);
    }

    /*
      Parameter: A view, representing the view that called this method
      Gets the text from the two editTexts that take numerical input to be calculated, if both
      editTexts have a value. Then, the value of the mathOperationTextView is retrieved to find
      which operation will be used. If the operation textView is empty, then a special message is
      displayed requesting that the user selects an operation. If not, then the math problem is
      calculated, and the solutionTextView is set to be the calculated answer. The answer is also
      concatenated to the global variable AnswerHistory.
     */
    public void solveEquation(View v) {
        //https://www.freecodecamp.org/news/java-string-to-int-how-to-convert-a-string-to-an-
        // integer/
        // Code from Free Code Camp that shows how to change a string into an double; calls a
        // method from the Double class to do so
        EditText firstNumET = findViewById(R.id.firstNumberEditView);
        EditText secondNumET = findViewById(R.id.secondNumberEditView);

        if (!firstNumET.getText().toString().equals("") &&
                !secondNumET.getText().toString().equals("")) {
            double firstNum = Double.parseDouble(firstNumET.getText().toString());
            double secondNum = Double.parseDouble(secondNumET.getText().toString());

            TextView operationTV = findViewById(R.id.mathOperationTextView);
            String operation = operationTV.getText().toString();

            TextView solution = findViewById(R.id.solutionTextView);
            solution.setText(operation);
            if (operation.equals("")) {
                //https://stackoverflow.com/questions/8102741/how-to-use-string-resource-in-a-java-
                //class-in-android
                // Code from Stack Overflow, showing how to use a string resource in an xml file in
                // java code; accesses the string by searching for its id
                solution.setText(this.getString(R.string.no_operation_chosen_message));
            } else {
                double ansNum = 0;
                if (operation.equals("+")) {
                    ansNum = firstNum + secondNum;
                } else if (operation.equals("-")) {
                    ansNum = firstNum - secondNum;
                } else if (operation.equals("x")) {
                    ansNum = firstNum * secondNum;
                } else if (operation.equals("/")) {
                    ansNum = firstNum / secondNum;
                }
                String answer = "" + ansNum;
                solution.setText(answer);
                answerHistory += answer + "\n";
            }
        }
    }

    /*
      This method switches screens to the activity that displays answerHistory. The global variable
      answerHistory is put in the intent, and the intent is sent.
     */
    public void switchScreens(View v){
        Log.i("mango", answerHistory);

        Intent intent = new Intent(this, AnswerHistoryActivity.class);
        intent.putExtra("ANSWER-HISTORY", answerHistory);

        startActivity(intent);
    }
}
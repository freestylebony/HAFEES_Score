package com.hafeesfalana.hafees_score;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener{
       //declare some variables
       int score1Value = 0;
       int score2Value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get buttons by IDs
        Button score1IncreaseBtn = findViewById(R.id.score1Increase);
        Button score1DecreaseBtn = findViewById(R.id.score1Decrease);
        Button score2IncreaseBtn = findViewById(R.id.score2Increase);
        Button score2DecreaseBtn = findViewById(R.id.score2Decrease);

        //listener
        RadioGroup pointsValue = findViewById(R.id.pointsValueGroup);
        score1DecreaseBtn.setOnClickListener(this);
        score1IncreaseBtn.setOnClickListener(this);
        score2DecreaseBtn.setOnClickListener(this);
        score2IncreaseBtn.setOnClickListener(this);
    }



     //onClick method
    @Override
    public void onClick(View view) {
        //initialize an integer called pointValue to store the point values
        int pointValue;
        //find the Id of the radio button group
        RadioGroup pointsValue = findViewById(R.id.pointsValueGroup);
        //use switch statement to get each point values from radio button
        switch (pointsValue.getCheckedRadioButtonId()){
            case R.id.point_3:
                pointValue = 3;
                break;
            case R.id.point_5:
                pointValue = 5;
                break;
            case R.id.point_2:
            default:
                pointValue = 2;
        }

        //get the IDs of the four buttons
        findViewById(R.id.score1Increase);
        findViewById(R.id.score2Increase);
         //get the two score text views
        TextView score1 = findViewById(R.id.score1textView);
        TextView score2 = findViewById(R.id.score2textView);
        // use switch statements to get any of the buttons when clicked
        switch(view.getId()) {
            case R.id.score1Decrease:
                  //decrease the value of score 1 by the radio button point selected
                  score1Value -= pointValue;
                  if(score1Value <= 0){
                      score1Value = 0;
                  }
                   //display the new score value to the score 1 textview
                    score1.setText(Integer.toString(score1Value));
                break;
            case R.id.score1Increase:
                // increase the value of score 1 by the radio button point selected
                 score1Value += pointValue;
                //display the new score value to the score 1 textview
                score1.setText(Integer.toString(score1Value));
                break;
            case R.id.score2Decrease:
                //decrease the value of score 2 by the radio button point selected
                score2Value -= pointValue;
                if(score2Value <= 0) {
                    score2Value = 0;
                }
                //display the new score value to the score 2 textview
                score2.setText(Integer.toString(score2Value));
                break;
            case R.id.score2Increase:
                //increase the value of score 2 by the radio button point selected
                score2Value += pointValue;
                //display the new score value to the score 2 textview
                score2.setText(Integer.toString(score2Value));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }

    }
}
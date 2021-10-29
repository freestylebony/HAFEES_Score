package com.hafeesfalana.hafees_score;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        View.OnClickListener{

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
        pointsValue.setOnCheckedChangeListener(this);
        score1DecreaseBtn.setOnClickListener(this);
        score1IncreaseBtn.setOnClickListener(this);
        score2DecreaseBtn.setOnClickListener(this);
        score2IncreaseBtn.setOnClickListener(this);
    }

     //onCheckedChanged method for radio buttons
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedButtonId) {
        //initialize an integer called pointValue to store the point values
        int pointValue;

           //find the score text views by their IDs
         TextView score1 = findViewById(R.id.score1textView);
         TextView score2 = findViewById(R.id.score2textView);

         //use switch statement to get the Id of the checked radio button to determine the point value
        switch (checkedButtonId){
            case R.id.point_3:
                Toast.makeText( MainActivity.this, "3 points selected", Toast.LENGTH_SHORT).show();
                 pointValue = 3;
                 score1.setText(String.valueOf(pointValue));
                 score2.setText(String.valueOf(pointValue));
                break;
            case R.id.point_5:
                Toast.makeText(MainActivity.this, "5 points selected", Toast.LENGTH_SHORT).show();
                pointValue = 5;
                score1.setText(String.valueOf(pointValue));
                score2.setText(String.valueOf(pointValue));
                break;
            case R.id.point_2:
            default:
                Toast.makeText(MainActivity.this, "2 points selected", Toast.LENGTH_SHORT).show();
                pointValue = 2;
                score1.setText(String.valueOf(pointValue));
                score2.setText(String.valueOf(pointValue));
        }
    }

     //onClick method for buttons
    @Override
    public void onClick(View view) {
        //get the IDs of the four buttons
        findViewById(R.id.score1Increase);
        findViewById(R.id.score1Decrease);
        findViewById(R.id.score2Increase);
        findViewById(R.id.score2Decrease);
         //get the two score text views
        TextView score1 = findViewById(R.id.score1textView);
        TextView score2 = findViewById(R.id.score2textView);
        // use switch statements to get any of the buttons when clicked
        switch(view.getId()) {
            case R.id.score1Decrease:
                //get the value from score 1 textview
                  String valueString = score1.getText().toString();
                  //convert the value to an integer and decrease it by 1
                   Integer scoreValue = Integer.parseInt(valueString);
                   scoreValue -= 1;
                   //display the new score value to the score 1 textview
                    score1.setText(scoreValue.toString());
                break;
            case R.id.score1Increase:
                //get the value from score 1 textview
                valueString = score1.getText().toString();
                //convert the value to an integer and increase it by 1
                 scoreValue = Integer.parseInt(valueString);
                scoreValue += 1;
                //display the new score value to the score 1 textview
                score1.setText(scoreValue.toString());
                break;
            case R.id.score2Decrease:
                //get the value from score 2 textview
                valueString = score2.getText().toString();
                //convert the value to an integer and decrease it by 1
                scoreValue = Integer.parseInt(valueString);
                scoreValue -= 1;
                //display the new score value to the score 1 textview
                score2.setText(scoreValue.toString());
                break;
            case R.id.score2Increase:
                //get the value from score 2 textview
                valueString = score2.getText().toString();
                //convert the value to an integer and increase it by 1
                scoreValue = Integer.parseInt(valueString);
                scoreValue += 1;
                //display the new score value to the score 1 textview
                score2.setText(scoreValue.toString());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }

    }
}
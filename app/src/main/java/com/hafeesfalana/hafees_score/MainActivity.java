package com.hafeesfalana.hafees_score;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
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
       private SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //preference manager
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
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
     //Menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }
   //Options menu onclick method

   public boolean onOptionsItemSelected(MenuItem item) {
       // Handle item selection
       switch (item.getItemId()) {
           case R.id.menu_about:
               Toast.makeText(this, "Hafees Falana. Student ID: A00240043", Toast.LENGTH_LONG).show();
               break;
           case R.id.menu_settings:
               startActivity(new Intent(
                       getApplicationContext(),
                       SettingsActivity.class
                       )

               );
               break;
           default:
               return super.onOptionsItemSelected(item);
       }
       return true;
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

    //on resume method

    @Override
    protected void onResume() {
        super.onResume();

        //get preferences
        //get score 1
        String score1String = prefs.getString("score1_pref", "0");
        TextView score1 = findViewById(R.id.score1textView);
        score1.setText(score1String);

        // get score2
        String score2String = prefs.getString("score2_pref", "0");
        TextView score2 = findViewById(R.id.score2textView);
        score2.setText(score2String);

    }

    //on Pause method

    @Override
    protected void onPause() {
        SharedPreferences.Editor editor = prefs.edit();
        boolean saveValues = prefs.getBoolean("save_values_pref", false);
        if(saveValues) {
            TextView score1 = findViewById(R.id.score1textView);
            TextView score2 = findViewById(R.id.score2textView);

            editor.putString("score1_pref", score1.getText().toString());
            editor.putString( "score2_pref", score2.getText().toString());
        }else{

            editor.clear();
            editor.putBoolean("save_values_pref", false);
        }
        editor.apply();

        super.onPause();

    }
}
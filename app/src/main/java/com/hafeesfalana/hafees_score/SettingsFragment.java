package com.hafeesfalana.hafees_score;


import android.os.Bundle;

import android.preference.PreferenceFragment;



public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //add preferences

        addPreferencesFromResource(R.xml.preferences);

    }

}
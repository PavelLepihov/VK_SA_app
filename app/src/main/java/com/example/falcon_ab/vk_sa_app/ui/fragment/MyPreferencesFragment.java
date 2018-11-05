package com.example.falcon_ab.vk_sa_app.ui.fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.example.falcon_ab.vk_sa_app.R;

public class MyPreferencesFragment extends PreferenceFragment {

    public MyPreferencesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}

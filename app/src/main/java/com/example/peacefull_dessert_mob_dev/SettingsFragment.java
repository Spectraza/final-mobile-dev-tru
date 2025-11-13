package com.example.peacefull_dessert_mob_dev;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;


public class SettingsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    EditText etLastName, etUsernsme, etEmail, etPassword, etConfirm;
    Button btnCreate;

//    @Override
//    protected void onCreate(Bundle b) {
//        super.onCreate(b);
//        setContentView(R.layout.activity_)
//    }
}
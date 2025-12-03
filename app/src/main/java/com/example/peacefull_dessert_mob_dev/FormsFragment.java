package com.example.peacefull_dessert_mob_dev;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Empty forms fragment
 *
 * Things to implement:
 * - Clear all form EditText boxes after clicking submit button
 * - If possible implement shared preferences before the clear by
 *   writing all user inputted text to a preferences file
 *
 * @author Rion Miyazaki
 * @since 2025
 * @documenter Rion Miyazaki
 */
public class FormsFragment extends Fragment {
    public FormsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forms, container, false);
    }
}
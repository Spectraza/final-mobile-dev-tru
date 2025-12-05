package com.example.peacefull_dessert_mob_dev;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


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

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Button submitButton = view.findViewById(R.id.button3);
        EditText nameEditText = view.findViewById(R.id.editTextText3);
        EditText allergiesEditText = view.findViewById(R.id.editTextTextMultiLine);
        EditText addressEditText = view.findViewById(R.id.editTextTextPostalAddress);
        RadioButton radioButton = view.findViewById(R.id.radioButton);





        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameEditText.getText().toString().isEmpty() || allergiesEditText.getText().toString().isEmpty() || addressEditText.getText().toString().isEmpty() || !radioButton.isChecked()) {
                    Toast.makeText(getActivity(), "Please fill out everything", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getActivity(), "Form submitted!", Toast.LENGTH_SHORT).show();
                nameEditText.setText("");
                allergiesEditText.setText("");
                addressEditText.setText("");
            }

        });

    }
}
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
    LinearLayout account, paymentMethod, language, notification, privacy, switchAccount, logOut;
    Switch darkMode;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // instantize View view as inflater.inflate
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // initialize all variables through view id
        account = view.findViewById(R.id.clickBoxAccount);
        darkMode = view.findViewById(R.id.switchDarkMode);
        paymentMethod = view.findViewById(R.id.clickBoxPayment);
        language = view.findViewById(R.id.clickBoxLanguage);
        notification = view.findViewById(R.id.clickBoxNotification);
        privacy = view.findViewById(R.id.clickBoxPrivacy);
        switchAccount = view.findViewById(R.id.clickBoxSwitchAccount);
        logOut = view.findViewById(R.id.clickBoxLogout);

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Take to new account fragment displaying email and user name (maybe set profile picture?)
            }
        });

        darkMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If toggled switch set all page backgrounds to dark and text to cream or white
            }
        });

        paymentMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Take to card fragment with several editviews to input card name, number, cvv, expirey date
            }
        });

        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // send dummy pop up this will only be implemented after everything else is done
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // send to fragment with a bunch of dummy switches labeled allow notifications, allow banner, etc
            }
        });

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // send pop up dummy
            }
        });

        switchAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // send to switch account fragment that allows the user to reinput username and password
                //send toast message after resigned in to new account
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // send toast message that user has been successfully logged out and send back to the log in page
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
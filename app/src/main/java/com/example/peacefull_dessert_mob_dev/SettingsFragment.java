package com.example.peacefull_dessert_mob_dev;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

/**
 * Settings fragment with variables initialized
 *  Switch account and log out take user back to log in activity
 *  Music player starts and stops foreground music service
 *
 * @author Rion Miyazaki and Valeriia Savych
 * @since 2025-10-16
 * @documenter Rion Miyazaki
 */
public class SettingsFragment extends Fragment {
    LinearLayout account, paymentMethod, language, notification, privacy, switchAccount, logOut, music;
    ImageView musicToggle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // instantize View view as inflater.inflate
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // initialize all variables through view id
        account = view.findViewById(R.id.clickBoxAccount);
        paymentMethod = view.findViewById(R.id.clickBoxPayment);
        language = view.findViewById(R.id.clickBoxLanguage);
        music = view.findViewById(R.id.clickBoxMusic);
        notification = view.findViewById(R.id.clickBoxNotification);
        privacy = view.findViewById(R.id.clickBoxPrivacy);
        switchAccount = view.findViewById(R.id.clickBoxSwitchAccount);
        logOut = view.findViewById(R.id.clickBoxLogout);
        musicToggle = view.findViewById(R.id.imageViewMusic);

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountFragment accountFragment = new AccountFragment();

                requireActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, accountFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        paymentMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(), "Feature still under development", Toast.LENGTH_SHORT).show();
            }
        });

        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(), "Feature still under development", Toast.LENGTH_SHORT).show();
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(), "Feature still under development", Toast.LENGTH_SHORT).show();
            }
        });

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = requireContext();
                Intent intent = new Intent(context, AppMusic.class);

                if (AppMusic.isPlaying) {
                    // If the service is currently playing stop it on click
                    context.stopService(intent);
                    musicToggle.setImageResource(R.drawable.baseline_music_off_24);
                } else {
                    // If service is not playing start it on click
                    ContextCompat.startForegroundService(context, intent);
                    musicToggle.setImageResource(R.drawable.outline_music_note_24);
                }
            }
        });

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(), "Feature still under development", Toast.LENGTH_SHORT).show();
            }
        });

        switchAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartManager cartManager = CartManager.getInstance(requireContext());
                cartManager.clearCart();

                SharedPreferences sharedPreferences = requireContext().getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("Logged Out", true);
                editor.apply();

                Toast.makeText(requireContext(), "Logged Out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(requireContext(), LogInActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                requireActivity().finish();

                // send toast message that user has been successfully logged out and send back to the log in page
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartManager cartManager = CartManager.getInstance(requireContext());
                cartManager.clearCart();

                SharedPreferences sharedPreferences = requireContext().getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("Logged Out", true);
                editor.apply();

                Toast.makeText(requireContext(), "Logged Out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(requireContext(), LogInActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                requireActivity().finish();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
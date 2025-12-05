package com.example.peacefull_dessert_mob_dev;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Main Activity class with user login and create account/sign up textView
 * onClick textView sends user to Sign up Activity
 * <p>
 * Possibly implement shared preferences onto shared preference file
 *
 * @author Valeriia Savych
 * @documenter Rion Miyazaki
 * @since 2025
 */
public class LogInActivity extends AppCompatActivity {

    Button login;
    TextView createAcc;

    EditText email, password;


//    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        login = findViewById(R.id.button);
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);

        login.setOnClickListener(v1 -> {
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            boolean isLoggedOut = sharedPreferences.getBoolean("isLoggedOut", true);

            if (isLoggedOut) {
                CartManager cartManager = CartManager.getInstance(LogInActivity.this);
                cartManager.clearCart();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("Logged Out", false);
                editor.apply();
            }

            if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                Toast.makeText(LogInActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                return;
            }
            
            Toast.makeText(LogInActivity.this, "Logged in!", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(LogInActivity.this, HomeActivity.class);
            startActivity(intent1);


        });
        createAcc = findViewById(R.id.textViewCreateAccount);
        createAcc.setOnClickListener(v2 -> {
            Intent intent2 = new Intent(LogInActivity.this, SignUpActivity.class);
            startActivity(intent2);
        });
    }
}
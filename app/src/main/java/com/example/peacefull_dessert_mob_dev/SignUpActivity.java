package com.example.peacefull_dessert_mob_dev;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
/**
 * Sign up activity for user account creation
 *
 * May need shared preferences implementation
 *
 * @author Valeriia Savych
 * @since 2025
 * @documenter Rion Miyazaki
 */
public class SignUpActivity extends AppCompatActivity {
    EditText etLastName, etUsername, etEmail, etPassword, etConfirm;
    Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acc);

        etLastName = findViewById(R.id.etLastName);
        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirm = findViewById(R.id.etConfirm);
        btnCreate = findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(v -> {
            String lastName = etLastName.getText().toString().trim();
            String username = etUsername.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String pass = etPassword.getText().toString().trim();
            String confirm = etConfirm.getText().toString().trim();

            if (lastName.isEmpty() || username.isEmpty() || email.isEmpty() ||
                    pass.isEmpty() || confirm.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!pass.equals(confirm)) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }

            // Save account locally using SharedPreferences
            SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("lastName", lastName);
            editor.putString("username", username);
            editor.putString("email", email);
            editor.putString("password", pass);
            editor.apply();

            CartManager cartManager = CartManager.getInstance(this);
            cartManager.clearCart();

            SharedPreferences sessionPrefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor sessionEditor = sessionPrefs.edit();
            sessionEditor.putBoolean("Logged Out", true);

            Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show();

            // Go to Login screen
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
            finish();
        });
    }
}

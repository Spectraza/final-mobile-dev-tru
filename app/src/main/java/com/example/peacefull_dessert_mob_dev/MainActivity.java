package com.example.peacefull_dessert_mob_dev;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    Button login;
    TextView createAcc;

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
        login.setOnClickListener(v1 -> {
            Intent intent1 = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent1);
        });
        createAcc = findViewById(R.id.textViewCreateAccount);
        createAcc.setOnClickListener(v2 -> {
            Intent intent2 = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent2);
        });
    }
}
package com.example.peacefull_dessert_mob_dev;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SinglePageDessert extends AppCompatActivity {
    TextView name, price, description, quantity, rate;
    ImageView image;

    ImageButton backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_single_page_dessert);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = findViewById(R.id.name);
        price = findViewById(R.id.textView);
        description = findViewById(R.id.textView9);
        quantity = findViewById(R.id.textView5);
        rate = findViewById(R.id.textView8);
        image = findViewById(R.id.imageView3);
        backButton = findViewById(R.id.imageButton2);

        Intent intent = getIntent();
        String nameValue = intent.getStringExtra("name");
        String priceValue = intent.getStringExtra("price");
        String descriptionValue = intent.getStringExtra("description");
        String quantityValue = intent.getStringExtra("quantity");
        String rateValue = intent.getStringExtra("rate");
        String imageValue = intent.getStringExtra("image");

        name.setText(nameValue);
        price.setText(priceValue);
        description.setText(descriptionValue);
        quantity.setText(quantityValue);
        rate.setText(rateValue);
        image.setImageResource(getResources().getIdentifier(imageValue, "drawable", getPackageName()));


        backButton.setOnClickListener(v -> {
            finish();
        });




    }
}
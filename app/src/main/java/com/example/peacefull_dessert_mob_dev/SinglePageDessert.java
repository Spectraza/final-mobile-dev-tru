package com.example.peacefull_dessert_mob_dev;

import static java.security.AccessController.getContext;

import android.content.Context;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SinglePageDessert extends AppCompatActivity {
    TextView name, price, description, quantity, rate;
    ImageView image, backArrow;

    RecyclerView recommendationList;
    DessertCardAdapter adapter;

    ArrayList<Dessert> dessertList;




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
        backArrow = findViewById(R.id.imageView4);
        recommendationList = findViewById(R.id.recycler_view_cards);

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

        dessertList = new ArrayList<>();
        dessertList.add(new Dessert("Blueberry Basil Eclair", "5$", "This refreshing éclair features a traditional croup pastry shell.", R.drawable.beclaire));
        dessertList.add(new Dessert("Brownie Sampler", "5$", "Our Brownie Sampler features a variety of rich, fudgy brownies.", R.drawable.brownie_sampler));
        dessertList.add(new Dessert("Hazelnut Eclair", "5$", "This Hazelnut Éclair is made with classic choux pastry.", R.drawable.hazel_nut));
        dessertList.add(new Dessert("Kalu Dodol", "5$", "Kalu Dodol is a traditional Sri Lankan sweet.", R.drawable.kalu_dodol));


        backArrow.setOnClickListener(v -> {
            finish();
        });

        adapter = new DessertCardAdapter(SinglePageDessert.this, dessertList);
        recommendationList.setAdapter(adapter);


        adapter = new DessertCardAdapter(SinglePageDessert.this, dessertList);
        recommendationList.setAdapter(adapter);

        int numberOfColumns = 2;

        GridLayoutManager gridLayoutManager = new GridLayoutManager(SinglePageDessert.this, numberOfColumns);
        recommendationList.setLayoutManager(gridLayoutManager);


    }


}
package com.example.peacefull_dessert_mob_dev;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class HomeActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
       setContentView(R.layout.activity_main_page);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);

        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(viewPageAdapter);


        String[] TAB_TITLES = {"Home", "Cart", "Forms", "Settings"};
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setText(TAB_TITLES[position]);
        });
        tabLayoutMediator.attach();
    }
}

package com.example.peacefull_dessert_mob_dev;

import android.os.Bundle;
import android.view.Menu;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class HomeActivity extends AppCompatActivity {
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_page);


        viewPager2 = findViewById(R.id.view_pager);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);


//
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(this);
        viewPager2.setAdapter(viewPageAdapter);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.item_1) {
                viewPager2.setCurrentItem(0);
            } else if (itemId == R.id.item_2) {
                viewPager2.setCurrentItem(1);
            } else if (itemId == R.id.item_3) {
                viewPager2.setCurrentItem(2);
            } else if (itemId == R.id.item_4) {
                viewPager2.setCurrentItem(3);
            }
            return true;
        });


//        String[] TAB_TITLES = {"Home", "Cart", "Forms", "Settings"};
//        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
//            tab.setText(TAB_TITLES[position]);
//        });
//        tabLayoutMediator.attach();


        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.item_1);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.item_2);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.item_3);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.item_4);
                }
            }
        });

    }
}


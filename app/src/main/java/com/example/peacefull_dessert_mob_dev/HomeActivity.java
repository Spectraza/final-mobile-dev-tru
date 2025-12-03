package com.example.peacefull_dessert_mob_dev;

import android.os.Bundle;

import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.google.android.material.bottomnavigation.BottomNavigationView;
/**
 * Home Activity class including the bottom navigation bar and search view
 *
 * Search view to be implemented:
 * - Need to filter key dessert names
 *
 * @author Valeriia Savych
 * @since 2025
 * @documenter Rion Miyazaki
 */

public class HomeActivity extends AppCompatActivity {
    //    ViewPager2 viewPager2;
    SearchView searchView;
    private Fragment activeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_page);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        searchView = findViewById(R.id.search_view);
        if (savedInstanceState == null) {
            loadFragment(new HomeFragment(), "Home");


        }

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            Fragment selectedFragment = null;
            String tag = "";

            if (itemId == R.id.item_1) {
                selectedFragment = new HomeFragment();
                tag = "Home";
            } else if (itemId == R.id.item_2) {
                selectedFragment = new CartFragment();
                tag = "Cart";
            } else if (itemId == R.id.item_3) {
                selectedFragment = new FormsFragment();
                tag = "Forms";
            } else if (itemId == R.id.item_4) {
                selectedFragment = new SettingsFragment();
                tag = "Settings";
            }

            if (selectedFragment != null) {
                loadFragment(selectedFragment, tag);
            }
            return true;
        });
        setupSearchView();
    }

    private void setupSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                passQueryToFragment(query);
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                passQueryToFragment(newText);
                return true;
            }


        });

    }

    private void loadFragment(Fragment fragment, String tag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        if (activeFragment != null) {
            transaction.hide(activeFragment);
        }

        Fragment existingFragment = fm.findFragmentByTag(tag);
        if (existingFragment == null) {
            transaction.add(R.id.fragment_container, fragment, tag);
            activeFragment = fragment;
        } else {
            transaction.show(existingFragment);
            activeFragment = existingFragment;
        }

        transaction.commit();
    }


    private void passQueryToFragment(String query) {
        if (activeFragment instanceof Searchable) {
            ((Searchable) activeFragment).onSearch(query);
        }
    }
}


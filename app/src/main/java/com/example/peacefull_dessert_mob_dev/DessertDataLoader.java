package com.example.peacefull_dessert_mob_dev;

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DessertDataLoader {
    public static Map<String, DessertData> loadDesserts(Context context) {
        Map<String, DessertData> desserts = new HashMap<>();
        // Load data from JSON file>
        try (
                InputStream inputStream = context.getAssets().open("desserts.json");
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        ){
            Gson gson = new Gson();
            DessertData[] dessertData = gson.fromJson(reader, DessertData[].class);
            for (DessertData dessert : dessertData) {
                desserts.put(dessert.getName(), dessert);
            }
        } catch (Exception a){
            a.printStackTrace();
        }
        return desserts;
    }
}

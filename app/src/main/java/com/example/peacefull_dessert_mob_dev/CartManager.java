package com.example.peacefull_dessert_mob_dev;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static final String NAME = "cart_items";
    private static final String KEY_CART_ITEMS = "cart_items";

    private static CartManager instance;
    private final SharedPreferences sharedPreferences;
    private final Gson gson;

    private CartManager(Context context) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(NAME, Context.MODE_PRIVATE);
        gson = new Gson();

    }

    public static synchronized CartManager getInstance(Context context) {
        if (instance == null) {
            instance = new CartManager(context);
        }
        return instance;
    }

    public void saveToCart(List<String> cartItemNames) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String jsonCart = gson.toJson(cartItemNames);
        editor.putString(KEY_CART_ITEMS, jsonCart);
        editor.apply();


    }

    public List<String> getCartItems() {
        String jsonCart = sharedPreferences.getString(KEY_CART_ITEMS, null);
        if (jsonCart == null) {
            return new ArrayList<>();
        } else {
            Type type = new TypeToken<ArrayList<String>>() {
            }.getType();
            return gson.fromJson(jsonCart, type);
        }
    }

    public void addItemToCart(String itemId) {
        List<String> cartItems = getCartItems();
        if (!cartItems.contains(itemId)) {
            cartItems.add(itemId);
            saveToCart(cartItems);
        }

    }

    public void removeItemFromCart(String itemId) {
        List<String> cartItems = getCartItems();
        if (cartItems.contains(itemId)) {
            cartItems.remove(itemId);
            saveToCart(cartItems);
        }
    }

    public int getCartSize() {
        return getCartItems().size();
    }

    public void clearCart() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(KEY_CART_ITEMS);
        editor.apply();
    }


}


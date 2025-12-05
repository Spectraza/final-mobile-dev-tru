package com.example.peacefull_dessert_mob_dev;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Cart fragment for displaying items added to cart via dessert card
 * "add to cart" button
 *
 * @author Valeriia Savych
 * @since 2025
 * @documenter Rion Miyazaki
 */

public class CartFragment extends Fragment implements CartUpdateListener {
    private CartManager cartManager;
    private RecyclerView dessert_list_cart_input;

    private DessertCartPageAdapter adapter;
    private TextView emptyCart;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        final Context context;

        super.onViewCreated(view, savedInstanceState);

        cartManager = CartManager.getInstance(requireContext());
        dessert_list_cart_input = view.findViewById(R.id.recyvler_view_cart);
        emptyCart = view.findViewById(R.id.emptyCart);


        setupRecyclerView();
        loadAndDisplayCartItems();
    }

    private void loadAndDisplayCartItems() {
        List<String> cartItems = cartManager.getCartItems();

        if(cartItems == null || cartItems.isEmpty()){
            dessert_list_cart_input.setVisibility(View.GONE);
            emptyCart.setVisibility(View.VISIBLE);
            adapter.updateCart(new ArrayList<>());
            return;
        }

        List<Dessert> allDessertList = HomeFragment.getAllDeserts();
        List<Dessert> dessertsInCart = new ArrayList<>();
        for (String dessertName : cartItems) {
            if (dessertName == null || dessertName.trim().isEmpty()) {
                continue;
            }
            for (Dessert dessert : allDessertList) {
                if (dessert.getName().equals(dessertName)) {
                    dessertsInCart.add(dessert);
                    break;
                }
            }
        }
        if (dessertsInCart.isEmpty()) {
            cartManager.clearCart();
            dessert_list_cart_input.setVisibility(View.GONE);
            emptyCart.setVisibility(View.VISIBLE);
            adapter.updateCart(new ArrayList<>());
        } else {
            dessert_list_cart_input.setVisibility(View.VISIBLE);
            emptyCart.setVisibility(View.GONE);
            adapter.updateCart(dessertsInCart);
        }
        adapter.updateCart(dessertsInCart);

    }

    private void setupRecyclerView() {
        adapter = new DessertCartPageAdapter(getContext(), new ArrayList<>());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        dessert_list_cart_input.setLayoutManager(linearLayoutManager);
        dessert_list_cart_input.setAdapter(adapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        if (cartManager != null) {
            loadAndDisplayCartItems();
        }
    }

    @Override
    public void onCartUpdated() {
        loadAndDisplayCartItems();
    }

    public void refreshCart() {
        if (cartManager != null) {
            loadAndDisplayCartItems();
        }
    }
}


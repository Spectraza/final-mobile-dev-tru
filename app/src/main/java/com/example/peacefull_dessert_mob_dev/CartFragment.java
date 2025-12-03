package com.example.peacefull_dessert_mob_dev;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Cart fragment for displaying items added to cart via dessert card
 * "add to cart" button
 *
 * @author Valeriia Savych
 * @since 2025
 * @documenter Rion Miyazaki
 */
public class CartFragment extends Fragment {
    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView dessert_list_cart_input = view.findViewById(R.id.recyvler_view_cart);

        ArrayList<Dessert> dessertList = new ArrayList<>();
        dessertList.add(new Dessert("Caramel Eclaire", "8$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.caramel_eclaire));
        DessertCartPageAdapter adapter = new DessertCartPageAdapter(getContext(), dessertList);
        dessert_list_cart_input.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        dessert_list_cart_input.setLayoutManager(linearLayoutManager);

    }
}


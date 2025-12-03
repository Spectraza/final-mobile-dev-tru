package com.example.peacefull_dessert_mob_dev;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Home Fragment displaying recycler view of dessert cards
 *
 * Need to add dessert description and update any dummy text
 *
 * @author Valeriia Savych
 * @since 2025
 * @documenter Rion Miyazaki
 */
public class HomeFragment extends Fragment implements Searchable {
    ArrayList<Dessert> dessertList;
    RecyclerView dessert_list_card_input;
    DessertCardAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         dessert_list_card_input = view.findViewById(R.id.recycler_view_cards);

        dessertList = new ArrayList<>();
        dessertList.add(new Dessert("Caramel Eclaire", "8$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.caramel_eclaire));
        dessertList.add(new Dessert("Black Forest Éclair", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.black_forest));
        dessertList.add(new Dessert("Banyk", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.banyk));
        dessertList.add(new Dessert("Beclaire", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.beclaire));
        dessertList.add(new Dessert("Brownie Sample", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.brownie_sampler));
        dessertList.add(new Dessert("Cookie Sampler", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.cookie_sampler));
        dessertList.add(new Dessert("Hazel Nut", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.hazel_nut));
        dessertList.add(new Dessert("Kalu Dodol", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.kalu_dodol));
        dessertList.add(new Dessert("Lemon Rasberry Cake", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.lemon_raspberry_cake));
        dessertList.add(new Dessert("Oeey Gooey", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.oeey_gooey));
        dessertList.add(new Dessert("Peach Lemonade", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.peach_lemonade));
        dessertList.add(new Dessert("Pomegrante Ginger Sparkler", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.pomegrante_ginger_sparkler));
        dessertList.add(new Dessert("Raspberry Millie Feuille", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.raspberry_mille_feuille));
        dessertList.add(new Dessert("Strawberry Mille-Feuille", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.strawberry_cake));
        dessertList.add(new Dessert("Chocolate Millie Feuille", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.chocolate_mille_feuille));
        dessertList.add(new Dessert("Coffee Caramel Mille Feuille", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.coffee_caramel_mille_feuille));
        dessertList.add(new Dessert("Chocolate Mocha Eclair", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.choco_eclaire_one));
        dessertList.add(new Dessert("Rasberry Negroni", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.raspberry_negroni));
        dessertList.add(new Dessert("Strawberry Soda", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.strawberry_soda));
        dessertList.add(new Dessert("Triple Chocolate Cake", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.triple_chocolate_cake));
        dessertList.add(new Dessert("Undu Walalu", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.undu_walalu));
        dessertList.add(new Dessert("White Hot Chocolate", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.white_hot_chocolate));
        dessertList.add(new Dessert("White Strawberry Brownie", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.white_strawberry_brownie));

        adapter = new DessertCardAdapter(requireContext(), dessertList);
        dessert_list_card_input.setAdapter(adapter);

        int numberOfColumns = 2;

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), numberOfColumns);
        dessert_list_card_input.setLayoutManager(gridLayoutManager);

    }
    @Override
    public void onSearch(String query) {
        if (adapter != null) {
            adapter.getFilter().filter(query);
        }
    }


}
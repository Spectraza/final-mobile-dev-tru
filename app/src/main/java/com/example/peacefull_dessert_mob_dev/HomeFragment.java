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
import java.util.List;


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
    private CartUpdateListener cartUpdateListener;


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
        dessertList.add(new Dessert("Caramel Eclaire", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.caramel_eclaire));
        dessertList.add(new Dessert("Black Forest Éclair", "8$", "This Black Forest Éclair. Sweet", R.drawable.black_forest));
        dessertList.add(new Dessert("Lviv Cheesecake", "7$", "Lviv Cheesecake, or Lvivskyi Syrnyk, is a lighter, tangy Ukrainian dessert.", R.drawable.cheesecake_horizontal));
        dessertList.add(new Dessert("Blueberry Basil Eclair", "9$", "This refreshing éclair features a traditional croup pastry shell.", R.drawable.beclaire));
        dessertList.add(new Dessert("Brownie Sampler", "10$", "Our Brownie Sampler features a variety of rich, fudgy brownies.", R.drawable.brownie_sampler));
        dessertList.add(new Dessert("Cookie Sampler", "8$", "Our Cookie Sampler is a delicious assortment of freshly baked cookies.", R.drawable.cookie_sampler));
        dessertList.add(new Dessert("Hazelnut Eclair", "11$", "This Hazelnut Éclair is made with classic choux pastry.", R.drawable.hazel_nut));
        dessertList.add(new Dessert("Kalu Dodol", "4$", "Kalu Dodol is a traditional Sri Lankan sweet.", R.drawable.kalu_dodol));
        dessertList.add(new Dessert("Kyiv Cake", "5$", "The Kyiv cake is a legendary Ukrainian dessert.", R.drawable.kyiv_cake));
        dessertList.add(new Dessert("Lemon Raspberry Cake", "2.30$", "The refreshing Lemon Raspberry Cake.", R.drawable.lemon_raspberry_cake));
        dessertList.add(new Dessert("Oeey Gooey", "3$", "Our Oeey Gooey treat is a soft, rich, and ultra-melty dessert.", R.drawable.oeey_gooey));
        dessertList.add(new Dessert("Peach Lemonade", "4$", "Our Peach Lemonade is a refreshing drink.", R.drawable.peach_lemonade));
        dessertList.add(new Dessert("Pomegranate Sparkler", "5$", "Pomegranate Ginger Sparkler is a refreshing, fruity drink.", R.drawable.pomegrante_ginger_sparkler));
        dessertList.add(new Dessert("Raspberry Millie Feuille", "3.30$", "The Raspberry Mille-Feuille. Sweet", R.drawable.raspberry_mille_feuille));
        dessertList.add(new Dessert("Strawberry Mille-Feuille", "6$", "The Strawberry Mille-Feuille. Sweet", R.drawable.strawberry_cake));
        dessertList.add(new Dessert("Chocolate Mille-Feuille", "5$", "The elegant pastry features layers of crisp puff pastry.", R.drawable.chocolate_mille_feuille));
        dessertList.add(new Dessert("Coffee Caramel Mille-Feuille", "8$", "This elegant pastry features layers of crisp puff pastry.", R.drawable.coffee_caramel_mille_feuille));
        dessertList.add(new Dessert("Chocolate Mocha Eclair", "10$", "The Chocolate Mocha Éclair. Sweet.", R.drawable.choco_eclaire_one));
        dessertList.add(new Dessert("Raspberry Negroni", "4$", "The Raspberry Negroni is a twist on the classic cocktail.", R.drawable.raspberry_negroni));
        dessertList.add(new Dessert("Strawberry Soda", "3.30$", "A refreshing and fizzy drink.", R.drawable.strawberry_soda));
        dessertList.add(new Dessert("Triple Chocolate Cake", "5$", "Our Triple Chocolate Cake is a decadent treat for chocolate lovers.", R.drawable.triple_chocolate_cake));
        dessertList.add(new Dessert("Undu Walalu", "7$", "Undu Walalu is a traditional Sri Lankan sweet.", R.drawable.undu_walalu));
        dessertList.add(new Dessert("White Hot Chocolate", "2$", "Indulge in our creamy White Hot Chocolate", R.drawable.white_hot_chocolate));
        dessertList.add(new Dessert("White Strawberry Brownie", "8$", "A soft and indulgent brownie.", R.drawable.white_strawberry_brownie));

        adapter = new DessertCardAdapter(requireContext(), dessertList);

        if (cartUpdateListener != null) {
            adapter.setCartUpdateListener(cartUpdateListener);
        }

        dessert_list_card_input.setAdapter(adapter);

        int numberOfColumns = 2;

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), numberOfColumns);
        dessert_list_card_input.setLayoutManager(gridLayoutManager);

    }

    public void setCartUpdateListener(CartUpdateListener listener) {
        this.cartUpdateListener = listener;
        if (adapter != null) {
            adapter.setCartUpdateListener(listener);
        }
    }
    @Override
    public void onSearch(String query) {
        if (adapter != null) {
            adapter.getFilter().filter(query);
        }
    }


    public static List<Dessert> getAllDeserts(){
        List<Dessert> allDessertList = new ArrayList<>();
        allDessertList.add(new Dessert("Caramel Eclaire", "5$", "Delicious caramel-flavored eclair topped with caramel glaze.", R.drawable.caramel_eclaire));
        allDessertList.add(new Dessert("Black Forest Éclair", "8$", "This Black Forest Éclair. Sweet", R.drawable.black_forest));
        allDessertList.add(new Dessert("Lviv Cheesecake", "7$", "Lviv Cheesecake, or Lvivskyi Syrnyk, is a lighter, tangy Ukrainian dessert.", R.drawable.cheesecake_horizontal));
        allDessertList.add(new Dessert("Blueberry Basil Eclair", "9$", "This refreshing éclair features a traditional croup pastry shell.", R.drawable.beclaire));
        allDessertList.add(new Dessert("Brownie Sampler", "10$", "Our Brownie Sampler features a variety of rich, fudgy brownies.", R.drawable.brownie_sampler));
        allDessertList.add(new Dessert("Cookie Sampler", "8$", "Our Cookie Sampler is a delicious assortment of freshly baked cookies.", R.drawable.cookie_sampler));
        allDessertList.add(new Dessert("Hazelnut Eclair", "11$", "This Hazelnut Éclair is made with classic choux pastry.", R.drawable.hazel_nut));
        allDessertList.add(new Dessert("Kalu Dodol", "4$", "Kalu Dodol is a traditional Sri Lankan sweet.", R.drawable.kalu_dodol));
        allDessertList.add(new Dessert("Kyiv Cake", "5$", "The Kyiv cake is a legendary Ukrainian dessert.", R.drawable.kyiv_cake));
        allDessertList.add(new Dessert("Lemon Raspberry Cake", "2.30$", "The refreshing Lemon Raspberry Cake.", R.drawable.lemon_raspberry_cake));
        allDessertList.add(new Dessert("Oeey Gooey", "3$", "Our Oeey Gooey treat is a soft, rich, and ultra-melty dessert.", R.drawable.oeey_gooey));
        allDessertList.add(new Dessert("Peach Lemonade", "4$", "Our Peach Lemonade is a refreshing drink.", R.drawable.peach_lemonade));
        allDessertList.add(new Dessert("Pomegranate Sparkler", "5$", "Pomegranate Ginger Sparkler is a refreshing, fruity drink.", R.drawable.pomegrante_ginger_sparkler));
        allDessertList.add(new Dessert("Raspberry Millie Feuille", "3.30$", "The Raspberry Mille-Feuille. Sweet", R.drawable.raspberry_mille_feuille));
        allDessertList.add(new Dessert("Strawberry Mille-Feuille", "6$", "The Strawberry Mille-Feuille. Sweet", R.drawable.strawberry_cake));
        allDessertList.add(new Dessert("Chocolate Mille-Feuille", "5$", "The elegant pastry features layers of crisp puff pastry.", R.drawable.chocolate_mille_feuille));
        allDessertList.add(new Dessert("Coffee Caramel Mille-Feuille", "8$", "This elegant pastry features layers of crisp puff pastry.", R.drawable.coffee_caramel_mille_feuille));
        allDessertList.add(new Dessert("Chocolate Mocha Eclair", "10$", "The Chocolate Mocha Éclair. Sweet.", R.drawable.choco_eclaire_one));
        allDessertList.add(new Dessert("Raspberry Negroni", "4$", "The Raspberry Negroni is a twist on the classic cocktail.", R.drawable.raspberry_negroni));
        allDessertList.add(new Dessert("Strawberry Soda", "3.30$", "A refreshing and fizzy drink.", R.drawable.strawberry_soda));
        allDessertList.add(new Dessert("Triple Chocolate Cake", "5$", "Our Triple Chocolate Cake is a decadent treat for chocolate lovers.", R.drawable.triple_chocolate_cake));
        allDessertList.add(new Dessert("Undu Walalu", "7$", "Undu Walalu is a traditional Sri Lankan sweet.", R.drawable.undu_walalu));
        allDessertList.add(new Dessert("White Hot Chocolate", "2$", "Indulge in our creamy White Hot Chocolate", R.drawable.white_hot_chocolate));
        allDessertList.add(new Dessert("White Strawberry Brownie", "8$", "A soft and indulgent brownie.", R.drawable.white_strawberry_brownie));
        return allDessertList;

    }
}
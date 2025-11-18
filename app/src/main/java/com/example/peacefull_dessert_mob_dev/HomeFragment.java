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
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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
        RecyclerView dessert_list_card_input = view.findViewById(R.id.recycler_view_cards);

        ArrayList<Dessert> dessertList = new ArrayList<>();
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

        DessertCardAdapter adapter = new DessertCardAdapter(requireContext(), dessertList);
        dessert_list_card_input.setAdapter(adapter);

        int numberOfColumns = 2;

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), numberOfColumns);
        dessert_list_card_input.setLayoutManager(gridLayoutManager);


    }




}
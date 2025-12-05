package com.example.peacefull_dessert_mob_dev;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AccountFragment extends Fragment {
TextView name, email;
Button info, orders, back;

    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container, false);

        back = view.findViewById(R.id.buttonBack);
        info = view.findViewById(R.id.buttonInformation);
        orders = view.findViewById(R.id.buttonOrders);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(), "Feature still under development", Toast.LENGTH_SHORT).show();
            }
        });

        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(), "Feature still under development", Toast.LENGTH_SHORT).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getContext(), HomeActivity.class);
                startActivity(intent1);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}
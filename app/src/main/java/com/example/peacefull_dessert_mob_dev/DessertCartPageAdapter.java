package com.example.peacefull_dessert_mob_dev;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class DessertCartPageAdapter extends RecyclerView.Adapter<DessertCartPageAdapter.ViewHolder> {
    private final Context context;
    private final List<Dessert> dessertList;

    private final Map<String, DessertData> dessertDataMap;

    public DessertCartPageAdapter(Context context, List<Dessert> dessertList) {
        this.context = context;
        this.dessertList = dessertList;
        this.dessertDataMap = DessertDataLoader.loadDesserts(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DessertCartPageAdapter.ViewHolder holder, int position) {
        Dessert dessert = dessertList.get(position);
        holder.more_info.setText(dessert.getName());
        holder.dessert_name.setText(dessert.getName());
        holder.dessert_price.setText(dessert.getPrice());
        holder.brief_description.setText(dessert.getBriefDescription());
        holder.more_info.setText("More Info");
        holder.purchase.setText("Purchase");
        holder.more_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DessertData dessertData = dessertDataMap.get(dessert.getName());
                if (dessertData == null) {
                    Toast.makeText(context, "The dessert" + dessert.getName() + " not found", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(context, DessertPageFragment.class);
                intent.putExtra("image", dessertData.getImage());
                intent.putExtra("dessert_name", dessertData.getName());
                intent.putExtra("price", dessertData.getPrice());
                intent.putExtra("quantity", dessertData.getQuantity());
                intent.putExtra("description", dessertData.getDescription());
                intent.putExtra("rate", dessertData.getRate());
                context.startActivity(intent);
                Toast.makeText(context, "The dessert" + dessert.getName() + " clicked", Toast.LENGTH_SHORT).show();
            }

        });
        holder.purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "The dessert" + dessert.getName() + " purchased", Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public int getItemCount() {
        return dessertList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button more_info, purchase;
        ImageView dessert_image;
        TextView dessert_name, dessert_price, brief_description;

        public ViewHolder(View itemView) {
            super(itemView);
            more_info = itemView.findViewById(R.id.button);
            purchase = itemView.findViewById(R.id.button2);
            dessert_image = itemView.findViewById(R.id.imageView2);
            dessert_name = itemView.findViewById(R.id.textView2);
            dessert_price = itemView.findViewById(R.id.textView4);
            brief_description = itemView.findViewById(R.id.textView3);

        }
    }
}

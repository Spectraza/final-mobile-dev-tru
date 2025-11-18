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

public class DessertCardAdapter extends RecyclerView.Adapter<DessertCardAdapter.ViewHolder> {


    private final Context context;
    private final List<Dessert> dessertList;

    private final Map<String, DessertData> dessertDataMap;

    public DessertCardAdapter(Context context, List<Dessert> dessertList) {
        this.context = context;
        this.dessertList = dessertList;
        this.dessertDataMap = DessertDataLoader.loadDesserts(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DessertCardAdapter.ViewHolder holder, int position) {
        Dessert dessert = dessertList.get(position);
        holder.more_info.setText("More Information");
        holder.add_to_cart.setText("Add to Cart");
        holder.dessert_name.setText(dessert.getName());
        holder.dessert_price.setText(dessert.getPrice());
        holder.brief_description.setText(dessert.getBriefDescription());
        holder.dessert_image.setImageResource(dessert.getImageResourceId());
        holder.more_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DessertData dessertData = dessertDataMap.get(dessert.getName());
                if (dessertData == null) {
                    Toast.makeText(context, "The dessert" + dessert.getName() + " not found", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(context, SinglePageDessert.class);
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
    }
        @Override
        public int getItemCount () {
            return dessertList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            Button more_info, add_to_cart;
            ImageView dessert_image;
            TextView dessert_name, dessert_price, brief_description;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                more_info = itemView.findViewById(R.id.button5);
                add_to_cart = itemView.findViewById(R.id.button6);
                dessert_image = itemView.findViewById(R.id.imageView);
                dessert_name = itemView.findViewById(R.id.textView6);
                dessert_price = itemView.findViewById(R.id.textView11);
                brief_description = itemView.findViewById(R.id.textView10);
            }
        }
    }

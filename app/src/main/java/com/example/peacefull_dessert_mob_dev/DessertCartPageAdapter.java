package com.example.peacefull_dessert_mob_dev;

import android.annotation.SuppressLint;
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

/**
 * Cart recycler view adapter class for displaying dessert added to customers cart
 * for checkout
 *
 * @author Valeriia Savych
 * @documenter Rion Miyazaki
 * @since 2025
 */
public class DessertCartPageAdapter extends RecyclerView.Adapter<DessertCartPageAdapter.ViewHolder> {
    private final Context context;
    private final List<Dessert> dessertList;

    private final Map<String, DessertData> dessertDataMap;

    private CartUpdateListener cartUpdateListener;



    public DessertCartPageAdapter(Context context, List<Dessert> dessertList) {
        this.context = context;
        this.dessertList = dessertList;
        this.dessertDataMap = DessertDataLoader.loadDesserts(context);
    }

    public void setCartUpdateListener(CartUpdateListener listener) {
        this.cartUpdateListener = listener;
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
        holder.dessert_name.setText(dessert.getName());
        holder.dessert_price.setText(dessert.getPrice());
        holder.brief_description.setText(dessert.getBriefDescription());
        holder.more_info.setText("More");
        holder.purchase.setText("Buy");
        holder.remove.setText("Delete");
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = holder.getAdapterPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {
                    Dessert dessertRemove = dessertList.get(currentPosition);
                    String dessertName = dessertRemove.getName();
                    CartManager cartManager = CartManager.getInstance(context);
                    cartManager.removeItemFromCart(dessertName);
                    dessertList.remove(currentPosition);
                    notifyItemRemoved(currentPosition);

                    if(dessertList.isEmpty() && cartUpdateListener != null){
                        cartUpdateListener.onCartUpdated();
                    }

                    Toast.makeText(context, "The dessert" + dessert.getName() + " removed", Toast.LENGTH_SHORT).show();
                }
            }


        });
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
        holder.purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = holder.getAdapterPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {
                    Dessert dessertRemove = dessertList.get(currentPosition);
                    String dessertName = dessertRemove.getName();
                    CartManager cartManager = CartManager.getInstance(context);
                    cartManager.removeItemFromCart(dessertName);
                    dessertList.remove(currentPosition);
                    notifyItemRemoved(currentPosition);

                    if(dessertList.isEmpty() && cartUpdateListener != null){
                        cartUpdateListener.onCartUpdated();
                    }

                    Toast.makeText(context, "The dessert" + dessert.getName() + " purchased", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return dessertList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button more_info, purchase, remove;
        ImageView dessert_image;
        TextView dessert_name, dessert_price, brief_description;

        public ViewHolder(View itemView) {
            super(itemView);
            more_info = itemView.findViewById(R.id.button);
            purchase = itemView.findViewById(R.id.button2);
            dessert_image = itemView.findViewById(R.id.imageView2);
            dessert_name = itemView.findViewById(R.id.textView2);
            dessert_price = itemView.findViewById(R.id.price);
            brief_description = itemView.findViewById(R.id.textView3);
            remove = itemView.findViewById(R.id.buttonDelete);

        }
    }


    public void updateCart(List<Dessert> newDessertList) {
        dessertList.clear();
        dessertList.addAll(newDessertList);
        notifyDataSetChanged();
    }
}

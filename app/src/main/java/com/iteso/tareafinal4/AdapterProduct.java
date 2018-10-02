package com.iteso.tareafinal4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iteso.tareafinal4.beans.ItemProduct;

import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder>{
    private ArrayList<ItemProduct> products;
    private Context context;

    public AdapterProduct(Context context, ArrayList<ItemProduct> products){
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        private TextView title;
        private TextView store;
        private TextView location;
        private TextView phone;
        private CardView card;
        public ViewHolder(View v){
            super(v);
            image = v.findViewById(R.id.item_product_image);
            title = v.findViewById(R.id.item_product_title);
            store = v.findViewById(R.id.item_product_store);
            location = v.findViewById(R.id.item_product_location);
            phone = v.findViewById(R.id.item_product_phone);
            card = v.findViewById(R.id.card_view);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.title.setText(products.get(position).getTitle());
        switch (products.get(position).getImage()){
            case 0:
                holder.image.setImageResource(R.drawable.mac);
                break;
            case 1:
                holder.image.setImageResource(R.drawable.alienware);
                break;

        }
        holder.store.setText(products.get(position).getStore());
        holder.location.setText(products.get(position).getLocation());
        holder.phone.setText(products.get(position).getPhone());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ActivityProduct.class);
                intent.putExtra("PRODUCTO",products.get(position));
                ((Activity) context).startActivityForResult(intent,1);
            }
        });
        holder.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ holder.phone.getText().toString()));
                context.startActivity(call);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}

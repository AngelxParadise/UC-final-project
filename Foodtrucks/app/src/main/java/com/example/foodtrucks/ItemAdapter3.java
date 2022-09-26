package com.example.foodtrucks;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemAdapter3 extends RecyclerView.Adapter {

    ArrayList<foodtrucks> foodtruckslist = new ArrayList<>();
    Context context;

    public ItemAdapter3(ArrayList<foodtrucks> foodtruckslist, Context context) {
        this.foodtruckslist = foodtruckslist;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foodtruck_list2, parent, false);
        ItemAdapter3.ViewHolder vh = new ItemAdapter3.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ((ItemAdapter3.ViewHolder)holder).textfoodtruckname.setText(foodtruckslist.get(position).getFoodtruckName());
        ((ItemAdapter3.ViewHolder)holder).textfoodtruckinstagram.setText(foodtruckslist.get(position).getFoodtruckInstagram());
        ((ItemAdapter3.ViewHolder)holder).textfoodtrucklocation.setText(foodtruckslist.get(position).getFoodtruckLocation());

        Picasso.with(context).load(foodtruckslist.get(position).getFoodtruckImg()).into(((ItemAdapter3.ViewHolder)holder).img);

        ((ItemAdapter3.ViewHolder)holder).v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity1.class);
                intent.putExtra("foodtrucks", foodtruckslist.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodtruckslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView textfoodtruckname, textfoodtrucklocation, textfoodtruckinstagram;
        View v;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            img = v.findViewById(R.id.imageViewcuisines);
            textfoodtruckname = v.findViewById(R.id.textViewnametruck2);
            textfoodtruckinstagram = v.findViewById(R.id.textViewsocial2);
            textfoodtrucklocation = v.findViewById(R.id.textViewLocation2);
        }
    }

}
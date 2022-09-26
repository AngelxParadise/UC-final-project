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

public class ItemAdapter2 extends RecyclerView.Adapter {

    ArrayList<cuisines> cuisineslist = new ArrayList<>();
    Context context;

    public ItemAdapter2(ArrayList<cuisines> cuisineslist, Context context) {
        this.cuisineslist = cuisineslist;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cuisines_list, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ((ViewHolder)holder).cuisinetype.setText(cuisineslist.get(position).getCuisineType());

        Picasso.with(context).load(cuisineslist.get(position).getCuisineImg()).into(((ItemAdapter2.ViewHolder)holder).cuisineimg);

        ((ItemAdapter2.ViewHolder)holder).v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity2.class);
                intent.putExtra("cuisinetype", cuisineslist.get(position).getCuisineType());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cuisineslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView cuisineimg;
        TextView cuisinetype;
        View v;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            cuisineimg = v.findViewById(R.id.imageViewcuisines);
            cuisinetype = v.findViewById(R.id.textViewcuisines);
     }
    }

}

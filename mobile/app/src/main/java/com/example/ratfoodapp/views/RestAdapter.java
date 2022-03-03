package com.example.ratfoodapp.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ratfoodapp.R;
import com.example.ratfoodapp.models.Restaurants;

import java.util.HashMap;
import java.util.List;

public class RestAdapter extends RecyclerView.Adapter<RestAdapter.RestHolder> {


    private Context context;
    private List<Restaurants> restaurantsList;

    public RestAdapter(Context context , List<Restaurants> restaurant){
        this.context = context;
        restaurantsList = restaurant;
    }

    @NonNull
    @Override
    public RestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item , parent , false);
        return new RestHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestHolder holder, int position) {

        Restaurants restaurants = restaurantsList.get(position);
        HashMap<String, String> data = restaurants.getRestaurant();
        holder.rating.setText(data.get("grade"));
        holder.title.setText(data.get("name"));
        holder.overview.setText(data.get("description"));
        Glide.with(context).load("https://cdn.discordapp.com/attachments/472313197836107780/670902106131136512/tqOmA0E.png").into(holder.imageView);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , DetailsActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("title" , data.get("name"));
                bundle.putString("overview" , data.get("description"));
                bundle.putString("poster" , "https://cdn.discordapp.com/attachments/472313197836107780/670902106131136512/tqOmA0E.png");
                bundle.putString("rating" , data.get("grade"));

                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return restaurantsList.size();
    }

    public class RestHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title , overview , rating;
        ConstraintLayout constraintLayout;

        public RestHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview);
            title = itemView.findViewById(R.id.title_tv);
            overview = itemView.findViewById(R.id.overview_tv);
            rating = itemView.findViewById(R.id.rating);
            constraintLayout = itemView.findViewById(R.id.main_layout);
        }
    }
}

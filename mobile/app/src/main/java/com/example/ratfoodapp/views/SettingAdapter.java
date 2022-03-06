package com.example.ratfoodapp.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.RestHolder>{

    private Context context;
    private List<Restaurants> restaurantsList;


    public SettingAdapter(Context context , List<Restaurants> restaurant){
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
        holder.title.setText(data.get("name"));

        holder.change_btn.setOnClickListener(view -> {
            Bundle bundle = new Bundle();

            Intent intent = new Intent(context, ChangeRestActivity.class);

            bundle.putString("_id", data.get("_id"));
            bundle.putString("title" , data.get("name"));
            bundle.putString("overview" , data.get("description"));
            bundle.putString("poster" , data.get("image"));
            bundle.putString("rating" , data.get("grade"));
            bundle.putString("hours", data.get("hour"));
            bundle.putString("phone_number", data.get("phone_number"));
            bundle.putString("website", data.get("website"));
            bundle.putString("localisation", data.get("localisation"));

            intent.putExtras(bundle);

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return restaurantsList.size();
    }

    public class RestHolder extends RecyclerView.ViewHolder{

        Button change_btn;
        TextView title;

        public RestHolder(@NonNull View itemView) {
            super(itemView);

            change_btn = itemView.findViewById(R.id.button_create);
            title = itemView.findViewById(R.id.title_rest);
        }
    }
}

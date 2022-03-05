package com.example.ratfoodapp.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.ratfoodapp.R;
import com.example.ratfoodapp.models.Menus;
import com.example.ratfoodapp.models.Restaurants;

import java.lang.invoke.ConstantCallSite;
import java.util.HashMap;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuHolder> {

    private Context context;
    private List<Menus> menusList;

    public MenuAdapter(Context context , List<Menus> menu){
        this.context = context;
        menusList = menu;
    }

    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false);
        return new MenuHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolder holder, int position) {
        Menus menu = menusList.get(position);
        HashMap<String, String> data = menu.getMenus();
        holder.name.setText(data.get("name"));
        holder.price.setText(data.get("price"));
        holder.description.setText(data.get("description"));
    }


    @Override
    public int getItemCount() {return menusList.size();}


    public class MenuHolder extends RecyclerView.ViewHolder{

        TextView name, description, price;
        ConstraintLayout constraintLayout;

        public MenuHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.title_menu);
            description = itemView.findViewById(R.id.overview_menu);
            price = itemView.findViewById(R.id.price);
            constraintLayout = itemView.findViewById(R.id.menu_layout);
        }
    }
}

package com.example.ratfoodapp.views;

import android.content.Intent;
import android.os.Bundle;

import com.example.ratfoodapp.api.ApiBuilder;
import com.example.ratfoodapp.api.RestaurantsApi;
import com.example.ratfoodapp.api.UsersApi;
import com.example.ratfoodapp.models.Restaurants;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import com.example.ratfoodapp.R;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddRestActivity extends AppCompatActivity {
    EditText input_name, input_description, input_grade, input_localisation, input_phone_number,
            input_website, input_hours, input_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rest);

        setInput();

        String test[] = getInput();
        Button btn_create = findViewById(R.id.create_btn);
        btn_create.setOnClickListener(view -> {
           checkCreate(getInput());
        });
    }

    private void setInput() {
        input_name = findViewById(R.id.input_name);
        input_description = findViewById(R.id.input_description);
        input_grade = findViewById(R.id.input_grade);
        input_localisation = findViewById(R.id.input_localization);
        input_website = findViewById(R.id.input_website);
        input_hours = findViewById(R.id.input_hours);
        input_phone = findViewById(R.id.input_phone_number);
    }

    private String[] getInput(){
        String name = input_name.getText().toString();
        String description = input_description.getText().toString();
        String grade = input_grade.getText().toString();
        String localisation = input_localisation.getText().toString();
        String website = input_website.getText().toString();
        String hours = input_hours.getText().toString();
        String phone = input_phone.getText().toString();
        String arr[] = {name, description, grade, localisation, website,
        hours, phone};
        return arr;
    }

    private void checkCreate(String inputs[]) {
        if (inputs[2].equals("")){
            Toast.makeText(getApplicationContext(), "FAIL", Toast.LENGTH_SHORT).show();
        }
        else {
            Call<ResponseBody> call = ApiBuilder.builderAPI().create(RestaurantsApi.class)
                    .createRest(inputs[0], inputs[1], Float.parseFloat(inputs[2]),
                            inputs[3], inputs[4], inputs[5], inputs[6]);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        try {
                            String result = response.body().string();
                            Toast.makeText(getApplicationContext(), "" + result, Toast.LENGTH_SHORT).show();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "FAIL" + t, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }




}
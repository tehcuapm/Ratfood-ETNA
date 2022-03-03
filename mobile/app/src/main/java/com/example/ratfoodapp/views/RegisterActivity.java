package com.example.ratfoodapp.views;

import android.content.Intent;
import android.os.Bundle;

import com.example.ratfoodapp.R;
import com.example.ratfoodapp.api.ApiBuilder;
import com.example.ratfoodapp.api.UsersApi;
import com.example.ratfoodapp.models.Users;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ratfoodapp.databinding.ActivityRegisterBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityRegisterBinding binding;
    private String user;
    EditText input_username, input_firstname, input_lastname, input_age, input_email,
    input_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ////this.user = LoginActivity.getInstance().giveUser();
        setContentView(R.layout.activity_register);

        setElements();
        setInput();
        ///
        // Toast.makeText(getApplicationContext(), "" + this.user.toString(), Toast.LENGTH_SHORT).show();
    }


    private void checkRegister(String inputs[]) {
        Toast.makeText(this, inputs[0], Toast.LENGTH_SHORT).show();
        if(inputs[4].equals("")){
            Toast.makeText(getApplicationContext(), "FAIL", Toast.LENGTH_SHORT).show();
        }
        else{
            Call<ResponseBody> call = ApiBuilder.builderAPI().create(UsersApi.class)
                    .createUser(inputs[0], inputs[1], inputs[2], inputs[3], Integer.parseInt(inputs[4]),
                            inputs[5]);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    if(response.isSuccessful()) {
                        try {
                            String result = response.body().string();
                            Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();

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

    private void setElements() {
        Button btn_register = findViewById(R.id.register_btn);
        Button btn_rest = findViewById(R.id.btn_restaurant);
        Button btn_prof = findViewById(R.id.btn_profil);


        btn_rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, RestaurantsActivity.class));
            }
        });

        btn_prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, Profil.class));
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] inputs = getInput();
                checkRegister(inputs);
            }
        });
    }

    private void setInput() {
        input_username = findViewById(R.id.input_username);
        input_firstname = findViewById(R.id.input_firstname);
        input_lastname = findViewById(R.id.input_lastname);
        input_email = findViewById(R.id.input_email);
        input_age = findViewById(R.id.input_age);
        input_password = findViewById(R.id.input_password);

    }

    private String[] getInput(){
        String username = input_username.getText().toString();
        String firstname = input_firstname.getText().toString();
        String lastname = input_lastname.getText().toString();
        String email = input_email.getText().toString();
        String age = input_age.getText().toString();
        String password = input_password.getText().toString();
        String arr[] = {username, firstname, lastname, email, age, password};
        return arr;
    }

}
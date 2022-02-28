package com.example.ratfoodapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ratfoodapp.R;
import com.example.ratfoodapp.api.ApiBuilder;
import com.example.ratfoodapp.api.UsersApi;
import com.example.ratfoodapp.models.Users;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText input_username, input_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        input_username = (EditText) findViewById(R.id.input_username);
        input_password = (EditText) findViewById(R.id.input_password);
        btn_login = (Button) findViewById(R.id.login_btn);
        Button btn_register = (Button) findViewById(R.id.signup_btn);
        
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {  ////Button click event
            @Override
            public void onClick(View v) {
                LoginCheck(input_username.getText().toString(),input_password.getText().toString());
            }
        });

        Button btn_rest = (Button) findViewById(R.id.btn_restaurant);
        btn_rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RestaurantsActivity.class));
            }
        });

        Button btn_prof = (Button) findViewById(R.id.btn_profil);
        btn_prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, Profil.class));
            }
        });

    }

    public void LoginCheck(final String username, final String password) {

        Call<ResponseBody> call = ApiBuilder.builderAPI().create(UsersApi.class).loginUser(username, password);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()) {
                    try {
                        String result = response.body().string();
                        JSONObject obj = new JSONObject(result);
                        String getstatus = obj.getString("user");
                        createUser(obj);
                        Toast.makeText(getApplicationContext(), getstatus, Toast.LENGTH_LONG).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + t, Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void createUser(JSONObject obj){
        try{
            String username = obj.getString("username");
            String name = obj.getString("name");
            String firstname = obj.getString("firstname");
            String _id = obj.getString("_id");
            int age = obj.getInt("age");


        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
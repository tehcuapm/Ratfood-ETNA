package com.example.ratfoodapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    private static volatile LoginActivity instance = null;
    EditText input_username, input_password;
    Button btn_login;
    public Users user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.instance = instance;
        setContentView(R.layout.activity_login);
        setElements();

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
                        user = createUser(getstatus);

                        Toast.makeText(getApplicationContext(), ""+user.getUsername(), Toast.LENGTH_SHORT).show();
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
    private void setElements() {
        input_username = findViewById(R.id.input_username);
        input_password = findViewById(R.id.input_password);
        btn_login = findViewById(R.id.login_btn);
        Button btn_register = findViewById(R.id.signup_btn);
        Button btn_rest = findViewById(R.id.btn_restaurant);
        Button btn_prof = findViewById(R.id.btn_profil);

        btn_rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RestaurantsActivity.class));
            }
        });

        btn_prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, Profil.class));
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginCheck(input_username.getText().toString(), input_password.getText().toString());
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

        public Users createUser(String object){
        try{
            JSONObject obj = new JSONObject(object);
            String username = obj.getString("username");
            String name = obj.getString("name");
            String firstname = obj.getString("firstname");
            String _id = obj.getString("_id");
            int age = obj.getInt("age");

            return new Users(_id, age, username, firstname, name);

        } catch (Exception e){
            e.printStackTrace();
            return user;
        }

    }
    public static LoginActivity getInstance(){
        return instance;
    }
    public String giveUser(){
        return user.getUsername();
    }

}
package com.example.ratfoodapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ratfoodapp.R;
import com.example.ratfoodapp.api.ApiBuilder;
import com.example.ratfoodapp.api.UsersApi;

import org.json.JSONObject;

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

        btn_login.setOnClickListener(new View.OnClickListener() {  ////Button click event
            @Override
            public void onClick(View v) {

                LoginCheck(input_username.getText().toString(),input_password.getText().toString());
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
                        String getstatus = obj.getString("status");


                        if (getstatus.equals("false")) {
                            String error = obj.getString("error");
                            Toast.makeText(getApplicationContext(), "" + error, Toast.LENGTH_LONG).show();
                        } else if (getstatus.equals("true")) {
                            String getUsername = obj.getString("username");
                            Toast.makeText(getApplicationContext(), getUsername, Toast.LENGTH_LONG).show();
                        }
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
}
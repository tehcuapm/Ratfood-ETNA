package com.example.ratfoodapp.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ratfoodapp.R;
import com.example.ratfoodapp.api.ApiBuilder;
import com.example.ratfoodapp.api.UsersApi;

import org.json.JSONObject;

import java.sql.CallableStatement;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginFragment extends Fragment {
    EditText input_username, input_password;
    Button btn_login;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_login,
                container, false);
        setElements(view);

        // Inflate the layout for this fragment
        return view;
    }
    private void setElements(View view){
        input_username = (EditText) view.findViewById(R.id.input_username);
        input_password = (EditText) view.findViewById(R.id.input_password);
        btn_login = (Button) view.findViewById(R.id.login_btn);
        Button btn_register = (Button) view.findViewById(R.id.signup_btn);

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
                        String getstatus = obj.getString("user");
                        createUser(obj);
                        Toast.makeText(getActivity(), getstatus, Toast.LENGTH_LONG).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(getActivity(), "fail", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "" + t, Toast.LENGTH_SHORT).show();

            }
        });
    }
        private void createUser(JSONObject obj)
        {
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
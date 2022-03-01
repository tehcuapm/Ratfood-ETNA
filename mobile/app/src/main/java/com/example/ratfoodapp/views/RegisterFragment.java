package com.example.ratfoodapp.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.ratfoodapp.R;


public class RegisterFragment extends Fragment {
    EditText input_username, input_password,input_lastname,input_firstname,input_email;
    Button btn_register;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    private void setElements(View view){
        input_username = (EditText) view.findViewById(R.id.input_username);
        input_password = (EditText) view.findViewById(R.id.input_password);
        input_firstname = (EditText) view.findViewById(R.id.input_firstname);
        input_lastname = (EditText) view.findViewById(R.id.input_lastname);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
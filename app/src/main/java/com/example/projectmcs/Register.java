package com.example.projectmcs;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Register  extends AppCompatActivity {

    EditText email;
    EditText password;
    EditText confirm;
    EditText name;
    EditText phoneNumber;
    Button registerButton, GotoLoginButton;

    static ArrayList<User> datauser = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirm = findViewById(R.id.confirm);
        name = findViewById(R.id.name);
        phoneNumber = findViewById(R.id.phoneNumber);

        registerButton = findViewById(R.id.registerButton);
        GotoLoginButton = findViewById(R.id.GotoLoginButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTxt = name.getText().toString();
                String emailTxt = email.getText().toString();
                String passwordTxt = password.getText().toString();
                String phoneNumberTxt = phoneNumber.getText().toString();
                String confirmTxt = confirm.getText().toString();
                String validate = "[a-zA-Z0-9._-]+.com";

                if(nameTxt.isEmpty() || emailTxt.isEmpty() || passwordTxt.isEmpty() || phoneNumberTxt.isEmpty() || confirmTxt .isEmpty()){
                    Toast.makeText(Register.this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
                }
                if (!passwordTxt.equals(confirmTxt)) {
                    Toast.makeText(Register.this, "Passwords are not matching", Toast.LENGTH_SHORT).show();
                }
                if (nameTxt.length() < 5) {
                    Toast.makeText(Register.this, "Name must be at least (at least 5 characters)", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!emailTxt.matches(validate)){
                    Toast.makeText(Register.this, "Email must end with .com", Toast.LENGTH_SHORT).show();
                }
            }
        });
        GotoLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Login.class));
            }
        });
    }
}
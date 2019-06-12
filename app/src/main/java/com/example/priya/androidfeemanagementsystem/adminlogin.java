package com.example.priya.androidfeemanagementsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class adminlogin extends AppCompatActivity {

    Button login;
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        login = findViewById(R.id.buttonlogin);
        username= findViewById(R.id.editTextusername);
        password= findViewById(R.id.editTextpassword);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String user_name = username.getText().toString();
                String pass_word = password.getText().toString();

                if (TextUtils.isEmpty(user_name))
                {
                    username.setError("Invalid User Name");
                }
                else if(TextUtils.isEmpty(pass_word))
                {
                    password.setError("enter password");
                }
                else
                {
                    if(user_name.equals("admin") & pass_word.equals("admin123")){
                        Intent intent =new Intent(adminlogin.this,adminmenu.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}

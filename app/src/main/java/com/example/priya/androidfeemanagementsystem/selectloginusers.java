package com.example.priya.androidfeemanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectloginusers extends AppCompatActivity {

    Button admin;
    Button accountant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectloginusers);
        admin= findViewById(R.id.buttonAdmin);
        accountant= findViewById(R.id.buttonAccountant);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(selectloginusers.this,adminlogin.class);
                startActivity(intent);

            }
        });
        accountant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(selectloginusers.this,accountantlogin.class);
                startActivity(intent);
            }
        });

    }
}

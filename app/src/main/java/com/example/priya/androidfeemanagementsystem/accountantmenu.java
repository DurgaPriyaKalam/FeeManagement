package com.example.priya.androidfeemanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class accountantmenu extends AppCompatActivity {
    Button btnaddstudent,btnviewastudent,btnlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountantmenu);
        btnaddstudent =(Button)findViewById(R.id.buttonAddStudent);
        btnviewastudent =(Button)findViewById(R.id.buttonViewStudent);
        btnlogout =(Button)findViewById(R.id.buttonlogout);
        btnlogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(accountantmenu.this,adminlogin.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}

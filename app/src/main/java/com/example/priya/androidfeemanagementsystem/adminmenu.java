package com.example.priya.androidfeemanagementsystem;

import android.support.v7.app.AppCompatActivity;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminmenu extends AppCompatActivity {

    Button btnaddaccountant,btnviewaccountant,btnlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminmenu);
        btnaddaccountant =(Button)findViewById(R.id.buttonAddAccountant);
        btnviewaccountant =(Button)findViewById(R.id.buttonViewAccountant);
        btnlogout =(Button)findViewById(R.id.buttonlogout);

        btnaddaccountant.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                startActivity(new Intent(getApplicationContext(), addaccountant.class));
            }
        });
        btnviewaccountant.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnlogout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(adminmenu.this,adminlogin.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}

package com.example.priya.androidfeemanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class accountantlogin extends AppCompatActivity {

    EditText user, pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountantlogin);

        user = findViewById(R.id.editTextEmail);
        pass = findViewById(R.id.editTextpassword);
        login = findViewById(R.id.buttonlogin);

        login.setOnClickListener(new View.OnClickListener() {

           DatabaseHandler db=new DatabaseHandler( accountantlogin.this, null, null, 2);
            public void onClick(View v) {
                String user_name = user.getText().toString();
                String pass_word = pass.getText().toString();
                if (TextUtils.isEmpty(user_name))
                {
                    user.setError("Invalid User Name");
                }
                else if(TextUtils.isEmpty(pass_word))
                {
                    pass.setError("enter password");
                }

                Registerdata reg=db.validateAccountant(user_name,pass_word);
                if(reg!=null)
                {
                    Intent intent =new Intent(accountantlogin.this,accountantmenu.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}


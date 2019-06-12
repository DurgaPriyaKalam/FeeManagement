package com.example.priya.androidfeemanagementsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class addaccountant extends AppCompatActivity {

    EditText name, pass, confpass,mobile,email;
    Button submit, clear;
    private AwesomeValidation awesomeValidation;
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addaccountant);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        name= (EditText)findViewById(R.id.editTextName);
        email=(EditText)findViewById(R.id.editTextemail);
        mobile =(EditText)findViewById(R.id.editTextPhone);
        pass=(EditText)findViewById(R.id.editTextPassword);
        confpass=(EditText)findViewById(R.id.editTextConfirmPassword);

        submit=(Button)findViewById(R.id.RegisterButton);
        clear=(Button)findViewById(R.id.Clear_Button);

        awesomeValidation.addValidation(this, R.id.editTextName, "^[a-zA-Z0-9]{3,15}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.editTextPassword, "^.*(?=.{4,10})(?=.*\\d)(?=.*[a-zA-Z]).*$", R.string.passworderror);
        awesomeValidation.addValidation(this, R.id.editTextemail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.editTextPhone, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);

        submit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                String edname = name.getText().toString();
                String edemail = email.getText().toString();
                String edmobile = mobile.getText().toString();
                String edpass = pass.getText().toString();
                String edConf = confpass.getText().toString();

                if(edConf.equals(edpass) ) {


                    db = new DatabaseHandler(addaccountant.this, null, null, 2);
                    Registerdata reg = new Registerdata();

                    reg.setName(edname);
                    reg.setEmailId(edemail);
                    reg.setMobNo(edmobile);
                    reg.setPassword(edpass);
                    db.addregister(reg);
                    if (awesomeValidation.validate()) {
                        Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), adminmenu.class));
                    }
                }
                else{

                    Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_LONG).show();
                    pass.setText("");
                    confpass.setText("");
                }
            }
        });
        clear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                pass.setText("");
                confpass.setText("");
                mobile.setText("");
                email.setText("");

                }
        });
    }
}

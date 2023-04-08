package com.example.foodchap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class chefcheckphone extends AppCompatActivity {
    EditText num;
    Button sendotp,signinemail;
    TextView signup;

    FirebaseAuth Fauth;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chefcheckphone);
        num = (EditText)findViewById(R.id.ddnumber);
        sendotp = (Button)findViewById(R.id.ddotp);

        signinemail=(Button)findViewById(R.id.btnddEmail);
        signup = (TextView)findViewById(R.id.ddsignup);

        Fauth = FirebaseAuth.getInstance();

        sendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number=num.getText().toString().trim();
                String Phonenumber =number;
                Intent b = new Intent(chefcheckphone.this,Chefsendotp.class);

                b.putExtra("Phonenumber",Phonenumber);
                startActivity(b);
                finish();

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chefcheckphone.this,chefRegister.class));
                finish();
            }
        });
        signinemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chefcheckphone.this,cheflogin.class));
                finish();
            }
        });

    }
    }

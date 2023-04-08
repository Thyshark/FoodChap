package com.example.foodchap;


import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class choose extends AppCompatActivity {
    Button btnchoose1, btnchoose2, btnchoose3;
    Intent intent;
    String type;
    ConstraintLayout back3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.tittle_img), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.fast_1), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img15), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img3), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img11), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img12), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img13), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img14), 3000);

        animationDrawable.setOneShot(false);
        animationDrawable.setEnterFadeDuration(850);
        animationDrawable.setExitFadeDuration(1600);

        back3 = findViewById(R.id.back3);
        back3.setBackgroundDrawable(animationDrawable);

        intent = getIntent();
        type = intent.getStringExtra("Home").toString().trim();

        btnchoose1 = (Button) findViewById(R.id.btnchoose1);
        btnchoose2 = (Button)findViewById(R.id.btnchoose2);
        btnchoose3 = (Button) findViewById(R.id.btnchoose3);

        btnchoose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type.equals("Email")) {
                    Intent loginemail = new Intent(choose.this, cheflogin.class);
                    startActivity(loginemail);
                    finish();
                }
                if (type.equals("phone")) {
                    Intent loginphone = new Intent(choose.this, chefverify.class);
                    startActivity(loginphone);
                    finish();
                }
                if (type.equals("signup")) {
                    Intent Register = new Intent(choose.this, chefRegister.class);
                    startActivity(Register);
                    // finish();
                }
            }
        });
        btnchoose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type.equals("Email")) {
                    Intent emailcustomer = new Intent(choose.this, loginCustomer.class);
                    startActivity(emailcustomer);
                    finish();
                }
                if (type.equals("phone")) {
                    Intent customerphone = new Intent(choose.this, loginverify.class);
                    startActivity(customerphone);
                    finish();
                }
                if (type.equals("signup")) {
                    Intent Registerc = new Intent(choose.this, Registercustomer.class);
                    startActivity(Registerc);
                    // finish();

                }
            }
        });

        btnchoose3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type.equals("Email")) {
                    Intent emailDel = new Intent(choose.this, login_Del.class);
                    startActivity(emailDel);
                    finish();
                }
                if (type.equals("phone")) {
                    Intent phonedel = new Intent(choose.this, loginphone_Del.class);
                    startActivity(phonedel);
                    finish();
                }
                if (type.equals("signup")) {
                    Intent Registerdel = new Intent(choose.this, Register_Del.class);
                    startActivity(Registerdel);
                    // finish();
                }
            }
        });


    }
}
package com.example.foodchap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainMenu extends AppCompatActivity {
    Button email, phone,signup;
    ImageView img3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        final Animation zoomin= AnimationUtils.loadAnimation(this,R.anim.zoomin);
        final Animation zoomout=AnimationUtils.loadAnimation(this,R.anim.zoomout);
        img3=findViewById(R.id.back);
        img3.setAnimation(zoomin);
        img3.setAnimation(zoomout);
        zoomout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                img3.startAnimation(zoomin);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        zoomin.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                img3.startAnimation(zoomout);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        signup=findViewById(R.id.Signup);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email =new Intent(MainMenu.this,choose.class);
                email.putExtra("Home", "Email");
                startActivity(email);
                finish();

            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phone =new Intent(MainMenu.this,choose.class);
                phone.putExtra("Home", "phone");
                startActivity(phone);
                finish();

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signup =new Intent(MainMenu.this,choose.class);
                signup.putExtra("Home", "signup");
                startActivity(signup);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }
}

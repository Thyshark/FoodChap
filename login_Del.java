package com.example.foodchap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class login_Del extends AppCompatActivity {
    TextInputLayout email,pass;
    Button Signin,Signinphone;
    TextView Forgotpassword , signup;
    FirebaseAuth Fauth;
    String emailid,pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_del);

        try{

            email = (TextInputLayout)findViewById(R.id.demail);
            pass = (TextInputLayout)findViewById(R.id.dpassword);
            Signin = (Button)findViewById(R.id.btnlogin);
            signup = (TextView) findViewById(R.id.dsignphone);
            Forgotpassword = (TextView)findViewById(R.id.dforgotpass);
            Signinphone = (Button)findViewById(R.id.btnphone);

            Fauth = FirebaseAuth.getInstance();

            Signin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    emailid = email.getEditText().getText().toString().trim();
                    pwd = pass.getEditText().getText().toString().trim();

                    if(isValid()){

                        final ProgressDialog mDialog = new ProgressDialog(login_Del.this);
                        mDialog.setCanceledOnTouchOutside(false);
                        mDialog.setCancelable(false);
                        mDialog.setMessage("Sign In Please Wait.......");
                        mDialog.show();

                        Fauth.signInWithEmailAndPassword(emailid,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){
                                    mDialog.dismiss();

                                    if(Fauth.getCurrentUser().isEmailVerified()){
                                        mDialog.dismiss();
                                        Toast.makeText(login_Del.this, "Congratulation! You Have Successfully Login", Toast.LENGTH_SHORT).show();
                                        Intent Z = new Intent(login_Del.this,DeliveryFoodPanel_BottomNavigation.class);
                                        startActivity(Z);
                                        finish();

                                    }else{
                                        ReusableCodeForAll.ShowAlert(login_Del.this,"Verification Failed","You Have Not Verified Your Email");

                                    }
                                }else{
                                    mDialog.dismiss();
                                    ReusableCodeForAll.ShowAlert(login_Del.this,"Error",task.getException().getMessage());
                                }
                            }
                        });
                    }
                }
            });
            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(login_Del.this,Register_Del.class));
                    finish();
                }
            });
            Forgotpassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(login_Del.this,DeliveryForgotPassword.class));
                    finish();
                }
            });
            Signinphone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(login_Del.this,loginphone_Del.class));
                    finish();
                }
            });
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }
    String emailpattern  = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public boolean isValid(){

        email.setErrorEnabled(false);
        email.setError("");
        pass.setErrorEnabled(false);
        pass.setError("");

        boolean isvalid=false,isvalidemail=false,isvalidpassword=false;
        if(TextUtils.isEmpty(emailid)){
            email.setErrorEnabled(true);
            email.setError("Email is required");
        }else{
            if(emailid.matches(emailpattern)){
                isvalidemail=true;
            }else{
                email.setErrorEnabled(true);
                email.setError("Invalid Email Address");
            }
        }
        if(TextUtils.isEmpty(pwd)){

            pass.setErrorEnabled(true);
            pass.setError("Password is Required");
        }else{
            isvalidpassword=true;
        }
        isvalid=(isvalidemail && isvalidpassword)?true:false;
        return isvalid;
    }
    }

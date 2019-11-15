package com.breathe.breathelk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import spencerstudios.com.bungeelib.Bungee;

public class Activity_Signup extends AppCompatActivity {

    EditText txtName;
    EditText txtUserName;
    EditText txtEmail;
    EditText txtPassword;
    EditText txtConfirmPassword;
    Button btnSignUp;
    Button btnSignIn;
    TextView txtCaption;
    Animation animation1,animation2,animation3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__signup);

        animation1 = AnimationUtils.loadAnimation(this,R.anim.zoom_enter);
        animation2 = AnimationUtils.loadAnimation(this,R.anim.in_out_enter);
        animation3 = AnimationUtils.loadAnimation(this,R.anim.zoom_exit);

        btnSignIn = findViewById(R.id.btnSignIn);
        txtCaption = findViewById(R.id.txtCaption);
        txtName = findViewById(R.id.txtName);
        txtUserName = findViewById(R.id.txtUserName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        txtConfirmPassword = findViewById(R.id.txtConfirmPassword);
        btnSignUp = findViewById(R.id.btnSignUp);


        txtCaption.startAnimation(animation1);
        txtName.startAnimation(animation2);
        txtUserName.startAnimation(animation2);
        txtEmail.startAnimation(animation2);
        txtPassword.startAnimation(animation2);
        txtConfirmPassword.startAnimation(animation2);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        txtCaption.startAnimation(animation3);

        Bungee.fade(Activity_Signup.this);
    }
}

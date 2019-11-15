package com.breathe.breathelk;

import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import spencerstudios.com.bungeelib.Bungee;

public class Activity_Signin extends Activity {

    EditText txtEmail;
    EditText txtPassword;
    TextView txtForgotPassword;
    Button btnSignIn;
    Button btnSignUp;
    ActivityOptionsCompat activityOptionsCompat;
    ImageView imgLogo;
    Animation animation1,animation2,animation3,animation4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__signin);

        animation1 = AnimationUtils.loadAnimation(this,R.anim.fade_enter);
        animation2 = AnimationUtils.loadAnimation(this,R.anim.zoom_enter);
        animation3 = AnimationUtils.loadAnimation(this,R.anim.in_out_enter);
        animation4 = AnimationUtils.loadAnimation(this,R.anim.slide_up_enter);

        txtForgotPassword = findViewById(R.id.txtForgotPassword);
        imgLogo = findViewById(R.id.imgLogo);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignIn = findViewById(R.id.btnSignIn);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);

        imgLogo.startAnimation(animation1);
        txtEmail.startAnimation(animation2);
        txtPassword.startAnimation(animation2);
        txtForgotPassword.startAnimation(animation3);
        btnSignIn.startAnimation(animation4);
        btnSignUp.startAnimation(animation4);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Signin.this,Activity_MainMenu.class));
            }
        });

        txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityOptionsCompat  = ActivityOptionsCompat.makeSceneTransitionAnimation(Activity_Signin.this, Pair.create((View)imgLogo,"imgLogo"),Pair.create((View)btnSignIn,"btnTransition_1"));
                startActivity(new Intent(Activity_Signin.this,Activity_ForgotPassword.class),activityOptionsCompat.toBundle());
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(Activity_Signin.this,Pair.create((View)imgLogo,"imgLogo"),Pair.create((View)btnSignIn,"btnTransition_1"),Pair.create((View)btnSignUp,"btnTransition_2"));
                startActivity(new Intent(Activity_Signin.this,Activity_Signup.class),activityOptionsCompat.toBundle());
            }
        });
    }
}

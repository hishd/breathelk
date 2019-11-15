package com.breathe.breathelk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;

import spencerstudios.com.bungeelib.Bungee;

public class Activity_ForgotPassword extends AppCompatActivity {

    TextView txtForgotPassSteps;
    EditText txtEmail;
    Animation animation1,animation2,animation3,animation4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__forgot_password);

        animation1 = AnimationUtils.loadAnimation(this,R.anim.in_out_enter);
        animation2 = AnimationUtils.loadAnimation(this,R.anim.zoom_enter);
        animation3 = AnimationUtils.loadAnimation(this,R.anim.in_out_exit);
        animation4 = AnimationUtils.loadAnimation(this,R.anim.zoom_exit);

        txtEmail = findViewById(R.id.txtEmail);
        txtForgotPassSteps = findViewById(R.id.txtForgotPassSteps);

        txtEmail.startAnimation(animation2);
        txtForgotPassSteps.startAnimation(animation1);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        txtEmail.startAnimation(animation4);
        txtForgotPassSteps.startAnimation(animation3);
    }
}

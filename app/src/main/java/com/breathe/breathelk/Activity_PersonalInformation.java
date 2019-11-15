package com.breathe.breathelk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import spencerstudios.com.bungeelib.Bungee;

public class Activity_PersonalInformation extends AppCompatActivity {

    EditText txtName;
    Spinner cmb_gender;
    EditText txtAge;
    EditText txtUserName;
    EditText txtPassword;
    EditText txtConfirmPassword;
    Button btnSave;
    ImageView imgLogo;
    TextView txtCaption;
    RelativeLayout layoutContainer;
    Animation animation1,animation2,animation3,animation4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__personal_information);

        animation1 = AnimationUtils.loadAnimation(this,R.anim.zoom_enter);
        animation2 = AnimationUtils.loadAnimation(this,R.anim.in_out_enter);
        animation3 = AnimationUtils.loadAnimation(this,R.anim.smalltobig);
        animation4 = AnimationUtils.loadAnimation(this,R.anim.zoom_exit);

        imgLogo = findViewById(R.id.imgLogo);
        txtCaption = findViewById(R.id.txtCaption);
        layoutContainer = findViewById(R.id.layoutContainer);
        btnSave = findViewById(R.id.btnSave);

        imgLogo.startAnimation(animation1);
        txtCaption.startAnimation(animation2);
        layoutContainer.startAnimation(animation2);
        btnSave.startAnimation(animation3);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        imgLogo.startAnimation(animation4);
        txtCaption.startAnimation(animation4);
        layoutContainer.startAnimation(animation4);
        btnSave.startAnimation(animation4);

        Bungee.split(this);
    }
}

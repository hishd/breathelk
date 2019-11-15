package com.breathe.breathelk;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

import spencerstudios.com.bungeelib.Bungee;

public class Activity_Launch extends AppCompatActivity {

    LottieAnimationView animationViewLogo;
    Animation animation1,animation2;
    ImageView imgBreatheText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__launch);

        animation1 = AnimationUtils.loadAnimation(this,R.anim.zoom_enter);

        animationViewLogo = findViewById(R.id.animationViewLogo);
        imgBreatheText = findViewById(R.id.imgBreatheText);

        imgBreatheText.startAnimation(animation1);

        animationViewLogo.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                startActivity(new Intent(Activity_Launch.this,Activity_Signin.class));
                Bungee.zoom(Activity_Launch.this);
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
}

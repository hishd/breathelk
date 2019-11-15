package com.breathe.breathelk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity_AboutBreathe extends AppCompatActivity {

    LinearLayout layout_content_about;
    TextView txtAboutApp;
    Animation animation1,animation2,animation3,animation4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__about_breathe);

        layout_content_about = findViewById(R.id.layout_content_about);
        txtAboutApp = findViewById(R.id.txtAboutApp);

        animation1 = AnimationUtils.loadAnimation(this,R.anim.in_out_enter);
        animation2 = AnimationUtils.loadAnimation(this,R.anim.zoom_enter);
        animation3 = AnimationUtils.loadAnimation(this,R.anim.in_out_exit);
        animation4 = AnimationUtils.loadAnimation(this,R.anim.zoom_exit);

        layout_content_about.startAnimation(animation1);
        txtAboutApp.startAnimation(animation2);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        layout_content_about.startAnimation(animation3);
        txtAboutApp.startAnimation(animation4);
    }
}

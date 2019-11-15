package com.breathe.breathelk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import spencerstudios.com.bungeelib.Bungee;

public class Activity_AbooutMain extends AppCompatActivity {

    TextView txtAboutApp;
    TextView txtTermsOfUse;
    TextView txtReportProblem;
    ImageView imgLogo;
    ActivityOptionsCompat activityOptionsCompat;

    Animation smallToBig,raiseUpS1,raiseUpS2,raiseUpS3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__aboout_main);

        smallToBig = AnimationUtils.loadAnimation(this,R.anim.smalltobig);
        raiseUpS1 = AnimationUtils.loadAnimation(this,R.anim.btta);
        raiseUpS2 = AnimationUtils.loadAnimation(this,R.anim.btta2);
        raiseUpS3 = AnimationUtils.loadAnimation(this,R.anim.btta3);

        txtAboutApp = findViewById(R.id.txtAboutApp);
        txtTermsOfUse = findViewById(R.id.txtTermsOfUse);
        txtReportProblem = findViewById(R.id.txtReportProblem);
        imgLogo = findViewById(R.id.imgLogo);

        imgLogo.startAnimation(smallToBig);
        txtAboutApp.startAnimation(raiseUpS1);
        txtTermsOfUse.startAnimation(raiseUpS2);
        txtReportProblem.startAnimation(raiseUpS3);


        txtAboutApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityOptionsCompat  = ActivityOptionsCompat.makeSceneTransitionAnimation(Activity_AbooutMain.this, imgLogo,"imgLogo");
                startActivity(new Intent(Activity_AbooutMain.this,Activity_AboutBreathe.class),activityOptionsCompat.toBundle());
            }
        });

        txtTermsOfUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.fade(this);
    }
}

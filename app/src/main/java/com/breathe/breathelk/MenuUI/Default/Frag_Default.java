package com.breathe.breathelk.MenuUI.Default;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.airbnb.lottie.LottieAnimationView;
import com.breathe.breathelk.R;

public class Frag_Default extends Fragment {

    private FragDefaultViewModel fragDefaultViewModel;
    RelativeLayout layout_heart;
    LinearLayout layout_bottom;
    Animation animation1,animation2,animationBounceUp,floatUpDown;
    LottieAnimationView animationViewHeart;
    LottieAnimationView animationViewVictory;
    Button btnImReadyScheduleActivities;
    TextView txtCaption, txtCaption2;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        fragDefaultViewModel = ViewModelProviders.of(this).get(FragDefaultViewModel.class);
        View root = inflater.inflate(R.layout.frag__default_fragment, container, false);
        fragDefaultViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        btnImReadyScheduleActivities = root.findViewById(R.id.btnImReadyScheduleActivities);
        txtCaption = root.findViewById(R.id.txtCaption);
        txtCaption2 = root.findViewById(R.id.txtCaption2);

        layout_heart = root.findViewById(R.id.layout_heart);
        layout_bottom = root.findViewById(R.id.layout_bottom);
        animationViewHeart = root.findViewById(R.id.animationViewHeart);
        animationViewVictory = root.findViewById(R.id.animationViewVictory);

        animation1 = AnimationUtils.loadAnimation(root.getContext(),R.anim.fade_enter);
        animation2 = AnimationUtils.loadAnimation(root.getContext(),R.anim.zoom_enter);
        animationBounceUp = AnimationUtils.loadAnimation(root.getContext(),R.anim.bounce_in_bottom);
        floatUpDown = AnimationUtils.loadAnimation(root.getContext(),R.anim.float_up_down);

        layout_heart.startAnimation(animation1);
        layout_bottom.startAnimation(animation2);
        btnImReadyScheduleActivities.startAnimation(floatUpDown);

        animationViewHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtCaption2.setVisibility(View.INVISIBLE);
                txtCaption.setText(R.string.victory_caption);
                btnImReadyScheduleActivities.setText(R.string.victory_button);

                animationViewHeart.setAnimation("heart_full.json");
                animationViewHeart.animate();
                animationViewHeart.setSpeed(1);
                animationViewHeart.playAnimation();

                animationViewVictory.setAnimation("victory.json");
                animationViewVictory.animate();
                animationViewVictory.playAnimation();

                btnImReadyScheduleActivities.startAnimation(animationBounceUp);
            }
        });

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("RESUME","RESUMED");
    }
}

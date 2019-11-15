package com.breathe.breathelk.MenuUI.Settings;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.breathe.breathelk.Activity_AbooutMain;
import com.breathe.breathelk.Activity_PersonalInformation;
import com.breathe.breathelk.R;

import spencerstudios.com.bungeelib.Bungee;

public class Frag_Settings extends Fragment {

    private FragSettingsViewModel fragSettingsViewModel;

    TextView txtPersonalInfo;
    TextView txtHelp;
    TextView txtAbout;
    ImageView imgLogo;
    View root;

    Animation animation1,animation2;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        fragSettingsViewModel = ViewModelProviders.of(this).get(FragSettingsViewModel.class);
        root =  inflater.inflate(R.layout.frag__settings_fragment, container, false);
        fragSettingsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        setUpView();

        return root;
    }

    private void setUpView() {

        animation1 = AnimationUtils.loadAnimation(root.getContext(),R.anim.zoom_enter);
        animation2 = AnimationUtils.loadAnimation(root.getContext(),R.anim.slide_up_enter);

        txtPersonalInfo = root.findViewById(R.id.txtPersonalInfo);
        txtHelp = root.findViewById(R.id.txtHelp);
        txtAbout = root.findViewById(R.id.txtAbout);
        imgLogo = root.findViewById(R.id.imgLogo);

        imgLogo.startAnimation(animation1);
        txtAbout.startAnimation(animation2);
        txtHelp.startAnimation(animation2);
        txtPersonalInfo.startAnimation(animation2);

        txtPersonalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),Activity_PersonalInformation.class));
                Bungee.zoom(view.getContext());
            }
        });

        txtHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        txtAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Activity_AbooutMain.class));
                Bungee.zoom(view.getContext());
            }
        });
    }

}

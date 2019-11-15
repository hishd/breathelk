package com.breathe.breathelk.MenuUI.Profile;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.FragmentNavigator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.breathe.breathelk.R;
import com.github.mikephil.charting.charts.LineChart;

public class Frag_Profile extends Fragment {

    private FragProfileViewModel fragProfileViewModel;

    TextView txtName;
    TextView txtUserName;
    TextView txtReportProblem;
    LineChart chartDailySelfCarePoints;
    ImageView imgLogo;
    LinearLayout layout_signOut;
    AlertDialog.Builder dialog;
    AlertDialog alertDialog;
    View dialogView;
    Button btnSignOutCancel,btnSignOutApp;

    Animation animation1,animation2,animation3;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        fragProfileViewModel = ViewModelProviders.of(this).get(FragProfileViewModel.class);
        View root = inflater.inflate(R.layout.frag__profile_fragment, container, false);
        fragProfileViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        animation1 = AnimationUtils.loadAnimation(root.getContext(),R.anim.zoom_enter);
        animation2 = AnimationUtils.loadAnimation(root.getContext(),R.anim.in_out_enter);
        animation3 = AnimationUtils.loadAnimation(root.getContext(),R.anim.fade_enter);

        dialog = new AlertDialog.Builder(root.getContext());
        dialogView = getLayoutInflater().inflate(R.layout.signout_dialog,null);
        dialog.setView(dialogView);
        btnSignOutApp = dialogView.findViewById(R.id.btnSignOutApp);
        btnSignOutCancel = dialogView.findViewById(R.id.btnSignOutCancel);
        alertDialog = dialog.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.SignOutDialogAnimation;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        txtName = root.findViewById(R.id.txtName);
        txtUserName = root.findViewById(R.id.txtUserName);
        txtReportProblem = root.findViewById(R.id.txtReportProblem);
        chartDailySelfCarePoints = root.findViewById(R.id.chartDailySelfCarePoints);
        imgLogo = root.findViewById(R.id.imgLogo);

        layout_signOut = root.findViewById(R.id.layout_signOut);
        layout_signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();

                btnSignOutCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });

                btnSignOutApp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }
        });

        imgLogo.startAnimation(animation1);
        txtName.startAnimation(animation2);
        txtReportProblem.startAnimation(animation2);
        txtUserName.startAnimation(animation2);
        chartDailySelfCarePoints.startAnimation(animation3);

        return root;
    }

}

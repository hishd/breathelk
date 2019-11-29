package com.breathe.breathelk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.breathe.breathelk.Validator.VD;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.xml.validation.Validator;

import spencerstudios.com.bungeelib.Bungee;

public class Activity_Signup extends AppCompatActivity {

    EditText txtName;
    EditText txtUserName;
    EditText txtEmail;
    EditText txtPassword;
    EditText txtConfirmPassword;
    CheckBox chkTermsConditions;
    Button btnSignUp;
    Button btnSignIn;
    TextView txtCaption;
    Animation animation1,animation2,animation3,animationFadeEnter,animationFadeExit;
    Animation wobble_shake;
    RelativeLayout layout_middle;
    LottieAnimationView animationLoading;

    private FirebaseAuth FBAuth;
    private FirebaseFirestore db;
    private DocumentReference documentReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__signup);


        animationFadeEnter = AnimationUtils.loadAnimation(this,R.anim.fade_enter);
        animationFadeExit = AnimationUtils.loadAnimation(this,R.anim.fade_exit);


        animation1 = AnimationUtils.loadAnimation(this,R.anim.zoom_enter);
        animation2 = AnimationUtils.loadAnimation(this,R.anim.in_out_enter);
        animation3 = AnimationUtils.loadAnimation(this,R.anim.zoom_exit);
        wobble_shake = AnimationUtils.loadAnimation(this,R.anim.wobble_shake);

        animationLoading = findViewById(R.id.animationLoading);

        btnSignIn = findViewById(R.id.btnSignIn);
        txtCaption = findViewById(R.id.txtCaption);
        txtName = findViewById(R.id.txtName);
        txtUserName = findViewById(R.id.txtUserName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        txtConfirmPassword = findViewById(R.id.txtConfirmPassword);
        chkTermsConditions = findViewById(R.id.chkTermsConditions);
        btnSignUp = findViewById(R.id.btnSignUp);

        layout_middle = findViewById(R.id.layout_middle);

        txtCaption.startAnimation(animation1);
        txtName.startAnimation(animation2);
        txtUserName.startAnimation(animation2);
        txtEmail.startAnimation(animation2);
        txtPassword.startAnimation(animation2);
        txtConfirmPassword.startAnimation(animation2);


        //FirebaseDBInitialization
        FirebaseDbInit();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if(txtName.getText().toString().length()<1){
                        txtName.setError("Name must be between 3 - 50 characters");
                        return;
                    }
                    if(!VD.validateName(txtName.getText().toString())){
                        txtName.setError("Name must be between 3 - 20 characters");
                        return;
                    }
                    if(txtUserName.getText().toString().length()<1){
                        txtUserName.setError("Username must be between 3 - 20 characters");
                        return;
                    }
                    if(!VD.validateUserName(txtUserName.getText().toString())){
                        txtUserName.setError("Username must be between 3 - 20 characters");
                        return;
                    }
                    if(!VD.validateEmail(txtEmail.getText().toString())){
                        txtEmail.setError("Please enter a valid Email");
                        return;
                    }
                    if(txtPassword.getText().toString().length()<6 || txtPassword.getText().toString().length()>20){
                        txtPassword.setError("Password Length should be between 6 to 20 characters");
                        return;
                    }
                    if(!txtPassword.getText().toString().equals(txtConfirmPassword.getText().toString())){
                        txtPassword.setError("Passwords should be matched with each other");
                        txtConfirmPassword.setError("Passwords should be matched with each other");
                        return;
                    }
//                    if(!chkTermsConditions.isChecked()){
//                    }


                  checkExistanceAndRegister("Hishara","HishD","hisharadilshan3@gmail.com","idmcc3");
            }
        });

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


    private boolean validateInput(){
        layout_middle.startAnimation(wobble_shake);
        return false;
    }

    private void playLoadingAnim(){
        btnSignUp.setVisibility(View.INVISIBLE);
        animationLoading.startAnimation(animationFadeEnter);
        animationLoading.setVisibility(View.VISIBLE);
        animationLoading.setAnimation("dot_loading.json");
        animationLoading.animate();
        animationLoading.playAnimation();
    }

    private void stopLoadingAnim(){
        animationLoading.setVisibility(View.INVISIBLE);
        animationLoading.cancelAnimation();
        btnSignUp.startAnimation(animationFadeEnter);
        btnSignUp.setVisibility(View.VISIBLE);
    }


    //FireStore Operations
    private void FirebaseDbInit(){
        db = FirebaseFirestore.getInstance();
    }


    private void checkExistanceAndRegister(final String name, final String userName, final String email, final String password){

        playLoadingAnim();

        documentReference = db.collection("users").document(email);
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    if(Objects.requireNonNull(task.getResult()).exists()){
                        Log.d("FireStore","A user already exists in the system");
                        stopLoadingAnim();
                    }else{
                        registerUser(name,userName,email,password);
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w("FireStore", "Error loading document", e);
                stopLoadingAnim();
            }
        });

    }

    private void registerUser(String name, String userName, final String email, String password){


        Map<String,Object> user = new HashMap<>();
        user.put("name",name);
        user.put("username",userName);
        user.put("email",email);
        user.put("password",password);

        db.collection("users").document(email).set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("Firestore", "DocumentSnapshot added with Email: " + email);
                stopLoadingAnim();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w("FireStore", "Error adding document", e);
                stopLoadingAnim();
            }
        });



//                .add(user)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Log.d("Firestore", "DocumentSnapshot added with ID: " + documentReference.getId());
//                        stopLoadingAnim();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w("FireStore", "Error adding document", e);
//                        stopLoadingAnim();
//                    }
//                });

    }


    //FireBase Authentication and Authorization Methods

    private void FBInit(){
        FBAuth = FirebaseAuth.getInstance();
    }

    private void FBuserLogin(String email,String pwd){
        FBAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(Activity_Signup.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d("Firebase","Sign In Successfully");
                }else{
                    Log.d("Firebase","Unsuccessful Sign In");
                }
            }
        });
    }
}

package com.example.cityguide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

public class RetailerStartupScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_startup_screen);
    }

    public void callLoginScreen(View view) {

        Intent intent=new Intent(getApplicationContext(),Login.class);

        Pair[] pairs=new Pair[1];
        pairs[0]=new Pair<View,String>(findViewById(R.id.login_btn),"transition_login");

        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(RetailerStartupScreen.this,pairs);
        startActivity(intent,options.toBundle());

    }

    public void callsignUp(View view) {

        Intent intent=new Intent(getApplicationContext(),SignUp.class);

        Pair[] pairs=new Pair[1];
        pairs[0]=new Pair<View,String>(findViewById(R.id.signup_btn),"trasition_signup");

        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(RetailerStartupScreen.this,pairs);
        startActivity(intent,options.toBundle());
    }
}

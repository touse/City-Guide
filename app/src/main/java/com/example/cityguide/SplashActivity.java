package com.example.cityguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {


    private static int splash_timer=5000;
    private ImageView backgroungimag;
    private TextView poerdby;
    Animation sideanim,bottomanim;
    SharedPreferences onboardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        backgroungimag=findViewById(R.id.backgroung_img);
        poerdby=findViewById(R.id.poered_by);

       sideanim= AnimationUtils.loadAnimation(this,R.anim.side_anim);
       bottomanim=AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

       backgroungimag.setAnimation(sideanim);
       poerdby.setAnimation(bottomanim);


       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {

              onboardingScreen=getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
              boolean isFirstTime=onboardingScreen.getBoolean("firsttime",true);

              if(isFirstTime){

                  SharedPreferences.Editor editor=onboardingScreen.edit();
                  editor.putBoolean("firsttime",false);
                  editor.commit();

                  Intent intent=new Intent(getApplicationContext(),OnboardingActivity.class);
                  startActivity(intent);
                  finish();
              }
              else
              {
                  Intent intent=new Intent(getApplicationContext(),UserDashboardActivity.class);
                  startActivity(intent);
                  finish();
              }


           }
       },splash_timer);


    }
}



















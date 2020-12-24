package com.example.cityguide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class SignupSecond extends AppCompatActivity {

    ImageView backBtn;
    Button next,login;
    TextView titleText;
    RadioGroup radioGroup;
    RadioButton selectedgender;
    DatePicker datePicker;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_second);

        radioGroup=findViewById(R.id.radio_group);
        datePicker=findViewById(R.id.date_picker);

        backBtn=findViewById(R.id.signup_back_button);
        next=findViewById(R.id.signup_next_button);
        login=findViewById(R.id.signup_login_button);
        titleText=findViewById(R.id.signup_title_text);
    }


    public void callnext3signupscreen(View view)
    {

        if(!validateAge() | !validategender() )
        {
            return;
        }
        selectedgender=findViewById(radioGroup.getCheckedRadioButtonId());
       String _gender=selectedgender.getText().toString();

       int day=datePicker.getDayOfMonth();
       int month=datePicker.getMonth();
       int year=datePicker.getYear();

       String _date=day+"/"+month+"/"+year;

        Intent intent=new Intent(getApplicationContext(),SignupThird.class);

        Pair[] pair=new Pair[4];

        pair[0]=new Pair<View,String>(backBtn,"transition_back_arrow_btn");
        pair[1]=new Pair<View,String>(next,"transition_next_btn");
        pair[2]=new Pair<View,String>(login,"transition_login_btn");
        pair[3]=new Pair<View,String>(titleText,"transition_title_text");


        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(SignupSecond.this,pair);
        startActivity(intent,options.toBundle());




    }


    private boolean validategender()
    {
        if(radioGroup.getCheckedRadioButtonId()==-1){
            Toast.makeText(getApplicationContext(),"Please select Gender",Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }

    private boolean validateAge(){

        int currentYear= Calendar.getInstance().get(Calendar.YEAR);
        int userAge=datePicker.getYear();
        int isAgevalid=currentYear - userAge;


        if(isAgevalid<14){
            Toast.makeText(getApplicationContext(),"You are less than 14 years ",Toast.LENGTH_SHORT).show();
            return false;
        }
else {
    return true;
        }
    }

}

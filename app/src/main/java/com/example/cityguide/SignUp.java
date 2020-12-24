package com.example.cityguide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {
    TextInputLayout fullname,username,email,password;
    ImageView backBtn;
    Button next,login;
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailor_sign_up);




        fullname=findViewById(R.id.signup_fullname);
        username=findViewById(R.id.signup_username);
        email=findViewById(R.id.signup_email);
        password=findViewById(R.id.signup_password);

        backBtn=findViewById(R.id.signup_back_button);
        next=findViewById(R.id.signup_next_button);
        login=findViewById(R.id.signup_login_button);
        titleText=findViewById(R.id.signup_title_text);
    }

    public void callnextsignupscreen(View view)
    {
        if(!validateFullname() | !validateusername() | !validateemail() | !validatepassword())
        {
            return;
        }

        Intent intent=new Intent(getApplicationContext(),SignupSecond.class);

        Pair[] pair=new Pair[4];

        pair[0]=new Pair<View,String>(backBtn,"transition_back_arrow_btn");
        pair[1]=new Pair<View,String>(next,"transition_next_btn");
        pair[2]=new Pair<View,String>(login,"transition_login_btn");
        pair[3]=new Pair<View,String>(titleText,"transition_title_text");


        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(SignUp.this,pair);
        startActivity(intent,options.toBundle());




    }


    private boolean validateFullname(){

        String val=fullname.getEditText().getText().toString().trim();
          if(val.isEmpty())
          {
              fullname.setError("Filed can not be empty");
              return  false;
          }
          else{
              fullname.setError(null);
              fullname.setErrorEnabled(false);
              return  true;
          }

    }

    private boolean validateusername(){

        String val=username.getEditText().getText().toString().trim();
        String checkspaces="\\A\\w{1,20}\\z";

        if(val.isEmpty())
        {
            username.setError("Filed can not be empty");
            return  false;
        }
        else if(val.length()>20)
        {
            username.setError("username is too long");
            return  false;
        }
        else if(!val.matches(checkspaces)){
            username.setError("No white spaces are allowed");
            return  false;
        }

        else{
            username.setError(null);
            username.setErrorEnabled(false);
            return  true;
        }

    }

    private boolean validateemail(){

        String val=email.getEditText().getText().toString().trim();
        String checkemail="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty())
        {
            email.setError("Filed can not be empty");
            return  false;
        }

        else if(!val.matches(checkemail)){
            email.setError("Invalid Email..!!");
            return  false;
        }

        else{
            email.setError(null);
            email.setErrorEnabled(false);
            return  true;
        }

    }

    private boolean validatepassword(){

        String val=password.getEditText().getText().toString().trim();
       // String checkemail="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty())
        {
            password.setError("Filed can not be empty");
            return  false;
        }
        else if(val.length()<5){
            password.setError("please write atleast 6 digits code");
            return false;
        }

        //else if(!val.matches(checkemail)){
          //  email.setError("Invalid Email..!!");
            //return  false;
       // }

        else{
            password.setError(null);
            password.setErrorEnabled(false);
            return  true;
        }

    }



}

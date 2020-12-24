package com.example.cityguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class SignupThird extends AppCompatActivity {

    ScrollView scrollView;
    TextInputLayout phonenumber;
    CountryCodePicker countryCodePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_third);


        scrollView=findViewById(R.id.thirdscrenscrool);
        phonenumber=findViewById(R.id.phonenumber);
        countryCodePicker=findViewById(R.id.coutrycodepicker);

    }


    public void callvarifyOTPscreen(View view)
    {



         //get all values from previous activity
          String _fullname=getIntent().getStringExtra("fullname");
         //
          String _username=getIntent().getStringExtra("username");
        String _email=getIntent().getStringExtra("email");
          String _password=getIntent().getStringExtra("password");
          String _date=getIntent().getStringExtra("date");
          String _gender=getIntent().getStringExtra("gender");

          String _getuserphnumber=phonenumber.getEditText().getText().toString().trim(); //get user number
          String _phoneno="+"+countryCodePicker.getFullNumber()+_getuserphnumber;

        Intent intent=new Intent(getApplicationContext(),VerifyOTP.class);
        startActivity(intent);

           //pass all fields to next activity
        intent.putExtra("fullname",_fullname);
        intent.putExtra("username",_username);
        intent.putExtra("email",_email);
        intent.putExtra("password",_password);
        intent.putExtra("date",_date);
        intent.putExtra("gender",_gender);
        intent.putExtra("phoneNo",_phoneno);



    }


}

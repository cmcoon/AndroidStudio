package com.example.securityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AccessControlActivity extends AppCompatActivity {
    public String password;
    public final String correctPassword = "1234";
    public boolean correctPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_control);

        Intent intent = getIntent();
        password = "";
    }

    // Add character 1 to password if corresponding button pressed
    public void pressButton1(View view){
        password += "1";
    }

    // Add character 2 to password if corresponding button pressed
    public void pressButton2(View view){
        password += "2";
    }

    // Add character 3 to password if corresponding button pressed
    public void pressButton3(View view){
        password += "3";
    }

    // Add character 4 to password if corresponding button pressed
    public void pressButton4(View view){
        password += "4";
    }

    // Once password is submitted we check and send back true or false to original intent/activity
    public void pressSubmit(View view){
        System.out.println(password);

        if(password.equals(correctPassword)){
            correctPass = true;
        }else{
            correctPass = false;
        }

        Intent intentResult = new Intent();
        intentResult.putExtra("correctPass", correctPass);
        setResult(RESULT_OK, intentResult);
        finish();
    }
}

package com.babyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SignUp extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
}

package com.babyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUp extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final EditText textName = findViewById(R.id.textName);
        final EditText textPass = findViewById(R.id.textPass);
        Button buttonOK = findViewById(R.id.buttonOK);

        /*dataBaseHelper = new DataBaseHelper(this);

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textName.getText().toString();

                String pass = textPass.getText().toString();

                //Boolean result = dataBaseHelper.insertData(ID);

                //if(result == true){
                    Toast.makeText(getApplicationContext(), "El usuario ha sido guardado satisfactoriamente", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(), "El usuario no ha sido guardado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Usuarios.class);
                startActivity(intent);
            }
        });*/
    }
}

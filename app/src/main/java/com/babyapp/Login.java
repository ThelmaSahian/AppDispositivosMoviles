package com.babyapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final DataBaseHelper dataBaseHelper;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dataBaseHelper = new DataBaseHelper(this);

        final EditText editTextName = findViewById(R.id.editTextName);
        final EditText editTextPass = findViewById(R.id.editTextPass);
        final TextView textUsuario = findViewById(R.id.textUsuario);


        Button buttonOK = findViewById(R.id.buttonOK);

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = dataBaseHelper.getAllData();
                StringBuffer stringBuffer = new StringBuffer();

                if(cursor != null && cursor.getCount() > 0){
                    while (cursor.moveToNext()){
                        stringBuffer.append("ID: " + cursor.getString(0) + "\n");
                        stringBuffer.append("Nombre: " + cursor.getString(1) + "\n");
                        stringBuffer.append("Contraseña: " + cursor.getString(2) + "\n");
                    }
                }

                textUsuario.setText(stringBuffer.toString());

            }
        });
    }
}

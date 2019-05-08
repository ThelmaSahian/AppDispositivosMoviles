package com.babyapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class activity_agregar extends AppCompatActivity {


    EditText etProducto, etTienda, etSucursal, etOferta;
    ImageButton buttonEnviar, buttonCancelar;
    DataBaseHelper dataBaseHelper;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        etProducto = findViewById(R.id.editTextProducto);
        etTienda = findViewById(R.id.editTextTienda);
        etSucursal = findViewById(R.id.editTextSucursal);
        etOferta = findViewById(R.id.editTextOferta);

        buttonEnviar = findViewById(R.id.button_enviar);
        buttonCancelar = findViewById(R.id.button_cancelar);

        dataBaseHelper = new DataBaseHelper(this);


        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

package com.babyapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class activity_agregar extends AppCompatActivity {


    EditText etProducto, etTienda, etSucursal, etOferta;
    Button buttonEnviar, buttonCancelar;
    DataBaseHelper dataBaseHelper;

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

                String editProducto = etProducto.getText().toString();
                String editTienda = etTienda.getText().toString();
                String editSucursal = etSucursal.getText().toString();
                String editOferta = etOferta.getText().toString();

                Boolean result = dataBaseHelper.insertData(editProducto, editTienda, editSucursal, editOferta);

                if(result == true){
                    Toast.makeText(getApplicationContext(), "Publicación realizada", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Hubo un error", Toast.LENGTH_SHORT).show();

                }
            }
        });

        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Usuarios.class);
                startActivity(intent);
            }
        });
    }
}

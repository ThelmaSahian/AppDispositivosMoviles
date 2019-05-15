package com.babyapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Publicaciones extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;
    TextView txtResult;
    //Button ver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicaciones);

        dataBaseHelper = new DataBaseHelper(this);

        txtResult = findViewById(R.id.idResult);

        //ver = findViewById(R.id.ver_publi);


                Cursor cursor = dataBaseHelper.getAllData();
                StringBuffer stringBuffer = new StringBuffer();
                if (cursor != null && cursor.getCount() > 0) {
                    while (cursor.moveToNext()) {
                        stringBuffer.append("Id: " + cursor.getString(0) + "\n");
                        stringBuffer.append("Producto: " + cursor.getString(1) + "\n");
                        stringBuffer.append("Tienda: " + cursor.getString(2) + "\n");
                        stringBuffer.append("Sucursal: " + cursor.getString(3) + "\n" + "\n");
                        stringBuffer.append("Oferta: " + cursor.getString(4) + "\n" + "\n");
                    }
                    txtResult.setText(stringBuffer.toString());
                    Toast.makeText(getApplicationContext(), "BD encontrada", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(), "BD no enontrada", Toast.LENGTH_SHORT).show();
                }




    }
}

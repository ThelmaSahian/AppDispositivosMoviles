package com.babyapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Retrofit;

public class DatosOferta extends AppCompatActivity {


    private RecyclerView recyclerView;
    private int offset;
    private boolean aptoParaCargar;
    private ArrayList<UsersInfo> usersInfo;
    private ListaAdapter listaAdapter;
    private DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_oferta);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaAdapter = new ListaAdapter(this);
        recyclerView.setAdapter(listaAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        obtenerDatos();

        final GestureDetector mGestureDetector = new GestureDetector(DatosOferta.this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                return false;
            }

        });

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                try {

                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());

                    if (child != null && mGestureDetector.onTouchEvent(e)) {

                        int position = recyclerView.getChildAdapterPosition(child);
                        //Toast.makeText(DatosHabitantes.this, "El habitante seleccionado es " + habitante.getFirst() + " " + habitante.getLast(), Toast.LENGTH_SHORT).show();
                        setContentView(R.layout.item_listainfo);

                        return true;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }



    private void obtenerDatos() {

        TextView txtResult = (TextView) findViewById(R.id.idResult);

        listaAdapter.adicionarListaOfertas(usersInfo);
        Cursor cursor = dataBaseHelper.getAllData();
        StringBuffer stringBuffer = new StringBuffer();
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                stringBuffer.append("Id: " + cursor.getString(0) + "\n");
                stringBuffer.append("Nombre: " + cursor.getString(1) + "\n");
                stringBuffer.append("Apellido: " + cursor.getString(2) + "\n");
                stringBuffer.append("Contraseña: " + cursor.getString(3) + "\n" + "\n");
            }
            txtResult.setText(stringBuffer.toString());
        }

    }
}
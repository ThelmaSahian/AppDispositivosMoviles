package com.babyapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;

//Activity de navegación de ofertas

public class Usuarios extends AppCompatActivity {

    private TextView inicioTextView;
    private BottomNavigationView bottomNavigationView;
    FloatingActionButton fab;
    private ListAdapter listaPublicacionesAdapter;

    private DataBaseHelper dataBaseHelper;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        fab= findViewById(R.id.morebottom);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),activity_agregar.class);
                startActivity(i);
            }
        });

        inicioTextView = (TextView) findViewById(R.id.iniciotextView);


        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        /*recyclerView.setAdapter(listaPublicacionesAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);*/

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.inicioItem){
                    inicioTextView.setText(R.string.inicio);

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
                }else if (item.getItemId() == R.id.favoritosItem) {
                    inicioTextView.setText(R.string.favoritos);
                } else if (item.getItemId() == R.id.chatItem) {


                    inicioTextView.setText(R.string.chat);
                    
                }


                return false;
            }
        });
      //  if (AccessToken.getCurrentAccessToken() == null) {
        //    goLoginScreen();
       // }

    }

    private void goLoginScreen() {
        Intent intent = new Intent (this, Login.class);
        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP | intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void logout(View view) {
        LoginManager.getInstance().logOut();
        goLoginScreen();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {   /*accion de inflar menu superior*/
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {  //aqui decidimos lo que pasa en cada opcion del menu superior
        switch (item.getItemId()){    //por si queremos agregar mas opciones
            case R.id.cerrar:         //este el case de cerrar sesion
                LoginManager.getInstance().logOut();
                goLoginScreen();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}

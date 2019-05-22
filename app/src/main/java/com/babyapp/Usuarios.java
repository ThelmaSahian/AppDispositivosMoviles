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
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;

//Activity de navegación de ofertas

public class Usuarios extends AppCompatActivity {

    private TextView inicioTextView;
    private BottomNavigationView bottomNavigationView;
    FloatingActionButton fab;
    private RecyclerView recyclerView;
    private ListAdapter listaPublicacionesAdapter;
    private DataBaseHelper dataBaseHelper;

    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        fab = findViewById(R.id.morebottom);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),activity_agregar.class);
                startActivity(i);
            }
        });

        inicioTextView = (TextView) findViewById(R.id.idResult);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        /*recyclerView.setAdapter(listaPublicacionesAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);*/

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.inicioItem){
                    //inicioTextView.setText(R.string.inicio);
                    //goPublications();
                    goBDPublicaciones();
                } else if (item.getItemId() == R.id.chatItem) {
                    goChatScreen();
                    
                }


                return true;
            }
        });
     // if (AccessToken.getCurrentAccessToken() == null) {
      //  goLoginScreen();
    //  }

    }

    private void goBDPublicaciones(){
        dataBaseHelper = new DataBaseHelper(this);

        txtResult = findViewById(R.id.idResult);

        //ver = findViewById(R.id.ver_publi);


        Cursor cursor = dataBaseHelper.getAllData();
        StringBuffer stringBuffer = new StringBuffer();
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                stringBuffer.append("Producto: " + cursor.getString(1) + "\n");
                stringBuffer.append("Tienda: " + cursor.getString(2) + "\n");
                stringBuffer.append("Sucursal: " + cursor.getString(3) + "\n");
                stringBuffer.append("Oferta: " + cursor.getString(4) + "\n_______________________________" + "\n");
            }
            txtResult.setText(stringBuffer.toString());
            //Toast.makeText(getApplicationContext(), "BD encontrada", Toast.LENGTH_SHORT).show();

        }else{
            //Toast.makeText(getApplicationContext(), "BD no enontrada", Toast.LENGTH_SHORT).show();
        }
    }

    private void goPublications(){
        Intent intent = new Intent(getApplicationContext(), Publicaciones.class);
        startActivity(intent);
    }

    private void goChatScreen() {
        Intent intent = new Intent (this, ChatActivity.class);
        startActivity(intent);
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
            /*case R.id.publicaciones:         //este el case de cerrar sesion
                LoginManager.getInstance().logOut();
                goLoginScreen();
                goPublications();
                break;
                */
            case R.id.cerrar:         //este el case de cerrar sesion
                LoginManager.getInstance().logOut();
                goLoginScreen();
                break;
            case R.id.chat:         //este el case de cerrar sesion
                Intent intent = new Intent (this, ChatActivity.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}

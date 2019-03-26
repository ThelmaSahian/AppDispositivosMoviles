package com.babyapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;

public class Usuarios extends AppCompatActivity {

    private TextView inicioTextView;
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        inicioTextView = (TextView) findViewById(R.id.iniciotextView);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.inicioItem){
                inicioTextView.setText(R.string.inicio);
                }else if (item.getItemId() == R.id.favoritosItem) {
                    inicioTextView.setText(R.string.favoritos);
                } else if (item.getItemId() == R.id.chatItem) {
                    inicioTextView.setText(R.string.chat);
                    
                }


                return false;
            }
        });
        if (AccessToken.getCurrentAccessToken() == null) {
            goLoginScreen();
        }

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


}

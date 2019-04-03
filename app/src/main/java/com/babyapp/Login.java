package com.babyapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Login extends AppCompatActivity {

    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private FirebaseAuth firebaseAuth;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        final DataBaseHelper dataBaseHelper;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dataBaseHelper = new DataBaseHelper(this);
        firebaseAuth = FirebaseAuth.getInstance();

        /*final EditText editTextName = findViewById(R.id.editTextName);
        final EditText editTextPass = findViewById(R.id.editTextPass);
        final TextView textUsuario = findViewById(R.id.textUsuario);*/


        //Button buttonOK = findViewById(R.id.buttonOK);



        /*buttonOK.setOnClickListener(new View.OnClickListener() {
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
        });*/

        /*buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Usuarios.class);
                startActivity(intent);
            }
        });*/

        callbackManager = CallbackManager.Factory.create();
        loginButton = findViewById(R.id.login_button);
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handleFacebookAccessToken(loginResult.getAccessToken());

                //goUsuariosScreen();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), R.string.com_facebook_loginview_cancel_action, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), R.string.com_facebook_smart_login_confirmation_cancel, Toast.LENGTH_SHORT).show();
            }


            public void onStart(){
                Login.super.onStart();
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

            }
        });
    }



    /*private void goUsuariosScreen() {
        Intent intent = new Intent(this, Usuarios.class);
        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP | intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void handleFacebookAccessToken(AccessToken token){
        AuthCredential authCredential = FacebookAuthProvider.getCredential(token.getToken());
        firebaseAuth.signInWithCredential(authCredential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user = firebaseAuth.getCurrentUser();

                        }else{
                            Toast.makeText(getApplicationContext(), "Authentication failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

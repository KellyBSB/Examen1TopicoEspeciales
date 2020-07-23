package com.example.bimestralexamen1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    EditText correo, contrasenia;
    Button regitrar, login;

    //firebase
    FirebaseAuth auth;
    FirebaseUser firebaseUser;

    @Override
    protected void onStart() {

        super.onStart();

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser != null){
            Intent i = new Intent(login.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    contrasenia = findViewById(R.id.password);
    correo = findViewById(R.id.correo);
    login = findViewById(R.id.login);

    //firebase
        auth = FirebaseAuth.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();


     // chequear que el usuaario existe

     if(firebaseUser != null){
         Intent i = new Intent(login.this, MainActivity.class);
         startActivity(i);
         finish();
     }

      //login botton, funcion

     login.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String mail = correo.getText().toString();
             String pass = contrasenia.getText().toString();

             if(TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass)){
                 Toast.makeText(login.this, "Llene todos los campos", Toast.LENGTH_LONG).show();
             }else{
                 auth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {

                         //ver si el usuario fue encontrado
                         if (task.isSuccessful()){
                             Toast.makeText(login.this, "Ingreso exitoso",Toast.LENGTH_LONG).show();
                             Intent i = new Intent(login.this,MainActivity.class);
                             i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                             startActivity(i);
                             finish();
                         }else{
                             Toast.makeText(login.this, "Usuario no encontrado", Toast.LENGTH_LONG).show();

                         }

                     }
                 });
             }
         }
     });




    }


    public void registrar(View view){
        FirebaseAuth.getInstance().signOut();//salir
        startActivity(new Intent(getApplicationContext(),Registro.class));
        finish();
    }

}
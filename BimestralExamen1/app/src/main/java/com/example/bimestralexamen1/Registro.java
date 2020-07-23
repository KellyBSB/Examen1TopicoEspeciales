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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Registro extends AppCompatActivity {

    EditText nombre, correo,contrasenia;
    Button registro, login;

    //firebase

    FirebaseAuth auth;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // inicializamos
        nombre = findViewById(R.id.nombre);
        correo  = findViewById(R.id.correo);
        contrasenia = findViewById(R.id.password);
        registro = findViewById(R.id.registrar);
        login = findViewById(R.id.login);

        auth = FirebaseAuth.getInstance();



        //añadi evento al boton regstarr

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usename = nombre.getText().toString();
                String mail = correo.getText().toString();
                String pass = contrasenia.getText().toString();

                if(TextUtils.isEmpty(usename) || TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass) ){
                    Toast.makeText(Registro.this, "Ingrese los tres campos",Toast.LENGTH_LONG).show();
                }else{
                    Obtenerregistro(usename,mail,pass);
                }


            }
        });




    }


    private void Obtenerregistro(final String nom,String mail, String pass){

        auth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser firebaseUser = auth.getCurrentUser();
                    String userId = firebaseUser.getUid();

                    myRef = FirebaseDatabase.getInstance().getReference("Usuarios").child(userId);

                    //hasshmap
                    HashMap<String,String>datosUsuario = new HashMap<>();
                    datosUsuario.put("id",userId);
                    datosUsuario.put("nombre",nom);
                    datosUsuario.put("imagenUrl","default");

                    //abrir el main activuti si todo va bien

                    myRef.setValue(datosUsuario).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Registro.this, "Registro exitoso",Toast.LENGTH_LONG).show();
                                Intent i = new Intent(Registro.this,login.class);
                                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(i);
                                finish();
                            }
                        }
                    });


                }else{
                    Toast.makeText(Registro.this, "No se puedo registrar",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void Irlogin(View view){
        FirebaseAuth.getInstance().signOut();//salir
        startActivity(new Intent(getApplicationContext(),login.class));
        finish();
    }


}
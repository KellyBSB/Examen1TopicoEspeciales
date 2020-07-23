package com.example.bimestralexamen1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.bimestralexamen1.Model.Users;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity {

    TextView p;

    //Firebase
    FirebaseUser firebaseUser;
    DatabaseReference myRef;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    //para subro a ala base de datos
    StorageReference storage;
    StorageReference storageReference;




    TextView nom;
    CircleImageView fotoperfil;
    RecyclerView rvmensajes;
    EditText enviarmensaje;
    Button enviar;
    TextView nom2;
    ImageButton imagenboton;

    private AdapterMensaje adapterMensaje;
    //codigo de galeria
    private static final int PHOTO_SEND = 1;
    private static final int PHOTO_PERFIL = 2 ;

    //foto perfil
    private String fotoPerfilCadena;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        myRef = FirebaseDatabase.getInstance().getReference();
        //nodo de chat
        databaseReference = FirebaseDatabase.getInstance().getReference("Chat");


        //instaciamos
        nom = findViewById(R.id.nombre);
        fotoperfil = findViewById(R.id.fotoperfil);
        rvmensajes = findViewById(R.id.rvMensajes);
        enviarmensaje = findViewById(R.id.txtmensaje);
        enviar = findViewById(R.id.enviar);
        nom2 = findViewById(R.id.nombredemensaje);
        imagenboton = findViewById(R.id.insertarImagen);
        fotoPerfilCadena = "";

        //instaciar imagen
        storage = FirebaseStorage.getInstance().getReference();

        adapterMensaje = new AdapterMensaje(this);
       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
       rvmensajes.setLayoutManager(linearLayoutManager);
       rvmensajes.setAdapter(adapterMensaje);

       enviar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               databaseReference.push().setValue(new MensajeEnviar(enviarmensaje.getText().toString(),nom.getText().toString(),fotoPerfilCadena,"1", ServerValue.TIMESTAMP));
               enviarmensaje.setText("");
           }
       });

       //insertar iamgen
        imagenboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //contenido de toda la galeria que se enecutre en el celular
                Intent intent = new Intent(Intent.ACTION_PICK);
                //abrir la galeria y escoger cualquier tipo de galeria
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_LOCAL_ONLY,true);
                //obtener el resultado y sea evaluado con un codigo
                //ayuda a subir a la base de datos
                startActivityForResult(intent,PHOTO_SEND);
            }
        });

        //cambiar foto de perfil

        fotoperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //contenido de toda la galeria que se enecutre en el celular
                Intent intent = new Intent(Intent.ACTION_PICK);
                //abrir la galeria y escoger cualquier tipo de galeria
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_LOCAL_ONLY,true);
                //obtener el resultado y sea evaluado con un codigo
                //ayuda a subir a la base de datos
                startActivityForResult(intent,PHOTO_PERFIL);
            }
        });



       //la pantalla se vaya moviendo segun haya mas mensajes
        //inserta un nuevo objeto


        adapterMensaje.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                //llamo aca la funcion del scroll
                setScrollbar();
            }
        });


        //firebase usuario

        myRef.child("Usuarios").child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                    Users users = snapshot.getValue(Users.class);
                    nom.setText(users.getNombre());
                   // nom2.setText(users.getNombre());

                }else{
                    Toast.makeText(MainActivity.this,"No hay nada en la base",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                MensajeRecibir m = snapshot.getValue(MensajeRecibir.class);
                adapterMensaje.addMensaje(m);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }


    //scroll nuesta lista siempre se vayya al ultimo

   public void setScrollbar(){
        rvmensajes.scrollToPosition (adapterMensaje.getItemCount()-1);
    }


    //subir imagen

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        //si se seleciona la imagen corerctamenre llama al requestcode
        if(requestCode == PHOTO_SEND && resultCode == RESULT_OK){

            //URL DE LA FOTO
            //sila foto se sube correctamente genera un codifo y leugo tofo ok
            //aqui se guarda la foto
            Uri u = data.getData();

            storageReference = storage.child("iamgenesChat").child(u.getLastPathSegment());

            storageReference.putFile(u).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Toast.makeText(MainActivity.this,"se subio de manera correcta la foto" , Toast.LENGTH_LONG).show();
                            //obtenemos la URL de la imagen que esta en el storage
                            //Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();
                            //se enevia el mensaje y la foto
                            MensajeEnviar m = new MensajeEnviar("Envio una foto", nom.getText().toString(),fotoPerfilCadena,"2",ServerValue.TIMESTAMP,uri.toString());
                            databaseReference.push().setValue(m);
                        }
                    });
                }
            });
        }else if(requestCode == PHOTO_PERFIL && resultCode == RESULT_OK){
            Uri u = data.getData();

            storageReference = storage.child("FotoPerfil").child(u.getLastPathSegment());

            storageReference.putFile(u).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(MainActivity.this, "se subio de manera correcta la foto", Toast.LENGTH_LONG).show();
                    //obtenemos la URL de la imagen que esta en el storage
                    Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();
                    fotoPerfilCadena = uri.toString();
                    //se enevia el mensaje y la foto
                    MensajeEnviar m = new MensajeEnviar("Actualizacion de foto de perfil", nom.getText().toString(),fotoPerfilCadena,"2",ServerValue.TIMESTAMP,uri.toString());
                    databaseReference.push().setValue(m);
                    Glide.with(MainActivity.this).load(uri.toString()).into(fotoperfil);
                }
            });
        }





    }



    //menu

    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    //eventos de menu

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this, login.class));
                finish();
                return true;
        }
        return false;
    }


}
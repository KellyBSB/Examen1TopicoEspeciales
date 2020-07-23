package com.example.bimestralexamen1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class HolderMensaje extends RecyclerView.ViewHolder {

    private TextView nombre;
    private TextView mensaje;
    private TextView hora;
    private CircleImageView fotoperfilmensaje;
    private ImageView imagenenviada;

    public HolderMensaje(@NonNull View itemView) {
        super(itemView);

        nombre = (TextView) itemView.findViewById(R.id.nombredemensaje);
        mensaje = (TextView) itemView.findViewById(R.id.mensajemensaje);
        hora = (TextView) itemView.findViewById(R.id.horamensaje);
        fotoperfilmensaje = (CircleImageView) itemView.findViewById(R.id.fotoperfilmensaje);
        imagenenviada = (ImageView) itemView.findViewById(R.id.imagenEnviada);

    }

    public TextView getNombre() {
        return nombre;
    }

    public void setNombre(TextView nombre) {
        this.nombre = nombre;
    }

    public TextView getMensaje() {
        return mensaje;
    }

    public void setMensaje(TextView mensaje) {
        this.mensaje = mensaje;
    }

    public TextView getHora() {
        return hora;
    }

    public void setHora(TextView hora) {
        this.hora = hora;
    }

    public CircleImageView getFotoperfilmensaje() {
        return fotoperfilmensaje;
    }

    public void setFotoperfilmensaje(CircleImageView fotoperfilmensaje) {
        this.fotoperfilmensaje = fotoperfilmensaje;
    }

    public ImageView getImagenenviada() {
        return imagenenviada;
    }

    public void setImagenenviada(ImageView imagenenviada) {
        this.imagenenviada = imagenenviada;
    }
}

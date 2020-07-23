package com.example.bimestralexamen1;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterMensaje extends RecyclerView.Adapter<HolderMensaje> {

    //lista del objeto mensaje

    private List<MensajeRecibir>listmensaje = new ArrayList<>();
    private Context c;

    public AdapterMensaje( Context c) {
        this.c = c;
    }

    //añadirmensaje
    public void addMensaje(MensajeRecibir m){

        listmensaje.add(m);
        notifyItemChanged(listmensaje.size());

    }


    @NonNull
    @Override
    public HolderMensaje onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.card_view_mensajes,parent,false);
        return new HolderMensaje(v);

    }

    @Override
    public void onBindViewHolder(@NonNull HolderMensaje holder, int position) {

        holder.getNombre().setText(listmensaje.get(position).getNombre());
        holder.getMensaje().setText(listmensaje.get(position).getMensaje());
        if(listmensaje.get(position).getType_mensaje().equals("2")){

            //que la imagen sea visible en el caso de que si este
            holder.getImagenenviada().setVisibility(View.VISIBLE);
            holder.getMensaje().setVisibility(View.VISIBLE);
            //descargar imagen
            Glide.with(c).load(listmensaje.get(position).getURLimagen()).into(holder.getImagenenviada());

        }else if(listmensaje.get(position).getType_mensaje().equals("1")){
            //gone es invisible
            holder.getImagenenviada().setVisibility(View.GONE);
            holder.getMensaje().setVisibility(View.VISIBLE);
        }
        if(listmensaje.get(position).getFotoperfil().isEmpty()){
            holder.getFotoperfilmensaje().setImageResource(R.drawable.icono);
        }else{
            Glide.with(c).load(listmensaje.get(position).getFotoperfil()).into(holder.getFotoperfilmensaje());
        }
        Long codigoHora = listmensaje.get(position).getHora();
        Date d = new Date(codigoHora);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a"); // a signfica am o pm
        holder.getHora().setText(sdf.format(d));


    }

    @Override
    public int getItemCount() {
        return listmensaje.size();
    }
}

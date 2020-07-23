package com.example.bimestralexamen1;

import java.util.Map;

public class MensajeEnviar extends Mensaje{

    private Map hora;

    //es necesario un contructor vacio la hora del casteo

    public MensajeEnviar (){

    }

    public MensajeEnviar(Map hora) {
        this.hora = hora;
    }

    public MensajeEnviar(String mensaje, String nombre, String fotoperfil, String type_mensaje, Map hora) {
        super(mensaje, nombre, fotoperfil, type_mensaje);
        this.hora = hora;
    }

    public MensajeEnviar(String mensaje, String nombre, String fotoperfil, String type_mensaje, Map hora,String URLimagen) {
        super(mensaje, nombre, fotoperfil, type_mensaje, URLimagen);
        this.hora = hora;
    }

    public Map getHora() {
        return hora;
    }

    public void setHora(Map hora) {
        this.hora = hora;
    }
}

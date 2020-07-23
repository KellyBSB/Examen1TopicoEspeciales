package com.example.bimestralexamen1;


//objeto de mensaje

public class Mensaje {

    private String mensaje;
    private String nombre;
    private String fotoperfil;
    private String type_mensaje;
    private String URLimagen;

//sobrecarga de construtores

    public Mensaje() {
    }

    public Mensaje(String mensaje, String nombre, String fotoperfil, String type_mensaje) {
        this.mensaje = mensaje;
        this.nombre = nombre;
        this.fotoperfil = fotoperfil;
        this.type_mensaje = type_mensaje;

    }

    public Mensaje(String mensaje, String nombre, String fotoperfil, String type_mensaje,  String URLimagen) {
        this.mensaje = mensaje;
        this.nombre = nombre;
        this.fotoperfil = fotoperfil;
        this.type_mensaje = type_mensaje;

        this.URLimagen = URLimagen;
    }

//getteres y setters

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFotoperfil() {
        return fotoperfil;
    }

    public void setFotoperfil(String fotoperfil) {
        this.fotoperfil = fotoperfil;
    }

    public String getType_mensaje() {
        return type_mensaje;
    }

    public void setType_mensaje(String type_mensaje) {
        this.type_mensaje = type_mensaje;
    }


    public String getURLimagen() {
        return URLimagen;
    }

    public void setURLimagen(String URLimagen) {
        this.URLimagen = URLimagen;
    }
}

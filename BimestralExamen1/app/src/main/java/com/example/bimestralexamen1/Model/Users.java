package com.example.bimestralexamen1.Model;

public class Users {

    private String id;
    private String nombre;
    private String imagenUrl;

    //toda la infoacion
    public Users(){

    }

    //para el login

    public Users(String id, String nombre, String imagenUrl) {
        this.id = id;
        this.nombre = nombre;
        this.imagenUrl = imagenUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
}

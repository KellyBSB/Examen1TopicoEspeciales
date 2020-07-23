package com.example.bimestralexamen1;

public class MensajeRecibir extends Mensaje {

    private Long hora;


    //contenga todos los metodos
    public MensajeRecibir() {
    }

    public MensajeRecibir(Long hora) {
        this.hora = hora;
    }

    public MensajeRecibir(String mensaje, String nombre, String fotoperfil, String type_mensaje, Long hora, String URLimagen) {
        super(mensaje, nombre, fotoperfil, type_mensaje, URLimagen);
        this.hora = hora;
    }

    public Long getHora() {
        return hora;
    }

    public void setHora(Long hora) {
        this.hora = hora;
    }
}

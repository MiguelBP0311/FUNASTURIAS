package com.example.funasturias.modelo;

public class Valoracion {
    private String usuario;
    private String idRestaurante;
    private String comentario;
    private int valoracion;


    public Valoracion(String usuario, String idRestaurante, String comentario, int valoracion) {
        this.usuario = usuario;
        this.idRestaurante = idRestaurante;
        this.comentario = comentario;
        this.valoracion = valoracion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(String idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
}

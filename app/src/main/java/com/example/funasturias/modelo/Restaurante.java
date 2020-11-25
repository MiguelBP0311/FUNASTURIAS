package com.example.funasturias.modelo;

import com.google.firebase.firestore.GeoPoint;

import java.io.Serializable;
import java.util.Date;

public class Restaurante implements Serializable {
    private String idZona;
    private Posicion lugarRestaurante;
    private String nombre;
    private String telefono;
    private String tipoComida;
    private String idRestaurante;

    public Restaurante(String idZona, GeoPoint lugarRestaurante, String nombre, String telefono, String tipoComida, String idRestaurante) {
        this.idZona = idZona;
        this.lugarRestaurante = new Posicion(lugarRestaurante.getLatitude(), lugarRestaurante.getLongitude());
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoComida = tipoComida;
        this.idRestaurante=idRestaurante;
    }

    public String getIdZona() {
        return idZona;
    }

    public void setIdZona(String idZona) {
        this.idZona = idZona;
    }

    public Posicion getLugarRestaurante() {
        return lugarRestaurante;
    }

    public void setLugarRestaurante(Posicion lugarRestaurante) {
        this.lugarRestaurante = lugarRestaurante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public String getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(String idRestaurante) {
        this.idRestaurante = idRestaurante;
    }
}


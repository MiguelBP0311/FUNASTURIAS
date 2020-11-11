package com.example.funasturias.modelo;

import com.google.firebase.firestore.GeoPoint;

import java.util.Date;

public class Restaurante {
    private String idZona;
    private GeoPoint lugarRestaurante;
    private String nombre;
    private String telefono;
    private String tipoComida;

    public Restaurante(String idZona, GeoPoint lugarRestaurante, String nombre, String telefono, String tipoComida) {
        this.idZona = idZona;
        this.lugarRestaurante = lugarRestaurante;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoComida = tipoComida;
    }

    public String getIdZona() {
        return idZona;
    }

    public void setIdZona(String idZona) {
        this.idZona = idZona;
    }

    public GeoPoint getLugarRestaurante() {
        return lugarRestaurante;
    }

    public void setLugarRestaurante(GeoPoint lugarRestaurante) {
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
}


package com.example.funasturias.modelo;

import java.io.Serializable;

public class Posicion implements Serializable {

    private double latitud;
    private double longintud;

    public Posicion(double latitud, double longintud) {
        this.latitud = latitud;
        this.longintud = longintud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongintud() {
        return longintud;
    }

    public void setLongintud(double longintud) {
        this.longintud = longintud;
    }
}

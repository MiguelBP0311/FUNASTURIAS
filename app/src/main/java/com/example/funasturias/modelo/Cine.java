package com.example.funasturias.modelo;

public class Cine {
    private String nombreCine;
    private String url;
    private String idZonaCine;


    public Cine(String nombreCine, String url, String idZonaCine) {
        this.nombreCine = nombreCine;
        this.url = url;
        this.idZonaCine = idZonaCine;
    }

    public String getNombreCine() {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIdZonaCine() {
        return idZonaCine;
    }

    public void setIdZonaCine(String idZonaCine) {
        this.idZonaCine = idZonaCine;
    }
}

package com.example.funasturias.modelo;

public class Fiesta {
    private String idLocalidad;
    private String municipio;
    private String nombreFiesta;
    private String fecha;
    private String descripcion;

    public String getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(String idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNombreFiesta() {
        return nombreFiesta;
    }

    public void setNombreFiesta(String nombreFiesta) {
        this.nombreFiesta = nombreFiesta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Fiesta(String idLocalidad, String municipio, String nombreFiesta, String fecha, String descripcion) {
        this.idLocalidad = idLocalidad;
        this.municipio = municipio;
        this.nombreFiesta = nombreFiesta;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}

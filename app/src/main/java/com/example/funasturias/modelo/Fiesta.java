package com.example.funasturias.modelo;

public class Fiesta {
    private String idLocalidad;
    private String municipioFiesta;
    private String nombreFiesta;
    private String fechaFiesta;
    private String descripcionFiesta;

    public String getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(String idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getMunicipioFiesta() {
        return municipioFiesta;
    }

    public void setMunicipioFiesta(String municipioFiesta) {
        this.municipioFiesta = municipioFiesta;
    }

    public String getNombreFiesta() {
        return nombreFiesta;
    }

    public void setNombreFiesta(String nombreFiesta) {
        this.nombreFiesta = nombreFiesta;
    }

    public String getFechaFiesta() {
        return fechaFiesta;
    }

    public void setFechaFiesta(String fechaFiesta) {
        this.fechaFiesta = fechaFiesta;
    }

    public String getDescripcionFiesta() {
        return descripcionFiesta;
    }

    public void setDescripcionFiesta(String descripcionFiesta) {
        this.descripcionFiesta = descripcionFiesta;
    }


    public Fiesta(String idLocalidad, String municipioFiesta, String nombreFiesta, String fechaFiesta, String descripcionFiesta) {
        this.idLocalidad = idLocalidad;
        this.municipioFiesta = municipioFiesta;
        this.nombreFiesta = nombreFiesta;
        this.fechaFiesta = fechaFiesta;
        this.descripcionFiesta = descripcionFiesta;
    }
}

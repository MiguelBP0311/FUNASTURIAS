package com.example.funasturias.modelo;

public class Zona {
    private String id;
    private String nombre;




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

    public Zona(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}

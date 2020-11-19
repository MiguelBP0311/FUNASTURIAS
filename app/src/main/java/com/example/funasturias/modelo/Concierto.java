package com.example.funasturias.modelo;

import com.google.firebase.firestore.GeoPoint;

import java.io.Serializable;
import java.util.Date;

public class Concierto implements Serializable {
    private String idZona;
    private GeoPoint lugar;
    private String artista;
    private Date fechaHora;
    private String gira;
    private String genero;
    private String URLGoogle;
    private String URLYouTube;
    private String URLSpotify;

    public String getIdZona() {
        return idZona;
    }

    public void setIdZona(String idZona) {
        this.idZona = idZona;
    }

    public GeoPoint getLugar() {
        return lugar;
    }

    public void setLugar(GeoPoint lugar) {
        this.lugar = lugar;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getGira() {
        return gira;
    }

    public void setGira(String gira) {
        this.gira = gira;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getURLGoogle() {
        return URLGoogle;
    }

    public void setURLGoogle(String URLGoogle) {
        this.URLGoogle = URLGoogle;
    }

    public String getURLYouTube() {
        return URLYouTube;
    }

    public void setURLYouTube(String URLYouTube) {
        this.URLYouTube = URLYouTube;
    }

    public String getURLSpotify() {
        return URLSpotify;
    }

    public void setURLSpotify(String URLSpotify) {
        this.URLSpotify = URLSpotify;
    }

    public Concierto(String idZona, GeoPoint lugar, String artista, Date fechaHora, String gira, String genero, String URLGoogle, String URLSpotify, String URLYouTube) {
        this.idZona = idZona;
        this.lugar = lugar;
        this.artista = artista;
        this.fechaHora = fechaHora;
        this.gira = gira;
        this.genero = genero;
        this.URLGoogle= URLGoogle;
        this.URLSpotify=URLSpotify;
        this.URLYouTube=URLYouTube;




    }
}

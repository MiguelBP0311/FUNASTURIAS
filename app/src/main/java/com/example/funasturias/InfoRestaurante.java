package com.example.funasturias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.funasturias.modelo.Restaurante;

public class InfoRestaurante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Restaurante restaurante= (Restaurante) getIntent().getSerializableExtra("todoInfoRestaurante");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_restaurante);
    }

//Por hacer: Comentarios en restuarantes,  terminar Pantalla info restuarantes
    //Meter alguna foto tanto local, como en Firebase
    // En Casa:  dar mejor formato a la APP

}

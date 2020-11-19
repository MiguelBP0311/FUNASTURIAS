package com.example.funasturias;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.funasturias.modelo.Concierto;

public class InfoConciertos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_conciertos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Concierto concierto= (Concierto) getIntent().getSerializableExtra("todoInfoConcierto");

        TextView informacionArtista= findViewById(R.id.textViewInfoArtista);
        TextView informacionGenero= findViewById(R.id.textViewInfoGenero);
        TextView informacionFechaHora= findViewById(R.id.textViewInfoFechaHora);
        Button botonLugar= findViewById(R.id.buttonInfoLugar);
        ImageView imagenGoogle= findViewById(R.id.imageViewGoogle);
        ImageView imagenSpotify= findViewById(R.id.imageViewSpotify);
        ImageView imageViewYouTube= findViewById(R.id.imageViewYouTube);
        informacionArtista.setText(concierto.getArtista());
        informacionGenero.setText(concierto.getGenero());
        informacionFechaHora.setText(concierto.getFechaHora().toString());




    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        } else{
            return super.onOptionsItemSelected(item);
        }

    }
}

package com.example.funasturias;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.funasturias.modelo.Concierto;

import java.text.DateFormat;

public class InfoConciertos extends AppCompatActivity {
    DateFormat formatoFecha= DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_conciertos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Concierto concierto= (Concierto) getIntent().getSerializableExtra("todoInfoConcierto");

        TextView informacionArtista= findViewById(R.id.textViewInfoArtista);
        TextView informacionGenero= findViewById(R.id.textViewInfoGenero);
        TextView informacionFechaHora= findViewById(R.id.textViewInfoFechaHora);
        Button botonLugar= findViewById(R.id.buttonInfoLugar);
        ImageView imagenGoogle= findViewById(R.id.imageViewGoogle);
        ImageView imagenSpotify= findViewById(R.id.imageViewSpotify);
        ImageView imageViewYouTube= findViewById(R.id.imageViewYouTube);
        informacionArtista.setText(concierto.getArtista());
        informacionGenero.setText(concierto.getGenero());
        informacionFechaHora.setText(formatoFecha.format(concierto.getFechaHora()));

        botonLugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri gmnIntentUri= Uri.parse("geo:"+concierto.getLugar().getLatitud()+","+concierto.getLugar().getLongintud()+"?q="+ concierto.getLugar().getLatitud()+","+ concierto.getLugar().getLongintud());
                Intent intencionMapa= new Intent(Intent.ACTION_VIEW, gmnIntentUri);
                intencionMapa.setPackage("com.google.android.apps.maps");
                if(intencionMapa.resolveActivity(getPackageManager())!= null) {
                    startActivity(intencionMapa);
                } else {
                    Toast.makeText(InfoConciertos.this, "Es necesario tener instalado Google Maps.", Toast.LENGTH_LONG).show();
                }

                startActivity(intencionMapa);
            }
        });


        imagenGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webIntentUri= Uri.parse(concierto.getURLGoogle());
                Intent intencionGoogle= new Intent(Intent.ACTION_VIEW, webIntentUri);
                startActivity(intencionGoogle);
            }
        });

        imagenSpotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webIntentUri= Uri.parse(concierto.getURLSpotify());
                Intent intencionSpotify= new Intent(Intent.ACTION_VIEW, webIntentUri);
                startActivity(intencionSpotify);
            }
        });


        imageViewYouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webIntentUri= Uri.parse(concierto.getURLYouTube());
                Intent intencionYouTube= new Intent(Intent.ACTION_VIEW, webIntentUri);
                startActivity(intencionYouTube);
            }
        });




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

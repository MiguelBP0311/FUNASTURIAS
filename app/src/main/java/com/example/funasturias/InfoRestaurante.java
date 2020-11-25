package com.example.funasturias;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.funasturias.modelo.Restaurante;

public class InfoRestaurante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Restaurante restaurante= (Restaurante) getIntent().getSerializableExtra("todoInfoRestaurante");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_restaurante);

        TextView informacionNombreRestaurante= findViewById(R.id.textViewInfoNombreRestaurante);
        TextView informacionTelfRestaurante= findViewById(R.id.textViewInfotelefono);
        TextView informacionTipoComida= findViewById(R.id.textViewInfoComida);

        Button botonLocalizacionRestaurante= findViewById(R.id.buttonInfoUbicacionRestaurante);

        Button botonOpiniones= findViewById(R.id.buttonValoraciones);

        informacionNombreRestaurante.setText(restaurante.getNombre());
        informacionTelfRestaurante.setText(restaurante.getTelefono());
        informacionTipoComida.setText(restaurante.getTipoComida());

        botonLocalizacionRestaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri gmnIntentUri= Uri.parse("geo:"+restaurante.getLugarRestaurante().getLatitud()+","+restaurante.getLugarRestaurante().getLongintud()+"?q="+ restaurante.getLugarRestaurante().getLatitud()+","+ restaurante.getLugarRestaurante().getLongintud());
                Intent intencionMapa= new Intent(Intent.ACTION_VIEW, gmnIntentUri);
                intencionMapa.setPackage("com.google.android.apps.maps");
                if(intencionMapa.resolveActivity(getPackageManager())!= null) {
                    startActivity(intencionMapa);
                } else {
                    Toast.makeText(InfoRestaurante.this, "Es necesario tener instalado Google Maps.", Toast.LENGTH_LONG).show();
                }
            }
        });


        botonOpiniones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencion= new Intent(InfoRestaurante.this, ComentariosRestauranteActivity.class);
                intencion.putExtra("idRestaurantePasar", restaurante.getIdRestaurante());
                startActivity(intencion);
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

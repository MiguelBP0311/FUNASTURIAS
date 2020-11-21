package com.example.funasturias;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.funasturias.modelo.Fiesta;

public class InfoFiestas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_fiestas);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Fiesta fiesta= (Fiesta) getIntent().getSerializableExtra("todoInfoFiestas");

        TextView textoinfoNombreFiesta= findViewById(R.id.textViewInfoNombreFiesta);
        TextView textoinfoMunicipioFiesta= findViewById(R.id.textViewInfoMunicipio);
        TextView textoinfoFechasFiesta= findViewById(R.id.textViewInfoFechaFiesta);
        TextView textoDescripcionFiesta= findViewById(R.id.textViewInfoDescripcionFiesta);

        textoinfoNombreFiesta.setText(fiesta.getNombreFiesta());
        textoinfoMunicipioFiesta.setText(fiesta.getMunicipioFiesta());
        textoinfoFechasFiesta.setText(fiesta.getFechaFiesta());
        textoDescripcionFiesta.setText(fiesta.getDescripcionFiesta());

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

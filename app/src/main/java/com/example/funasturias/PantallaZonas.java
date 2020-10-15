package com.example.funasturias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PantallaZonas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_zonas);
        Button botonOviedo= findViewById(R.id.buttonOviedo);
        botonOviedo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencion= new Intent(v.getContext(), zona.class);
                intencion.putExtra("zona","jJrMhUlIp69vWg222HpU");
                startActivity(intencion);

            }
        });

    }
}

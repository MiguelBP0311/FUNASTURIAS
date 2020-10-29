package com.example.funasturias;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class PantallaZonas extends AppCompatActivity {
private final String TAG= PantallaZonas.class.getName();
private PantallaZonasArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_zonas);
        ListView zonasListView= findViewById(R.id.seleccionarZonas);
        adaptador= new PantallaZonasArrayAdapter(this);
        zonasListView.setAdapter(adaptador);

        FirebaseFirestore db= FirebaseFirestore.getInstance();

        db.collection("localidades")


                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Zona zona= new Zona( document.getId(), (String) document.getData().get("zona"));
                                adaptador.add(zona);


                            }
                            adaptador.notifyDataSetChanged();
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
        zonasListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Zona zona= adaptador.getItem(position);
                Intent intencion= new Intent(PantallaZonas.this, zonaActivity.class);
                intencion.putExtra("idZonaPasar", zona.getId());
                startActivity(intencion);
            }
        })

        ;


    }

    }


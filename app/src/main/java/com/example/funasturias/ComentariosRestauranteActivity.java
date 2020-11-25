package com.example.funasturias;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.funasturias.adaptadores.ValoracionesRestaurantesArrayAdapter;
import com.example.funasturias.modelo.Valoracion;
import com.example.funasturias.modelo.Zona;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ComentariosRestauranteActivity extends AppCompatActivity {
    private final String TAG= ComentariosRestauranteActivity.class.getName();
    private ValoracionesRestaurantesArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios_restaurante);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView valoracionesListView= findViewById(R.id.ListViewValoraciones);
        adaptador= new ValoracionesRestaurantesArrayAdapter(this);
       valoracionesListView.setAdapter(adaptador);


        String filtroRestaurante= getIntent().getStringExtra("idRestaurantePasar");



        FirebaseFirestore db= FirebaseFirestore.getInstance();

        db.collection("valoraciones")

                .whereEqualTo("idRestaurante",filtroRestaurante)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Valoracion valoracion = new Valoracion(document.getString("usuario"), document.getString("idRestaurante"), document.getString("comentario"), 5);//document.getLong("valoracionNumero").intValue());
                                adaptador.add(valoracion);


                            }
                            adaptador.notifyDataSetChanged();
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
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

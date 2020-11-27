package com.example.funasturias;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Rating;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.funasturias.adaptadores.ValoracionesRestaurantesArrayAdapter;
import com.example.funasturias.modelo.Valoracion;
import com.example.funasturias.modelo.Zona;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

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

       Button botonPublicarComentario= findViewById(R.id.buttonPublicarComentario);




        final String filtroRestaurante= getIntent().getStringExtra("idRestaurantePasar");







       final FirebaseFirestore db= FirebaseFirestore.getInstance();


        botonPublicarComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText escribeValoracion= findViewById(R.id.editTextEscribeValoracion);
                RatingBar puntuaEstrellas= findViewById(R.id.ratingBarPublicaValoracion);

                String textoValoracion= escribeValoracion.getText().toString();

                int numeroValoracionEstrellas=  (int)puntuaEstrellas.getRating();

                FirebaseUser usuario= FirebaseAuth.getInstance().getCurrentUser();

                Map<String, Object> valoracionOb= new HashMap<>();

                valoracionOb.put("comentario", textoValoracion);
                valoracionOb.put("idRestaurante", filtroRestaurante);
                valoracionOb.put("usuario", usuario.getDisplayName());
                valoracionOb.put("valoracionNumero", numeroValoracionEstrellas);

                db.collection("valoraciones").add(valoracionOb).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast mensajeExito= Toast.makeText(ComentariosRestauranteActivity.this, "Comenatrio publicado con éxito", Toast.LENGTH_LONG);
                        mensajeExito.show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast mensajeError= Toast.makeText(ComentariosRestauranteActivity.this, "Ha ocurrido un error. Revise su conexión a Internet, si persiste, contcate con el programador", Toast.LENGTH_LONG);
                        mensajeError.show();
                    }
                });




            }
        });




        db.collection("valoraciones")

                .whereEqualTo("idRestaurante",filtroRestaurante)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Valoracion valoracion = new Valoracion(document.getString("usuario"), document.getString("idRestaurante"), document.getString("comentario"),document.getLong("valoracionNumero").intValue());
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

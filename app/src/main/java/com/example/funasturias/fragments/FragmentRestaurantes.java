package com.example.funasturias.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.funasturias.InfoConciertos;
import com.example.funasturias.InfoRestaurante;
import com.example.funasturias.R;

import com.example.funasturias.ZonaActivity;

import com.example.funasturias.adaptadores.FragmentRestaurantesArrayAdapter;

import com.example.funasturias.modelo.Concierto;
import com.example.funasturias.modelo.Restaurante;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


public class FragmentRestaurantes extends Fragment {
    private FragmentRestaurantesArrayAdapter restaurantesAdapter;
    private final String TAG= FragmentRestaurantes.class.getName();
    private String filtraZona;

    public FragmentRestaurantes() {

    }

    public static FragmentRestaurantes newInstance() {
        FragmentRestaurantes fragment = new FragmentRestaurantes();

        return fragment;
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        restaurantesAdapter= new FragmentRestaurantesArrayAdapter(context);
        filtraZona=((ZonaActivity) context).getParametroZona();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista= inflater.inflate(R.layout.fragment_restaurantes, container, false);
        ListView listaRestaurantes= vista.findViewById(R.id.ListViewListaRestaurantes);
        listaRestaurantes.setAdapter(restaurantesAdapter);
        FirebaseFirestore db= FirebaseFirestore.getInstance();

        db.collection("Restaurantes")


                .whereEqualTo("zona",filtraZona)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Restaurante restaurante= new Restaurante(document.getString("zona"), document.getGeoPoint("direccion"), document.getString("nombre"), document.getString("telefono"), document.getString("tipo_comida"));
                                restaurantesAdapter.add(restaurante);


                            }
                            restaurantesAdapter.notifyDataSetChanged();
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });

        listaRestaurantes.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Restaurante restaurante=restaurantesAdapter.getItem(position);
                Intent intencion= new Intent(getContext(), InfoRestaurante.class);
                intencion.putExtra("todoInfoRestaurante", restaurante);
                startActivity(intencion);
            }
        });




        return vista;
    }

}

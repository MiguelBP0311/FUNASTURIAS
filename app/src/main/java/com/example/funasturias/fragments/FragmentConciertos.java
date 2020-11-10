package com.example.funasturias.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.funasturias.R;
import com.example.funasturias.ZonaActivity;
import com.example.funasturias.adaptadores.FragmentConciertosArrayAdapter;
import com.example.funasturias.modelo.Concierto;
import com.example.funasturias.modelo.Fiesta;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


public class FragmentConciertos extends Fragment {
    private FragmentConciertosArrayAdapter conciertosAdapter;
    private final String TAG= FragmentConciertos.class.getName();
    private String filtraZona;



    public FragmentConciertos() {

    }


    public static FragmentConciertos newInstance() {
        FragmentConciertos fragment = new FragmentConciertos();



        return fragment;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        conciertosAdapter= new FragmentConciertosArrayAdapter(context);
        filtraZona=((ZonaActivity) context).getParametroZona();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista= inflater.inflate(R.layout.fragment_conciertos, container, false);
        ListView listaConciertos= vista.findViewById(R.id.conciertosListView);
        listaConciertos.setAdapter(conciertosAdapter);
        FirebaseFirestore db= FirebaseFirestore.getInstance();

        db.collection("Conciertos")


                .whereEqualTo("zona",filtraZona)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Concierto concierto= new Concierto(document.getString("zona"), document.getGeoPoint("lugar"), document.getString("Artista"), document.getDate("fecha_hora"),  document.getString("Gira"), document.getString("Genero"));
                                conciertosAdapter.add(concierto);


                            }
                           conciertosAdapter.notifyDataSetChanged();
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });




        return vista;
    }

}

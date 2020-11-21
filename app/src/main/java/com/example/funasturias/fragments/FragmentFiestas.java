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

import com.example.funasturias.InfoFiestas;
import com.example.funasturias.R;
import com.example.funasturias.ZonaActivity;

import com.example.funasturias.adaptadores.FragmentFiestasArrayAdapter;
import com.example.funasturias.modelo.Fiesta;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


public class FragmentFiestas extends Fragment {
private FragmentFiestasArrayAdapter fiestasAdapter;
    private final String TAG= FragmentFiestas.class.getName();
    private String filtraZona;





    public FragmentFiestas() {

    }


    public static FragmentFiestas newInstance() {
        FragmentFiestas fragment = new FragmentFiestas();



        return fragment;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fiestasAdapter= new FragmentFiestasArrayAdapter(context);
        filtraZona=((ZonaActivity) context).getParametroZona();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista= inflater.inflate(R.layout.fragment_fiestas, container, false);
        ListView listaFiestas= vista.findViewById(R.id.fiestasListView);
        listaFiestas.setAdapter(fiestasAdapter);
        FirebaseFirestore db= FirebaseFirestore.getInstance();

        db.collection("fiestas")


               .whereEqualTo("idlocalidad",filtraZona)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Fiesta fiesta = new Fiesta( document.getString("idlocalidad"),document.getString("municipio"), document.getString("nombre"), document.getString("fecha"), document.getString("descripcion"));
                               fiestasAdapter.add(fiesta);


                            }
                            fiestasAdapter.notifyDataSetChanged();
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });

        listaFiestas.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fiesta fiesta=fiestasAdapter.getItem(position);
                Intent intencion= new Intent(getContext(), InfoFiestas.class);
                intencion.putExtra("todoInfoFiestas", fiesta);
                startActivity(intencion);
            }
        });




        return vista;
    }
}

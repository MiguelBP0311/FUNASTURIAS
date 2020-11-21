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

import com.example.funasturias.R;
import com.example.funasturias.WebCines;
import com.example.funasturias.ZonaActivity;

import com.example.funasturias.adaptadores.FragmentCinesArrayAdapter;

import com.example.funasturias.modelo.Cine;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


public class FragmentCines extends Fragment {
    private String filtraZona;
    private FragmentCinesArrayAdapter cinesAdapter;
    private final String TAG= FragmentCines.class.getName();



    public FragmentCines() {
        // Required empty public constructor
    }


    public static FragmentCines newInstance() {
        FragmentCines fragment = new FragmentCines();

        return fragment;
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        cinesAdapter= new FragmentCinesArrayAdapter(context);
        filtraZona=((ZonaActivity) context).getParametroZona();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista= inflater.inflate(R.layout.fragment_cines, container, false);
        ListView listaCines= vista.findViewById(R.id.listViewListaCines);
        listaCines.setAdapter(cinesAdapter);
        FirebaseFirestore db= FirebaseFirestore.getInstance();


        db.collection("Cines")


                .whereEqualTo("idzona",filtraZona)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Cine cine= new Cine(document.getString("nombreCine"), document.getString("URL"), document.getString("idzona"));
                                cinesAdapter.add(cine);


                            }
                            cinesAdapter.notifyDataSetChanged();
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });


        listaCines.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cine cine= cinesAdapter.getItem(position);
                Intent intencion= new Intent(getContext(), WebCines.class);
                intencion.putExtra("URL", cine.getUrl());
                startActivity(intencion);




            }
        });

        return vista;



    }

}

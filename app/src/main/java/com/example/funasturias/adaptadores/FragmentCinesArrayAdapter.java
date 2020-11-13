package com.example.funasturias.adaptadores;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.funasturias.R;
import com.example.funasturias.modelo.Cine;

public class FragmentCinesArrayAdapter extends ArrayAdapter<Cine> {

    public FragmentCinesArrayAdapter(@NonNull Context context) {
        super(context, R.layout.itemelmentocine);



    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView= View.inflate(getContext(), R.layout.itemelmentocine, null);

        }
        TextView textoNombreCine= convertView.findViewById(R.id.textViewNombreCine);
        TextView paginaWebCine= convertView.findViewById(R.id.textViewURLCine);




        textoNombreCine.setText(getItem(position).getNombreCine());
        paginaWebCine.setText(getItem(position).getUrl());





        return convertView;
    }





}

package com.example.funasturias.adaptadores;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.funasturias.R;
import com.example.funasturias.modelo.Concierto;
import com.example.funasturias.modelo.Fiesta;

public class FragmentConciertosArrayAdapter extends ArrayAdapter<Concierto> {


    public FragmentConciertosArrayAdapter(@NonNull Context context) {
        super(context, R.layout.itemelementoconcierto);



    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
         if (convertView==null){
             convertView= View.inflate(getContext(), R.layout.itemelementoconcierto, null);

         }
         TextView textoNombreArtista= convertView.findViewById(R.id.textViewNombreArtista);
         TextView textogenero= convertView.findViewById(R.id.textViewGenero);
         TextView textoNombreGira= convertView.findViewById(R.id.textViewgira);
         TextView textoFechaHora= convertView.findViewById(R.id.textViewfechaHora);


         textoNombreArtista.setText(getItem(position).getArtista());
         textogenero.setText(getItem(position).getGenero());
         textoNombreGira.setText(getItem(position).getGira());
         textoFechaHora.setText( getItem(position).getFechaHora().toString());

        return convertView;
    }

    //Verificar porque no aparece lugar
}

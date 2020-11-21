package com.example.funasturias.adaptadores;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.funasturias.R;
import com.example.funasturias.modelo.Fiesta;


public class FragmentFiestasArrayAdapter extends ArrayAdapter<Fiesta> {


    public FragmentFiestasArrayAdapter(@NonNull Context context) {
        super(context, R.layout.itemelementofiesta);



    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
         if (convertView==null){
             convertView= View.inflate(getContext(), R.layout.itemelementofiesta, null);

         }
         TextView textoNombreFiesta= convertView.findViewById(R.id.textViewNombreFiesta);
         TextView textoMunicipioFiesta= convertView.findViewById(R.id.textViewMunicipioFiesta);
         TextView textoFechaFiesta= convertView.findViewById(R.id.textViewFechaFiesta);
        // TextView textoDescripcionFiesta= convertView.findViewById(R.id.textViewDescripcionFiesta);

         textoNombreFiesta.setText(getItem(position).getNombreFiesta());
         textoMunicipioFiesta.setText(getItem(position).getMunicipioFiesta());
       textoFechaFiesta.setText(getItem(position).getFechaFiesta());
        // textoDescripcionFiesta.setText(getItem(position).getDescripcionFiesta());

        return convertView;
    }
}

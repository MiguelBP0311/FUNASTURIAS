package com.example.funasturias.adaptadores;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.funasturias.R;

import com.example.funasturias.modelo.Restaurante;

public class FragmentRestaurantesArrayAdapter extends ArrayAdapter<Restaurante> {

    public FragmentRestaurantesArrayAdapter(@NonNull Context context) {
        super(context, R.layout.itemelementorestaurante);



    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView= View.inflate(getContext(), R.layout.itemelementorestaurante, null);

        }
        TextView textoNombreRestaurante= convertView.findViewById(R.id.textViewNombreRestaurante);

        TextView tipoComida= convertView.findViewById(R.id.textViewTipoComida);



        textoNombreRestaurante.setText(getItem(position).getNombre());

        tipoComida.setText(getItem(position).getTipoComida());
        //



        return convertView;
    }


}

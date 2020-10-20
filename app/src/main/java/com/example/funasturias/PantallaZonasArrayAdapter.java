package com.example.funasturias;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PantallaZonasArrayAdapter extends ArrayAdapter<Zona> {


    public PantallaZonasArrayAdapter(@NonNull Context context) {
        super(context, R.layout.itemzona);



    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
         if (convertView==null){
             convertView= View.inflate(getContext(), R.layout.itemzona, null);

         }
         TextView texto= convertView.findViewById(R.id.nombrezona);

         texto.setText(getItem(position).getNombre());

        return convertView;
    }
}

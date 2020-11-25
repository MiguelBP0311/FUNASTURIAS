package com.example.funasturias.adaptadores;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.funasturias.R;
import com.example.funasturias.modelo.Valoracion;


public class ValoracionesRestaurantesArrayAdapter extends ArrayAdapter<Valoracion> {

    public ValoracionesRestaurantesArrayAdapter (@NonNull Context context) {
        super(context, R.layout.itemelementovaloracion);



    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView= View.inflate(getContext(), R.layout.itemelementovaloracion, null);

        }
        TextView nombreUsuarioVal= convertView.findViewById(R.id.textViewUsuarioVAL);
        TextView comentarioValoracion= convertView.findViewById(R.id.textViewComentarioVAL);
        RatingBar estrellasValoracion= convertView.findViewById(R.id.ratingBarValoracionVAL);

        nombreUsuarioVal.setText(getItem(position).getUsuario());
        comentarioValoracion.setText(getItem(position).getComentario());
        estrellasValoracion.setRating(getItem(position).getValoracion());


        return convertView;
    }


}

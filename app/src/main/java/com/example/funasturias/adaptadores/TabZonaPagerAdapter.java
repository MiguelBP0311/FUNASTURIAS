package com.example.funasturias.adaptadores;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.funasturias.fragments.FragmentCines;
import com.example.funasturias.fragments.FragmentConciertos;
import com.example.funasturias.fragments.FragmentFiestas;
import com.example.funasturias.fragments.FragmentRestaurantes;
import com.example.funasturias.R;


public class TabZonaPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3, R.string.tab_text_4};
    private final Context mContext;

    public TabZonaPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        if(position==0){
            return FragmentFiestas.newInstance();
        }
        if (position == 1) {
            return FragmentConciertos.newInstance();
        }
        if (position==2){
            return FragmentRestaurantes.newInstance();
        }
        if(position==3){
            return FragmentCines.newInstance();


        }
        throw new RuntimeException("Error. Posición No válida");
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 4;
    }
}
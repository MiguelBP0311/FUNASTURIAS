package com.example.funasturias;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.funasturias.adaptadores.TabZonaPagerAdapter;
import com.google.firebase.firestore.FirebaseFirestore;


public class ZonaActivity extends AppCompatActivity {
private final String TAG= ZonaActivity.class.getName();
private String parametroZona;

    public String getParametroZona() {
        return parametroZona;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona);
        TabZonaPagerAdapter sectionsPagerAdapter = new TabZonaPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


        parametroZona= getIntent().getStringExtra("idZonaPasar");









    }
}
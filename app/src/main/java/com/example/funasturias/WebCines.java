package com.example.funasturias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebCines extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_cines);
        WebView navegadorChromeEmbebido= findViewById(R.id.chromeEmbed);
        String URLCine= getIntent().getStringExtra("URL");
        navegadorChromeEmbebido.loadUrl(URLCine);
        navegadorChromeEmbebido.getSettings().setJavaScriptEnabled(true);




    }
}

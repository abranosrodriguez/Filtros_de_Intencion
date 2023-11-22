package com.example.filtros_de_intencion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class LlamadaExplicita extends AppCompatActivity {

    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamada_explicita);
        webview = findViewById(R.id.id_web_view_explicita);
        Intent intent = getIntent();
        String URLRecibida = intent.getExtras().getString("url_key");
        webview.loadUrl(URLRecibida);

    }
}
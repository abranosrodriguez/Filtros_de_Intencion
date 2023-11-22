package com.example.filtros_de_intencion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnExplicito, btnImplicito;
    private EditText editTextURL;
    private String strinEditTextUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnExplicito = findViewById(R.id.btnExplicito);
        btnImplicito = findViewById(R.id.btnImplicito);
        editTextURL = findViewById(R.id.edtTextURL);

        btnExplicito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strinEditTextUrl = editTextURL.getText().toString();
                if(strinEditTextUrl.isEmpty()){
                    Toast.makeText(MainActivity.this, "ERROR - Introduce una URL", Toast.LENGTH_SHORT).show();
                }else{
                    //Toast.makeText(MainActivity.this, "aaa", Toast.LENGTH_SHORT).show();
                    onClickCambiarActividadExplicita(v);

                }
            }
        });

        btnImplicito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strinEditTextUrl = editTextURL.getText().toString();
                if(strinEditTextUrl.isEmpty()){
                    Toast.makeText(MainActivity.this, "ERROR - Introduce una URL", Toast.LENGTH_SHORT).show();
                }else{
                    onClickCambiarActividadImplicita(v);
                }
            }
        });
    }
    public void onClickCambiarActividadExplicita(View v){
        Intent intent = new Intent(this, LlamadaExplicita.class);
        intent.putExtra("url_key",strinEditTextUrl);
        startActivity(intent);
    }

    public void onClickCambiarActividadImplicita(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(strinEditTextUrl));
        startActivity(intent);
    }
}
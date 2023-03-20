package com.example.canvasmartalainez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent dibujar;
    Intent rect;
    Intent buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rect = new Intent(this, Rectangulo.class);
        dibujar = new Intent(this, Dibujar.class);
        buscar = new Intent(this, JuegoBuscar.class);
    }
    public void rect(View view){
        startActivity(rect);
    }
    public void dibujar(View view){
        startActivity(dibujar);
    }
    public void buscar(View view){
        startActivity(buscar);
    }
}
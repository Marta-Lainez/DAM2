package com.example.pasoparametros_martalainez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //variable de tipo EditText
    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //Recoger objeto EditText de la vista
        //et = findViewById(R.id.tv);
    }
    public void ver (View v) {
    //Crear un nuevo Intent
    //usar método putExtra para pasar la dirección web
    //ejecutar la nueva actividad
    }
}
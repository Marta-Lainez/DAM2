package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // calling this activity's function to use ActionBar utility methods
        ActionBar actionBar = getSupportActionBar();

        // providing title for the ActionBar
        actionBar.setTitle(" Lista de contactos");

        // providing subtitle for the ActionBar
        actionBar.setSubtitle(" Contactos");

        // adding icon in the ActionBar
        actionBar.setIcon(R.drawable.logo);

        // methods to display the icon in the ActionBar
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.opcion1) {
            Toast.makeText(this,"Seleccionedo: Señor delegado",Toast.LENGTH_LONG).show();
        }
        if (id==R.id.opcion2) {
            Toast.makeText(this,"Seleccionado: Antonio",Toast.LENGTH_LONG).show();
        }
        if (id==R.id.opcion3) {
            Toast.makeText(this,"Seleccionado: Ionut", Toast.LENGTH_LONG).show();
        }
        if (id==R.id.video) {
            Toast.makeText(this,"Iniciando videollamada", Toast.LENGTH_LONG).show();
        }
        if (id==R.id.llamada) {
            Toast.makeText(this,"Iniando llamada", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
    public void ocultar(View v) {
        getSupportActionBar().hide();
    }
    public void mostrar(View v) {
        getSupportActionBar().show();
    }
}
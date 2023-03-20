package com.example.martalainezt24canvas;

import static android.view.View.SYSTEM_UI_FLAG_FULLSCREEN;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Intent dibujar;
    String color;
    // Declaro las variables del menu
    private Button b1;
    private Button b2;
    private Spinner spinner;
    private EditText et1;
    // Declaro las variables del menu
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instancio los elementos del menu
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        // instancio spinner
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.colores,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        et1 = findViewById(R.id.et1);

        dibujar = new Intent(this, Dibujar.class);
    }
    public void dibujar(View view){
        dibujar.putExtra("color", color);
        dibujar.putExtra("tamanio", Integer.parseInt(et1.getText().toString()));
        startActivity(dibujar);


    }
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        if(text.equals("Negro"))
            color = "Negro";
        else if(text.equals("Azul"))
            color = "Azul";
        else if(text.equals("Rojo"))
            color = "Rojo";
        else if(text.equals("Verde"))
            color = "Verde";
        else if(text.equals("Blanco"))
            color = "Blanco";
    }
    public void onNothingSelected(AdapterView<?> adapterView) {
        color = "Negro";
    }
}
package com.example.martat22;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Actividad3 extends AppCompatActivity {
    private Spinner spinner;
    Intent intentAct2;
    String especie;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        // Spinner
        spinner = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.species,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //spinner.setOnItemSelectedListener(this);

        // Intent
        intentAct2 = new Intent(Actividad3.this,Actividad2.class);

    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        especie = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),"Escogido: " + especie,Toast.LENGTH_SHORT).show();

    }


    public void onNothingSelected(AdapterView<?> adapterView) {
        especie = "Human";
    }
    public void onClickBAck(View view){
        startActivity(intentAct2);
    }
}

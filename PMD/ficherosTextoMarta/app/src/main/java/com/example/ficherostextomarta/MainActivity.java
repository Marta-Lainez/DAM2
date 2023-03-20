package com.example.ficherostextomarta;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private EditText datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        datos = findViewById(R.id.mlt);

    }

    public void grabar(View view) {
        try {
            String fecha = et1.getText().toString();
            String[] numeros = fecha.split("/");
            if(numeros.length == 3 && numeros[0].length() == 2 && numeros[1].length() == 2 && numeros[2].length() == 4){
                String nombreFichero = numeros[0] + numeros[1] + numeros[2] + ".txt";
                OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                        nombreFichero, Activity.MODE_PRIVATE));
                archivo.write(String.valueOf(datos.getText().toString()));
                archivo.flush();
                archivo.close();
                Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Formato de fecha incorrecta. Debe ser dd/MM/YYYY", Toast.LENGTH_SHORT).show();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void consultar(View view) {
        String fecha = et1.getText().toString();
        String[] numeros = fecha.split("/");
        if(numeros.length == 3 && numeros[0].length() == 2 && numeros[1].length() == 2 && numeros[2].length() == 4){
            String nombreFichero = numeros[0] + numeros[1] + numeros[2] + ".txt";
            String[] archivos = fileList();
            String linea = "";
            try {
                if (existe(archivos, nombreFichero)) {
                    InputStreamReader archivo = new InputStreamReader(openFileInput(nombreFichero));
                    BufferedReader br = new BufferedReader(archivo);
                    String todo = "";
                    linea = br.readLine();
                    while(linea  != null){
                        todo += (linea + "\n");
                        linea = br.readLine();
                    }
                    br.close();
                    archivo.close();
                    datos.setText(todo);
                }
                else{
                    Toast.makeText(this, "Ese fichero no existe", Toast.LENGTH_SHORT).show();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            Toast.makeText(this, "Formato de fecha incorrecta. Debe ser dd/MM/YYYY", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean existe(String[] vector, String string){
        for(String fichero: vector){
            if(fichero.equals(string))
                return true;
        }
        return false;
    }
}
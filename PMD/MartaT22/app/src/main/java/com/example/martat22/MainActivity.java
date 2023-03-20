package com.example.martat22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        // instancio intent
        intent = new Intent(MainActivity.this,Actividad2.class);
    }
    public void signUp(View v) {
        //Obtener el objeto de preferencias “agenda”
        SharedPreferences preferencias=getSharedPreferences("agenda", Context.MODE_PRIVATE);
        //Editarlo y guardar los nuevos datos
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString(et1.getText().toString(), et2.getText().toString());
        editor.commit();
        //Mostrar un toast indicando que los datos se han guardado correctamente
        String notiTexto = "Los datos se han guardado correctamente";
        Toast notification = Toast.makeText(getApplicationContext(), notiTexto , Toast.LENGTH_LONG);
        notification.setGravity(Gravity.TOP|Gravity.LEFT,250,0);
        notification.show();

    }
    public void logIn(View view){
        //Obtener el objeto de preferencias “agenda”
        SharedPreferences preferencias=getSharedPreferences("agenda",Context.MODE_PRIVATE);
        //Comprobar si existe el nombre en la agenda
        String nombre = et1.getText().toString();
        String datos = preferencias.getString(nombre, "null");
        Log.i("*******",datos);

        if(et2.getText().toString().equals(datos)){
            intent.putExtra("usuario", nombre);
            startActivity(intent);
        }
        else if((datos.equals("null"))) {
            Toast notification = Toast.makeText(getApplicationContext(), "No existe ese usuario", Toast.LENGTH_LONG);
            notification.setGravity(Gravity.TOP | Gravity.LEFT, 250, 0);
            notification.show();
        }
        else{
            Toast notification = Toast.makeText(getApplicationContext(), "Incorrecto." , Toast.LENGTH_SHORT);
            notification.setGravity(Gravity.TOP|Gravity.LEFT,250,0);
            notification.show();
        }

    }


}
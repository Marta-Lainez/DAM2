package com.example.sharedpreferences_martalainez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1, mlt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.et1);
        mlt1=(EditText)findViewById(R.id.mlt1);

        //et1.setText(prefe.getString("mail",""));
    }

    public void grabar(View v) {
        //Obtener el objeto de preferencias “agenda”
        SharedPreferences preferencias=getSharedPreferences("agenda",Context.MODE_PRIVATE);
        //Editarlo y guardar los nuevos datos
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString(et1.getText().toString(), mlt1.getText().toString());
        editor.commit();
        //Mostrar un toast indicando que los datos se han guardado correctamente
        String notiTexto = "Los datos se han guardado correctamente";
        Toast notification = Toast.makeText(getApplicationContext(), notiTexto , Toast.LENGTH_LONG);
        notification.setGravity(Gravity.TOP|Gravity.LEFT,250,0);
        notification.show();

        mlt1.setText("");
    }
    public void recuperar(View v) {
        //Obtener el objeto de preferencias “agenda”
        SharedPreferences preferencias=getSharedPreferences("agenda",Context.MODE_PRIVATE);
        //Comprobar si existe el nombre en la agenda
        String nombre = et1.getText().toString();

        String datos = preferencias.getString(nombre, "null");
        Log.i("*******",datos);

        if((datos.equals("null"))){
            Toast notification = Toast.makeText(getApplicationContext(), "No existe" , Toast.LENGTH_LONG);
            notification.setGravity(Gravity.TOP|Gravity.LEFT,250,0);
            notification.show();
        }else{
            mlt1.setText(datos);
        }
    }
}

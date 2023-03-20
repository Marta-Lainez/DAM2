package com.example.martat22;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Actividad2 extends AppCompatActivity {
    private Intent intentAct3,intentMain;
    private TextView tv4;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        tv4 = (TextView)findViewById(R.id.tv4);
        // calling this activity's function to use ActionBar utility methods
        ActionBar actionBar = getSupportActionBar();

        // providing title for the ActionBar
        actionBar.setTitle(" Lista de contactos");

        // providing subtitle for the ActionBar
        actionBar.setSubtitle(" Contactos");

        // adding icon in the ActionBar
        actionBar.setIcon(R.mipmap.helmet);

        // methods to display the icon in the ActionBar
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        // Recupero el nombre de usuario
        Bundle contenidos = getIntent().getExtras();
        String nombre = contenidos.getString("usuario");
        tv4.setText(nombre);
        // INtent para volver a la página principal
        intentMain = new Intent(Actividad2.this,MainActivity.class);
        intentAct3 = new Intent(Actividad2.this,Actividad3.class);
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
            dialogo().show();
        }
        if (id==R.id.opcion2) {
            Intent intent = new
                    Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    public void onClickSalir(View view){
        startActivity(intentMain);
    }

    public AlertDialog dialogo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Add the buttons
        builder.setTitle("Do not ask");
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(),"Click en 'Ok'",Toast.LENGTH_SHORT).show();
            }
        });
        // Create the AlertDialog
        AlertDialog dialog = builder.create();
        return dialog;
    }
    public void onClickNew(View view){
        startActivity(intentAct3);
    }
}

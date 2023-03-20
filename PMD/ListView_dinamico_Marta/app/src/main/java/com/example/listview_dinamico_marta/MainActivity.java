package com.example.listview_dinamico_marta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2;
    private ListView lv1;

    private ArrayList<String> datos;
    private ArrayAdapter<String> adaptador;
    private SharedPreferences prefe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datos =new ArrayList<String>();
        leerSharedPreferences();
        adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);
        lv1=(ListView)findViewById(R.id.lv1);
        lv1.setAdapter(adaptador);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);

        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int posicion=i;

                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Eliminación de contacto");
                dialogo.setMessage("¿Está seguro de eliminar ese contacto?");
                dialogo.setCancelable(false);
                dialogo.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo, int id) {
                        String s=datos.get(posicion);
                        StringTokenizer tok1=new StringTokenizer(s," : ");
                        String nom=tok1.nextToken().trim();
                        SharedPreferences.Editor elemento = prefe.edit();
                        elemento.remove(nom);
                        elemento.commit();

                        datos.remove(posicion);
                        adaptador.notifyDataSetChanged();
                    }
                });
                dialogo.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo, int id) {
                    }
                });
                dialogo.show();

                return false;
            }
        });
    }


    private void leerSharedPreferences() {
        prefe=getSharedPreferences("datostelefonos", Context.MODE_PRIVATE);
        Map<String,?> claves = prefe.getAll();
        for(Map.Entry<String,?> ele : claves.entrySet()){
            datos.add(ele.getKey()+" : " +ele.getValue().toString());
        }
    }

    public void añadir(View v) {
        datos.add(et1.getText().toString() + " : " + et2.getText().toString());
        adaptador.notifyDataSetChanged();
        SharedPreferences.Editor elemento = prefe.edit();
        elemento.putString(et1.getText().toString(),et2.getText().toString());
        elemento.commit();
        et1.setText("");
        et2.setText("");
    }
}
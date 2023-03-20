package com.example.marta_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Persona> lista;
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = new ArrayList<>();
        lv = (ListView)findViewById(R.id.list1);
        lista.add(new Persona("Marta",'a'));
        lista.add(new Persona("Tony",'a'));
        lista.add(new Persona("Ionut",'b'));
        lista.add(new Persona("Delegado Eric",'a'));
        lista.add(new Persona("David",'b'));
        lista.add(new Persona("Juan",'b'));
        lista.add(new Persona("Minaya", 'a'));
        lista.add(new Persona("Victor", 'b'));
        lista.add(new Persona("Guille", 'a'));

        AdaptadorPersonas adaptador = new AdaptadorPersonas(this, lista);
        lv.setAdapter(adaptador);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                //Notificación Toast con el nombre de la persona pulsada
                Toast toast = Toast.makeText(getApplicationContext(),lista.get(i).getNombre(),Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
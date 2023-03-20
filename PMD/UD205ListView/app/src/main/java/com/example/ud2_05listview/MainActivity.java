package com.example.ud2_05listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<Persona> alumnos = new ArrayList<Persona>();
    private ListView lv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv1=(ListView) findViewById(R.id.list1);

        Persona Guille = new Persona ("Guillermo Duc",'b');
        Persona Antonio = new Persona ("Antonio Mallen",'a');
        Persona Eric = new Persona ("Eric sierra",'b');
        Persona Ionut = new Persona ("Ionut Toma",'a');
        Persona Pepe = new Persona ("Pepe ibañez",'b');
        Persona Juanjo = new Persona ("Juanjose Parra",'a');


        alumnos.add(Guille);
        alumnos.add(Antonio);
        alumnos.add(Eric);
        alumnos.add(Ionut);
        alumnos.add(Pepe);
        alumnos.add(Juanjo);

        AdaptadorPersonas adaptador = new AdaptadorPersonas(this, alumnos);
        lv1.setAdapter(adaptador);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view, int i, long l){
                Toast toast = Toast.makeText(getApplicationContext(),alumnos.get(i).getNombre(),Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
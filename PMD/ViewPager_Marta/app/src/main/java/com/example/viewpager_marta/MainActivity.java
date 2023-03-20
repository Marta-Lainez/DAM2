package com.example.viewpager_marta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ViewPager view1;
    private ListView lista1;
    private LinearLayout pagina1;
    private ConstraintLayout pagina2;
    private ConstraintLayout pagina3;
    private ArrayList<Button> listaBotones;
    public int n_random;
    private EditText et3;
    private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view1=(ViewPager)findViewById(R.id.view);
        view1.setAdapter(new AdminPageAdapter());

    }
    private void cargarBuscadores() {
        String[] sitios = {"google.com", "yahoo.es", "bing.es"};
        ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sitios);

        ListView lv1 = (ListView) pagina1.findViewById(R.id.lista1);
        lv1.setAdapter(adaptador1);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intento1 = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www." + sitios[i]));
                startActivity(intento1);
            }
        });
    }
    private void cargarBotones(){
        LinearLayout botones = pagina2.findViewById(R.id.botones);
        listaBotones = new ArrayList<Button>();
        Random random = new Random();
        for(int i = 0; i < 5; i++){
            Button button = new Button(this);
            button.setBackgroundColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button.setBackgroundColor(Color.WHITE);
                }
            });
            listaBotones.add(button);
            botones.addView(button);
        }
    }
    public void reset(View v) {
        for(Button boton: listaBotones){
            Random random = new Random();
            boton.setBackgroundColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        }
    }
    private void cargarNumerosAleatorios(){
        n_random=(int) (Math.random()*50+1);
    }
    public void check(View v){
        int contador = 0;
        et3=(EditText)findViewById(R.id.et3);
        tv3=(TextView)findViewById(R.id.tv3);
        int valor= Integer.parseInt(String.valueOf(et3.getText()));

        if(valor==n_random){
            contador++;
            tv3.setText(String.valueOf(contador));
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    "Correcto", Toast.LENGTH_SHORT);
            toast1.show();
        }
        if(valor<n_random){
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    "El número es mayor del introducido", Toast.LENGTH_SHORT);
            toast1.show();
        }
        if(valor>n_random){
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    "El número es menor del introducido", Toast.LENGTH_SHORT);
            toast1.show();
        }
    }

    public void irPagina1(View v) {
        view1.setCurrentItem(0);
    }
    public void irPagina2(View v) {
        view1.setCurrentItem(1);
    }
    public void irPagina3(View v) {
        view1.setCurrentItem(2);
    }
    class AdminPageAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position)
        {
            View paginaactual = null;
            Log.d("****************", position+"");
            switch (position)
            {
                case 0:
                    if (pagina1 == null)
                    {
                        Log.d("****************", position+" ENTRA 1");
                        pagina1 = (LinearLayout)
                                LayoutInflater.from(MainActivity.this).inflate(R.layout.pagina1, null);
                        cargarBuscadores();
                    }
                    paginaactual = pagina1;
                    break;
                case 1:
                    if (pagina2 == null)
                    {

                    //carga la vista

                    //carga el método cargarBotones
                        pagina2 = (ConstraintLayout)
                                LayoutInflater.from(MainActivity.this).inflate(R.layout.pagina2, null);
                        cargarBotones();

                    }
                    paginaactual = pagina2;
                    break;
                case 2:
                    if (pagina3 == null)
                    {
                    //carga la vista

                    //carga el método cargaNumerosAleatorios
                        pagina3 = (ConstraintLayout)
                                LayoutInflater.from(MainActivity.this).inflate(R.layout.pagina3, null);
                        cargarNumerosAleatorios();

                    }
                    paginaactual = pagina3;
                    break;
            }
            ViewPager vp=(ViewPager) collection;

            vp.addView(paginaactual, 0);
            return paginaactual;
        }

        //Debemos implementar los métodos isViewFromObject y destroyItem para el correcto
        //funcionamiento de la clase PageAdapter:
        @Override
        public boolean isViewFromObject(View view, Object object)
        {
            return view == object;
        }
        @Override
        public void destroyItem(View collection, int position, Object view)
        {
            ((ViewPager) collection).removeView((View) view);
        }
    }
}

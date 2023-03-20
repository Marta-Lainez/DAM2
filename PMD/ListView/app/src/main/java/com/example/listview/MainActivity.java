package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        private String grupos[]= {"DAM2","ESO1","ESO2","ESO3","ESO4","Batch1"};
        private int alumnos[]={9,6,44,5,16,22};
        //crear un array de Strings llamado alumnos
        private ListView lv1;
        private TextView tv1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            lv1=(ListView) findViewById(R.id.lv1);
            tv1=(TextView) findViewById(R.id.tv1);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,grupos);
            lv1.setAdapter(adapter);
            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                    tv1.setText("La clase "+grupos[i]+" tiene "+ alumnos[i]);
                }
            });
        }
    }

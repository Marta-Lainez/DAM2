package com.example.ud2_05listview;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AdaptadorPersonas extends ArrayAdapter<Persona> {
    AppCompatActivity appCompatActivity;

    ArrayList<Persona> alumnos;

    AdaptadorPersonas(AppCompatActivity context, ArrayList<Persona> alumnos) {
        super(context, R.layout.persona, alumnos);
        this.alumnos=alumnos;
        appCompatActivity = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = appCompatActivity.getLayoutInflater();
        View item = inflater.inflate(R.layout.persona, null);
        TextView textView1 = (TextView)item.findViewById(R.id.textView);
        textView1.setText(alumnos.get(position).getNombre());
        ImageView imageView1 = (ImageView)item.findViewById(R.id.imageView);
        if (alumnos.get(position).getGrupo()=='a')
            imageView1.setImageResource(R.drawable.a);
        else
            imageView1.setImageResource(R.drawable.b);
        return(item);
    }

}

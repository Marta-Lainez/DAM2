package com.example.marta_listview;

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
    ArrayList<Persona> lista;

    AdaptadorPersonas(AppCompatActivity context, ArrayList<Persona> lista) {
        super(context, R.layout.persona, lista);
        this.lista=lista;
        appCompatActivity = context;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = appCompatActivity.getLayoutInflater();
        View item = inflater.inflate(R.layout.persona, null);
        TextView textView1 = (TextView)item.findViewById(R.id.textView);
        textView1.setText(lista.get(position).getNombre());
        ImageView imageView1 = (ImageView)item.findViewById(R.id.imageView);
        if (lista.get(position).getGrupo()=='a')
            imageView1.setImageResource(R.drawable.a);
        else
            imageView1.setImageResource(R.drawable.b);
        return(item);
    }
}

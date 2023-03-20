package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.Random;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int logos[];
    LayoutInflater inflter;
    public CustomAdapter(Context applicationContext, int[] logos) {
        this.context = applicationContext;
        this.logos = logos;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return logos.length;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_gridview, null); // inflate the layout
        ImageView icon = (ImageView) view.findViewById(R.id.icon); // get the reference of ImageView
        Random r = new Random();
        int aleatorio = r.nextInt(4-0)+0;
        if(aleatorio == 1){
            icon.setImageResource(logos[0]); // set logo images
        }
        if (aleatorio == 2){
            icon.setImageResource(logos[1]);
        }
        if (aleatorio == 3){
            icon.setImageResource(logos[2]);
        }
        //icon.setImageResource(logos[1]); // set logo images
        return view;
    }
}

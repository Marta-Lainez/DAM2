package com.example.mlpractica22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void boton1 (View view){
        setContentView(R.layout.linear_layout_1);
    }
    public void boton2 (View view){
        setContentView(R.layout.linear_layout_2);
    }
    public void boton3 (View view){
        setContentView(R.layout.linear_layout_3);
    }
    public void boton4 (View view){
        setContentView(R.layout.linear_layout_4);
    }
    public void boton5 (View view){
        setContentView(R.layout.frame_layout);
    }
    public void boton6 (View view){
        setContentView(R.layout.relative_layout);
    }
    public void boton7 (View view){
        setContentView(R.layout.linear_layout_5);
    }
    public void boton8 (View view){
        setContentView(R.layout.table_layout);
    }
    public void boton9 (View view){
        setContentView(R.layout.grid_layout);
    }
}
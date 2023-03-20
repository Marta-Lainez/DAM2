package com.example.martalainezt24canvas;

import static android.view.View.SYSTEM_UI_FLAG_FULLSCREEN;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Dibujar extends AppCompatActivity {

    private MyCanvasView myCanvasView;
    String color;
    int tamanio;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dibujar);

        Bundle contenidos = getIntent().getExtras();
        color = contenidos.getString("color");
        int colorNuevo = darColor();
        tamanio = contenidos.getInt("tamanio");

        myCanvasView = new MyCanvasView(this,tamanio, colorNuevo);
        myCanvasView.mPaint.setStrokeWidth(tamanio);
        myCanvasView.setSystemUiVisibility(SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(myCanvasView);





    }
    public int darColor(){
        if(color.equals("Negro"))
            return R.color.black;
        else if(color.equals("Azul"))
            return R.color.blue;
        else if(color.equals("Rojo"))
            return Color.RED;
        else if(color.equals("Verde"))
            return R.color.green;
        else
            return R.color.white;
    }

}

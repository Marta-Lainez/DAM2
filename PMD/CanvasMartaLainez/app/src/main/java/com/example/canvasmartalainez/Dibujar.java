package com.example.canvasmartalainez;

import static android.view.View.SYSTEM_UI_FLAG_FULLSCREEN;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Dibujar extends AppCompatActivity {
    private MyCanvasView myCanvasView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dibujar);
        myCanvasView = new MyCanvasView(this);
        myCanvasView.setSystemUiVisibility(SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(myCanvasView);
    }
}

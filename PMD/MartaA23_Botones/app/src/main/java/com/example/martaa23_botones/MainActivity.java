    package com.example.martaa23_botones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

    public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private ToggleButton tb1;
    private ToggleButton tb2;
    private ToggleButton tb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv2);
        tb1 = (ToggleButton)findViewById(R.id.tb1);
        tb2 = (ToggleButton)findViewById(R.id.tb2);
        tb3 = (ToggleButton)findViewById(R.id.tb3);

        // Funcion toggleButton1
        tb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    tv.setText("ToggleButton izquierda ON");
                } else {
                    // The toggle is disabled
                    tv.setText("ToggleButton izquierda OFF");
                }
            }
        });
        // Funcion toggleButton2
        tb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    tv.setText("ToggleButton centro ON");
                } else {
                    // The toggle is disabled
                    tv.setText("ToggleButton centro OFF");
                }
            }
        });
        // Funcion toggleButton3
        tb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    tv.setText("ToggleButton derecha ON");
                } else {
                    // The toggle is disabled
                    tv.setText("ToggleButton derecha OFF");
                }
            }
        });
    }
    // Funciones para los botones de la tabla y del boton de reinicio
    public void ib1(View view){
        tv.setText("Has pulsado el boton 1");
    }
    public void ib2(View view){
        tv.setText("Has pulsado el boton 2");
    }
    public void ib3(View view){
        tv.setText("Has pulsado el boton 3");
    }
    public void ib4(View view){
        tv.setText("Has pulsado el boton 4");
    }
    public void ib5(View view){
        tv.setText("Has pulsado el boton 5");
    }
    public void ib6(View view){
        tv.setText("Has pulsado el boton 6");
    }
    public void ib7(View view){
        tv.setText("Has pulsado el boton 7");
    }
    public void ib8(View view){
        tv.setText("Has pulsado el boton 8");
    }
    public void ib9(View view){
        tv.setText("Has pulsado el boton 9");
    }
    public void ib10(View view){
        tv.setText("Has pulsado el boton 10");
    }
    public void b1(View view){tv.setText("Reiniciado");}
}
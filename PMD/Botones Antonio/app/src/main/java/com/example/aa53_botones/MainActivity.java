package com.example.aa53_botones;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.mostrar2);


        ToggleButton toggle1 = (ToggleButton) findViewById(R.id.toggleButton);
        toggle1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    tv1.setText("ToggleButton ON");

                } else {
                    // The toggle is disabled
                    tv1.setText("ToggleButton OFF");
                }
            }
        });
        ToggleButton toggle2 = (ToggleButton) findViewById(R.id.toggleButton2);
        toggle2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    tv1.setText("ToggleButton2 ON");
                } else {
                    // The toggle is disabled
                    tv1.setText("ToggleButton2 OFF");
                }
            }
        });
        ToggleButton toggle3 = (ToggleButton) findViewById(R.id.toggleButton3);
        toggle3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    tv1.setText("ToggleButton3 ON");
                } else {
                    // The toggle is disabled
                    tv1.setText("ToggleButton3 OFF");
                }
            }
        });
    }

    public void b1(View view){
        tv1.setText("Has pulsado el boton 1");
    }
    public void b2(View view){
        tv1.setText("Has pulsado el boton 2");
    }
    public void b3(View view){
        tv1.setText("Has pulsado el boton 3");
    }
    public void b4(View view){
        tv1.setText("Has pulsado el boton 4");
    }
    public void b5(View view){
        tv1.setText("Has pulsado el boton 5");
    }
    public void b6(View view){
        tv1.setText("Has pulsado el boton 6");
    }
    public void b7(View view){
        tv1.setText("Has pulsado el boton 7");
    }
    public void b8(View view){
        tv1.setText("Has pulsado el boton 8");
    }
    public void b9(View view){
        tv1.setText("Has pulsado el boton 9");
    }
    public void b10(View view){
        tv1.setText("Has pulsado el boton 10");
    }
    public void bi(View view){
        tv1.setText("");
    }

}
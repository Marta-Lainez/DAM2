package com.example.checkbox;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2;
    private TextView tv1;
    private CheckBox check1, check2, check3, check4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv1 = (TextView) findViewById(R.id.tv1);
        check1 = (CheckBox) findViewById(R.id.check1);
        check2 = (CheckBox) findViewById(R.id.check2);
        check3 = (CheckBox) findViewById(R.id.check3);
        check4 = (CheckBox) findViewById(R.id.check4);

    }
    public void operar(View view) {
        String resultado = "";
        int valor1 = Integer.parseInt(et1.getText().toString());
        int valor2 = Integer.parseInt(et2.getText().toString());

        if (check1.isChecked()) {
            resultado += "La suma es: " + (valor1 + valor2) + "\n";
        }
        if (check2.isChecked()) {
            resultado += "La resta es: " + (valor1 - valor2) + "\n";
        }
        if (check3.isChecked()) {
            resultado += "El producto es: " + (valor1 * valor2) + "\n";
        }
        if (check4.isChecked()) {
            if(valor2 == 0){
                resultado += "No se puede dividir entre 0";
            }else{
                int division = valor1 / valor2;
                resultado += "La division es: "+ (valor1 / valor2);
            }
        }

        if(!(check1.isChecked())&&!(check2.isChecked()) &&!(check3.isChecked())&&!(check4.isChecked())){
            resultado = "Selecciona una operacion";
        }
        tv1.setText(resultado);
    }
}

package com.example.martacalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button b1,b2;
    RadioButton rb;
    Double numero1,numero2,resultado;
    String operador;
    TableRow tr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rb = (RadioButton)findViewById(R.id.rb);
        b1 = (Button)findViewById(R.id.button_cuadrado);
        b2 = (Button)findViewById(R.id.button_raiz);
    }

    public void onClickIgual(View miView)
    {
        boolean error = false;
        TextView tv = (TextView) findViewById(R.id.respuesta) ;

        if(operador.equals("+"))
        {
            numero2 = Double.parseDouble(tv.getText().toString());
            resultado= numero1+numero2;
        }
        else if(operador.equals("-"))
        {
            numero2 = Double.parseDouble(tv.getText().toString());
            resultado= numero1-numero2;
        }
        else if(operador.equals("*"))
        {
            numero2 = Double.parseDouble(tv.getText().toString());
            resultado= numero1*numero2;
        }
        else if(operador.equals("/"))
        {
            numero2 = Double.parseDouble(tv.getText().toString());
            if(numero1 != 0)
                resultado= numero1/numero2;
            else
                error = true;
        }
        else if(operador.equals("^2"))
        {
            resultado= numero1 * numero1;
        }
        else if(operador.equals("^(1/2)"))
        {
            resultado= Math.sqrt(numero1);
        }
        if(!error)
            tv.setText(resultado.toString());
        else{
            tv.setText("ERROR");
            error = false;
        }

    }
    // Gestiona las opciones extra, cuadrado y raíz
    public void extras(View miView)
    {
        if(rb.isChecked()) {
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
        }
        else{
            b1.setVisibility(View.INVISIBLE);
            b2.setVisibility(View.INVISIBLE);
        }
    }
    // Maneja las operaciones
    public void onClickSuma(View miView)
    {
        operador="+";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickResta(View miView)
    {
        operador="-";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickMultiplicacion(View miView)
    {
        operador="*";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickDivision(View miView)
    {
        operador="/";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickCuadrado(View miView)
    {
        operador="^2";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickRaíz(View miView)
    {
        operador="^(1/2)";
        onClickOperacionCapturaNumero1(miView);
    }

    public void onClickOperacionCapturaNumero1(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.respuesta) ;
        numero1 = Double.parseDouble(tv.getText().toString());
        tv.setText("");
    }
    // Borra el cuadro de texto para reiniciar operaciones
    public void onClickLimpia(View miView)
    {
        numero1=0.0;
        numero2=0.0;
        TextView tv = (TextView) findViewById(R.id.respuesta) ;
        tv.setText("");
    }
    // Escoge los digitos para operar según los botones
    public void onClickBtn1(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.respuesta) ;
        tv.setText(tv.getText() + "1");
    }
    public void onClickBtn2(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.respuesta) ;
        tv.setText(tv.getText() + "2");
    }
    public void onClickBtn3(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.respuesta) ;
        tv.setText(tv.getText() + "3");
    }
    public void onClickBtn4(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.respuesta) ;
        tv.setText(tv.getText() + "4");
    }
    public void onClickBtn5(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.respuesta) ;
        tv.setText(tv.getText() + "5");
    }
    public void onClickBtn6(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.respuesta) ;
        tv.setText(tv.getText() + "6");
    }
    public void onClickBtn7(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.respuesta) ;
        tv.setText(tv.getText() + "7");
    }
    public void onClickBtn8(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.respuesta) ;
        tv.setText(tv.getText() + "8");
    }
    public void onClickBtn9(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.respuesta) ;
        tv.setText(tv.getText() + "9");
    }
    public void onClickBtn0(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.respuesta) ;
        tv.setText(tv.getText() + "0");
    }
    public void onClickBtnPunto(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.respuesta) ;
        tv.setText(tv.getText() + ".");
    }

}



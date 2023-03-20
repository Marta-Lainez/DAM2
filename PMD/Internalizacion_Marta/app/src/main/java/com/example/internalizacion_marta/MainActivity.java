package com.example.internalizacion_marta;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    TextView tv1, tv2;
    RadioButton rb1, rb2;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Intent i = new Intent( android.provider.Settings.ACTION_LOCALE_SETTINGS );
        startActivity( i );*/

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);

    }
    public void spanish(View view){
        context = LocaleHelper.setLocale(MainActivity.this, "es");
        Resources resources = context.getResources();
        tv1.setText(resources.getString(R.string.word01));
        tv2.setText(resources.getString(R.string.word02));
        rb1.setText(resources.getString(R.string.language01));
        rb2.setText(resources.getString(R.string.language02));
    }
    public void english(View view){
        context = LocaleHelper.setLocale(MainActivity.this, "en");
        Resources resources = context.getResources();
        tv1.setText(resources.getString(R.string.word01));
        tv2.setText(resources.getString(R.string.word02));
        rb1.setText(resources.getString(R.string.language01));
        rb2.setText(resources.getString(R.string.language02));
    }
}
package com.example.martalainezt23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.OrientationEventListener;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentoHorizontal fragment1 = new FragmentoHorizontal();
        FragmentoVertical fragment2 = new FragmentoVertical();
        FragmentManager fragmentManager = getSupportFragmentManager();

        OrientationEventListener mOrientationListener = new OrientationEventListener(getApplicationContext()) {
            @Override
            public void onOrientationChanged(int i) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if(i == 90 || i == 270){

                    fragmentTransaction.replace(android.R.id.content,fragment1).commit();
                }

                if(i == 180 || i == 0){

                    fragmentTransaction.replace(android.R.id.content,fragment2).commit();
                }
            }
        };
        if(mOrientationListener.canDetectOrientation()){
            mOrientationListener.enable();
        }
    }
}
package com.example.martalainezep1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mbutton;
    private Boolean isFragmentDisplayed = false;
    static final String STATE_FRAGMENT = "state_of_fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instancio el botón
        mbutton = findViewById(R.id.button);

        // Listener para que el boton muestre el fragmento
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Si el fragmento no se está mostrando, se muestra. Si es al revés, lo cierra.
                if(!isFragmentDisplayed)
                    displayFragment();
                else
                    closeFragment();
            }
        });

        if(savedInstanceState != null){
            isFragmentDisplayed = savedInstanceState.getBoolean(STATE_FRAGMENT);
            if(isFragmentDisplayed){
                mbutton.setText(R.string.close);
            }
        }
    }
    // Método que muestra el fragmento
    public void displayFragment(){
        Fragment1 fragment = Fragment1.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragment_container, fragment).addToBackStack(null).commit();

        mbutton.setText(R.string.close);
        isFragmentDisplayed = true;
    }
    // Método que cierra el fragmento
    public void closeFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment1 fragment = (Fragment1) fragmentManager.findFragmentById(R.id.fragment_container);

        if(fragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragment).commit();
        }
        mbutton.setText(R.string.open);
        isFragmentDisplayed = false;
    }
    public void onSaveInstaceState(Bundle savedInstaceState){
        savedInstaceState.putBoolean(STATE_FRAGMENT, isFragmentDisplayed);
        super.onSaveInstanceState(savedInstaceState);
    }
}
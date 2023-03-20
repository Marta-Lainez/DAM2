package com.example.martalainezep1;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {
    private EditText et;
    private CheckBox cb1;
    private CheckBox cb2;
    private SharedPreferences preferencias;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_1, container, false);

        // Instancio los elementos del fragment
        et = rootView.findViewById(R.id.et);
        cb1 = rootView.findViewById(R.id.cb1);
        cb2 = rootView.findViewById(R.id.cb2);
        final Button b = rootView.findViewById(R.id.b);
        final String nombreFichero = "mail.txt";

        // Recojo los elementos del checkbox si hay guardados de antes
        preferencias = this.getActivity().getSharedPreferences("check",Context.MODE_PRIVATE);
        boolean booleanCb1 = preferencias.getBoolean("cb1", false);
        boolean booleanCb2 = preferencias.getBoolean("cb2", false);

        // Los muestro en el layout
        cb1.setChecked(booleanCb1);
        cb2.setChecked(booleanCb2);

        // Recojo el correo si se ha guardado uno antes
        String correo;
        try {
            InputStreamReader archivo = new InputStreamReader(this.getActivity().openFileInput(nombreFichero));
            BufferedReader br = new BufferedReader(archivo);
            correo = br.readLine();
            et.setText(correo);
            // Cierro los elementos abiertos
            br.close();
            archivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // LLamo al método boton() cuando el usuario  haga click en el botón
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boton();
            }
        });
        return rootView;
    }
    public static Fragment1 newInstance(){
        return new Fragment1();
    }

    public void boton (){
        // Guardo el estado de los checkboxes
        preferencias = this.getActivity().getSharedPreferences("check",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();

        editor.putBoolean("cb1", cb1.isChecked());
        editor.putBoolean("cb2", cb2.isChecked());
        editor.commit();

        // Guardo el texto del correo
        final String nombreFichero = "mail.txt";
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(this.getActivity().openFileOutput(nombreFichero, Activity.MODE_PRIVATE));
            String correo = et.getText().toString();
            archivo.write(String.valueOf(correo));
            archivo.flush();
            archivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Cierro la aplicación
        this.getActivity().finish();
        System.exit(0);


    }

}
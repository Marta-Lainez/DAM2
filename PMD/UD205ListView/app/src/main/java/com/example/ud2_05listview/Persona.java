package com.example.ud2_05listview;

public class Persona {
    private String nombre;
    private char grupo;



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGrupo() {
        return grupo;
    }

    public void setGrupo(char grupo) {
        this.grupo = grupo;
    }


    public Persona(String nombre, char grupo) {
        this.nombre = nombre;
        this.grupo = grupo;
    }

}

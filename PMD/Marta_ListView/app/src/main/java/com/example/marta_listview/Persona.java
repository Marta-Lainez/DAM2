package com.example.marta_listview;

public class Persona {
    private String nombre;
    private char grupo;

    public Persona(String nombre, char grupo) {
        this.nombre = nombre;
        this.grupo = grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public char getGrupo() {
        return grupo;
    }
}

package x2_conjuntos;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import entrada.Teclado;

public class EjemploTreeSetPersonas {
	public static void main(String[] args) {
		Set<Persona> conjunto = new TreeSet<>();	
		Random aleatorio = new Random();
		
		Persona persona;
		String nombre;
		int edad;
		do {
			nombre = Teclado.leerCadena("Dime nombre");
			edad = Teclado.leerEntero("Dame edad");
			persona = new Persona(nombre,edad);
			if (conjunto.add(persona)) {
				System.out.println("Añadido");
			}
		} 
		while (conjunto.size() < 3);
		System.out.println(conjunto.toString());
	}
	
}

package x1_listas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class EjemploArrayList {
	
	public static void main(String[] args) {
		Random aleatorio = new Random();
		String[] palabras = {
			"aleatorio", "zanahoria", "letra", "frio", "calor", "zapato", 
			"bajo", "dibujo", "grande", "pequeño", "montaña", "este"
		};
		List<String> listaPalabras = new ArrayList<String>();	
		
		String palabra;
		System.out.println("LISTA DE 20 PALABRAS");
		do {
			palabra = palabras[aleatorio.nextInt(palabras.length)];
			System.out.println("Nueva palabra: " + palabra);
			listaPalabras.add(palabra);
			
		} 
		while (listaPalabras.size() < 20);

		// Recorrido con un iterador
		Iterator<String> iterador = listaPalabras.iterator();
		while (iterador.hasNext()) { 
			palabra = iterador.next(); 
			System.out.print(palabra + " "); 
		}
		System.out.println();
		
		// Ordenación de la lista
		System.out.println("LISTA ORDENADA ASCENDENTE");
		Collections.sort(listaPalabras);
		System.out.println(listaPalabras.toString());
		
		System.out.println("LISTA ORDENADA DESCENDENTE");
		Collections.sort(listaPalabras, new OrdenStringDescendente());
		System.out.println(listaPalabras.toString());
	}
}

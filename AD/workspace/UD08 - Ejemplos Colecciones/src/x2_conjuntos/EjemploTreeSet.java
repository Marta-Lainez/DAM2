package x2_conjuntos;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
	
	public static void main(String[] args) {
		Set<Integer> conjunto = new TreeSet<Integer>();	
		Random aleatorio = new Random();
		
		int numero;
		do {
			numero = aleatorio.nextInt(1000) + 1;
			if (conjunto.add(numero)) {
				System.out.println("Nuevo número: " + numero);
			}
		} 
		while (conjunto.size() < 10);
		
		System.out.println("CONJUNTO DE 10 NÚMEROS SIN DUPLICADOS Y ORDENADOS");
		System.out.println(conjunto.toString());
	}
	
}

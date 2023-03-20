package x2_conjuntos;

import java.util.HashSet;
import java.util.Set;
import entrada.Teclado;

public class EjemploHashSet {
	
	public static void main(String[] args) {
		Set<Integer> conjunto = new HashSet<Integer>();		
		
		int numero, suma = 0;
		System.out.println("CONJUNTO DE 5 N�MEROS SIN DUPLICADOS");
		do {
			numero = Teclado.leerEntero("Elemento " + (conjunto.size() + 1) + ": ");
			if (! conjunto.add(numero)) {
				System.out.println("N�mero no v�lido, ya est� en el conjunto.");
			}
		} 
		while (conjunto.size() < 5);

		for (Integer i: conjunto) {
			suma = suma + i;
		}
		System.out.println("La suma de todos los n�meros es: " + suma);
	}
}

package x3_mapas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import entrada.Teclado;

public class EjemploHashMap {
	
	public static void main(String[] args) {
		Map<String, Integer> mapaNotas = new HashMap<String,Integer>();

		System.out.println("MAPA CON NOTAS PARA 5 ALUMNOS");
		String nombre;
		int nota;
		do {
			nombre = Teclado.leerCadena("¿Nombre? ");
			nota = Teclado.leerEntero("¿Nota? ");
			if (mapaNotas.put(nombre, nota) != null) {
				System.out.println("Se ha modificado la nota de " + nombre);
			}
			else {
				System.out.println("Alumno añadido correctamtente.");
			}
		} 
		while (mapaNotas.size() < 5);
		
		System.out.println("CONTENIDO DEL MAPA: " + mapaNotas.toString());
		
		// Cálculo de aprobados (nota >= 5)
		Set<String> aprobados = new HashSet<String>();
		for (Entry<String, Integer> entrada : mapaNotas.entrySet()) {
			if (entrada.getValue() >= 5) {
				aprobados.add(entrada.getKey());
			}
		}
		
		System.out.println("CONJUNTO DE APROBADOS: " + aprobados.toString());
	}
}

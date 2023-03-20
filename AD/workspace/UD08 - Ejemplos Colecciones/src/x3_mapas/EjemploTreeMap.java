package x3_mapas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import entrada.Teclado; 

public class EjemploTreeMap {
	
	public static void main(String[] args) {
		Map<String,List<String>> mapaTelefonos = new TreeMap<String,List<String>>();	
		
		int cantidad;
		String nombre, telefono;
		System.out.println("AGENDA DE TELÉFONOS ORDENADA POR NOMBRE");
		do {
			nombre = Teclado.leerCadena("¿Nombre? ");
			cantidad = Teclado.leerNatural("¿Cuántos teléfonos? ");
			List<String> telefonos = new ArrayList<String>();
			for (int i = 0 ; i < cantidad ; i++ ) {
				telefono = Teclado.leerCadena("¿Telefono " + ( i + 1) + " ? ");
				telefonos.add(telefono);
			}
			if (mapaTelefonos.put(nombre, telefonos) != null) {
				System.out.println("Se el registro de " + nombre);
			}
			else {
				System.out.println("Contacto añadido correctamtente.");
			}
		}
		while (mapaTelefonos.size() < 2);
		
		System.out.println("RESUMEN DE LOS DATOS: " + mapaTelefonos.toString());
		
		// Recorrido del mapa
		for (String contacto : mapaTelefonos.keySet()) {
			List<String> telefonos = mapaTelefonos.get(contacto);
			System.out.println(contacto + " tiene " + telefonos.size() + 
					" número/s de teléfono, que son " + telefonos.toString());
		}
	}
	
}

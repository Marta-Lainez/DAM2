package practica_mapas;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Mapas {

	public static void main(String[] args) {
		Map<Integer, String> nombreMap = new TreeMap<Integer, String>();
		nombreMap.put(1, "Marta");
		nombreMap.put(2, "Dani"); 
		nombreMap.put(3, "Sara"); 
		nombreMap.put(4, "Tony"); 
		
		Set <Integer> claves = nombreMap.keySet();
		
		for(Integer registro: claves) {
			System.out.println(nombreMap.get(registro));
		}
	}

}

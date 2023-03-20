package x1_listas;

import java.util.Comparator;

public class OrdenStringDescendente implements Comparator<String> {

	@Override
	public int compare(String cadena1, String cadena2) {
		return cadena2.compareTo(cadena1);
	}

}

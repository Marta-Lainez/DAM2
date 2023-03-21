import java.util.ArrayList;

public class CifrarTrasposicionColumnar {
	// Me gustan las papas
	/* MEGUS
	 * TANLA
	 * SPAPA
	 * S
	 */
	public static String cifrar(String cadena, int columnas) {
		cadena = cadena.toUpperCase();
		String nuevaCadena = "";
		String[] cadenasSinEspacios = cadena.split(" ");
		for(String cad: cadenasSinEspacios) {
			nuevaCadena += cad;
		}
		
		String cifrado = "";
		int numFilas = (int)Math.ceil(nuevaCadena.length() / columnas);
		ArrayList <ArrayList> filas = new ArrayList<>(numFilas);
		
		//String CadenasPorColumnas = nuevaCadena.
		for(int i = 0; i < numFilas; i++) {
			for(int j = 0; i < nuevaCadena.length(); i++) {
				
			}
		}
		
		return "";
	}
}

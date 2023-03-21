
public class CifrarPolialfabetico {
	private static final String ALFABETO = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
	private static final String PAR =      "AEIMPTXBFJNQUYCGKÑRVZDHLOSQ";
	private static final String IMPAR =    "NRWBGLPUZEJÑSXCHMQVAFKOTYDI";
	
	public static String cifrar(String cadena) {
		cadena = cadena.toUpperCase();
		String nuevaCadena = "";
		String[] cadenasSinEspacios = cadena.split(" ");
		for(String cad: cadenasSinEspacios) {
			nuevaCadena += cad;
		}
		String cifrado = "";
		// Me gustan las papas
		//System.out.println(nuevaCadena);
		for(int i = 1; i <= nuevaCadena.length(); i++) {
			char letra = nuevaCadena.charAt(i - 1);
			int posicion = ALFABETO.indexOf(letra);
			//System.out.println(posicion);
			if(i % 2 == 0) {
				letra = PAR.charAt(posicion);
			}
			else {
				letra = IMPAR.charAt(posicion);
			}
			//System.out.println(letra);
			cifrado += letra;
		}
		return cifrado;
	}
	public static String descifrar(String cadena) {
		cadena = cadena.toUpperCase();
		String descifrado = "";
		// Me gustan las papas
		
		for(int i = 1; i <= cadena.length(); i++) {
			char letra = cadena.charAt(i -1);
			int posicion = 0;
			if(i % 2 == 0) {
				posicion = PAR.indexOf(letra);
			}
			else {
				posicion = IMPAR.indexOf(letra);
			}
			letra = ALFABETO.charAt(posicion);
			descifrado += letra;
		}
		return descifrado;
	}
}


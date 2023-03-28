
public class CifradoPolybios {
	private static final char[][] MATRIZ = {{'A','B','C','D','E'},
											{'F','G','H','I','K'},
											{'L','M','N','O','P'},
											{'Q','R','S','T','U'},
											{'V','W','X','Y','Z'}};
	public static String cifrar(String palabra) {
		palabra = palabra.toUpperCase();
		String cifrado = "";

		// POLYBIOS
		for(int posicionLetra = 0; posicionLetra < palabra.length(); posicionLetra++) {
			for(int i = 0; i < 5; i++) { // recorre las 5 filas
				for(int j = 0; j < 5; j++) { // recorre las 5 columnas
					char letra = MATRIZ[i][j];
					if(letra == palabra.charAt(posicionLetra)) {
						cifrado += (i+1) + "" + (j+1) + " ";
					}
				}
			}
		}
		cifrado = cifrado.trim();
		return cifrado;
	}
	public static String descifrar(String palabra) {
		String[] secciones = palabra.split(" ");
		String descifrado = "";
		
		int[] numeros = new int[secciones.length];
		for(int i = 0; i < numeros.length; i++) {
			numeros[i] = (Integer.parseInt(secciones[i])) - 11;
			descifrado += MATRIZ[numeros[i]/10][numeros[i]%10] + " ";
		}
		descifrado = descifrado.trim();
		
		return descifrado;
	}
}

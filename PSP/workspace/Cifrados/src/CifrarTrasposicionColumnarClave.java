import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import entrada.Teclado;

public class CifrarTrasposicionColumnarClave {

	public static void main(String[] args) {
		String frase = "Me gustan las papas";
		int numero = Teclado.leerEntero("Número: ");
		String palabra = "";
		while(palabra.length() != numero) {
			palabra = Teclado.leerCadena("Palabra: ");
			if(palabra.length() != numero)
				System.out.println("Longitud incorrecta. Debe tener una longitud de " + numero + " caracteres.");
		}
		System.out.println(frase);
		System.out.println(cifrar(frase, numero, palabra));

	}
	// Me gustan las papas
	// AZULE

	/* MEGUS
	 * TANLA
	 * SPAPA
	 * S
	 *
	 * MTSS-SAA-ULP-GNA-EAP
	 */
	public static String cifrar(String cadena, int columnas, String palabra) {
		Map<Character, Integer> mapa = ordenarPalabra(palabra);

		cadena = cadena.toUpperCase();
		String nuevaCadena = "";
		String[] cadenasSinEspacios = cadena.split(" ");
		for(String cad: cadenasSinEspacios) {
			nuevaCadena += cad;
		}

		String cifrado = "";
		int numFilas = (int)Math.ceil((double)nuevaCadena.length() / columnas);
		// Creo matriz
		Character[][] matriz = new Character[numFilas][columnas];

		/*
		System.out.println("Columnas: " + columnas);
		System.out.println("Letras: " + nuevaCadena.length());
		System.out.println("Filas:" + numFilas);
		 */
		// Recorremos la matriz
		int contador = 0;
		for(int i = 0; i < numFilas; i++) {
			for(int j = 0; j < columnas; j++) {
				if(contador < nuevaCadena.length()) {
					char letra = nuevaCadena.charAt(contador);
					matriz[i][j] = letra;
					contador++;
				}
			}
		}
		/*
		// imprimir contenido de la matriz
		for(int i = 0; i < numFilas; i++) {
			for(int j = 0; j < columnas; j++) {
			System.out.print(matriz[i][j]);	
			}
			System.out.println();
		}
		 */
		// Sacamos la frase cifrada
		//Para cada elemento key del conjunto map.keySet()
		for (Character key : mapa.keySet()){
			System.out.println(key + "=> " + mapa.get(key));
			int columnaNum = Integer.parseInt(mapa.get(key) + "");
			for(int i = 0; i < numFilas; i++) {
				if(matriz[i][columnaNum] != null)
					cifrado += matriz[i][columnaNum];		
			}
		}

		return cifrado;
	}
	public static Map<Character, Integer> ordenarPalabra(String palabra){
		char[] vectorLetras = palabra.toCharArray();
		Arrays.sort(vectorLetras);
		System.out.println(vectorLetras);
		Map<Character, Integer> mapa = new TreeMap<>();
		for(int i = 0; i < palabra.length(); i++) {
			mapa.put(vectorLetras[i], palabra.indexOf(vectorLetras[i]));
		}

		return mapa;
	}


}

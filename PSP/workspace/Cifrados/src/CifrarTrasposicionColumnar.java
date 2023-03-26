import java.util.ArrayList;

public class CifrarTrasposicionColumnar {
	public static void main (String[]args) {
		String frase = "Me gustan las papas";
		System.out.println(frase);
		System.out.println(cifrar(frase, 5));
	}
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
		int numFilas = (int)Math.ceil((double)nuevaCadena.length() / columnas);
		// Creo matriz
		 Character[][] matriz = new Character[numFilas][columnas];
		
		 System.out.println("Columnas: " + columnas);
		 System.out.println("Letras: " + nuevaCadena.length());
		 System.out.println("Filas:" + numFilas);
		 
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
		for(int i = 0; i < columnas; i++) {
			for(int j = 0; j < numFilas; j++) {
				Character letra = matriz[j][i];
				if(letra != null)
				cifrado += letra;
			}
		}
		
		return cifrado;
	}
}

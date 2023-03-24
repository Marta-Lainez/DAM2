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
		for(int i = 0; i < columnas; i++) {
			int contador = 0;
			for(int j = 0; j < numFilas; j++) {
				char letra = nuevaCadena.charAt(contador);
				matriz[i][j] = letra;
				contador++;
			}
		}
		// Sacamos la frase cifrada
		for(int i = 0; i < numFilas; i++) {
			for(int j = 0; j < columnas; j++) {
				Character letra = matriz[i][j];
				if(letra != null)
				cifrado += letra;
			}
		}
		
		return cifrado;
	}
}

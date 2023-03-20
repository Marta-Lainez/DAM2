import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class CalculaPrimos {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps = new PrintStream(System.out);
		String dato = in.readLine();
		if(dato != null) {
			int numero = Integer.parseInt(dato);
			if(esPrimo(numero)) {
				ps.println("El numero " + numero + " es primo.");
				ps.flush();
			}
			else {
				ps.println("Los numeros primos menores que " + numero + " son:");
				ps.flush();
				for (int j = numero; j >= 1; j--) {
					if(esPrimo(j)) {
						ps.println(j);
						ps.flush();
					}
						
				}
			}
		}
		System.exit(0);
	}
	public static boolean esPrimo(int numero) {
		for(int i = 2; i < numero; i++) {
			if(numero % i == 0) {
				return false;
			}
		}
		return true;
	}
}

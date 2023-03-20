import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import entrada.Teclado;

public class Ejercicio01 {

	public static void main(String[] args) {
		String line;
		Runtime runtime = Runtime.getRuntime();
		int contadorRef1 = 0;
		int contadorRef2 = 0;
		int contadorRef3 = 0;
		int contadorRef9 = 0;
		String referencia = "";
		try {
			Process hijo = runtime.exec("java Referencia", null, new File(".\\bin"));
			BufferedReader lectorDelHijo = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
			PrintStream escritorEnHijo = new PrintStream(hijo.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			boolean codigoValido = false;
			String codigo = "";
			while(!(codigo.equals("0000"))) {
		
				codigo = Teclado.leerCadena("¿Código? ");
				codigoValido = esValido(codigo);
				if(!codigoValido)
					System.err.println("Código no válido.");
				else {
					escritorEnHijo.println(codigo);
					escritorEnHijo.flush(); // Asegura que los datos se han enviado
					if((line = lectorDelHijo.readLine()) != null) {
						System.out.println(line);
						referencia = line.substring(4);
						System.out.println(referencia);
						if(referencia.equals("1"))
							contadorRef1++;
						else if(referencia.equals("2"))
							contadorRef2++;
						else if(referencia.equals("3"))
							contadorRef3++;
						else
							contadorRef9++;
					}
				}
				
			}
			System.out.println("Resumen resultados:");
			System.out.println("Códigos con REF01: " + contadorRef1 + "\nCódigos con REF02: " + contadorRef2 + 
					"\nCódigos con REF03: " + contadorRef3 + "\nCódigos con REF09: " + contadorRef9);
			in.close();
			hijo.destroy();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	
	public static boolean esValido(String codigo) {
		if(codigo.length() != 4)
			return false;
		else if(!codigo.equals("0000")) {
			String cadena1 = codigo.substring(0, 1);
			int cadena2 = Integer.parseInt(codigo.substring(1, 3));
			int cadena3 = Integer.parseInt(codigo.substring(3));
			if(!(cadena1.equals("A") || cadena1.equals("B"))) 
				return false;
			else if(cadena2 < 0 || cadena2 > 19)
				return false;
			else if(cadena3 != 9)
				return false;
			else
				return true;
		}
		else
			return true;
	}
	// AÑADIDO DURANTE LA CORRECCIÓN
	public static boolean esValido2(String codigo) {
		//Mejor con expresión irregular. No me da tiempo a cogerlo ;-;
		return codigo.matches("[AB]");
	}
}

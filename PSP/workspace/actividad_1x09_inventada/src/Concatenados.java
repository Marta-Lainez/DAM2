import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Concatenados {
	/*
	 * La clase padre pide 2 strings. La clase hija las concatena y las devuelve. El ejercicio funciona 1 VEZ.
	 */
	public static void main(String[] args) {
		String line;
		Runtime runtime = Runtime.getRuntime();
		try {
			Process hijo = runtime.exec("java Concatena_cadenas", null, new File(".\\bin"));
			BufferedReader lectorDelHijo = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
			PrintStream escritorEnHijo = new PrintStream(hijo.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Escribe cadena 1: ");
			String cadena1 = in.readLine();
			System.out.print("Escribe cadena 2: ");
			String cadena2 = in.readLine();
			
			escritorEnHijo.println(cadena1);
			escritorEnHijo.flush(); // Asegura que los datos se han enviado
			escritorEnHijo.println(cadena2);
			escritorEnHijo.flush();
			if((line = lectorDelHijo.readLine()) != null) {
				System.out.println(line);
			}
			in.close();
			hijo.destroy();
			System.out.println("Finalizado");
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}


	}

}

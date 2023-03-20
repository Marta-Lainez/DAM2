

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Suma {
	/*
	 * Proceso padre que manda un solo numero al proceso hijo. El proceso hijo (Suma5) suma 5 a cualquier numero
	 * enviado por el proceso padre y devuelve el numero  + 5
	 */
	public static void main(String[] args) {
		String line;
		Runtime runtime = Runtime.getRuntime();
		try {
			Process hijo = runtime.exec("java Suma5", null, new File(".\\bin"));
			BufferedReader lectorDelHijo = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
			PrintStream escritorEnHijo = new PrintStream(hijo.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Escribe un numero entero: ");
			int dato = Integer.parseInt(in.readLine());
			escritorEnHijo.println(dato);
			escritorEnHijo.flush(); // Asegura que los datos se han enviado
			line = lectorDelHijo.readLine();
			if(line != null) {
				System.out.println(line);
				line = lectorDelHijo.readLine();
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

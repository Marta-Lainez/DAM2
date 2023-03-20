package actividad_1x01;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Aleatorios {
	public static void main(String[] args) {
		String line;
		File directorio = new File(".\\bin"); //Se indica el directorio en el que está
		ProcessBuilder pb = new ProcessBuilder("java", "GeneraAleatorio");
		pb.directory(directorio);
		try {
			Process hijo = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
			PrintStream ps = new PrintStream(hijo.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Escribe una linea: ");
			String linea = in.readLine();
			while(!linea.equals("fin")) {
				ps.println(""); // No es necesario escribir nada
				ps.flush(); // Asegura que los datos se han enviado
				if((line = br.readLine()) != null) {
					System.out.println(line);
				}
				System.out.println("Escribe una linea: ");
				linea = in.readLine(); // se hace de nuevo porque el otro esta fuera del bucle
			}
			hijo.destroy();
			System.out.println("Finalizado");
			
		}
		catch (IOException ex){
			System.out.println("Error cocurrió durante la ejecución");
		}
	}
}

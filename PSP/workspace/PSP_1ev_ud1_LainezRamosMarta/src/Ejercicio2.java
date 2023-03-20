import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Ejercicio2 {

	public static void main(String[] args) {
		String line;
		File directorio = new File(".\\bin"); //Se indica el directorio en el que está
		ProcessBuilder pb = new ProcessBuilder("java", "MultiploDivisor");
		pb.directory(directorio);
		try {
			Process hijo = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
			PrintStream ps = new PrintStream(hijo.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Escribe numero 1: ");
			int numero1 = Integer.parseInt(in.readLine());
			System.out.println("Escribe numero 2: ");
			int numero2 = Integer.parseInt(in.readLine());
			ps.println(numero1);
			ps.flush(); // Asegura que los datos se han enviado
			ps.println(numero2);
			ps.flush(); // Asegura que los datos se han enviado
			
			if((line = br.readLine()) != null) {
				System.out.println(line);
			}
			in.close();
			hijo.destroy();
			
		}
		catch(NumberFormatException nfe) {
			System.out.println("El dato no es correcto");
		}
		catch (IOException ex){
			System.out.println(ex);
			System.out.println("Error cocurrió durante la ejecución");
		}

	}

}

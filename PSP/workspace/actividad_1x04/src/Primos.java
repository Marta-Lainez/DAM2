import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Primos {

	public static void main(String[] args) {
		String line;
		File directorio = new File(".\\bin"); //Se indica el directorio en el que está
		ProcessBuilder pb = new ProcessBuilder("java", "CalculaPrimos");
		pb.directory(directorio);
		try {
			Process hijo = pb.start();
			BufferedReader lectorDelHijo = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
			PrintStream escritorEnHijo = new PrintStream(hijo.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Escribe un numero entero: ");
			int dato = Integer.parseInt(in.readLine());
			
			if(dato < 1)
				throw new NumberFormatException();
			escritorEnHijo.println(dato);
			escritorEnHijo.flush(); // Asegura que los datos se han enviado
			line = lectorDelHijo.readLine();
			while(line != null) { // While para que imprima mas de un dato en la misma vuelta del proceso
				System.out.println(line);
				line = lectorDelHijo.readLine();
			}
			in.close();
			hijo.destroy();
			System.out.println("Finalizado");
		}
		catch (NumberFormatException nfe) {
			System.err.println("Dato introducido no valido");
		}
		catch (IOException ex){
			System.out.println("Error cocurrió durante la ejecución");
		}
	}

}

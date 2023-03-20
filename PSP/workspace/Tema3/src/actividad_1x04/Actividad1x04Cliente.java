package actividad_1x04;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Actividad1x04Cliente {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String host = "localhost"; 
		int puerto = 60000;// puerto remoto 
		Socket cliente = new Socket(host, puerto); 
		
		// Se crea flujo de salida al servidor
		PrintWriter fsalida = new PrintWriter (cliente.getOutputStream(), true); 
		
		// Se crea flujo de entrada del servidor
		BufferedReader fentrada = new BufferedReader (new InputStreamReader(cliente.getInputStream())); 
		
		// Se crea flujo de entrada estándar (teclado)
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in)); 
	
		BufferedReader flujoEntrada = null;
		try {
			File fichero = new File("data\\ejercicio4.txt");
			flujoEntrada = new BufferedReader(new FileReader(fichero));
      		String linea = flujoEntrada.readLine(); 
      		while (linea != null) { 	
      			System.out.println(linea);
      			linea = flujoEntrada.readLine();
      		}
		}
		catch (FileNotFoundException fnfe) {                      
			System.out.println("Error al abrir el fichero:");
			System.out.println(fnfe.getMessage());
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			System.out.println("Error al leer del fichero:");
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
		catch (NumberFormatException nfe) {
			System.out.println("Error al convertir de cadena a número:");
			System.out.println(nfe.getMessage());
			nfe.printStackTrace();
		}
		finally {
			try {
				if (flujoEntrada != null) {
					flujoEntrada.close();
				}
			}
			catch (IOException ioe) {
				System.out.println("Error al cerrar el fichero:");
				System.out.println(ioe.getMessage());
				ioe.printStackTrace();
			}
		}
		
		// Se cierran flujos y sockets
		fsalida.close(); 
		fentrada.close(); 
		System.out.println("Fin del envío... "); 
		in.close(); 
		cliente.close(); 
		
	}

}

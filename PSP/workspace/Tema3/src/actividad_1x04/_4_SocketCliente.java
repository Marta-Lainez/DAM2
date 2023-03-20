package actividad_1x04;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import entrada.Teclado;

public class _4_SocketCliente {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String host = "localhost"; 
		int puerto = 60000;// puerto remoto 
		Socket cliente = new Socket(host, puerto); 
		
		// Se crea flujo de salida al servidor
		DataOutputStream fsalida = new DataOutputStream(cliente.getOutputStream()); 
		
		// Se crea flujo de entrada del servidor
		BufferedReader fentrada = new BufferedReader (new InputStreamReader(cliente.getInputStream())); 
		
		BufferedReader flujoEntradaFichero = null;
		try {
			File fichero = new File("data\\archivo.txt");
			flujoEntradaFichero = new BufferedReader(new FileReader(fichero));
      		String linea = flujoEntradaFichero.readLine();
      		do {
      			System.out.println("Leyendo: " + linea);
      			fsalida.writeUTF(linea);
      		}while((linea = flujoEntradaFichero.readLine()) != null);
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
				if (flujoEntradaFichero != null) {
					flujoEntradaFichero.close();
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
		cliente.close(); 
		
	}

}

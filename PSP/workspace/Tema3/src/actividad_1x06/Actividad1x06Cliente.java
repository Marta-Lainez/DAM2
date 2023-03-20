package actividad_1x06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Actividad1x06Cliente {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String host = "localhost"; 
		int puerto = 60000;// puerto remoto 
		Socket cliente = new Socket(host, puerto); 

		// Se crea flujo de entrada del servidor
		BufferedReader fentrada = new BufferedReader (new InputStreamReader(cliente.getInputStream())); 

		// Se crea flujo de entrada estándar (teclado)
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in)); 
		String eco=""; 

		eco=fentrada.readLine(); // cadena del servidor 
		System.out.println(eco); 

		// Se cierran flujos y sockets
		fentrada.close(); 
		System.out.println("Fin del envío... "); 
		in.close(); 
		cliente.close(); 
	}

}

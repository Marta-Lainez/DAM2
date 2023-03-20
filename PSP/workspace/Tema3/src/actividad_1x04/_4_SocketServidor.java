package actividad_1x04;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class _4_SocketServidor {

	public static void main(String[] args) throws IOException {
		int numeroPuerto = 60000;// Puerto 
		ServerSocket servidor = new ServerSocket(numeroPuerto); 
		
		System.out.println("Esperando Conexión..."); 
		Socket cliente = servidor.accept(); 
		System.out.println("Cliente conectado..."); 
		
		// Se crea flujo de salida al cliente
		DataOutputStream fsalida = new DataOutputStream (cliente.getOutputStream()); 
		
		// Se crea flujo de entrada del cliente
		DataInputStream fentrada =  new DataInputStream(cliente.getInputStream()); 
		do{ 
			String linea = fentrada.readUTF();
			System.out.println("Recibiendo: " + linea); 	
		} while (fentrada.available() > 0);//recibo la siguiente linea del cliente 
		
		// Se cierran flujos y sockets
		System.out.println("Cerrando conexión..."); 
		fentrada.close(); 
		fsalida.close(); 
		cliente.close(); 
		servidor.close(); 	}

}

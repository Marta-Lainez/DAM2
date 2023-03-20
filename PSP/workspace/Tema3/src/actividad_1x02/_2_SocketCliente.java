package actividad_1x02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import entrada.Teclado;

public class _2_SocketCliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String host = "localhost"; 
		int puerto = 60000;//puerto remoto 
		
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		Socket cliente = new Socket(host, puerto); 
		
		// Se crea flujo de salida al servidor
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream()); 
				
		// Se envía un mensaje al servidor 
		String mensaje = Teclado.leerCadena("Mensaje para servidor: ");
		flujoSalida.writeUTF(mensaje); 
				
		// Se crea flujo de entrada del servidor
		DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream()); 
				
		// Se recibe mensaje enviado del servidor   
		System.out.println("Recibiendo del SERVIDOR: \n\t" + flujoEntrada.readUTF()); 
				
		// Se cierran flujos y sockets
		flujoEntrada.close(); 
		flujoSalida.close(); 
		cliente.close(); 
		
		
		cliente.close();// Cierra el socket

	}

}

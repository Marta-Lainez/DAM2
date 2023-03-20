package _02.tcp.ejemplo1;


import java.io.*; 
import java.net.*;

public class EjemploCliente { 
	
	public static void main(String[] args) throws Exception { 
		
		String host = "localhost"; 
		int puerto = 60000;//puerto remoto 
		
		System.out.println("PROGRAMA CLIENTE INICIADO...."); 
		Socket cliente = new Socket(host, puerto); 
		
		// Se crea flujo de salida al servidor
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream()); 
		
		// Se envía un mensaje al servidor 
		flujoSalida.writeUTF("Saludos al SERVIDOR DESDE EL CLIENTE"); 
		
		// Se crea flujo de entrada del servidor
		DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream()); 
		
		// Se recibe mensaje enviado del servidor   
		System.out.println("Recibiendo del SERVIDOR: \n\t" + flujoEntrada.readUTF()); 
		
		// Se cierran flujos y sockets
		flujoEntrada.close(); 
		flujoSalida.close(); 
		cliente.close(); 
		
	}// fin de main 
	
}// Fin de Ejemplo1Cliente
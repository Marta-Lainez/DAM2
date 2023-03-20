package _02.tcp.ejemplo1;


import java.io.*;
import java.net.*; 

public class EjemploServidor { 
	
	public static void main(String[] arg) throws IOException { 
		
		int numeroPuerto = 60000;// Puerto 
		ServerSocket servidor = new ServerSocket(numeroPuerto); 
		Socket clienteConectado = null; 
		System.out.println("Esperando al cliente....."); 
		clienteConectado = servidor.accept(); 
		
		// Se crea flujo de entrada   
		InputStream entrada = null; 
		entrada = clienteConectado.getInputStream(); 
		DataInputStream flujoEntrada = new DataInputStream(entrada); 
		
		// Recepción de mensaje del cliente
		System.out.println("Recibiendo del CLIENTE: \n\t" + flujoEntrada.readUTF()); 
		
		// Se crea flujo de salida
		OutputStream salida = null; 
		salida = clienteConectado.getOutputStream(); 
		DataOutputStream flujoSalida = new DataOutputStream(salida); 
		
		// Se envía un mensaje al cliente
		flujoSalida.writeUTF("Saludos al cliente del servidor"); 
		
		// Se cierran flujos y sockets
		entrada.close(); 
		flujoEntrada.close(); 
		salida.close(); 
		flujoSalida.close();
		clienteConectado.close(); 
		servidor.close(); 
		
	}// main 
	
}// fin de Ejemplo1Servidor
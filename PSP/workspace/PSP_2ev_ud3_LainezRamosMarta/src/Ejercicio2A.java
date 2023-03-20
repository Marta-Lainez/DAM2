import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import entrada.Teclado;

public class Ejercicio2A {

	public static void main(String[] args) {
		DatagramSocket clientSocket = null;
		InetAddress IPServidor = null;
		try {
			clientSocket = new DatagramSocket(); //socket cliente    			
			byte[] enviados = new byte[8]; 
			byte[] recibidos = new byte[8]; 
					
			// Datos del servidor

			IPServidor = InetAddress.getLocalHost();
			
			// localhost 
			int puerto = 55000; // puerto por el que escucha 
					 
			// Se solicitan el número por teclado
			boolean correcto = false;
			int numero = -1;
			String cadena;
			do {
				cadena = Teclado.leerCadena("Indica clave: ");
				try {
					numero = Integer.parseInt(cadena);
					if(cadena.length() == 8 && numero >= 0 && numero < 100000000) //cadena.matches("[0-9]{8}")
						correcto = true;
					else
						System.out.println("Clave no válida.");
				}
				catch(NumberFormatException nfe) {
					System.out.println("Clave no válida.");
				}
				
			}while(!correcto);
			
			enviados = cadena.getBytes(); 
					
			// Se envía el datagrama al servidor
			DatagramPacket envio = new DatagramPacket (enviados, enviados.length, IPServidor, puerto); 
			
			clientSocket.send(envio);
			
			// Se recibe el datagrama del servidor
			DatagramPacket recibo = new DatagramPacket (recibidos, recibidos.length); 
			clientSocket.receive(recibo); 		
			
			String invertido = new String(recibo.getData()); 
					
			// Se obtiene información del datagrama
			InetAddress IPOrigen = recibo.getAddress(); 
			int puertoOrigen = recibo.getPort();				
			System.out.println("Respuesta: " + invertido.trim()); 
		}
		catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			if(clientSocket != null) {
				//cerrar socket			
				clientSocket.close();
			}
		}

	}

}

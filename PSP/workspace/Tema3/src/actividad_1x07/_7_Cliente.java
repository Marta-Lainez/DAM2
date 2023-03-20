package actividad_1x07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import entrada.Teclado;

public class _7_Cliente {

	public static void main(String[] args){
			
		DatagramSocket clientSocket = null;
		InetAddress IPServidor = null;
		try {
			clientSocket = new DatagramSocket();//socket cliente    			
			byte[] enviados = new byte[1024]; 
			byte[] recibidos = new byte[1024]; 
					
			// Datos del servidor
		
			IPServidor = InetAddress.getLocalHost();
			
			// localhost 
			int puerto = 55000; // puerto por el que escucha 
					 
			// Se solicitan los datos por teclado
			String cadena = Teclado.leerCadena("Introduce mensaje: ");
			enviados = cadena.getBytes(); 
					
			// Se envía el datagrama al servidor
			System.out.println("Enviando " + enviados.length + " bytes al servidor.");
			DatagramPacket envio = new DatagramPacket (enviados, enviados.length, IPServidor, puerto); 
			
			clientSocket.send(envio);
			
			// Se recibe el datagrama del servidor
			DatagramPacket recibo = new DatagramPacket (recibidos, recibidos.length); 
			System.out.println("Esperando datagrama...."); 
			clientSocket.receive(recibo); 				String mayuscula = new String(recibo.getData()); 
					
			// Se obtiene información del datagrama
			InetAddress IPOrigen = recibo.getAddress(); 
			int puertoOrigen = recibo.getPort(); 
			System.out.println("\tProcedente de: " + IPOrigen + ":" + puertoOrigen); 				
			System.out.println("\tDatos: " + mayuscula.trim()); 
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

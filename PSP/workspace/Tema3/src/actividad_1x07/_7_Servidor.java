package actividad_1x07;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class _7_Servidor {

	public static void main(String[] args){
		byte[] bufer = new byte[1024];//bufer para recibir el datagrama 
				
		//Puerto por el que escucha el servidor: 55000 
		DatagramSocket serverSocket = null;
		
		try {
			serverSocket = new DatagramSocket(55000);
			
			byte[] recibidos = new byte[1024]; 
			byte[] enviados = new byte[1024]; 
			String cadena; 
					
			while(true) { 
				System.out.println ("Esperando datagrama....."); 
						
				//Ser recibe datagrama
				recibidos = new byte[1024]; 
				DatagramPacket paqRecibido = new DatagramPacket (recibidos, recibidos.length);
				serverSocket.receive(paqRecibido); 
				cadena = new String(paqRecibido.getData()); 
						
				//Dirección de origan
				InetAddress IPOrigen = paqRecibido.getAddress(); 
				int puerto = paqRecibido.getPort(); 
				System.out.println ("\tOrigen: " + IPOrigen + ":" + puerto); 
				System.out.println ("\tMensaje recibido: " + cadena.trim()); 
						
				//Se comprueba si contiene "Hola"
						
				if(cadena.toLowerCase().contains("hola")) {
					enviados = "“¿Qué tal?".getBytes();
				}
				else {
					enviados = "Rude".getBytes();
				}
						 
						
				//Se envía el datagrama al cliente
				DatagramPacket paqEnviado = new DatagramPacket (enviados, enviados.length, IPOrigen, puerto); 
				serverSocket.send(paqEnviado); 
						
				//Para terminar 
				if(cadena.trim().equals("*")) break;
				System.out.println ("Socket cerrado..."); 
						
			}//Fin de while
		}
		catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			if(serverSocket != null) {
				serverSocket.close();
			}
			
		}
	}
}

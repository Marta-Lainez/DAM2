import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Ejercicio2B {

	public static void main(String[] args) {
		byte[] bufer = new byte[8];//bufer para recibir el datagrama 
		
		//Puerto por el que escucha el servidor: 55000 
		DatagramSocket serverSocket = null;
		
		try {
			serverSocket = new DatagramSocket(55000);
			
			byte[] recibidos;
			byte[] enviados = new byte[8]; 
			String cadena; 
					
			while(true) { 
						
				//Se recibe datagrama
				recibidos = new byte[8]; 
				DatagramPacket paqRecibido = new DatagramPacket (recibidos, recibidos.length);
				serverSocket.receive(paqRecibido); 
				cadena = new String(paqRecibido.getData()); 
						
				//Dirección de origan
				InetAddress IPOrigen = paqRecibido.getAddress(); 
				int puerto = paqRecibido.getPort(); 
						
				//Se transforma la clave al revés
				String revertida = "";
				for(int i = cadena.length()-1; i >= 0; i--) {
					char letra = cadena.charAt(i);
					revertida += letra;
				}
				enviados = revertida.getBytes();		 
						
				//Se envía el datagrama al cliente
				DatagramPacket paqEnviado = new DatagramPacket (enviados, enviados.length, IPOrigen, puerto); 
				serverSocket.send(paqEnviado); 
						
						
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

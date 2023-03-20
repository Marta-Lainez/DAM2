package actividad_1x03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class _3_SocketServidor {

	public static void main(String[] args) throws IOException {
		int puerto = 60000;// Puerto 
		ServerSocket servidor=null;
		
		servidor = new ServerSocket(puerto);
				
		System.out.println("Escuchando en " + servidor.getLocalPort());
		
		Socket cliente = servidor.accept();//esperando a un cliente 
		
		//realizar acciones con cliente
		
		// Se crea flujo de entrada del cliente
		DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream()); 
		
		// Se recibe mensaje enviado del servidor 
		int numeroEntero = flujoEntrada.readInt();
		
		  
		System.out.println("Recibiendo del Cliente: \n\t" + numeroEntero); 
		
		// Se crea flujo de salida al servidor
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
		
		// Se envía un mensaje al servidor 
		flujoSalida.writeInt(numeroEntero * numeroEntero);
		
		servidor.close(); //cierro socket servidor
	}

}

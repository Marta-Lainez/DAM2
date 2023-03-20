package actividad_1x03;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import entrada.Teclado;

public class Actividad1x03Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		String host = "localhost"; 
		int puerto = 60000;//puerto remoto 
		
		System.out.println("PROGRAMA CLIENTE INICIADO...."); 
		Socket cliente = new Socket(host, puerto); 
		
		// Se crea flujo de salida al servidor
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream()); 
		
		// Se envía un mensaje al servidor 
		int numero=Teclado.leerEntero("Dime un numero: ");
		flujoSalida.writeInt(numero); 
		
		// Se crea flujo de entrada del servidor
		DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream()); 
		
		// Se recibe mensaje enviado del servidor   
		System.out.println("Recibiendo del SERVIDOR: \n\t" + flujoEntrada.readInt()); 
		
		// Se cierran flujos y sockets
		flujoEntrada.close(); 
		flujoSalida.close(); 
		cliente.close(); 

	}

}

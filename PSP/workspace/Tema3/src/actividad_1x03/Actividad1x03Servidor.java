package actividad_1x03;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Actividad1x03Servidor {

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
		int recibido=flujoEntrada.readInt();
		System.out.println("Recibiendo del CLIENTE: \n\t" + recibido); 
		
		// Se crea flujo de salida
		OutputStream salida = null; 
		salida = clienteConectado.getOutputStream(); 
		DataOutputStream flujoSalida = new DataOutputStream(salida); 
		
		// Se envía un mensaje al cliente
		flujoSalida.writeInt(recibido*recibido); 
		
		// Se cierran flujos y sockets
		entrada.close(); 
		flujoEntrada.close(); 
		salida.close(); 
		flujoSalida.close();
		clienteConectado.close(); 
		servidor.close(); 
		
	}// main 
}

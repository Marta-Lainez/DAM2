package actividad_1x05;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Actividad1x05Servidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int numeroPuerto = 60000;// Puerto 
		ServerSocket servidor = new ServerSocket(numeroPuerto); 
		String cad=""; 

		System.out.println("Esperando Conexión..."); 
		Socket c1ienteConectado = servidor.accept(); 
		System.out.println("Cliente conectado..."); 

		// Se crea flujo de salida al cliente
		PrintWriter fsalida = new PrintWriter (c1ienteConectado.getOutputStream(),true); 

		// Se crea flujo de entrada del cliente
		BufferedReader fentrada = new BufferedReader (new InputStreamReader(c1ienteConectado.getInputStream())); 

		cad=fentrada.readLine();//recibo cad del cliente 

		if(cad.equals("¿cómo te llamas?")) {
			fsalida.println("El servidor de Marta devuelve: me llamo ejercicio 5"); //envio cadena al cliente 
		}else if(cad.equals("¿cuántas líneas de código tienes?")) {
			fsalida.println("Muchas"); //envio cadena al cliente 
		}else {
			fsalida.println("No te he entendido"); //envio cadena al cliente 
		}
		fsalida.println("El servidor de david devuelve: "+cad.toUpperCase()); //envio cadena al cliente 
		// Se cierran flujos y sockets
		System.out.println("Cerrando conexión..."); 
		fentrada.close(); 
		fsalida.close(); 
		c1ienteConectado.close(); 
		servidor.close(); 
	}

}

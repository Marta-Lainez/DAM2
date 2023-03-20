import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		String host = "localhost"; 
		int puerto = 60000;// puerto remoto 
		Socket cliente = new Socket(host, puerto); 

		// Se crea flujo de salida al servidor
		PrintWriter fsalida = new PrintWriter (cliente.getOutputStream(), true); 

		// Se crea flujo de entrada del servidor
		BufferedReader fentrada = new BufferedReader (new InputStreamReader(cliente.getInputStream())); 

		// Se crea flujo de entrada estándar (teclado)
		BufferedReader teclado = new BufferedReader (new InputStreamReader(System.in)); 
		String pregunta, respuesta; 
		
		for(int i = 0; i < 3; i++){
			System.out.print("Introduce pregunta: "); 
			pregunta = teclado.readLine();//lectura por teclado 
	
			fsalida.println(pregunta); // cadena al servidor 
			respuesta=fentrada.readLine(); // cadena del servidor 
			System.out.println(respuesta); 
		}
		
		
		// Se cierran flujos y sockets
		fsalida.close(); 
		fentrada.close(); 
		System.out.println("Fin del envío... "); 
		teclado.close(); 
		cliente.close(); 

	}

}

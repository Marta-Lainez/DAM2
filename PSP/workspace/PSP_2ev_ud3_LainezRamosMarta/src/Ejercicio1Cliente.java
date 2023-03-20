import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Ejercicio1Cliente {

	public static void main(String[] args) {
		String host = "localhost"; 
		int puerto = 60000;// puerto remoto 
		Socket cliente = null;
		PrintWriter fsalida = null;
		BufferedReader fentrada = null;
		BufferedReader teclado = null;
		try {
			cliente = new Socket(host, puerto);

			// Se crea flujo de salida al servidor
			fsalida = new PrintWriter (cliente.getOutputStream(), true); 
	
			// Se crea flujo de entrada del servidor
			fentrada = new BufferedReader (new InputStreamReader(cliente.getInputStream())); 
	
			// Se crea flujo de entrada estándar (teclado)
			teclado = new BufferedReader (new InputStreamReader(System.in)); 
			
			String equipos = fentrada.readLine(); // cadena del servidor 
			System.out.println(equipos); 
			String respuesta = teclado.readLine();//lectura por teclado
			// se manda el voto al servidor
			fsalida.println(respuesta); // cadena al servidor
			
			System.out.println("Gracias por tu voto\n -- Recuento --");
			// Imprimir recuento
			
			
			String votos = fentrada.readLine(); // lectura de servidor
			String[] cadenas = votos.split(",");
			for(String s: cadenas) {
				System.out.println(s);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			// Se cierran flujos y sockets
			if(fsalida != null) {
				fsalida.close();
			}
			if(fentrada != null) {
				try {
					fentrada.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(teclado != null) {
				try {
					teclado.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(cliente != null) {
				try {
					cliente.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

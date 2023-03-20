package actividad_1x05;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class _5_SocketServidor {

	public static void main(String[] args) {
		int numeroPuerto = 60000;// Puerto 
		ServerSocket servidor = null;
		DataOutputStream fsalida = null;
		DataInputStream fentrada = null;
		try {
			servidor = new ServerSocket(numeroPuerto); 
			
			System.out.println("Esperando Conexión..."); 
			Socket cliente = null; 
			System.out.println("Cliente conectado..."); 
			do {
				cliente = servidor.accept();
			}while(cliente.isClosed());
			
			// Se crea flujo de salida al cliente
			fsalida = new DataOutputStream (cliente.getOutputStream()); 
			
			// Se crea flujo de entrada del cliente
			fentrada =  new DataInputStream(cliente.getInputStream()); 
			
			String pregunta = "";
			do {
				pregunta = fentrada.readUTF();
				switch (pregunta) {
					case "¿como te llamas?":
						fsalida.writeUTF("Me llamo ejercicio 3");
						break;
					case "¿cuantas lineas de codigo tienes?":
						fsalida.writeUTF("Tengo 78 lineas de codigo");
						break;
					case "?":
						fsalida.writeUTF("Programa finalizado");
						break;
					default:
						fsalida.writeUTF("no he entendido la pregunta");
				}
					
			}while(!(pregunta.equals("?")));
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(servidor != null) {
				try {
					servidor.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fentrada != null) {
				try {
					fentrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fsalida != null) {
				try {
					fsalida.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
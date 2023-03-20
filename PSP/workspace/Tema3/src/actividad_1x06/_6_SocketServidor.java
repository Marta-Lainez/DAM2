package actividad_1x06;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class _6_SocketServidor {

	public static void main(String[] args) {
		int numeroPuerto = 60000;// Puerto 
		ServerSocket servidor = null;
		DataOutputStream fsalida = null;
		DataInputStream fentrada = null;
		try {
			
			servidor = new ServerSocket(numeroPuerto); 
			
			System.out.println("Esperando Conexión..."); 
			int contador = 1;
			 
			do {
				Socket cliente = servidor.accept();
				System.out.println("Cliente número " + contador + " conectado...");
				// Se crea flujo de salida al cliente
				fsalida = new DataOutputStream (cliente.getOutputStream());
				System.out.println("Cliente número " + contador + " desconectado...");
				fsalida.writeInt(contador++);
			}while(true);
			
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
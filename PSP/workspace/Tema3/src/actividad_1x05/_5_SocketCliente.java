package actividad_1x05;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import entrada.Teclado;

public class _5_SocketCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host = "localhost"; 
		int puerto = 60000;// puerto remoto 
		Socket cliente = null;
		DataOutputStream flujoSalida = null;
		DataInputStream flujoEntrada = null;
		try {
			cliente = new Socket(host, puerto); 
			
			// Se crea flujo de salida al servidor
			flujoSalida = new DataOutputStream(cliente.getOutputStream()); 
			
			// Se crea flujo de entrada del servidor
			flujoEntrada = new DataInputStream(cliente.getInputStream());
			
			// Se envía un mensaje al servidor 
			String mensaje = "";
			do {
				mensaje = Teclado.leerCadena("Mensaje para servidor: ");
				flujoSalida.writeUTF(mensaje); 
				System.out.println(flujoEntrada.readUTF());
			}while(!(mensaje.equals("?")));
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(cliente != null) {
				try {
					cliente.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(flujoSalida != null) {
				try {
					flujoSalida.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(flujoEntrada != null) {
				try {
					flujoEntrada.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}
}

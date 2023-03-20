package actividad_1x06;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class _6_SocketCliente {

	public static void main(String[] args) {
		String host = "localhost"; 
		int puertoRemoto = 60000;//puerto remoto 
		DataInputStream flujoEntrada = null;
		// ABRIR SOCKET 
		Socket cliente = null;
		try {
			cliente = new Socket(host, puertoRemoto);
			System.out.println("Conectado a servidor");
			// Se crea flujo de entrada del servidor
			flujoEntrada = new DataInputStream(cliente.getInputStream());
			System.out.println("Cliente número: " + flujoEntrada.readInt());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//conecta
		finally {
			if(cliente != null) {
				try {
					cliente.close();
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

package actividad_1x06;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Actividad1x06Servidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int numeroPuerto = 60000;// Puerto 
		ServerSocket servidor = new ServerSocket(numeroPuerto); 
		String cad=""; 

		System.out.println("Esperando Conexión..."); 
		try {
			int numConexiones=0;
			while(true) {
				Socket c1ienteConectado = servidor.accept(); 
				numConexiones++;
				System.out.println("Cliente conectado..."); 
	
				// Se crea flujo de salida al cliente
				PrintWriter fsalida = new PrintWriter (c1ienteConectado.getOutputStream(),true); 
	
				fsalida.println("Has sido la conexion: "+numConexiones); //envio cadena al cliente 
				c1ienteConectado.close(); 
			} 
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		finally {
			servidor.close();
		}
		
	}

}

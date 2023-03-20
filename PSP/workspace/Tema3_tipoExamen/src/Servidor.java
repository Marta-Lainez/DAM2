import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args){
		int numeroPuerto = 60000;// Puerto 
		ServerSocket servidor = null;
		int contador = 0;
		try {
			servidor = new ServerSocket(numeroPuerto);
			
			while(true) {
				Socket cliente = servidor.accept();
				System.out.println("Cliente conectado " + ++contador);
				Hilo hiloCliente = new Hilo(cliente, contador);
				hiloCliente.start();
			}
		}
		catch(IOException ioe) {
			ioe.toString();
		}
		finally {
			if(servidor != null) {
				try {
					servidor.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}

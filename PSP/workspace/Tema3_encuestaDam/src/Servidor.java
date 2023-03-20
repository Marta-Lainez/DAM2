import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
	public static void main(String[] args){
		int numeroPuerto = 60000;// Puerto 
		ServerSocket servidor = null;
		int contador = 0;
		List <Alumno> listaAlumnos = new ArrayList<>();
		try {
			servidor = new ServerSocket(numeroPuerto);
			while(true) {
				Socket cliente = servidor.accept();
				System.out.println("Cliente conectado " + ++contador);
				Hilo hiloCliente = new Hilo(cliente, contador, listaAlumnos);
				hiloCliente.start();
				
				System.out.println("desde servidor lista edades : " + listaAlumnos);
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
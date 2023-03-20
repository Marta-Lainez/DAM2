import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import entrada.Teclado;

public class Ejercicio1Servidor {

	public static void main(String[] args) {
		int numeroPuerto = 60000;// Puerto 
		ServerSocket servidor = null;
		int contador = 0;
		List <String> listaEquipos = new ArrayList<>();
		List <Integer> listaVotos = new ArrayList<>();
		try {
			servidor = new ServerSocket(numeroPuerto);
			
			// Pregunta por la cantidad de equipos que hay
			int numEquipos = Teclado.leerEntero("¿Cantidad de equipos? ");
			
			// Pregunta por x nombre de equipos
			for(int i = 1; i <= numEquipos; i++) {
				String nombre = Teclado.leerCadena("¿Nombre equipo " + i + "? ");
				listaEquipos.add(nombre);
				listaVotos.add(0);
			}
			System.out.println("Esperando votaciones...");
			while(true) {
				Socket cliente = servidor.accept();
				
				Hilo hiloCliente = new Hilo(cliente, listaEquipos, listaVotos);
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

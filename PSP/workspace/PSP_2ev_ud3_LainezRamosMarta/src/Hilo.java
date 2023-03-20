import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import entrada.Teclado;

public class Hilo extends Thread{
	private Socket cliente;

	private List <String> listaEquipos;
	private List <Integer> listaVotos;
	
	public Hilo(Socket cliente, List <String> listaEquipos, List <Integer> listaVotos) {
		this.cliente = cliente;
		this.listaEquipos = listaEquipos;
		this.listaVotos = listaVotos;
	}
	@Override
	public void run() {
		
		PrintWriter fsalida = null;
		BufferedReader fentrada = null;
		
		try {
			// Se crea flujo de salida al servidor
			fsalida = new PrintWriter (cliente.getOutputStream(), true);
			// Se crea flujo de entrada del servidor
			fentrada = new BufferedReader (new InputStreamReader(cliente.getInputStream()));
			
			
			fsalida.println("Indica nombre de equipo (" + listaEquipos + ")");
			String respuesta = fentrada.readLine(); // lectura desde cliente
			
			int posicion = 0;
			if(listaEquipos.contains(respuesta)) {
				
				for(String equipo: listaEquipos) {
					if(equipo.equals(respuesta)) {
						listaVotos.set(posicion, listaVotos.get(posicion)+1);
					}
					posicion++; 
				}
			}	
			String votos = "";
			for(int i = 0; i < listaEquipos.size(); i++) {
				votos += listaEquipos.get(i) + ": " + listaVotos.get(i) + " votos,";
			}
			fsalida.println(votos);
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		finally {
			if(fsalida != null)
				fsalida.close();
			if(fentrada != null) {
				try {
					fentrada.close();
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


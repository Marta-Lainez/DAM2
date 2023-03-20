import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Hilo extends Thread{
	private Socket cliente;
	private int numero;
	private List <Integer> listaEdades;
	int edad;
	
	public Hilo(Socket cliente, int numero, List <Integer> listaEdades) {
		this.cliente = cliente;
		this.numero = numero;
		this.listaEdades = listaEdades;
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
			
			for(int i = 1; i <= 4; i++) {
				String pregunta = pregunta(i);
				fsalida.println("Pregunta número " + i + ": " + pregunta);
				System.out.println("Cliente número " + numero + " pregunta " + i);
				
				String respuesta = fentrada.readLine(); // lectura desde cliente
				System.out.println("Respuesta de cliente número " + numero + ": " + respuesta);
				if(i == 1) {
					edad = Integer.parseInt(respuesta);
					
				}					
			}
			listaEdades.add(edad);
			System.out.println("Edad: " + edad);
			System.out.println(listaEdades);
			
			double edadTotal = 0;
			for(Integer edades: listaEdades) {
				edadTotal += edades;
			}
			System.out.println("Edad total: " + edadTotal);
			System.out.println("Tamaño lista: " + listaEdades.size());
			fsalida.println("Edad media de los clientes: " + edadTotal / listaEdades.size());
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
	private String pregunta(int i) {
		if(i == 1) {
			return "¿Cuántos años tienes?";
		}
		else if(i == 2) {
			return "¿Cómo te llamas?";
		}
		else if(i == 3) {
			return "¿Eres chico o chica?";
		}
		else 
			return "¿Tienes hermanos?";
	}
}


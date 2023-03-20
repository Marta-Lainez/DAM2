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
	private List <Alumno> listaAlumnos;
	
	public Hilo(Socket cliente, int numero, List <Alumno> listaAlumnos) {
		this.cliente = cliente;
		this.numero = numero;
		this.listaAlumnos = listaAlumnos;
	}
	@Override
	public void run() {
		String nombre = "-";
		int edad = 0;
		String grado = "-";
		int curso = 0;
		Alumno alumno;
		
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
				if(i == 1) 
					nombre = respuesta;
				else if( i == 2)
					edad = Integer.parseInt(respuesta);
				else if (i == 3)
					grado = respuesta;
				else {
					curso = Integer.parseInt(respuesta);
				}
			}
			alumno = new Alumno(nombre, edad, grado, curso);
			listaAlumnos.add(alumno);
			
			fsalida.println(listaAlumnos);
			
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
			return "¿Cómo te llamas?";
		}
		else if(i == 2) {
			return "¿Cuántos años tienes?";
		}
		else if(i == 3) {
			return "¿En qué grado estás?";
		}
		else 
			return "¿En qué curso estás?";
	}
}


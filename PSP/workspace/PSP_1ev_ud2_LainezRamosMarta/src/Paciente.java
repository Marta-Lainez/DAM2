import java.util.concurrent.Semaphore;

public class Paciente extends Thread{
	private Semaphore atender; // empieza a 0
	private Semaphore salir; // empieza a 0
	private int id;
	
	public Paciente(Semaphore atender, Semaphore salir, int id) {
		this.atender = atender;
		this.salir = salir;
		this.id = id;
	}
	
	public void run() {
		try {
			System.out.println("Paciente " + id + " espera su turno");
			atender.acquire(); // Paciente listo para ser atendido. Suma 1
			System.out.println("Paciente " + id + " entra en consulta");
			salir.acquire(); // espera a poder salir. Resta 1
			System.out.println("Paciente " + id + " saliendo de la consulta del médico");
		}
		catch (InterruptedException e) { 
			System.out.println("Paciente interrumpido");
		}
	}
}

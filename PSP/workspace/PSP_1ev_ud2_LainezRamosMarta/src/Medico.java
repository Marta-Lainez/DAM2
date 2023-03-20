import java.util.Random;
import java.util.concurrent.Semaphore;

public class Medico extends Thread{
	final private int[] TIEMPO_ATENCION = {1100, 1500, 2100, 2500};
	private double tiempoTotal;
	Semaphore atender; // empieza a 0
	Semaphore salir; // empieza a 0
	
	public Medico(Semaphore atender, Semaphore salir) {
		this.atender = atender;
		this.salir = salir;
	}
	
	public void run() {
		try {
			Random random = new Random();
			while(true) { // trabaja indefinidamente
				atender.release(); // espera a tener un cliente. Resta 1
				int esperaPaciente = TIEMPO_ATENCION[random.nextInt(0,4)];
				tiempoTotal += esperaPaciente;
				Thread.sleep(esperaPaciente); // espera un tiempo random
				System.out.println("Tiempo de espera: " + esperaPaciente);
				salir.release(); // sale el cliente. Suma 1
			}
		}
		catch (InterruptedException e) { 
			System.out.println("Médico finaliza consulta. Tiempo total: " + tiempoTotal );
		}
	}
}

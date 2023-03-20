import java.util.Random;
import java.util.concurrent.Semaphore;

public class Frutero extends Thread{
	private int[] tiempoAtencion = {1100, 1500, 2100, 2500};
	private double tiempoTotal;
	private int totalCaja;
	Semaphore atender; // empieza a 0
	Semaphore salir; // empieza a 0
	private int numFrutero;
	public Frutero(Semaphore atender, Semaphore salir, int numFrutero) {
		this.atender = atender;
		this.salir = salir;
		this.numFrutero = numFrutero;
		totalCaja = 0;
	}
	public void run() {
		try {
			Random random = new Random();
			while(true) { // trabaja indefinidamente
				atender.acquire(); // espera a tener un cliente. Resta 1
				int esperaCliente = tiempoAtencion[random.nextInt(0,4)];
				tiempoTotal += esperaCliente;
				Thread.sleep(esperaCliente); // espera un tiempo random
				int cuentaCliente = random.nextInt(1,10);
				totalCaja += cuentaCliente;
				System.out.println("Tiempo de espera: " + esperaCliente + ", cuenta: " + cuentaCliente);
				salir.release(); // sale el cliente. Suma 1
			}
		}
		catch (InterruptedException e) { 
			System.out.println("Frutería cerrada por falta de clientes. Tiempo total: " + tiempoTotal + ". Total caja: " + totalCaja);
		}
	}
	
}

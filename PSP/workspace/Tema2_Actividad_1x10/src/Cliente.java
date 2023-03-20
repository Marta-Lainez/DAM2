import java.util.concurrent.Semaphore;

public class Cliente extends Thread{
	Semaphore atender; // empieza a 0
	Semaphore salir; // empieza a 0
	private int numCliente;
	public Cliente(Semaphore atender, Semaphore salir, int numCliente) {
		this.atender = atender;
		this.salir = salir;
		this.numCliente = numCliente;
	}
	public void run() {
		try {
			System.out.println("Cliente esperando: " + numCliente);
			atender.release(); // cliente listo para ser atendido. Suma 1
			System.out.println("Cliente siendo atendido: " + numCliente);
			salir.acquire(); // espera a poder salir. Resta 1
			System.out.println("Cliente saliendo: " + numCliente);
		}
		catch (InterruptedException e) { 
			System.out.println("Cliente interrumpido");
		}
	}
}

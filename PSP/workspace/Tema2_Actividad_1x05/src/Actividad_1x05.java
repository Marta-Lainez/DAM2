import java.util.concurrent.Semaphore;

public class Actividad_1x05 {
	public static void main(String[] args) throws InterruptedException {

		Semaphore semaforo= new Semaphore(0);
		Saludo hilo1 = new Saludo(semaforo, 1);
		Saludo hilo2 = new Saludo(semaforo, 2);

		hilo1.start();
		hilo2.start(); 

	}

}

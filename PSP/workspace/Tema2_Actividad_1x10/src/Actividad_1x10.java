import java.util.Random;
import java.util.concurrent.Semaphore;

public class Actividad_1x10 {
	public static void main (String[] args) {
		Semaphore atender = new Semaphore(0);
		Semaphore salir = new Semaphore(0);
		Frutero frutero = new Frutero(atender, salir, 1); // Es uno siempre porque solo hay un frutero. En cliente cambia porque hay más de 1 cliente
		frutero.start();
		
		Cliente[] clientes = rellenarClientes(atender,salir);
		hacerJoin(clientes);
		frutero.interrupt();
	}
	public static Cliente[] rellenarClientes(Semaphore atender, Semaphore salir) {
		Random random = new Random();
		Cliente[] clientes = new Cliente[random.nextInt(3,5)];
		for(int i = 0; i < clientes.length; i++) {
			Cliente cliente = new Cliente(atender,salir,i);
			clientes[i] = cliente;
			cliente.start();
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return clientes;
	}
	public static void hacerJoin(Cliente[] clientes) {
		for(Cliente cliente: clientes) {
			try {
				cliente.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

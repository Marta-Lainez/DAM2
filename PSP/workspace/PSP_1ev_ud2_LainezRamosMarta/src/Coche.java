import java.util.Random;

public class Coche extends Thread{
	// Recurso compartido = Turno
	private int id;
	private Turno turno;
	private int tiempoEspera;
	public Coche(int id, Turno turno) {
		this.id = id;
		this.turno = turno;
		Random random = new Random();
		tiempoEspera = random.nextInt(0,1501);
	}
	// Método run
	public void run() {
		try {
			System.out.println(id + " se pone en cola");
			int puesto = turno.entrada(id);
			System.out.println(id + " espera " + tiempoEspera);
			Thread.sleep(tiempoEspera);
			turno.salida(puesto);
			System.out.println(id + " liberando puesto");
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

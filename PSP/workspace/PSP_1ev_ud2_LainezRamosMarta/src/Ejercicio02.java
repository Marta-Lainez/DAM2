import java.time.LocalDateTime;

public class Ejercicio02 {

	public static void main(String[] args) {
		System.out.println("\tEstación abierta " + LocalDateTime.now().toLocalTime());
		int puestos = 2;
		int clientes = 5;
		Turno turno = new Turno(puestos, 1);
		Coche[] coches = rellenarCoches(turno,clientes);
		hacerJoin(coches);
		System.out.println("\tEstación cerrada " + LocalDateTime.now().toLocalTime());
	}
	// Método para crear coches y hacerles start
	public static Coche[] rellenarCoches(Turno turno, int clientes) {
		Coche[] coches = new Coche[clientes];
		for(int i = 0; i < clientes; i++) {
			Coche coche = new Coche(i+1,turno);
			coches[i] = coche;
			coche.start();
			
		}
		return coches;
	}
	// Método para hacer join a los coches
	public static void hacerJoin(Coche[] coches) {
		for(Coche coche: coches) {
			try {
				coche.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Actividad_1x08 {
	static int NUM_PLAZAS = 3;
	static int NUM_COCHES = 6;
	public static void main(String[] args) {
		Barrera barrera = new Barrera(NUM_PLAZAS);
		Coche[] coches = rellenarCoches(barrera);
		
	}
	public static Coche[] rellenarCoches(Barrera barrera) {
		Coche[] coches = new Coche[NUM_COCHES];
		for(int i = 0; i < NUM_COCHES; i++) {
			Coche coche = new Coche(i+1,barrera);
			coches[i] = coche;
			coche.start();
			
		}
		return coches;
	}
}

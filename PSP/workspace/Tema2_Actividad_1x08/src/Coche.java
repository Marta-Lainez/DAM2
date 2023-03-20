import java.util.Random;

public class Coche extends Thread{
	/*
 	Cosa que entra.
 	numero de plaza = posicion del vector
 	
 	recurso compartido= barrera
 */
	private int matricula;
	private Barrera barrera;
	public Coche(int matricula, Barrera barrera) {
		this.matricula = matricula;
		this.barrera = barrera;
	}
	
	public void run() {
		try {
			Random random = new Random();
			Thread.sleep(random.nextInt(100,1000));
			System.out.println("Coche " + matricula + " intenta entrar");
			int plaza = barrera.entrada(matricula);
			System.out.println("Coche " + matricula + " aparca en la plaza " + plaza);
			barrera.mostrar();
			Thread.sleep(random.nextInt(100,1000));
			barrera.salida(plaza);
			System.out.println("Coche " + matricula + " ha salido");
			barrera.mostrar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

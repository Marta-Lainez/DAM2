public class Dato {

	private String cadena;
	private boolean disponible = false; // Para que no puedan hacer 2 veces seguidas un get o un set
	private int turnoSiguiente = 1; // Para saber a qué productor le toca


	// Clase que trata la cadena a la que acceden tanto el productor como el consumidor.
	// El considor a partir del get
	// El productor a partir del set
	public synchronized void get(){
		while(!disponible){
			try{
				wait();
			}
			catch(InterruptedException e){
				System.err.println(e.toString());
			}
		}
		disponible = false;
		System.out.println("Consume: " + cadena);
		notifyAll();

	}

	public synchronized void set (String dia,int turno){
		while(disponible || turnoSiguiente != turno){
			try{
				wait();
			}
			catch(InterruptedException e){
				System.err.println(e.toString());
			}
		}
		turnoSiguiente = turno%7+1;
		
		cadena = dia;
		disponible = true;
		System.out.println("Produce " + cadena);
		notifyAll();
	}
}
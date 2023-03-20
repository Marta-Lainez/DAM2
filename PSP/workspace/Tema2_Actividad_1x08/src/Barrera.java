
public class Barrera {
	/*
	 * Monitor (tendra metodos sincronizados)
	 * entrada,salida y mostrar
	 * 
	 * vector para plazas y atributo auxiliar para ver huecos libres(dato-- cuando entre uno nuevo)
	 * 
	 * entrar=wait
	 * sair= notifyall
	 */
	private int plazas[];
	private int libres;
	
	Barrera(int nPlazas){
		plazas = new int[nPlazas];
		libres=nPlazas;
	}
	synchronized public int entrada(int matriculaCoche) throws InterruptedException{
		while(libres == 0) { // en caso de que no queden plazas libres, espera
			System.out.println("Coche " + matriculaCoche + " esperando");
			wait();
		}
		int plazaLibre = 0; // busca la plaza que esta libre, es decir a 0
		while(plazas[plazaLibre] != 0) {
			plazaLibre++;
		}
		plazas[plazaLibre] = matriculaCoche; // Cambia el valor de 0 de la plaza libre al valor de la matricula que lo ocupa ahora
		libres--;		
		return plazaLibre;
	}
	
	synchronized public void salida (int plaza) {
		plazas[plaza] = 0; // vuelve el valor de la plaza que queda vacia a 0
		libres++;
		notify();
	}
	synchronized public void mostrar() {
		String parking = "";
		for(Integer plaza: plazas) {
			parking += "[" +plaza + "]";
		}
		
		System.out.println(parking);
	}
	
}

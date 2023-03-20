
public class Turno {
	/*
	 * Monitor (tendra metodos sincronizados)
	 * entrada y salida
	 * 
	 * vector para puestos y atributo auxiliar para ver huecos libres(dato-- cuando entre uno nuevo)
	 * 
	 * entrar=wait
	 * sair= notifyall
	 */
	private int puestos[];
	private int libres;
	private int siguiente;
	
	public Turno(int nPlazas,int siguiente) {
		this.siguiente = siguiente;
		this.puestos = new int[nPlazas];
		libres=nPlazas;
	}
	synchronized public int entrada(int idCoche) throws InterruptedException{
		while(libres == 0 || idCoche != siguiente) { // en caso de que no queden plazas libres o no sea el turno, espera
			wait();
		}
		System.out.println("Atendiendo a " + idCoche);
		int puestoLibre = 0; // busca el puesto que esta libre, es decir a 0
		while(puestos[puestoLibre] != 0) {
			puestoLibre++;
		}
		puestos[puestoLibre] = idCoche; // Cambia el valor de 0 del puesto libre al valor del id del coche que lo ocupa ahora
		libres--;
		siguiente++;
		return puestoLibre;
	}
	
	synchronized public void salida (int puesto) {
		puestos[puesto] = 0; // vuelve el valor del puesto que queda vacio a 0
		libres++;
		notify();
	}
}

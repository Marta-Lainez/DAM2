
public class Actividad_1x03 {
	public static void main(String[] args) {
		Dato dato = new Dato();
		Productor p1 = new Productor(dato,1, "Ping");
		Productor p2 = new Productor(dato,2, "Pong");
		Consumidor c = new Consumidor(dato);
		p1.start();
		p2.start();
		c.start();
	}
}
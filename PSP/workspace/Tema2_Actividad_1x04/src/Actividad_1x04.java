
public class Actividad_1x04 {

	public static void main(String[] args) {
		Dato dato = new Dato();
		Productor lunes = new Productor(dato,1, "lunes");
		Productor martes = new Productor(dato,2, "martes");
		Productor miercoles = new Productor(dato,3, "miercoles");
		Productor jueves = new Productor(dato,4, "jueves");
		Productor viernes = new Productor(dato,5, "viernes");
		Productor sabado = new Productor(dato,6, "sabado");
		Productor domingo = new Productor(dato,7, "domingo");
		Consumidor c = new Consumidor(dato);
		lunes.start();
		martes.start();
		miercoles.start();
		jueves.start();
		viernes.start();
		sabado.start();
		domingo.start();
		c.start();
	}

}

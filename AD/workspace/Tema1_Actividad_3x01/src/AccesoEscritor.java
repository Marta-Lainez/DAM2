import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AccesoEscritor {
	public static final String NOMBRE_FICHERO_ESCRITORES = "data/escritores.dat";
	
	public static List<Escritor> leerEscritores() throws IOException, ClassNotFoundException{
		ObjectInputStream flujoEntrada = null;
		List<Escritor> listaEscritores = new ArrayList<>();
		boolean finalFichero = false;
		try {
			flujoEntrada = new ObjectInputStream(new FileInputStream(NOMBRE_FICHERO_ESCRITORES));
			while (!finalFichero) {
				try {
					Escritor escritor = (Escritor) flujoEntrada.readObject();
					listaEscritores.add(escritor);
				}
				catch (EOFException eofe) {	
					finalFichero = true;
				}
			}
		}
		finally {
			if(flujoEntrada != null)
				flujoEntrada.close();	
		}
  		return listaEscritores;
	}
	public static void escribirEscritores(List<Escritor> nuevaLista) throws IOException {
		File fichero = new File(NOMBRE_FICHERO_ESCRITORES);
		List <Escritor> lista = nuevaLista;
		ObjectOutputStream flujoSalida1 = null;
		try {
			flujoSalida1 = new ObjectOutputStream(new FileOutputStream(fichero));
			for(Escritor e: lista) {		
				flujoSalida1.writeObject(e);
			}
		}
		finally {
			if (flujoSalida1 != null) {
				flujoSalida1.close();
			}
		}
	}
	public static Escritor existeEscritor(int código) throws IOException, ClassNotFoundException{
		List <Escritor> lista = leerEscritores();
		for(Escritor e: lista) {
			if(e.getCódigo() == código)
				return e;
		}
		return null;
	}
	public static int numeroEscritores(List <Escritor> lista) {
		return lista.size();
	}
	public static void insertarEscritor(int código, String nombre, String nacimiento, String nacionalidad) throws IOException{
		ObjectOutputStream salidaConCabecera = null; // Escribe cabecera
		MyObjectOutputStream salidaSinCabecera = null; // No escribe cabecera
		try {
			File fichero = new File(NOMBRE_FICHERO_ESCRITORES);
			// Insertar el escritor al final del fichero.
			if (fichero.exists()) {
				salidaSinCabecera = new MyObjectOutputStream(new FileOutputStream(fichero, true));
				salidaSinCabecera.writeObject(new Escritor(código,nombre,nacimiento,nacionalidad));
			}
			// Crear el fichero e insertar el escritor al principio del fichero.
			else {
				salidaConCabecera = new ObjectOutputStream(new FileOutputStream(fichero));
				salidaConCabecera.writeObject(new Escritor(código,nombre,nacimiento,nacionalidad));
			}
		}
		finally {
			if (salidaConCabecera != null) {
				salidaConCabecera.close();
			}
			if (salidaSinCabecera != null) {
				salidaSinCabecera.close();
			}
		}
	}
	public static List<Escritor> eliminarEscritor(int código) throws IOException, ClassNotFoundException{
		List <Escritor> lista = leerEscritores();
		Iterator <Escritor> iterador = lista.iterator();
		while(iterador.hasNext()) {
			Escritor escritorIterador = iterador.next();
			if(escritorIterador.getCódigo() == código) {
				iterador.remove();
			}
		}
		return lista;
	}
}

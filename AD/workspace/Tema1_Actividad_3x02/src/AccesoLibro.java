import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AccesoLibro {
public static final String NOMBRE_FICHERO_LIBROS = "data/libros_sec.dat";
	
	public static List<Libro> leerLibros() throws IOException, ClassNotFoundException{
		ObjectInputStream flujoEntrada = null;
		List<Libro> listaEscritores = new ArrayList<>();
		boolean finalFichero = false;
		try {
			flujoEntrada = new ObjectInputStream(new FileInputStream(NOMBRE_FICHERO_LIBROS));
			while (!finalFichero) {
				try {
					Libro libro = (Libro) flujoEntrada.readObject();
					listaEscritores.add(libro);
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
	public static void escribirLibros(List<Libro> nuevaLista) throws IOException {
		File fichero = new File(NOMBRE_FICHERO_LIBROS);
		List <Libro> lista = nuevaLista;
		ObjectOutputStream flujoSalida1 = null;
		try {
			flujoSalida1 = new ObjectOutputStream(new FileOutputStream(fichero));
			for(Libro l: lista) {
				flujoSalida1.writeObject(l);
			}
		}
		finally {
			if (flujoSalida1 != null) {
				flujoSalida1.close();
			}
		}
	}
	public static Libro existeLibro(int codigo) throws IOException, ClassNotFoundException{
		List <Libro> lista = leerLibros();
		for(Libro l: lista) {
			if(l.getCodigo() == codigo)
				return l;
		}
		return null;
	}
	public static void insertarLibro(int codigo, int codigoEscritor, int añoPublicacion, double precio, String titulo) throws IOException{
		ObjectOutputStream salidaConCabecera = null; // Escribe cabecera
		MyObjectOutputStream salidaSinCabecera = null; // No escribe cabecera
		try {
			File fichero = new File(NOMBRE_FICHERO_LIBROS);
			// Insertar el libro al final del fichero SIN añadir cabecera.
			if (fichero.exists()) {
				salidaSinCabecera = new MyObjectOutputStream(new FileOutputStream(fichero, true));
				salidaSinCabecera.writeObject(new Libro(codigo,codigoEscritor,añoPublicacion,precio,titulo));
			}
			// Crear el fichero e insertar el libro al principio del fichero AÑADIENDO cabecera.
			else {
				salidaConCabecera = new ObjectOutputStream(new FileOutputStream(fichero));
				salidaConCabecera.writeObject(new Libro(codigo,codigoEscritor,añoPublicacion,precio,titulo));
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
	public static List<Libro> eliminarLibro(int codigo) throws IOException, ClassNotFoundException{
		List <Libro> lista = leerLibros();
		Iterator <Libro> iterador = lista.iterator();
		while(iterador.hasNext()) {
			Libro libroIterador = iterador.next();
			if(libroIterador.getCodigo() == codigo) {
				iterador.remove();
			}
		}
		return lista;
	}
	/*
	public static List<Libro> actualizarLibro(int codigo, Libro libro) throws IOException, ClassNotFoundException{
		List <Libro> lista = leerLibros();
		ListIterator <Libro> iterador = lista.listIterator();
		int posicion = 0;
		while(iterador.hasNext()) {
			Libro libroIterador = iterador.next();
			if(libroIterador.getCodigo() == codigo) {
				posicion = iterador.nextIndex();
			}
		}
		lista.remove(posicion);
		lista.add(posicion, libro);
		return lista;
	}*/
}

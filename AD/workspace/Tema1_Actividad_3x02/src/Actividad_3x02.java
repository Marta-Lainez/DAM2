import java.io.IOException;
import java.util.List;

import entrada.Teclado;

public class Actividad_3x02 {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			int opción = -1;
			do {
				imprimirMenú();
				opción = Teclado.leerEntero("Opción: ");
				menú(opción);
			}while(opción != 0);
			
		}
		catch (IOException ioe) {
			System.out.println("Error al leer del fichero:");
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
	}
	// Opcion 1 en menu
	public static void insertarLibro() throws IOException, ClassNotFoundException {
		int codigo = Teclado.leerEntero("Código:");
		if(AccesoLibro.existeLibro(codigo) != null)
			System.out.println("Ya existe otro libro con ese código en el fichero binario.");
		else {
			int codigoEscritor = Teclado.leerEntero("Código del escritor:");
			int añoPublicacion = Teclado.leerEntero("Año de publicacion:");
			double precio = Teclado.leerReal("Año de publicacion:");
			String titulo = Teclado.leerCadena("Titulo del libro:");
			AccesoLibro.insertarLibro(codigo,codigoEscritor,añoPublicacion,precio,titulo);
			System.out.println("Se ha insertado un escritor en el fichero binario.");
		}
	} 
	
	// Opcion 2 en menu
	public static void imprimirFichero() throws IOException, ClassNotFoundException{
		List <Libro> lista = AccesoLibro.leerLibros();
		if(lista.size() == 0)
			System.out.println("El fichero binario no tiene ningún libro.");
		else {
			for(Libro l: lista) {
				System.out.println(l.toString());
			}
			System.out.println("Se han consultado " + lista.size() + " libros del fichero de texto.");
		}
	}
		// Opcion 3 en menu
		public static void consultarLibro(int codigo) throws ClassNotFoundException, IOException {
			if(AccesoLibro.existeLibro(codigo) == null)
				System.out.println("No existe ningún libro con ese código en el fichero binario.");
			else 
				System.out.println(AccesoLibro.existeLibro(codigo).toString());
		}
		// Opcion 4 del menu
		public static void actualizarLibro() throws ClassNotFoundException, IOException {
			int codigo = Teclado.leerEntero("Código:");
			if(AccesoLibro.existeLibro(codigo) == null)
				System.out.println("No existe ningún libro con ese código en el fichero binario.");
			else {
				int codigoEscritor = Teclado.leerEntero("Código del escritor:");
				int añoPublicacion = Teclado.leerEntero("Año de publicacion:");
				double precio = Teclado.leerReal("Año de publicacion:");
				String titulo = Teclado.leerCadena("Titulo del libro:");
				List<Libro> lista = AccesoLibro.eliminarLibro(codigo);
				AccesoLibro.escribirLibros(lista);
				AccesoLibro.insertarLibro(codigo,codigoEscritor,añoPublicacion,precio,titulo);
				System.out.println("Se ha actualizado un libro del fichero binario.");
			}
		}
		// Opcion 5 del menu
		public static void eliminarLibro(int codigo) throws ClassNotFoundException, IOException {
			if(AccesoLibro.existeLibro(codigo) == null)
				System.out.println("No existe ningún libro con ese código en el fichero binario.");
			else {
				List<Libro> lista = AccesoLibro.eliminarLibro(codigo);
				AccesoLibro.escribirLibros(lista);
				System.out.println("Se ha eliminado un libro del fichero binario.");
			}
		}
	public static void imprimirMenú() {
		System.out.println("0) Salir del programa.\n1) Insertar un libro en el fichero binario\n"
				+ "2) Consultar todos los libros del fichero binario.\n"
				+ "3) Consultar un libro, por código, del fichero binario\n"
				+ "4) Actualizar un libro, por código, del fichero binario.\n"
				+ "5) Eliminar un libro, por código, del fichero binario.");
	}
	
	public static void menú(int opción) throws IOException, ClassNotFoundException {
		int codigo;
		switch (opción) {
		case 0:
			break;
		case 1: // FUNCIONA
			insertarLibro();
			break;
		case 2: // FUNCIONA
			imprimirFichero();
			break;
		case 3: // FUNCIONA
			codigo = Teclado.leerEntero("Código: ");
			consultarLibro(codigo);
			break;
		case 4: // 
			actualizarLibro();
			break;
		case 5: //
			codigo = Teclado.leerEntero("Código empleado:");
			eliminarLibro(codigo);
			break;
		default:
			System.out.println("La opción de menú debe estar comprendida entre 0 y 5.");
		}
	}
}

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import entrada.Teclado;

public class Actividad_2x01 {

	public static void main(String[] args) {
		try {
			int opcion = -1;
			do {
				imprimirMenu();
				opcion = Teclado.leerEntero("Opcion: ");
				menu(opcion);
			}while(opcion != 0);
			
		}
		catch (IOException ioe) {
			System.out.println("Error al leer del fichero:");
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException sqle) {
			System.err.println("El libro está referenciado en un libro de la base de datos.");
		}
		
	}
	/*
	 * input: Lista de libros para imprimir
	 * Descripción: Recorre la lista con un for-each e imprime cada elemento con el método toString() de la clase Libro
	 */
	public static void imprimirLista(List<Libro> listaLibros) {
		for(Libro libro: listaLibros) {
			System.out.println(libro.toString());
		}
			System.out.println("Se han consultado " + listaLibros.size() + " libros de la base de datos.");
	}
	/*
	 * Opción 1 del menú
	 * Descripción: Pide parámetros del constructor del libro a insertar en la base de datos. Utiliza la clase AccesoLibro
	 * y su método insertar.
	 */
	public static void insertar() throws ClassNotFoundException, SQLException {
		String isbn = Teclado.leerCadena("Isbn: ");
		String titulo = Teclado.leerCadena("Título: ");
		String escritor = Teclado.leerCadena("Escritor: ");
		int agnoPublicacion = Teclado.leerEntero("Año de publicación");
		double puntuacion = Teclado.leerReal("Puntuación: ");
		AccesoLibro.insertar(isbn, titulo, escritor, agnoPublicacion, puntuacion);
		System.out.println("Se ha insertado un libro en la base de datos.");
	}
	/*
	 * Opción 2 del menú
	 * Descripción: Pide código del libro a borrar. Busca el libro que contenga ese código con el método eliminar(codigo)
	 * de la clase AccesoLibro y si encuentra el libro, lo borra de la base de datos
	 */
	public static void eliminar() throws ClassNotFoundException, SQLException {
		int codigo = Teclado.leerEntero("Código: ");
		int filasEliminadas = AccesoLibro.eliminar(codigo);
		if (filasEliminadas == 0) {
			System.out.println("No existe ningún libro con ese código en la base de datos.");
		}
		else {
			System.out.println("Se ha eliminado un libro de la base de datos.");
		}
	}
	/*
	 * Opción 3 del menú
	 * Descripción: Recorre la lista de libros generada por el método consultarTodos() de la clase AccesoLibro.
	 * Por cada registro/libro recorrido de la lista de libros, imprime su información con el método imprimirLista(listaLibros)
	 */
	public static void consultarTodos() throws ClassNotFoundException, SQLException {
		List<Libro> listaLibros = AccesoLibro.consultarTodos();
		if(listaLibros.size() == 0)
			System.out.println("No se ha encontrado ningún libro en la base de datos.");
		else {
			imprimirLista(listaLibros);
		}
	}
	/*
	 * Opción 4 del menú
	 * Descripción: Recorre la lista de libros generada por el método consultarTodos() de la clase AccesoLibro.
	 * Por cada registro/libro recorrido de la lista de libros, imprime su información con el método imprimirLista(listaLibros)
	 */
	public static void consultarVarios() throws ClassNotFoundException, SQLException {
		String escritor = Teclado.leerCadena("Escritor: ");
		List<Libro> listaLibros = AccesoLibro.consultarVarios(escritor);
		if(listaLibros.size() == 0)
			System.out.println("No existe ningún libro con ese escritor en la base de datos.");
		else 
			imprimirLista(listaLibros);
	}
	/*
	 * Opción 5 del menú
	 * Descripción: Recorre la lista de libros generada por el método consultarNoPrestados() de la clase AccesoLibro.
	 * Por cada registro/libro recorrido de la lista de libros que no esté en el registro de libros prestados,
	 * imprime su información con el método imprimirLibros(listaLibros)
	 */
	public static void consultarNoPrestados() throws ClassNotFoundException, SQLException {
		List<Libro> listaLibros = AccesoLibro.consultarNoPrestados();
		if(listaLibros.size() == 0)
			System.out.println("No existe ningún libro no prestado en la base de datos.");
		else {
			imprimirLista(listaLibros);
		}
	}
	/*
	 * Opción 6 del menú
	 * Descripción: Recorre la lista de libros generada por el método consultarDevueltos() de la clase AccesoLibro.
	 * Por cada registro/libro recorrido de la lista de libros cuya fecha de devolución sea la introducida por parámetro,
	 * imprime su información con el método imprimirLibros(listaLibros)
	 */
	public static void consultarDevueltos() throws ClassNotFoundException, SQLException {
		String fechaDevolucion = Teclado.leerCadena("Fecha de devolución: ");
		List<Libro> listaLibros = AccesoLibro.consultarDevueltos(fechaDevolucion);
		if(listaLibros.size() == 0)
			System.out.println("No existe ningún libro devuelto en esa fecha en la base de datos.");
		else {
			imprimirLista(listaLibros);
		}
	}
	/*
	 * Descripción: Describe las opciones del menú
	 */
	public static void imprimirMenu() {
		System.out.println("0) Salir del programa.\n1) Insertar un libro en la base de datos.\n"
				+ "2) Eliminar un libro, por código, de la base de datos.\n"
				+ "3) Consultar todos los libros de la base de datos.\n"
				+ "4) Consultar varios libros, por escritor, de la base de datos, ordenados por puntuación decendente.\n"
				+ "5) Consultar los libros no prestados de la base de datos.\n"
				+ "6) Consultar los libros devueltos, en una fecha, de la base de datos");
	}
	/*
	 * Input: opción a elegir del menú
	 * Descrición: Tras obtener la opción introducidas por parámetro, entra en el switch y ejecuta la opción pertinente
	 */
	public static void menu(int opcion) throws IOException, ClassNotFoundException, SQLException {
		switch (opcion) {
		case 0:
			break;
		case 1:
			insertar();
			break;
		case 2: 
			eliminar();
			break;
		case 3: 
			consultarTodos();
			break;
		case 4: 
			consultarVarios();
			break;
		case 5:
			consultarNoPrestados();
			break;
		case 6:
			consultarDevueltos();
			break;
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 6.");
		}
	}
}

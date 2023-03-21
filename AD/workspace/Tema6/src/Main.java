

import java.io.IOException;
import java.util.ArrayList;

import entrada.Teclado;

public class Main {

	public static void main(String[] args) {
		try {
			int opcion = -1;
			do {
				imprimirMenu();
				opcion = Teclado.leerEntero("Opcion: ");
				menu(opcion);
			}while(opcion != 0);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
			

	}
	public static void insertar() {
		int codigo = Teclado.leerEntero("Código: ");
		Libro libro = AccesoLibros.consultarLibroPorCodigo(codigo);
		if(libro == null) {
			String titulo = Teclado.leerCadena("Título: ");
			String autor = Teclado.leerCadena("Autor: ");
			int agno = Teclado.leerEntero("Año: ");
			String genero = Teclado.leerCadena("Género: ");
			int numPartes = Teclado.leerEntero("Número de partes: ");
			ArrayList<String> partes = new ArrayList<>(numPartes);
			for(int i = 1 ; i <= numPartes; i++) {
				String parte = Teclado.leerCadena("Parte " + i + ": ");
				partes.add(parte);
			}
			int numPaginas = Teclado.leerEntero("Número de páginas :");
			int numPersonajes = Teclado.leerEntero("Número de personajes: ");
			ArrayList<String> personajes = new ArrayList<>(numPersonajes);
			for(int i = 1 ; i <= numPersonajes; i++) {
				String personaje = Teclado.leerCadena("Personaje " + i + ": ");
				personajes.add(personaje);
			}
			libro = new Libro(codigo, titulo, autor, agno, genero, partes, numPaginas, personajes);
			AccesoLibros.insertarLibro(libro);
			System.out.println("Se ha insertado un libro en la base de datos.");
		}
		else {
			System.out.println("Ese libro ya existe en la base de datos");
			System.out.println(libro.toString());
		}
	}
	public static void consultarTodos() {
		ArrayList<Libro> listaLibros = AccesoLibros.consultarTodos();
		if(listaLibros.size() > 0) {
			for(Libro libro: listaLibros) {
				System.out.println(libro.toString());
			}
			System.out.println("Se han encontrado " + listaLibros.size() + " libros en la base de datos.");
		}
		else {
			System.out.println("No se ha encontrado ningún libro en la base de datos.");
		}
	}
	public static void consultaLibro() {
		int codigo = Teclado.leerEntero("Código: ");
		Libro libro = AccesoLibros.consultarLibroPorCodigo(codigo);
		if(libro == null) {
			System.out.println("No existe ningún libro con ese código en la base de datos.");
		}
		else {
			System.out.println(libro.toString());
		}
	}
	public static void actualizarLibro() {
		int codigo = Teclado.leerEntero("Código: ");
		Libro libro = AccesoLibros.consultarLibroPorCodigo(codigo);
		if(libro == null) {
			System.out.println("No existe ningún libro con ese código en la base de datos.");
		}
		else {
			String titulo = Teclado.leerCadena("Título: ");
			String autor = Teclado.leerCadena("Autor: ");
			int agno = Teclado.leerEntero("Año: ");
			String genero = Teclado.leerCadena("Género: ");
			libro = new Libro(codigo, titulo, autor, agno, genero);
			long actualizaciones = AccesoLibros.actualizarLibro(libro);
			System.out.println("Ha habido " + actualizaciones + " actualizaciones.");
			System.out.println(libro.toString());
		}
	}
	public static void eliminarLibro() {
		int codigo = Teclado.leerEntero("Código: ");
		Libro libro = AccesoLibros.consultarLibroPorCodigo(codigo);
		if(libro == null) {
			System.out.println("No existe ningún libro con ese código en la base de datos.");
		}
		else {
			long librosEliminados = AccesoLibros.eliminarLibro(codigo);
			System.out.println("Se ha eliminado el libro de la base de datos.");
		}
	}
	
	/*
	 * Descripción: Describe las opciones del menú
	 */
	public static void imprimirMenu() {
		System.out.println("0) Salir del programa.\n"
				+ "1) Insertar un libro en la base de datos.\n"
				+ "2) Consultar todos los libros de la base de datos.\n"
				+ "3) Consultar un libro, por código, de la base de datos.\n"
				+ "4) Actualizar un libro, por código, de la base de datos.\n"
				+ "5) Eliminar un libro, por código, de la base de datos.");
	}
	/*
	 * Input: opción a elegir del menú
	 * Descrición: Tras obtener la opción introducidas por parámetro, entra en el switch y ejecuta la opción pertinente
	 */
	public static void menu(int opcion)  {
		switch (opcion) {
		case 0:
			break;
		case 1:
			insertar();
			break;
		case 2: 
			consultarTodos();
			break;
		case 3: 
			consultaLibro();
			break;
		case 4: 
			actualizarLibro();
			break;
		case 5: 
			eliminarLibro();
			break;
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 5.");
		}
	}

}

package Actividad_2x01;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.sqlite.SQLiteException;

import entrada.Teclado;

public class main {

	/**
	 * Metodo con el menu que queremos imprimir
	 * @return Devuelve una string con el texto a imprimir
	 */
	public static String texto() {
		return 	  "0. Salir del programa. \n"
				+ "1. Insertar un libro en la base de datos\n"
				+ "2. Eliminar un libro, por código, de la base de datos.\n"
				+ "3. Consultar todos los libros de la base de datos.\n"
				+ "4. Consultar varios libros, por escritor, de la base de datos, ordenados por puntuación decendente.\n"
				+ "5. Consultar los libros no prestados de la base de datos\n"
				+ "6. Consultar los libros devueltos, en una fecha, de la base de datos.";
	}

	/**
	 * Desde este main se ejecutara el switch con las distintas opciones que contempla el menu
	 */
	public static void main(String[] args) {
		try {
			int opcion;
			do {
				System.out.println(texto());
				opcion=Teclado.leerEntero("Dime una opcion \n");
				switch (opcion) {
				case 0:
					System.out.println("Fin del programa");
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
					consultarEscritor();
					break;
				case 5:
					consultarNoPrestados();
					break;
				case 6:
					consultarFecha();
					break;
				default:
					System.out.println("La opcion de menu debe estar comprendida entre 0 y 5.");
				}
			}while(opcion!=0);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insertar() throws ClassNotFoundException, SQLException {
		String isbn=Teclado.leerCadena("Dime el ISBN");
		String titulo=Teclado.leerCadena("Dime el titulo");
		String escritor=Teclado.leerCadena("Dime el escritor");
		int ano_publicacion=Teclado.leerEntero("Dime el año de publicacion");
		double puntuacion=Teclado.leerReal("Dime la puntuacion");
		Libro libro = new Libro(isbn,titulo,escritor,ano_publicacion,puntuacion);
		AccesoLibro.insertar(libro);
		System.out.println("Se ha insertado un libro en la base de datos.");
	}

	public static void eliminar() throws ClassNotFoundException, IOException, SQLException{
		try{
			int codigo = Teclado.leerEntero("Dime el codigo del libro");
			if(AccesoLibro.eliminar(codigo)!=0) {
				System.out.println("Se ha eliminado un libro de la base de datos.");
			}else {
				System.out.println("No existe ningún libro con ese código en la base de datos.");
			}
		}catch (SQLiteException SQLE){
			System.err.println("El libro está referenciado en un préstamo de la base de datos.");
		}
	}

	public static void consultarTodos() throws ClassNotFoundException, SQLException {
		ArrayList<Libro> libros = AccesoLibro.consultarTodos();
		if(libros.size()==0) {
			System.out.println("No se ha encontrado ningún libro en la base de datos.");
		}else {
			for(Libro lib: libros) {
				System.out.println(lib);
			}
			System.out.println("Se han consultado "+libros.size()+" libros de la base de datos.");
		}

	}
	
	public static void consultarEscritor() throws ClassNotFoundException, SQLException {
		String escritor=Teclado.leerCadena("Dime el escritor de los libros a consultar");
		ArrayList<Libro> libros = AccesoLibro.consultarAutor(escritor);
		if(libros.size()==0) {
			System.out.println("No existe ningún libro con ese escritor en la base de datos.");
		}else {
			for(Libro lib: libros) {
				System.out.println(lib);
			}
			System.out.println("Se han consultado "+libros.size()+" libros de la base de datos.");
		}
	}
	
	public static void consultarNoPrestados() throws ClassNotFoundException, SQLException {
		ArrayList<Libro> libros = AccesoLibro.consultarNoPrestados();
		if(libros.size()==0) {
			System.out.println("No existe ningún libro no prestado en la base de datos.");
		}else {
			for(Libro lib: libros) {
				System.out.println(lib);
			}
			System.out.println("Se han consultado "+libros.size()+" libros de la base de datos.");
		}
	}
	public static void consultarFecha() throws ClassNotFoundException, SQLException {
		String fecha=Teclado.leerCadena("Dime la fecha de los libros a consultar");
		ArrayList<Libro> libros = AccesoLibro.consultarFecha(fecha);
		if(libros.size()==0) {
			System.out.println("No existe ningún libro devuelto en esa fecha en la base de datos.");
		}else {
			for(Libro lib: libros) {
				System.out.println(lib);
			}
			System.out.println("Se han consultado "+libros.size()+" libros de la base de datos.");
		}
	}


}

import java.util.ArrayList;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

import entrada.Teclado;
public class GestorBiblioteca {

	public static void main(String[] args) {
		try {
			int opcion = -1;
			do {
				imprimirMenu();
				opcion = Teclado.leerEntero("Opcion: ");
				menu(opcion);
			}while(opcion != 0);
			
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
		} 
		catch (InstantiationException ie) {
			System.out.println("Error de instanciación de base de datos XML: " + ie.getMessage());
		} 
		catch (IllegalAccessException iae) {
			System.out.println("Error de acceso ilegal: " + iae.getMessage());
		} 
		catch (XMLDBException xmldbe) {
			System.out.println("Error de base de datos XML: " + xmldbe.getMessage());
		}

	}
	// Consultar libros
	private static void consultar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		ArrayList<Libro> libros = AccesoBiblioteca.consultar();
		if(libros.size() == 0) {
			System.out.println("La base de datos no tiene ningún libro.");
		}else {
			for(Libro libro: libros) {
				System.out.println(libro.toString());
			}
			System.out.println("Se han consultado " + libros.size() + " libros de la base de datos.");
		}
	}
	
	// Insertar socios
	public static void insertar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException{
		String dni = Teclado.leerCadena("¿Dni? ");
		
		Socio socioCom = AccesoBiblioteca.consultarDni(dni);

		if(socioCom != null) {
			System.out.println("Se ha encontrado un socio con ese DNI en la base de datos.");
		}
		else {
			String nombre = Teclado.leerCadena("¿Nombre? ");
			String localidad = Teclado.leerCadena("¿Localidad? ");
			String telefono = Teclado.leerCadena("¿Teléfono? ");
			String correo = Teclado.leerCadena("¿Correo? ");
			Socio socio = new Socio(dni,nombre,localidad,telefono,correo);
			AccesoBiblioteca.insertar(socio);
			System.out.println("Se ha insertado un socio en la base de datos");
		}
		
	}
	public static void eliminarSocio() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		String dni = Teclado.leerCadena("¿Dni? ");
		ArrayList<Prestamo> prestamos = AccesoBiblioteca.consultarPrestamos(dni);
		if(prestamos.size() > 0) {
			System.out.println("Se han encontrado " + prestamos.size() + " préstamos relacionados.");
			for(Prestamo prestamo: prestamos) {
				System.out.println(prestamo.toString());
			}
		}else {
			Socio socioCom = AccesoBiblioteca.consultarDni(dni);
			if(socioCom == null) {
				System.out.println("No se ha encontrado ningún socio con ese DNI en la base de datos.");
			}
			else {
				AccesoBiblioteca.eliminar(dni);
				System.out.println("Se ha eliminado un socio de la base de datos");
			}
		}
	}

	/*
	 * Descripción: Describe las opciones del menú
	 */
	public static void imprimirMenu() {
		System.out.println("0) Salir del programa.\n"
				+ "1) Consultar todos los LIBROS, ordenados por año descendente, de la base de datos.\n"
				+ "2) Insertar un SOCIO en la base de datos.\n"
				+ "3) Eliminar un SOCIO, por DNI, de la base de datos.");
	}
	/*
	 * Input: opción a elegir del menú
	 * Descrición: Tras obtener la opción introducidas por parámetro, entra en el switch y ejecuta la opción pertinente
	 */
	public static void menu(int opcion) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		switch (opcion) {
		case 0:
			break;
		case 1:
			consultar();
			break;
		case 2: 
			insertar();
			break;
		case 3: 
			eliminarSocio();
			break;
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 5.");
		}
	}

}

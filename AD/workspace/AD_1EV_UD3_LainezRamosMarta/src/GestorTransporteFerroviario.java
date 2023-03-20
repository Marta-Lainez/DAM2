import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entrada.Teclado;
import modulo.Billete;
import modulo.Clase;
import modulo.Estacion;
import modulo.Viajero;

import modulo.HibernateUtil;

public class GestorTransporteFerroviario {

	public static void main(String[] args) {
		try {
			int opcion = -1;
			do {
				imprimirMenu();
				opcion = Teclado.leerEntero("Opcion: ");
				menu(opcion);
			}while(opcion != 0);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RuntimeException e1) {
			System.out.println(e1.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("El departamento está referenciado en un empleado de la base de datos.");
		}

	}
	// Imprimir estaciones
	public static void imprimirEstaciones() {
		List<Estacion> estaciones = AccesoTransporteFerroviario.imprimirEstaciones();
		if (estaciones.size() == 0) {
			System.out.println("La base de datos no tiene ninguna estación.");
		}else {
			for (Estacion estacion : estaciones) {
				System.out.println(estacion.toString());
			}
			System.out.println("Se han consultado " + estaciones.size() +
	                   " estaciones de la base de datos.");
		}
	}
	// Insertar viajero
	private static void insertarViajero() throws NumberFormatException, ClassNotFoundException, IOException, SQLException {

		ArrayList<Clase> clases = AccesoTransporteFerroviario.imprimeClases();
		if (clases.size() == 0) {
			System.out.println("No hay clases en la base de datos.");
		}
		else {
			for(Clase clase: clases) {
				System.out.println(clase.toString());
			}
			int codigoClase = Teclado.leerEntero("Código de la clase: ");
			Clase clase = AccesoTransporteFerroviario.consultarClase(codigoClase);
			System.out.println();
			if(clase == null) {
				System.out.println("No existe ninguna clase con ese código de la base de datos:");
			}
			else {
				String nombre = Teclado.leerCadena("Nombre de viajero: ");
				String fechaNacimiento = Teclado.leerCadena("Fecha de nacimiento: ");
				String lugarResidencia = Teclado.leerCadena("Lugar de residencia: ");
				String correo = Teclado.leerCadena("Correo: ");
	
				Viajero viajero = new Viajero(clase, nombre, fechaNacimiento, lugarResidencia, correo, (short) 0);
				AccesoTransporteFerroviario.insertarViajero(viajero);
				System.out.println("Se ha insertado un viajero en la base de datos");
			}
		}
	}
	// borrar clase
	private static void eliminarClase() {
		int codigo = Teclado.leerEntero("Código de la clase: ");
		ArrayList<Viajero> viajerosPorCodigo = AccesoTransporteFerroviario.listarViajerosPorClase(codigo);
		if(viajerosPorCodigo.size() == 0) {
			Boolean eliminar = AccesoTransporteFerroviario.eliminarClaseSinViajeros(codigo);
			if(eliminar)
				System.out.println("Se ha eliminado una clase de la base de datos.");
			else
				System.out.println("No existe ninguna clase con ese código en la base de datos.");
		}
		else {
			System.out.println("Se han encontrado " + viajerosPorCodigo.size() + " viajeros referenciados a esa "
					+ "clase en la base de datos.");
			for (Viajero viajero : viajerosPorCodigo) {
				System.out.println(viajero.toString());
			}
		}
	}
		
	/*
	 * Descripción: Describe las opciones del menú
	 */
	public static void imprimirMenu() {
		System.out.println("0) Salir del programa.\n"
				+ "1) Consultar todas las ESTACIONES, ordenadas por año de inauguración descendente, de la base de datos.\n"
				+ "2) Insertar un VIAJERO en la base de datos.\n"
				+ "3) Eliminar una CLASE, por código, de la base de datos.");
	}
	/*
	 * Input: opción a elegir del menú
	 * Descrición: Tras obtener la opción introducidas por parámetro, entra en el switch y ejecuta la opción pertinente
	 */
	public static void menu(int opcion) throws IOException, ClassNotFoundException, SQLException {
		switch (opcion) {
		case 0:
			System.out.println("\tPrograma finalizado");
			break;
		case 1:
			imprimirEstaciones();
			break;
		case 2: 
			insertarViajero();
			break;
		case 3: 
			eliminarClase();
			break;
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 3.");
		}
	}
	
}

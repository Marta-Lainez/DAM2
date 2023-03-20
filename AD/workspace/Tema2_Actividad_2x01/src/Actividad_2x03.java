import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import entrada.Teclado;

public class Actividad_2x03 {

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
			sqle.printStackTrace();
		}
	}
	/*
	 * Opción 1 del menú	
	 */
	public static void insertar() throws SQLException, ClassNotFoundException {
		
		int codigoLibro = Teclado.leerEntero("Código libro: ");
		Libro libroExiste = AccesoLibro.existe(codigoLibro);
		if(libroExiste != null) {
			boolean estaPrestado = AccesoPrestamo.estarPrestado(codigoLibro);
			boolean tenerLibro;
			int inserciones;
			if(!estaPrestado) {
				int codigoSocio = Teclado.leerEntero("Código socio: ");
				tenerLibro = AccesoPrestamo.tenerLibro(codigoSocio);
				if(!tenerLibro) {
					String fechaInicio = Teclado.leerCadena("Fecha de inicio: ");
					String fechaFin = Teclado.leerCadena("Fecha de fin: ");
					inserciones = AccesoPrestamo.insertar(codigoLibro, codigoSocio, fechaInicio, fechaFin);
					if(inserciones > 0)
						System.out.println("Se ha insertado un préstamo en la base de datos.");
				}
				else {
					System.out.println("Se ha prestado un libro a ese socio y éste aún no lo ha devuelto.");
				}
			}
			else {
				System.out.println("Se ha prestado ese libro a un socio y éste aún no lo ha devuelto.");
			}
		}
		else {
			System.out.println("Ese libro no existe en la base de datos.");
		}
	}
	/*
	 * Opción 2 del menú
	 */
	public static void actualizar() throws SQLException {
		int codigoLibro = Teclado.leerEntero("Código libro: ");
		int codigoSocio = Teclado.leerEntero("Código socio: ");
		String fechaInicio = Teclado.leerCadena("Fecha de inicio: ");
		boolean existe = AccesoPrestamo.existePrestamo(codigoLibro, codigoSocio, fechaInicio);
		if(existe) {
			String fechaDevolucion = Teclado.leerCadena("Fecha de devolución: ");
			int actualizacion = AccesoPrestamo.actualizar(codigoLibro, codigoSocio, fechaInicio, fechaDevolucion);
			if(actualizacion > 0)
				System.out.println("Se ha actualizado un préstamo de la base de datos.");
		}
		else
			System.out.println("No existe ningún préstamo con esos datos identificativos en la base de datos.");
	}
	/*
	 * Opción 3 del menú
	 */
	public static void eliminar() throws ClassNotFoundException, SQLException {
		int codigoLibro = Teclado.leerEntero("Código libro: ");
		int codigoSocio = Teclado.leerEntero("Código socio: ");
		String fechaInicio = Teclado.leerCadena("Fecha de inicio: ");
		int eliminados = AccesoPrestamo.eliminar(codigoLibro, codigoSocio, fechaInicio);
		if(eliminados > 0) 
			System.out.println("Se ha eliminado un préstamo de la base de datos.");
		else
			System.out.println("No existe ningún préstamo con esos datos identificativos en la base de datos.");
	}
	/*
	 * Opción 4 del menú
	 */
	public static void consultarTodos() throws IOException, SQLException {
		List<Prestamo> lista = AccesoPrestamo.listarTodos();
		if(lista.size() > 0) {
			for(Prestamo prestamo: lista) {
				System.out.println(prestamo.toString());
			}
			System.out.println("Se han consultado " + lista.size() + " préstamos de la base de datos.");
		}
		else
			System.out.println("No se ha encontrado ningún préstamo en la base de datos.");
	}
	/*
	 * Descripción: Describe las opciones del menú
	 */
	public static void imprimirMenu() {
		System.out.println("0) Salir del programa.\n"
				+ "1) Insertar un préstamo en la base de datos.\n"
				+ "2) Actualizar un préstamo, por datos identificativos, de la base de datos.\n"
				+ "3) Eliminar un préstamo, por datos identificativos, de la base de datos.\n"
				+ "4) Consultar todos los préstamos de la base de datos.\n"
				+ "5) Consultar los préstamos no devueltos de la base de datos.\n"
				+ "6) Consultar DNI y nombre de socio, ISBN y título de libro y fecha de devolución de los"
				+ " préstamos realizados en una fecha de la base de datos.");
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
			actualizar();
			break;
		case 3: 
			eliminar();
			break;
		case 4: 
			consultarTodos();
			break;
		case 5:
			//consultarNoPrestados();
			break;
		case 6:
			//consultarFecha();
			break;
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 6.");
		}
	}
}

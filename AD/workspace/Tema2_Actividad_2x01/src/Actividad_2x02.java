import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import entrada.Teclado;

public class Actividad_2x02 {

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
			System.err.println("El socio está referenciado en un socio de la base de datos.");
		}
	}
	/*
	 * input: Lista de socios para imprimir
	 * Descripción: Recorre la lista con un for-each e imprime cada elemento con el método toString() de la clase Socio
	 */
	public static void imprimirLista(List<Socio> listaSocio) {
		for(Socio socio: listaSocio) {
			System.out.println(socio.toString());
		}
			System.out.println("Se han consultado " + listaSocio.size() + " socios de la base de datos.");
	}
	/*
	 * Opción 1 del menú
	 * Descripción: Pide parámetros del constructor del libro a insertar en la base de datos. Utiliza la clase AccesoLibro
	 * y su método insertar.
	 */
	public static void insertar() throws ClassNotFoundException, SQLException {
		String dni = Teclado.leerCadena("DNI: ");
		String nombre = Teclado.leerCadena("Nombre: ");
		String domicilio = Teclado.leerCadena("Domicilio: ");
		String telefono = Teclado.leerCadena("Teléfono: ");
		String correo = Teclado.leerCadena("Correo: ");
		AccesoSocio.insertar(dni, nombre, domicilio, telefono, correo);
		System.out.println("Se ha insertado un socio en la base de datos.");
	}
	/*
	 * Opción 2 del menú
	 * Descripción: Pide código del socio a borrar. Busca el socio que contenga ese código con el método eliminar(codigo)
	 * de la clase AccesoSocio y si encuentra el socio, lo borra de la base de datos
	 */
	public static void eliminar() throws ClassNotFoundException, SQLException {
		int codigo = Teclado.leerEntero("Código: ");
		int filasEliminadas = AccesoSocio.eliminar(codigo);
		if (filasEliminadas == 0) {
			System.out.println("No existe ningún socio con ese código en la base de datos.");
		}
		else {
			System.out.println("Se ha eliminado un socio de la base de datos.");
		}
	}
	/*
	 * Opción 3 del menú
	 * Descripción: Recorre la lista de socios generada por el método consultarTodos() de la clase AccesoSocio.
	 * Por cada registro/socio recorrido de la lista de socios, imprime su información con el método imprimirLista(listaSocios)
	 */
	public static void consultarTodos() throws ClassNotFoundException, SQLException {
		List<Socio> listaSocios = AccesoSocio.consultarTodos();
		if(listaSocios.size() == 0)
			System.out.println("No se ha encontrado ningún socio en la base de datos.");
		else {
			imprimirLista(listaSocios);
		}
	}
	/*
	 * Opción 4 del menú
	 * Descripción: Recorre la lista de socios generada por el método consultarVarios() de la clase AccesoSocio.
	 * Por cada registro/socio recorrido de la lista de socios, imprime su información con el método imprimirSocio(listaSocios)
	 */
	public static void consultarVarios() throws ClassNotFoundException, SQLException {
		String localidad = Teclado.leerCadena("Localidad: ");
		List<Socio> listaSocios = AccesoSocio.consultarVarios(localidad);
		if(listaSocios.size() == 0)
			System.out.println("No existe ningún socio con esa localidad en la base de datos.");
		else 
			imprimirLista(listaSocios);
	}
	/*
	 * Opción 5 del menú
	 * Descripción: Recorre la lista de socios generada por el método consultarNoPrestados() de la clase AccesoSocio.
	 * Por cada registro/socio recorrido de la lista de socios que no esté en el registro de libros prestados,
	 * imprime su información con el método imprimirLista(listaSocios)
	 */
	public static void consultarNoPrestados() throws ClassNotFoundException, SQLException {
		List<Socio> listaSocios = AccesoSocio.consultarNoPrestados();
		if(listaSocios.size() == 0)
			System.out.println("No existe ningún socio sin préstamos en la base de datos.");
		else {
			imprimirLista(listaSocios);
		}
	}
	/*
	 * Opción 6 del menú
	 * Descripción: Recorre la lista de libros generada por el método consultarFecha() de la clase AccesoSocio.
	 * Por cada registro/libro recorrido de la lista de socios que tenga un prestamo en la fecha introducida por parámetro,
	 * imprime su información con el método imprimirLista(listaSocios)
	 */
	public static void consultarFecha() throws ClassNotFoundException, SQLException {
		String fecha = Teclado.leerCadena("Fecha: ");
		List<Socio> listaSocios = AccesoSocio.consultarFecha(fecha);
		if(listaSocios.size() == 0)
			System.out.println("No existe ningún socio con préstamos en esa fecha en la base de datos.");
		else {
			imprimirLista(listaSocios);
		}
	}
	/*
	 * Descripción: Describe las opciones del menú
	 */
	public static void imprimirMenu() {
		System.out.println("0) Salir del programa.\n1) Insertar un socio en la base de datos.\n"
				+ "2) Eliminar un socio, por código, de la base de datos.\n"
				+ "3) Consultar todos los socios de la base de datos.\n"
				+ "4) Consultar varios socios, por localidad, de la base de datos, ordenados por nombre ascendente.\n"
				+ "5) Consultar los socios sin préstamos de la base de datos.\n"
				+ "6) Consultar los socios con préstamos en una fecha de la base de datos.");
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
			consultarFecha();
			break;
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 6.");
		}
	}
}

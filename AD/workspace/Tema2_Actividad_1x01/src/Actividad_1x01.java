import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.sqlite.SQLiteException;

import entrada.Teclado;

public class Actividad_1x01 {

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
			System.err.println("El departamento está referenciado en un empleado de la base de datos.");
		}

	}
	/*
	 * Opción 1 del menú
	 * Descripción: Pide nombre y ubicación del departamento a insertar en la base de datos
	 */
	public static void insertarDepartamento() throws ClassNotFoundException, SQLException {
		String nombre = Teclado.leerCadena("Nombre: ");
		String ubicacion = Teclado.leerCadena("Ubicación: ");
		AccesoDepartamento.InsertarDepartamento(nombre, ubicacion);
		System.out.println("Se ha insertado un departamento en la base de datos.");
	}
	/*
	 * Opción 2 del menú
	 * Descripción: Recorre la lista de departamentos generada por el método consultarApartamentos() de la clase AccesoDepartamento.
	 * Por cada registro / departamento recorrido de la lista de deprtamentos, imprime su información con el método toString() 
	 * de la clase Departamento
	 */
	public static void consultarDepartamentos() throws ClassNotFoundException, SQLException {
		List<Departamento> listaDepartamentos = AccesoDepartamento.consultarDepartamentos();
		if(listaDepartamentos.size() == 0)
			System.out.println("No se ha encontrado ningún departamento en la base de datos.");
		else {
			for(Departamento departamento: listaDepartamentos) {
				System.out.println(departamento.toString());
			}
				System.out.println("Se han consultado " + listaDepartamentos.size() + " departamentos de la base de datos.");
		}
	}
	/*
	 * Opción 3 del menú
	 * Descripción: Pide código del departamento que se quiere consultar. Lo busca con el método consultar1Departamento(codigo) de
	 * la clase AccesoDepartamento. Si lo encuentra imprime su información con el método toString() de la clase Departamento
	 */
	public static void consultar1Departamento() throws ClassNotFoundException, SQLException {
		int codigo = Teclado.leerEntero("Codigo: ");
		Departamento departamento = AccesoDepartamento.consultar1Departamento(codigo);
		if(departamento != null)
			System.out.println(departamento.toString());
		else
			System.out.println("No existe ningún departamento con ese código en la base de datos.");
		
	}
	/*
	 * Opción 4 del menú
	 * Descripción: Pide código, nombre y ubicación del nuevo departamento. A través del código, se busca ese departamento con el método
	 * actualizarDepartamento(codigo,nombre,ubicacion) de la clase AccesoDepartamento
	 */
	public static void actualizarDepartamento() throws ClassNotFoundException, SQLException {
		int codigo = Teclado.leerEntero("Código: ");
		String nombre = Teclado.leerCadena("Nombre: ");
		String ubicacion = Teclado.leerCadena("Ubicación: ");
		int filasActualizadas = AccesoDepartamento.actualizarDepartamento(codigo, nombre, ubicacion);
		if (filasActualizadas == 0) {
			System.out.println("No existe ningún departamento con ese código en la base de datos.");
		}
		else {
			System.out.println("Se ha actualizado un departamento de la base de datos.");
		}
	}
	/*
	 * Opción 5 del menú
	 * Descripción: Pide código del departamento a borrar. Busca el departamento que contenga ese código con el método eliminarDerpartamento(codigo)
	 * de la clase AccesoDepartamento y si encuentra elo departamento, lo borra de la base de datos
	 */
	public static void eliminarDepartamento() throws ClassNotFoundException, SQLException {
		int codigo = Teclado.leerEntero("Código: ");
		int filasEliminadas = AccesoDepartamento.eliminarDepartamento(codigo);
		if (filasEliminadas == 0) {
			System.out.println("No existe ningún departamento con ese código en la base de datos.");
		}
		else {
			System.out.println("Se ha eliminado un departamento de la base de datos.");
		}
	}
	/*
	 * Descripción: Describe las opciones del menú
	 */
	public static void imprimirMenu() {
		System.out.println("0) Salir del programa.\n1) Insertar un departamento en la base de datos.\n"
				+ "2) Consultar todos los departamentos de la base de datos.\n"
				+ "3) Consultar un departamento, por código, de la base de datos.\n"
				+ "4) Actualizar un departamento, por código, de la base de datos.\n"
				+ "5) Eliminar un departamento, por código, de la base de datos.");
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
			insertarDepartamento();
			break;
		case 2: 
			consultarDepartamentos();
			break;
		case 3: 
			consultar1Departamento();
			break;
		case 4: 
			actualizarDepartamento();
			break;
		case 5:
			eliminarDepartamento();
			break;
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 5.");
		}
	}

}

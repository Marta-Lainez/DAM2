import java.io.IOException;
import java.sql.SQLException;

import entrada.Teclado;

public class Actividad_3x01 {

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
			System.out.println(sqle.getMessage());
		}
	}
	/*
	 * Opción 1 del menú
	 * Descripción: Inserta todos los departamentos de un fichero txt que contiene departamentos.
	 * 	Accede al método insertar() de la clase AccesoDepartamento. Esa misma clase accede al método listar() que pasa todos
	 * 	los departamentos del txt a un ArrayList de Departamento. insertar() crea una conexión con la base de datos y crea la sentencia sql
	 * 	de inserción. Con un forEach recorre la lista de departamentos y los inserta en la base de datos. Por último imprime cuántos
	 * 	departamentos han sido insertados.
	 */
	public static void insertarDepartamentos() throws ClassNotFoundException, SQLException, IOException {
		
		int filasInsertadas = AccesoDepartamento.insertar();
		System.out.println("Se han insertado " + filasInsertadas + " departamentos en la base de datos.");
	}
	/*
	 * Opción 2 del menú
	 * Descripción: Inserta todos los empleados de un fichero txt que contiene empleados.
	 * 	Accede al método insertar() de la clase AccesoEmpleado. Esa misma clase accede al método listar() que pasa todos los
	 * 	empleados del fichero txt a un ArrayList de Empleado. insertar() crea una conexión con la base de datos y crea la sentencia sql
	 * 	de inserción. Con un forEach recorre la lista de departamentos y los inserta en la base de datos. Por último imprime cuántos
	 *  empleados se han insertado en la base de datos.
	 */
	public static void insertarEmpleados() throws ClassNotFoundException, SQLException, IOException {
		
		int filasInsertadas = AccesoEmpleado.insertar();
		System.out.println("Se han insertado " + filasInsertadas + " empleados en la base de datos.");
	}
	/*
	 * Opción 3 del menú
	 * Descripción: Actualiza los salarios de los empleados según su departamento en la base de datos de este modo: Departamento 2 Salario *= 1.01,
	 * 	Departamento 4 salario *= 1.02, Departamento 6 salario *= 1.03. Lo hace accediendo al método actualizar() de la clase AccesoEmpleado.
	 * 	Crea la conexión con la base de datos y crea y ejecuta la sentencia de update. Por último imprime cuántos salarios han sido actualizados.
	 */
	public static void actualizarEmpleados() throws ClassNotFoundException, SQLException, IOException {
		
		int filasActualizadas = AccesoEmpleado.actualizar();
		System.out.println("Se han actualizado " + filasActualizadas + " empleados en la base de datos.");
	}
	/*
	 * Opción 4 del menú
	 * Descripción: Pide al usuario un número de departamento. Los departamentos con ese código y los empelados con ese código de departamento
	 * 	son eliminados de la base de datos a través del método elimiar(int codigo) de la clase AccesoDepartamento. Este método crea la conexión
	 * 	con la base de datos. A continuación crea ambas sentencias de eliminación y las ejecuta. Por último imprime cuántos departamentos y empleados
	 *  han sido eliminados de la base de datos.
	 */
	public static void eliminar() throws ClassNotFoundException, SQLException, IOException {
		int codigo = Teclado.leerEntero("Código de departamento:");
		int[] departamentosYEmpleados = AccesoDepartamento.eliminar(codigo);
		if(departamentosYEmpleados[1] == 0)
			System.out.println("No se ha eliminado ningún departamento de la base de datos.");
		else
			System.out.println("Se han eliminado " + departamentosYEmpleados[0] + " empleados en la base de datos.\n"
				+ "Se han eliminado " + departamentosYEmpleados[1] + " departamentos de la base de datos.");
	}
	/*
	 * Descripción: Describe las opciones del menú
	 */
	public static void imprimirMenu() {
		System.out.println("0) Salir del programa.\n"
				+ "1) Insertar todos los departamentos de un fichero de texto en la base de datos.\n"
				+ "2) Insertar todos los empleados de un fichero de texto en la base de datos.\n"
				+ "3) Actualizar los salarios de los empleados, por departamento, de la base de datos.\n"
				+ "4) Eliminar un departamento, por código, de la base de datos.");
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
			insertarDepartamentos();
			break;
		case 2: 
			insertarEmpleados();
			break;
		case 3: 
			actualizarEmpleados();
			break;
		case 4: 
			eliminar();
			break;
		
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 4.");
		}
	}
}

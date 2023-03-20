import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import entrada.Teclado;

public class Actividad_1x02 {

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
			System.err.println("El empleado está referenciado en un empleado de la base de datos.");
		}

	}
	/*
	 * Opción 1 del menú
	 * Descripción: Pide nombre y ubicación del departamento a insertar en la base de datos
	 */
	public static void insertarEmpleado() throws ClassNotFoundException, SQLException {
		double salario = Teclado.leerReal("Salario: ");
		int codigoDepartamento = Teclado.leerEntero("Código del departamento: ");
		String nombre = Teclado.leerCadena("Nombre: ");
		String fechaAlta = Teclado.leerCadena("Fecha de alta: ");
		AccesoEmpleado.InsertarEmpleado(salario, codigoDepartamento, nombre, fechaAlta);
		System.out.println("Se ha insertado un departamento en la base de datos.");
	}
	/*
	 * Opción 2 del menú
	 * Descripción: Recorre la lista de empleados generada por el método consultarEmpleados() de la clase AccesoEmpleado.
	 * Por cada registro / empleado recorrido de la lista de empleados, imprime su información con el método toString() 
	 * de la clase Empleado
	 */
	public static void consultarEmpleados() throws ClassNotFoundException, SQLException {
		List<Empleado> listaEmpleados = AccesoEmpleado.consultarEmpleados();
		if(listaEmpleados.size() == 0)
			System.out.println("No se ha encontrado ningún empleado en la base de datos.");
		else {
			for(Empleado empleado: listaEmpleados) {
				System.out.println(empleado.toString());
			}
				System.out.println("Se han consultado " + listaEmpleados.size() + " empleados de la base de datos.");
		}
	}
	/*
	 * Opción 3 del menú
	 * Descripción: Pide código del empleado que se quiere consultar. Lo busca con el método consultar1Empleado(codigo) de
	 * la clase AccesoEmpleado. Si lo encuentra imprime su información con el método toString() de la clase Empleado
	 */
	public static void consultar1Empleado() throws ClassNotFoundException, SQLException {
		int codigo = Teclado.leerEntero("Codigo: ");
		Empleado empleado = AccesoEmpleado.consultar1Empleado(codigo);
		if(empleado != null)
			System.out.println(empleado.toString());
		else
			System.out.println("No existe ningún empleado con ese código en la base de datos.");
		
	}
	/*
	 * Opción 4 del menú
	 * Descripción: Pide el código, salario, codigo de departamento, nombre y fecha de alta del empleado. A través del código, 
	 * se busca ese empleado con el método  actualizarEmpleado(codigo,salario,codigodepartamento,nombre, fechaAlta) de la clase
	 * AccesoEmpleado
	 */
	public static void actualizarEmpleado() throws ClassNotFoundException, SQLException {
		int codigo = Teclado.leerEntero("Código: ");
		double salario = Teclado.leerReal("Salario: ");
		int codigoDepartamento = Teclado.leerEntero("Código del departamento: ");
		String nombre = Teclado.leerCadena("Nombre: ");
		String fechaAlta = Teclado.leerCadena("Fecha de alta: ");
		int filasActualizadas = AccesoEmpleado.actualizarEmpleado(codigo, salario, codigoDepartamento, nombre, fechaAlta);
		if (filasActualizadas == 0) {
			System.out.println("No existe ningún empleado con ese código en la base de datos.");
		}
		else {
			System.out.println("Se ha actualizado un empleado de la base de datos.");
		}
	}
	/*
	 * Opción 5 del menú
	 * Descripción: Pide código del departamento a borrar. Busca el departamento que contenga ese código con el método eliminarDerpartamento(codigo)
	 * de la clase AccesoDepartamento y si encuentra elo departamento, lo borra de la base de datos
	 */
	public static void eliminarEmpleado() throws ClassNotFoundException, SQLException {
		int codigo = Teclado.leerEntero("Código: ");
		int filasEliminadas = AccesoEmpleado.eliminarEmpleado(codigo);
		if (filasEliminadas == 0) {
			System.out.println("No existe ningún empleado con ese código en la base de datos.");
		}
		else {
			System.out.println("Se ha eliminado un empleado de la base de datos.");
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
			insertarEmpleado();
			break;
		case 2: 
			consultarEmpleados();
			break;
		case 3: 
			consultar1Empleado();
			break;
		case 4: 
			actualizarEmpleado();
			break;
		case 5:
			eliminarEmpleado();
			break;
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 5.");
		}
	}

}

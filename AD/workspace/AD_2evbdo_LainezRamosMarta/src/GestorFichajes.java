import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entrada.Teclado;
import modelo.Departamento;
import modelo.Empleado;

public class GestorFichajes {

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
	/* Método 1: Insertar departamento
	 * Descripción: Pide los datos del departamento a insertar, lo inserta y lo indica por pantalla
	 */
	public static void insertarDepartamento() {
		String denominacion = Teclado.leerCadena("Denominacion del departamento: ");
		double presupuesto = Teclado.leerReal("Presupuesto del departamento: ");
		
		Departamento departamento = new Departamento(denominacion, presupuesto);
		AccesoFichajes.insertarDepartamento(departamento);
		System.out.println("Se ha insertado un departamento en la base de datos.");
		
	}
	/* Método 2: Eliminar departamento
	 * Descripción: Pide el código del departamento a eliminar. Si existe algún empleado con ese departamento, no procede con la eliminación y
	 * saca por consola la lista de los empleados con su información. Si no hay empleados con ese departamento se comprueba que este existe.
	 * Si existe se procede a su eliminación, y si no existe para. En ambos casos saca por pantalla si se elimina o no.
	 */
	public static void eliminarDepartamento() {
		int codigo = Teclado.leerEntero("Código del departamento: ");
		List <Empleado> listaEmpleados = AccesoFichajes.consultarEmpleadosPorDepartamento(codigo);
		if(listaEmpleados.size() > 0) {
			System.out.println("Se han encontrado " + listaEmpleados.size() + " empleados relacionados con ese departamento en la base de datos:");
			for(Empleado empleado: listaEmpleados) {
				System.out.println(empleado.toString());
			}
		}
		else {
			Departamento departamento = AccesoFichajes.consultarDepartamento(codigo);
			if(departamento == null)
				System.out.println("No existe ningún departamento con ese código en la base de datos");
			else {
				AccesoFichajes.eliminarDepartamento(codigo);
				System.out.println("Se ha eliminado un departamento de la base de datos");
			}
		}
	}
	/* Método 3: Actualizar empleado
	 * Descripción: Pide los datos necesarios para actualizar un empleado. Tras pedir la clave primaria comprueba si el empleado existe.
	 * Si el empleado no existe lo saca por consola y para. Si existe pide su departamento. Si el departamento no existe lo saca por
	 * pantalla. Si el departamento existe actualiza el empleado con su nuevo departamento.
	 */
	public static void actualizarEmpleado() {
		String nombre = Teclado.leerCadena("Nombre del empleado: ");
		Empleado empleado = AccesoFichajes.consultarEmpleado(nombre);
		if(empleado == null) 
			System.out.println("No existe ningún empleado con ese nombre en la base de datos");
		else {
			int codigo = Teclado.leerEntero("Código del departamento: ");
			Departamento departamento = AccesoFichajes.consultarDepartamento(codigo);
			if(departamento == null)
				System.out.println("No existe ningún departamento con ese código en la base de datos");
			else {
				boolean empleadoActualizado = AccesoFichajes.actualizarEmpleado(nombre, departamento);
				if(empleadoActualizado)
					System.out.println("Se ha actualizado un empleado de la base de datos");
			}
		}
	}
	/*
	 * Descripción: Describe las opciones del menú
	 */
	public static void imprimirMenu() {
		System.out.println("0) Salir del programa.\n"
				+ "1) Insertar un DEPARTAMENTO en la base de datos.\n"
				+ "2) Eliminar un DEPARTAMENTO, por código, de la base de datos.\n"
				+ "3) Actualizar un EMPLEADO, por nombre, de la base de datos.");
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
			eliminarDepartamento();
			break;
		case 3: 
			actualizarEmpleado();
			break;
		
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 3.");
		}
	}
	
}

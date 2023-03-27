import java.util.ArrayList;

import entrada.Teclado;

public class GestorPersonal {

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
	public static void consultarTodos() {
		ArrayList<Empleado> listaEmpleados = AccesoPersonal.consultarTodos();
		ArrayList<Empleado> listaEmpleadosInvertida = invertirLista(listaEmpleados);

		if(listaEmpleadosInvertida.size() > 0) {
			for(Empleado empleado: listaEmpleadosInvertida) {
				System.out.println(empleado.toString());
			}
			System.out.println("Se han encontrado " + listaEmpleadosInvertida.size() + " empleados en la base de datos.");
		}
		else {
			System.out.println("la base de datos no tiene ningun empleado.");
		}
	}
	public static ArrayList<Empleado> invertirLista(ArrayList<Empleado> listaEmpleados){
		ArrayList<Empleado> invertida = new ArrayList<>();
		for(int i = listaEmpleados.size() -1; i >= 0; i--) {
			invertida.add(listaEmpleados.get(i));
		}
		return invertida;
	}

	public static void insertar() {
		int codigo = AccesoPersonal.consultarCodigoMaximo().getCodigo() + 1;
		String nombre = Teclado.leerCadena("Nombre: ");
		String fechaAlta = Teclado.leerCadena("Fecha de alta: ");
		String departamento = Teclado.leerCadena("Departamento: ");
		double salario = Teclado.leerReal("Salario: ");

		Empleado empleado = new Empleado(codigo, nombre, fechaAlta, departamento, salario);
		AccesoPersonal.insertar(empleado);
		System.out.println("Se ha insertado un empleado en la base de datos.");
	}
	public static void eliminar() {
		int codigo = Teclado.leerEntero("Código: ");
		Long empleadosEliminados = AccesoPersonal.eliminar(codigo);
		if(empleadosEliminados == 0) {
			System.out.println("No se ha encontrado ningún empleado con ese código en la base de datos.");
		}
		else {
			System.out.println("Se ha eliminado un empleado de la base de datos.");
		}
	}
	/*
	 * Descripción: Describe las opciones del menú
	 */
	public static void imprimirMenu() {
		System.out.println("0) Salir del programa.\n"
				+ "1) Consultar todos los EMPLEADOS, ordenados por salario ascendente, de la base de datos.\n"
				+ "2) Insertar un EMPLEADO en la base de datos.\n"
				+ "3) Eliminar un EMPLEADO, por código, de la base de datos.");
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
			consultarTodos();
			break;
		case 2: 
			insertar();
			break;
		case 3: 
			eliminar();
			break;
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 3.");
		}
	}

}
